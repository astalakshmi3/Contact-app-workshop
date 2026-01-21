### CONTACT APPLICATION


Conceptual Model (Class Diagram)
The following diagram shows the relationship between the different layers of the application and how exceptions flow through them using the MVC (Model-View-Controller) pattern.

 
Suggested Package Structure
Model: model
Data: data
View: view
Controller: controller
Exception: exception
``` mermaid

classDiagram
namespace model {
class Contact {
-String name
-String phoneNumber
+Contact(String name, String phoneNumber)
}
}

    namespace data {
        class ContactDAO {
            <<interface>>
            +findAll() List~Contact~
            +save(Contact contact) void
            +findByName(String name) Contact
        }
        class FileContactDAOImpl {
            -Path filePath
        }
    }

    namespace view {
        class ContactView {
            +getUserInput(String prompt) String
            +displayMenu() void
            +displayContacts(List~Contact~ contacts) void
            +displayMessage(String message) void
            +displayError(String message) void
        }
    }

    namespace controller {
        class ContactController {
            -ContactDAO contactDAO
            -ContactView contactView
            +run() void
        }
    }

    namespace exception {
        class ContactStorageException { }
        class DuplicateContactException { }
        class ExceptionHandler {
            +handle(Exception e)$ void
        }
    }

    ContactDAO <|.. FileContactDAOImpl
    ContactController --> ContactDAO : uses
    ContactController --> ContactView : updates
    ContactController ..> ExceptionHandler : delegates errors
    
    %% Package Dependencies (MVC Flow)
    ContactDAO ..> Contact : manages
    FileContactDAOImpl ..> Contact : persists
    
    %% Exceptions
    Contact ..> IllegalArgumentException : throws
    FileContactDAOImpl ..> ContactStorageException : throws
    FileContactDAOImpl ..> DuplicateContactException : throws
    
 ```