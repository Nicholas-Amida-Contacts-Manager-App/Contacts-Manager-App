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
        System.out.println("Select an option \n");
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
        System.out.println("-----------------------------------------------------");
        System.out.printf( "%16s%10s%16s\n","NAME","|","NUMBER");
        System.out.println("-----------------------------------------------------");
        for (String arr : arrays) {
            System.out.println(arr);
        }
        System.out.println("-----------------------------------------------------");

    }




    //********************************* Show numbered list of contacts ***********************************************************
    public static void showListAndIndex(ArrayList<String> arrays) {
        System.out.println("-----------------------------------------------------");
        System.out.printf( "%16s%13s%16s\n","NAME","|","NUMBER");
        System.out.println("-----------------------------------------------------");
        for (int i=0;i<arrays.size();i++) {
            System.out.println(i+1 +": "+ arrays.get(i) );
        }
        System.out.println("-----------------------------------------------------");

    }






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
        arr.add(cn.toString());

        String response = Input.getString("Do u want to add another contact [y/n]");
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            creatNew(arr);
        } else if(response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no"))
        {
            System.out.println("your contacts has been added");

        }

    }



//*************************************DELETE CONTACTS***********************************************************
public static void deleteOption(ArrayList<String>array, int num) {

    array.remove(num);

    }





//**********************Search for contact*********************************
public static void search (String name, ArrayList<String> contact){
for(String arr : contact){
    if(arr.contains(name)){
        System.out.println( arr);
    }

    }

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



    //********************************Main************************************************************

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> contacts = new ArrayList<>();


        Contacts jordy = new Contacts("Jordy", "ostar", "3333333333");

       // contacts.add(jordy.toString());


        boolean Run = true;
        loadList(contacts);
        do {
            int choice = mainMenu();
            switch (choice) {

                case 1: //load from file

                    showList(contacts);
                    break;


                case 2:  //Add contacts
                    creatNew(contacts);
                    showList(contacts);
                    break;


                case 3:   //Search a contact by name
                    search(Input.getString("Enter the name you want to search for"),contacts);

                    break;


                case 4:   //Delete an existing contact
                    showListAndIndex(contacts);
                int ask = Input.getInt("choose a contact to delete; 1, 2 , 3 .....");
                    deleteOption(contacts,ask-1);
                    System.out.println("\n");
                    showList(contacts);
                    break;


                case 5:   //Exit

                    appendAll(contacts);

                    break;


                default:
                    System.out.println("try again");
                    break;
            }
            System.out.println("\n");
            System.out.println("Do u want to do anything else");
            int answer = Input.getInt(" 1:  Save and Exit \n 2: Back to main Menu");
            if (answer == 1) {
                appendAll(contacts);
            }else {Run=true;}
        }while (Run);
    }
}