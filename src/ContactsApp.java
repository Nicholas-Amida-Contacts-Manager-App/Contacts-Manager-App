import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class ContactsApp {



   //*************************** this function shows the available options*************************************
    public static int mainMenu() {
        System.out.println("Select an option");
        String[] options = {
                "View contacts.",
                "Add a new contact.",
                "Search a contact by name.",
                "Delete an existing contact.",
                "Exit."};
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ": " + options[i]);
        }

        return Input.getInt("");
    }


    //*********************this function reads file and add to an arraylist**************************************
    public static void loadList(ArrayList<String> arrayList) throws FileNotFoundException {

        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        Scanner s = new Scanner(new File("data/contacts.txt"));

        while (s.hasNext()) {
            arrayList.add(s.nextLine());
        }
        if (!Files.exists(dataFile)) {
            throw new FileNotFoundException("file not found");
        }
        s.close();


    }

    //*******************this function display the contents of an arraylist line by line*************************

    public static void showList(ArrayList<String> arrays) {
        for (String arr : arrays) {
            System.out.println(arr);
        }

    }


    // contacts.add(new Contacts(firstName, lastName, number));
    // System.out.println(firstName + " " + lastName + " has been successfully added to the contact list ");

//********************************* CLEAR THE CONTENT OF THE FILE********************************************
    public static void clearPath() {
        try {
            FileChannel.open(Paths.get("data", "contacts.txt"), StandardOpenOption.WRITE).truncate(0).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // ******************THIS FUNCTION CREATES A NEW CONTACT AND ADD TO AN ARRAYLIST*********************
    public static void creatNew(ArrayList<String> arr) {
        Contacts cn = new Contacts(Contacts.setFirstName(), Contacts.setLastName(), Contacts.setNumber());
        arr.add(cn.getNameNum());

        String response = Input.getString("Do u want to add another contact [y/n]");
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            creatNew(arr);
        } else if(response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no"))
        {
            System.out.println("Ok");

        }

    }
//*************************************DELETE CONTACTS***********************************************************
public static void deleteOption(ArrayList<String>array, String name) {

    for (String arr : array) {
        if (arr.contains(name)) {
            array.remove(arr);
            break;

        } else {

            System.out.println(arr + "\n");



        }

    }
    System.out.println("contact not found");


}





    //*********************************Clear file /Add data to file**********************************************************

    public static void appendAll(ArrayList<String> contacts) {
        clearPath();  //clear path function

        ListIterator<String> list = contacts.listIterator();
        while (list.hasNext()) {

            try {            //write one line at a time
                Files.write(
                        Paths.get("data", "contacts.txt"),
                        List.of(list.next()), // list with one item
                        StandardOpenOption.APPEND


                );


            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(list.next());
            }

        }
        System.exit(0);

    }


    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> contacts = new ArrayList<>();


        Contacts mido = new Contacts("Mido", "ostar", "5555555555");
        Contacts nico = new Contacts("Nico", "barrera", "4444444444");
        Contacts jordy = new Contacts("Jordy", "ostar", "3333333333");
        contacts.add(mido.getNameNum());
        contacts.add(nico.getNameNum());
        contacts.add(jordy.getNameNum());


        boolean Run = true;
        do {
            int choice = mainMenu();
            switch (choice) {

                case 1: //load from file
                    loadList(contacts);
                    showList(contacts);
                    break;


                case 2:  //Add contacts
                    creatNew(contacts);
                    appendAll(contacts);
                    break;


                case 3:   //Search a contact by name

                    break;


                case 4:   //Delete an existing contact
                    deleteOption(contacts, Input.getString("the name of the contact u want to delete"));

                    break;


                case 5:   //Exit

                    appendAll(contacts);

                    break;


                default:
                    System.out.println("try again");
                    break;
            }

        }while (Run==true);
    }
}