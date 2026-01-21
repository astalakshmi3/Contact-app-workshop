package astalakshmi.example;


import astalakshmi.example.controller.ContactController;
import astalakshmi.example.data.FileContactDAOImpl;
import astalakshmi.example.view.ContactView;

import java.nio.file.Path;

public class Main {

    static void main() {
        FileContactDAOImpl fc = new FileContactDAOImpl(Path.of("contacts.txt"));
        ContactView cv = new ContactView();
        ContactController cc = new ContactController(fc,cv);
cc.run();
            }
}