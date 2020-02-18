import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {

    Entry[] array = new Entry[0];

    public void insertEntry(Entry entry) {

        // creates one size bigger temporary array
        Entry[] temporaryArray = Arrays.copyOf(array,array.length + 1);

        // puts a new entry to the array
        temporaryArray[array.length] = entry;

        // puts all the values to directory array from temporary array
        array = temporaryArray;

    }

    public void deleteEntryUsingName(String surname) {

        // variable to check how many entries will need to be deleted out of array
        int amountDeletedEntries = 0;

        // loop which checks the amount of entries that will be deleted
        for (Entry entry : array) {
            if (entry.getSurname().equals(surname)) {
                amountDeletedEntries++;
            }
        }

        // creates a temporary array
        Entry[] temporaryArray = new Entry[array.length - amountDeletedEntries];

        // puts all the entries to a temporary array without required surname
        for(int i = 0, k = 0; i < array.length; i++){
            if(!array[i].getSurname().equals(surname)) {
                temporaryArray[k] = array[i];
                k++;
            }
        }

        // puts all the values to directory array from temporary array
        array = temporaryArray;

    }

    public void deleteEntryUsingExtension(String number) {

        // variable to check how many entries will need to be deleted out of array
        int amountDeletedEntries = 0;

        // converts string to intager value
        int intNumber = Integer.parseInt(number);

        // loop which checks the amount of entries that will be deleted
        for (Entry entry : array) {
            if (entry.getNumber() != intNumber) {
                amountDeletedEntries++;
            }
        }

        // creates a temporary array
        Entry[] temporaryArray = new Entry[array.length - amountDeletedEntries];

        // puts all the entries to a temporary array without required surname
        for(int i = 0, k = 0; i < array.length; i++){
            if(array[i].getNumber() != intNumber) {
                temporaryArray[k] = array[i];
                k++;
            }
        }

        // puts all the values to directory array from temporary array
        array = temporaryArray;

    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        // searches for the entry with required surname and updates it's extension
        for (Entry entry : array) {
            if (entry.getSurname().equals(surname)) {
                // converts string to intager value
                int intNumber = Integer.parseInt(newNumber);
                entry.setNumber(intNumber);
            }
        }

    }

    public String lookupExtension(String surname) {

        String numberExtension = null;
        
        // searches for the required surname and saves it's extension
        for (Entry entry : array) {
            if (entry.getSurname().equals(surname)) {
                numberExtension = Integer.toString(entry.getNumber());
            }
        }
        return numberExtension;
    }

    public List<Entry> toArrayList() {

        // creates and returns a list with all the objects of the array
        return new ArrayList<>(Arrays.asList(array));

    }
}