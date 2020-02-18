public class MainClass {
    public static void main(String[] args) {

        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();

        Input input = new Input();

        Entry newEntry = new Entry();

        newEntry.setEntry("James", "J.K.", 55555);
        arrayListDirectory.insertEntry(newEntry);

        input.writerDirectory(arrayListDirectory);
        input.readerCSV(arrayListDirectory);

    }
}
