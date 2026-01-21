package astalakshmi.example.controller;

import astalakshmi.example.data.ContactDAO;
import astalakshmi.example.view.ContactView;

public class ContactController {
    private ContactDAO contactDAO;
    private final ContactView contactView;
    public ContactController(ContactDAO contactDAO, ContactView contactView) {
      this.contactDAO = contactDAO;
      this.contactView = contactView;
    }
    public void run ()
    {

    }
}
