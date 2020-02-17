import java.util.List;
import java.util.Scanner;

public class ArrayDirectory implements Directory {

    Scanner user_input = new Scanner(System.in);

    Entry[] array = new Entry[100000];
    int numberOfArrayEntry = 0;

    public void insertEntry(Entry entry) {

        System.out.println("To create new entry in the directory, please input the following.");
        System.out.print("Surname: ");
        entry.surname = user_input.next();
        System.out.print("Initials: ");
        entry.initials = user_input.next();
        System.out.print("Number: ");
        entry.number = user_input.next();

        array[numberOfArrayEntry] = entry;

        /*
        System.out.println("New entry was successfully created in the directory.");
        System.out.println(array[numberOfArrayEntry].surname);
        System.out.println(array[numberOfArrayEntry].initials);
        System.out.println(array[numberOfArrayEntry].number);
         */

        numberOfArrayEntry++;

    }

    public void deleteEntryUsingName(String surname) {

    }

    public void deleteEntryUsingExtension(String number) {

    }

    public void updateExtensionUsingName(String surname, String newNumber) {

    }

    public String lookupExtension(String surname) {
        return null;
    }

    public List<Entry> toArrayList() {
        return null;
    }

    public ArrayDirectory() { }

    public static void main(String[] args){

        Directory directory = new ArrayDirectory();
        Entry newEntry = new Entry();
        directory.insertEntry(newEntry);

    }
}