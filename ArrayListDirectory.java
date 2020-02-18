import java.util.List;
import java.util.ArrayList;

public class ArrayListDirectory implements Directory {

    ArrayList<Entry> arrayList = new ArrayList<Entry>();

    public void insertEntry(Entry entry) {

        arrayList.add(entry);
        System.out.println(arrayList.get(0).getSurname());

    }

    public void deleteEntryUsingName(String surname) {

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getSurname().equals(surname)){
                arrayList.remove(i);
            }
        }

    }

    public void deleteEntryUsingExtension(String number) {

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getNumber() == Integer.parseInt(number)){
                arrayList.remove(i);
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getSurname().equals(surname)){
                arrayList.get(i).setNumber(Integer.parseInt(newNumber));
            }
        }

    }

    public String lookupExtension(String surname) {
        return null;
    }

    public List<Entry> toArrayList() {
        return null;
    }
}
