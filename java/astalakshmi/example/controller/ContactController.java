package astalakshmi.example.controller;

import astalakshmi.example.data.ContactDAO;
import astalakshmi.example.data.FileContactDAOImpl;
import astalakshmi.example.exception.ExceptionHandler;
import astalakshmi.example.model.Contact;
import astalakshmi.example.view.ContactView;

    public class ContactController {
    private ContactDAO contactDAO;
    private ContactView contactView;
    public ContactController(ContactDAO contactDAO,ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView= contactView;
    }
        public void run ()
    {
      boolean running = true;
      while (running)
    {
            contactView.displayMenu();
            String choice = contactView.getUserInput ("Select the option").trim();
                   try {
                    switch (choice)
                    {
                        case "1" :
                            try {
                                contactView.displayContacts(contactDAO.findAll());
                            }
                            catch (Exception e) {
                                contactView.displayError(e.getMessage());
                            }
                            break;
                        case "2" :

                                String name = contactView.getUserInput("Name").trim();
                                String phoneNumber = contactView.getUserInput("Phone Number").trim();
                            try {
                               contactDAO.save(new Contact(name,phoneNumber));
                               contactView.displayMessage("Contact saved");
                            }
                            catch (Exception e) {
                                contactView.displayError(e.getMessage());
                            }
                        case "3":
                            String searchName = contactView.getUserInput ("Search by name").trim();
                            Contact found = contactDAO.findByName(searchName);
                            try {
                                if (found == null) {
                                    contactView.displayMessage("Contact not found");

                                } else {
                                    contactView.displayMessage("Contact not found" + found.getName()+ "-" + found.getPhoneNumber());
                                }
                            }
                            catch (Exception e) {
                                contactView.displayError(e.getMessage());
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
                   catch (Exception e) {
                       contactView.displayError(e.getMessage());
                   }
    }
           }
    }
