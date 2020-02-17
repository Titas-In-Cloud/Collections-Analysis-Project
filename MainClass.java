public class MainClass {
    public static void main(String[] args) {

        Directory aDirectory = new ArrayDirectory();

        Entry newEntry = new Entry();

        newEntry.setEntry("James", "J.K.", 55555);
        aDirectory.insertEntry(newEntry);

        aDirectory.deleteEntryUsingName("James");

    }
}
