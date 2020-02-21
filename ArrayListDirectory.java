import java.util.List;
import java.util.ArrayList;

public class ArrayListDirectory implements Directory {

    ArrayList<Entry> arrayList = new ArrayList<>();

    public void insertEntry(Entry entry) {

        boolean surnameExists = false;

        // checks if there is a duplicate surname of entry in the array list
        for (Entry value : arrayList) {
            if (value.getSurname().equals(entry.getSurname())) {
                surnameExists = true;
                break;
            }
        }
        // adds new entry to an array list if there was no duplicate added before
        if(!surnameExists){
            arrayList.add(entry);
        }
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
            if(arrayList.get(i).getNumber().equals(number)){
                arrayList.remove(i);
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        // searches for the entry with required surname and updates it's extension
        for (Entry entry : arrayList) {
            if (entry.getSurname().equals(surname)) {
                // changes extension to a new extension which was converted to integer
                entry.setNumber(newNumber);
            }
        }
    }

    public String lookupExtension(String surname) {

        String numberExtension = null;

        // searches for the required surname and saves it's extension
        for (Entry entry : arrayList) {
            if (entry.getSurname().equals(surname)) {
                numberExtension = entry.getNumber();
            }
        }
        return numberExtension;
    }

    public List<Entry> toArrayList() {

        // creates and returns a list with all the objects of the array list;
        return new ArrayList<>(arrayList);

    }
}