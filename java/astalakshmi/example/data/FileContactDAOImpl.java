package astalakshmi.example.data;

import astalakshmi.example.exception.ContactStorageException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileContactDAOImpl {
   private final Path filePath;

    public FileContactDAOImpl(Path filePath) {
        this.filePath = filePath;
    }
    public void ensureFileExit() throws ContactStorageException
    {
        try
        {
            if (Files.notExists(filePath))
            {
                Path newFilePath = filePath.getParent().resolve(filePath.getFileName().toString());
                if (Files.notExists(newFilePath))
                {
                    Files.createDirectories(newFilePath);
                }
            }
        } catch (IOException e) {
            throw new ContactStorageException("Could not create contact file:" + filePath, e);
        }
    }

}
