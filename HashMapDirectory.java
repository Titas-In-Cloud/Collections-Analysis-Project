import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {

    HashMap<String,Entry> hashMapDirectorySurname = new HashMap<>();
    HashMap<String,Entry> hashMapDirectoryNumber = new HashMap<>();

    public void insertEntry(Entry entry) {

        // puts new entry to 2 hash maps - one with an index of surname and another of number
        hashMapDirectorySurname.put(entry.getSurname(), entry);
        hashMapDirectoryNumber.put(entry.getNumber(), entry);

    }

    public void deleteEntryUsingName(String surname) {

        hashMapDirectoryNumber.remove(hashMapDirectorySurname.get(surname).getNumber());
        hashMapDirectorySurname.remove(surname);

    }

    public void deleteEntryUsingExtension(String number) {

        hashMapDirectorySurname.remove(hashMapDirectoryNumber.get(number).getSurname());
        hashMapDirectoryNumber.remove(number);

    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        hashMapDirectoryNumber.get(hashMapDirectorySurname.get(surname).getNumber()).setNumber(newNumber);
        hashMapDirectorySurname.get(surname).setNumber(newNumber);

    }

    public String lookupExtension(String surname) {

        return hashMapDirectorySurname.get(surname).getNumber();
    }

    public List<Entry> toArrayList() {

        // creates and returns a list with all the objects of the array list;
        return new ArrayList<>(hashMapDirectorySurname.values());
    }
}