package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.service.FileStorageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStorageServiceImpl implements FileStorageService {

    private final Path root = Paths.get("uploads");

    @Override
    public void init()
    {
        try
        {
            Files.createDirectory(root);
        } catch (IOException e)
        {
            throw new RuntimeException("Could not initialize upload directory.");

        }
    }

    @Override
    public void save(MultipartFile file)
    {
        try
        {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch(Exception e)
        {
            throw new RuntimeException("Could not upload the file. Error: "+e.getMessage());
        }
    }
}
