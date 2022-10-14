
public class Contacts {
    private String firstName;
    private String lastName;
    private String number;

    public Contacts (String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + "Phone number: " + this.number;
    }





}
