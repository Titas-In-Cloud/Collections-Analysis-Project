import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory {

    Entry[] array = new Entry[0];

    public void insertEntry(Entry entry) {

        boolean surnameExists = false;

        // checks if there is a duplicate surname of entry in the array
        for (Entry value : array) {
            if (value.getSurname().equals(entry.getSurname())) {
                surnameExists = true;
                break;
            }
        }

        // adds a new entry to the array if there was no duplicate added before
        if(!surnameExists){
            // creates one size bigger temporary array
            Entry[] temporaryArray = Arrays.copyOf(array,array.length + 1);

            // adds a new entry to the array
            temporaryArray[array.length] = entry;

            // puts all the values to directory array from temporary array
            array = temporaryArray;
        }
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

        // loop which checks the amount of entries that will be deleted
        for (Entry entry : array) {
            if (entry.getNumber().equals(number)) {
                amountDeletedEntries++;
            }
        }

        // creates a temporary array
        Entry[] temporaryArray = new Entry[array.length - amountDeletedEntries];

        // puts all the entries to a temporary array without required extension number
        for(int i = 0, k = 0; i < array.length; i++){
            if(!array[i].getNumber().equals(number)) {
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
                entry.setNumber(newNumber);
            }
        }
    }

    public String lookupExtension(String surname) {
        
        // searches for the required surname and saves it's extension
        for (Entry entry : array) {
            if (entry.getSurname().equals(surname)) {
                return entry.getNumber();
            }
        }
        return surname;
    }

    public List<Entry> toArrayList() {

        // creates and returns a list with all the objects of the array
        return new ArrayList<>(Arrays.asList(array));

    }
}