import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArrayListDirectory implements Directory {

    ArrayList<Entry> arrayList = new ArrayList<Entry>();

    public void insertEntry(Entry entry) {

        // adds new entry to an array list
        arrayList.add(entry);

    }

    public void deleteEntryUsingName(String surname) {

        // removes entry from the array list by required surname
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getSurname().equals(surname)){
                arrayList.remove(i);
            }
        }
    }

    public void deleteEntryUsingExtension(String number) {

        // removes entry from the array list by required extension number
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getNumber() == Integer.parseInt(number)){
                arrayList.remove(i);
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        // searches for the entry with required surname and updates it's extension
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getSurname().equals(surname)){
                // changes extension to a new extension which was converted to integer
                arrayList.get(i).setNumber(Integer.parseInt(newNumber));
            }
        }
    }

    public String lookupExtension(String surname) {

        String numberExtension = null;

        // searches for the required surname and saves it's extension
        for (Entry entry : arrayList) {
            if (entry.getSurname().equals(surname)) {
                numberExtension = Integer.toString(entry.getNumber());
            }
        }
        return numberExtension;
    }

    public List<Entry> toArrayList() {

        // creates and returns a list with all the objects of the array list;
        return new ArrayList<>(arrayList);

    }
}