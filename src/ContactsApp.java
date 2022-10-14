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

    public static int mainMenu () {
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        System.out.println(" 1. View contacts.");
        System.out.println(" 2. Add a new contact.");
        System.out.println(" 3. Search a contact by name.");
        System.out.println(" 4. Delete an existing contact.");
        System.out.println(" 5. Exit.");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return userInput;
    }

    public static void addPerson () throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 2. Add a new contact");
        System.out.println(" First Name: ");
        String firstName = scanner.nextLine();
        System.out.println(" Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println(" Phone Number: ");
        String number = scanner.nextLine();

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
