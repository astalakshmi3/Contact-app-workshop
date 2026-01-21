package astalakshmi.example.model;

public class Contact {
private String name;
private String phoneNumber;
private static final String PHONE_REGEX = "\\d{10}";

public  String getName() {
	return name;
}
public void setName(String name) {
    if (name == null || name.isEmpty())
    {
        throw new IllegalArgumentException("Name cannot be empty");
    }
	this.name = name.trim();
}
public  String getPhoneNumber() {
    return  phoneNumber;
}
public  void setPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isEmpty())
    {
        throw new IllegalArgumentException("Phone number cannot empty");
    }
    if(phoneNumber.length()<10)
    {
        IO.println("Phone number is too short");
    }
    String trimmed= phoneNumber.trim();
    if (!trimmed.matches (PHONE_REGEX))
    {
        throw new IllegalArgumentException("Phone number is invalid");
    }
    this.phoneNumber = trimmed;
}

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
