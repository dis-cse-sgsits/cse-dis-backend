package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.ExpertLectureDetails;
import sgsits.cse.dis.academics.model.FileInfo;
import sgsits.cse.dis.academics.model.IndustryVisit;
import sgsits.cse.dis.academics.repo.ExpertLectureRepository;
import sgsits.cse.dis.academics.repo.IndustryVisitRepository;
import sgsits.cse.dis.academics.service.FileStorageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path root = Paths.get("uploads");
    public int count = 0;

    @Autowired
    IndustryVisitRepository industryVisitRepository;

    @Autowired
    ExpertLectureRepository expertLectureRepository;

    @Override
    public void init()
    {
        try
        {
            if(!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException e)
        {
            throw new RuntimeException("Could not initialize upload directory.");

        }
    }

    @Override
    public void saveIndustryVisit(String industryVisitId, MultipartFile file, int size)
    {
        IndustryVisit industryVisit = industryVisitRepository.findByIndustryVisitId(industryVisitId);
        if(this.count == 0)
            this.count = size;
        try
        {
            Files.copy(file.getInputStream(), this.root.resolve(industryVisit.getCompanyName()+"_"+industryVisit.getDate()+"_image_"+Integer.toString(this.count) + ".jpg"));
            this.count -= 1;
        } catch(Exception e)
        {
            throw new RuntimeException("Could not upload the file. Error: "+e.getMessage());
        }
    }

    @Override
    public void saveExpertLecture(String expertLectureId, MultipartFile file, int size)
    {
        ExpertLectureDetails expertLecture = expertLectureRepository.findByExpertLectureId(expertLectureId);
        if(this.count == 0)
            this.count = size;
        try
        {
            Files.copy(file.getInputStream(), this.root.resolve(expertLecture.getTopic()+"_"+expertLecture.getDate()+"_image_"+Integer.toString(this.count) + ".jpg"));
            this.count -= 1;
        } catch(Exception e)
        {
            throw new RuntimeException("Could not upload the file. Error: "+e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll()
    {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the images!");
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public List<FileInfo> filterImagesIndustryVisit(String industryVisitId, List<FileInfo> fileInfos)
    {
        IndustryVisit industryVisit = industryVisitRepository.findByIndustryVisitId(industryVisitId);
        String visit = industryVisit.getCompanyName()+"_"+industryVisit.getDate();
        int count = 1;
        List<FileInfo> output = new ArrayList<>();

        for(FileInfo image : fileInfos)
        {
            if(image.getName().contains(visit))
                output.add(image);
        }

        return output;
    }

    @Override
    public List<FileInfo> filterImagesExpertLecture(String expertLectureId, List<FileInfo> fileInfos)
    {
        ExpertLectureDetails expertLecture = expertLectureRepository.findByExpertLectureId(expertLectureId);
        String visit = expertLecture.getTopic()+"_"+expertLecture.getDate();
        int count = 1;
        List<FileInfo> output = new ArrayList<>();

        for(FileInfo image : fileInfos)
        {
            if(image.getName().contains(visit))
                output.add(image);
        }

        return output;
    }
}
