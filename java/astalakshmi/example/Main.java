package astalakshmi.example;


import astalakshmi.example.controller.ContactController;
import astalakshmi.example.data.ContactDAO;
import astalakshmi.example.data.FileContactDAOImpl;
import astalakshmi.example.view.ContactView;

import java.nio.file.Path;

public class Main {

    static void main() {
        ContactView contactView = new ContactView();
        ContactController cc = new ContactController(contactView);
        FileContactDAOImpl contactDAO = new FileContactDAOImpl(Path.of("contact.txt"));
cc.run();
            }
}