import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class ContactsApp {
    public static ArrayList<Contacts> contacts = new ArrayList<>();


    Contacts mido = new Contacts("Mido", "ostar", "5555555555");
    Contacts nico = new Contacts("Nico", "barrera", "4444444444");
    Contacts jordy = new Contacts("Jordy", "ostar", "3333333333");

    public static void mainMenu () {
        System.out.println("Select an option" );
        String[] options = {
                "View contacts.",
                "Add a new contact.",
                "Search a contact by name.",
                "Delete an existing contact.",
                "Exit."};
        for (int i =0; i<options.length;i++ ){
            System.out.println(i+1+": "+options[i] );
        }
        Input.getInt("");

    }

    public static void addPerson () throws IOException {

        System.out.println(" 2. Add a new contact");

        String firstName =  Input.getString(" First Name: ");

        String lastName =  Input.getString(" Last Name: ");

        String number =  Input.getString(" Phone Number: ");


        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + number),
                StandardOpenOption.APPEND
        );
        contacts.add(new Contacts(firstName, lastName, number));
        System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");
    }








    public static void main(String[] args) {

        mainMenu();

    }
}