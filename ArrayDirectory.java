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
        for(int i = 0; i < array.length; i++){
            if(array[i].getSurname().equals(surname)){
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

    }

    public void updateExtensionUsingName(String surname, String newNumber) {

    }

    public String lookupExtension(String surname) {
        return null;
    }

    public List<Entry> toArrayList() {
        return null;
    }

    public static void main(String[] args){

        int entryIndex;

        Directory directory = new ArrayDirectory();

        Entry newEntry = new Entry();

        directory.deleteEntryUsingName("James");

    }
}