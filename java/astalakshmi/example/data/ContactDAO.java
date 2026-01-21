package astalakshmi.example.data;

import astalakshmi.example.exception.ContactStorageException;
import astalakshmi.example.exception.DuplicateContactException;
import astalakshmi.example.model.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll() throws ContactStorageException;
     void  save(Contact contact) throws  ContactStorageException, DuplicateContactException;
     Contact findByName (String name) throws ContactStorageException;

}
