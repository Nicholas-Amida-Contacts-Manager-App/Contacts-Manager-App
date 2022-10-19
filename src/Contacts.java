
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

    public String getName(){
        return this.firstName +" "+this.lastName;
    }
    public String format = "%16s%10s%16s";
    public String toString() {
        return String.format(format,this.getName(),"|",this.number);
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
