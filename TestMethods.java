public class TestMethods {
    // runs testMethods method with all 3 directories
    public void runTestMethods(){

        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();

        testMethods(arrayDirectory);
        testMethods(arrayListDirectory);
        testMethods(hashMapDirectory);
    }

    // tests if methods of directories are working without any bugs.
    public void testMethods(Directory directory) {

        Output output = new Output();

        System.out.println("\nTESTING OF " + directory + "\n");
        System.out.println(" --- Entry Method ---");

        Entry entry1 = new Entry();
        entry1.setEntry("First", "F.T", "11111");
        directory.insertEntry(entry1);
        System.out.println("Inserted: " + entry1.getSurname() + "," + entry1.getInitials() + "," + entry1.getNumber());

        Entry entry2 = new Entry();
        entry2.setEntry("Second", "S.D", "22222");
        directory.insertEntry(entry2);
        System.out.println("Inserted: " + entry2.getSurname() + "," + entry2.getInitials() + "," + entry2.getNumber());

        Entry entry3 = new Entry();
        entry3.setEntry("Third", "T.D", "33333");
        directory.insertEntry(entry3);
        System.out.println("Inserted: " + entry3.getSurname() + "," + entry3.getInitials() + "," + entry3.getNumber());

        // it should not insert this entry because it is the duplicate
        Entry entry4 = new Entry();
        entry4.setEntry("Second", "S.D", "44444");
        directory.insertEntry(entry4);
        System.out.println("Was not inserted (because it is a duplicate): " + entry4.getSurname() + ","
                + entry4.getInitials() + "," + entry4.getNumber());

        output.outputInTable(directory);


        System.out.println("\n --- Lookup By Surname Method --- ");
        System.out.println("Searches for 'Second' extension number (should be 22222).");
        System.out.println("Extension number: " + directory.lookupExtension("Second"));

        output.outputInTable(directory);


        System.out.println("\n --- Update Number By Surname Method --- ");
        System.out.println("Updated 'First' extension number to '12121'.");
        directory.updateExtensionUsingName("First", "12121");

        output.outputInTable(directory);


        System.out.println("\n --- Delete Entry By Surname Method --- ");
        System.out.println("Entry with surname 'Third' was deleted.");
        directory.deleteEntryUsingName("Third");

        output.outputInTable(directory);


        System.out.println("\n --- Delete Entry By Extension Number Method --- ");
        System.out.println("Entry with extension number '22222' was deleted.");
        directory.deleteEntryUsingExtension("22222");

        output.outputInTable(directory);


        System.out.println("\n --- Return Array List Method --- ");
        System.out.println("Must return entry's 'First,F.T,12121' hash code (" + entry1 + ").");
        System.out.println("Returned hash code: " + directory.toArrayList());
        System.out.println("Which is: " + directory.toArrayList().get(0).getSurname() + "," +
                directory.toArrayList().get(0).getInitials() + "," +
                directory.toArrayList().get(0).getNumber());
    }
}