import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {

    int index = 0;

    HashMap<Integer,Entry> hashMapDirectory = new HashMap<>();

    public void insertEntry(Entry entry) {

        // puts entry to a hash map in an index of index
        hashMapDirectory.put(index, entry);
        index++;

    }

    public void deleteEntryUsingName(String surname) {

        // removes entry from the hash map by required surname
        for(int i = 0; i < hashMapDirectory.size(); i++){
            if(hashMapDirectory.get(i).getSurname().equals(surname)){
                hashMapDirectory.remove(i);
            }
        }
    }

    public void deleteEntryUsingExtension(String number) {

        // removes entry from the array list by required extension number
        for(int i = 0; i < hashMapDirectory.size(); i++){
            if(hashMapDirectory.get(i).getNumber() == Integer.parseInt(number)){
                hashMapDirectory.remove(i);
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        // searches for the entry with required surname and updates it's extension
        for(int i = 0; i < hashMapDirectory.size(); i++){
            if(hashMapDirectory.get(i).getSurname().equals(surname)){
                // changes extension to a new extension which was converted to integer
                hashMapDirectory.get(i).setNumber(Integer.parseInt(newNumber));
            }
        }
    }

    public String lookupExtension(String surname) {

        String numberExtension = null;

        // searches for the required surname and saves it's extension
        for(int i = 0; i < hashMapDirectory.size(); i++){
            if(hashMapDirectory.get(i).getSurname().equals(surname)){
                numberExtension = Integer.toString(hashMapDirectory.get(i).getNumber());
            }
        }

        return numberExtension;
    }

    public List<Entry> toArrayList() {
        return null;
    }
}