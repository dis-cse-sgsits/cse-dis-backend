package sgsits.cse.dis.academics.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.FileInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileStorageService {

    public void init();

    public void saveIndustryVisit(String industryVisitId, MultipartFile file, int size);

    public void saveExpertLecture(String expertLectureId, MultipartFile file, int size);

    public Stream<Path> loadAll();

    public Resource load(String filename);

    List<FileInfo> filterImagesIndustryVisit(String industryVisitId, List<FileInfo> fileInfos);

    List<FileInfo> filterImagesExpertLecture(String expertLectureId, List<FileInfo> fileInfos);
}
