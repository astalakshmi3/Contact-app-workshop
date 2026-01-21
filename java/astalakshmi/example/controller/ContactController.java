package astalakshmi.example.controller;

import astalakshmi.example.data.ContactDAO;
import astalakshmi.example.exception.ExceptionHandler;
import astalakshmi.example.model.Contact;
import astalakshmi.example.view.ContactView;

    public class ContactController {
    private ContactDAO contactDAO;
    private ContactView contactView;
    public ContactController(ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;
    }
        public void run ()
    {
      boolean running = true;
      while (running)
    {
        try
        {
            contactView.displayMenu();
            String choice = contactView.getUserInput ("").trim();
                    switch (choice)
                    {
                        case "1" :
                contactView.displayContacts(contactDAO.findAll());
                            break;
                        case "2" :
                           // String name = contactView.getUserInput ("Name").trim();
                         //   String phoneNumber = contactView.getUserInput ("Phone Number").trim();
                            contactDAO.save((Contact) contactDAO);
                            contactView.displayContacts(contactDAO.findAll());
                        case "3":
                            String email = contactView.getUserInput ("Email").trim();
                            Contact contact = contactDAO.findByName(email);
                            if (contact == null)
                            {
                                contactView.displayMessage("Contact not found");

                            }
                            else {
                                contactView.displayMessage("Contact not found" + contact.getName());
                            }
                        case "4":
                        {
                            running = false;
                            contactView.displayMessage("Finished");
                        }
                        default:
                            contactView.displayMessage("Invalid choice");
                    }
        }
        catch (Exception e)
        {
contactView.displayError(ExceptionHandler.handleException(e));
        }
    }
    }
}
