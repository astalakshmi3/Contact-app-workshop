package astalakshmi.example.view;

import astalakshmi.example.model.Contact;
import java.util.Scanner;
import java.util.List;

public class ContactView {
    Scanner sc = new Scanner(System.in);
    public void displayMenu ()
    {
        IO.println("Contact Application");
        System.out.println("1. Show all Contacts");
        System.out.println("2. Add new Contact");
        System.out.println("3. Find Contact by name");
        System.out.println("4. Exit");
        System.out.println("Choose: ");
    }
    public String getUserInput (String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    public void displayMessage (String message) {
        System.out.println(message);
    }
    public void displayContacts (List<Contact> contacts)
    {
    if (contacts.isEmpty())
    {
    System.out.println("No contact is found");
    return;
    }
    for (Contact c : contacts)
        System.out.println(c);
    }
    public void displayError(String message)
    {
        System.out.println("Error" + message);
}
}
