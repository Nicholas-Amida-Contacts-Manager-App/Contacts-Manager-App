
public class Contacts {
    private String firstName;
    private String lastName;
    private String number;



    public Contacts (String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getNameNum(){
        return this.firstName +" "+this.lastName+ " | "+ this.number;
    }
    public String toString() {
        return this.firstName + " " + this.lastName + "Phone number: " + this.number;
    }


//Function to add a new contact
public static String setFirstName(){
    return  Input.getString(" Enter First Name: ");

}

    public static String setLastName(){
        return  Input.getString(" Enter Last Name: ");

    }

    public static String setNumber(){
        return  Input.getString(" Enter Phone Number: ");

    }



}
