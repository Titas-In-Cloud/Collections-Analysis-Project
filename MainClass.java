public class MainClass {
    public static void main(String[] args) {

        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();

        Entry newEntry = new Entry();

        newEntry.setEntry("James", "J.K.", 55555);
        arrayListDirectory.insertEntry(newEntry);

        arrayListDirectory.deleteEntryUsingName("James");

    }
}
