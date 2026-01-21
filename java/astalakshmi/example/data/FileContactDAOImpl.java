package astalakshmi.example.data;

import astalakshmi.example.exception.ContactStorageException;
import astalakshmi.example.exception.DuplicateContactException;
import astalakshmi.example.model.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.lines;

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

    public List<Contact> findAll() throws ContactStorageException {
        ensureFileExit();
        List<Contact> contacts = new ArrayList<>();
        try (var lines = Files.lines(filePath))  // open and close the file safely
        {
            lines.filter(line -> ! line.isEmpty()); // ignore the empty file
            contacts.add(new Contact(";","1"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
    public void save(Contact contact) throws ContactStorageException, DuplicateContactException {
        ensureFileExit();
        Contact existing =  (contact.getName());

    }

}
