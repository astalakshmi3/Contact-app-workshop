package astalakshmi.example.data;

import astalakshmi.example.exception.ContactStorageException;
import astalakshmi.example.exception.DuplicateContactException;
import astalakshmi.example.model.Contact;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileContactDAOImpl implements ContactDAO {

    private final Path file;

    public FileContactDAOImpl(Path file) {
        this.file = file;
    }

    public void ensureFileExists() throws ContactStorageException {
        try {
            if (Files.notExists(file)) {
                Path parent = file.getParent();
                if (parent != null && Files.notExists(parent)) {
                    Files.createDirectories(parent);
                }
                Files.createFile(file);
            }
        } catch (IOException e) {
            throw new ContactStorageException("Could not create contact");
        }
    }

    @Override
    public List<Contact> findAll() throws ContactStorageException {
        ensureFileExists();
        List<Contact> contacts = new ArrayList<>();
        try (var lines = Files.lines(file)) {
            lines.filter(line -> !line.isBlank()).forEach(line ->
            {
                String[] parts = line.split(";", -1);
                if (parts.length == 2) {
                    contacts.add(new Contact(parts[0], parts[1]));
                }
            });


            return contacts;
        } catch (IOException e) {
            throw new ContactStorageException("Error", e);
        }
    }

    @Override
    public void save(Contact contact) throws ContactStorageException, DuplicateContactException {
        ensureFileExists();
        Contact existing = findByName(contact.getName());
        if (existing != null) {
            throw new DuplicateContactException("Contact already exists" + contact.getName());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {// try with resource
            writer.write(contact.getName() + ";" + contact.getPhoneNumber());
            writer.newLine();
        } catch (IOException e) {
            throw new ContactStorageException("Error", e);
        }
    }

    @Override
    public Contact findByName(String name) throws ContactStorageException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        String search = name.trim();
        for (Contact contact : findAll())
            if (contact.getName().equals(search))
            {
                return contact;
    }
                return null;
}
}
