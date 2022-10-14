import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
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



    }

    public static void addPerson () throws IOException {


        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + number),
                StandardOpenOption.APPEND
        );
        contacts.add(new Contacts(firstName, lastName, number));
        System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");
    }



    public static void main(String[] args) throws IOException {

        System.out.println(mainMenu());
        ContactsApp.addPerson();

    }
}
