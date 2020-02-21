public class TestMethods {
    public void runTestMethods(){

        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();

        testMethods(arrayDirectory);
        testMethods(arrayListDirectory);
        testMethods(hashMapDirectory);
    }

    public void testMethods(Directory directory) {

        Input input = new Input();
        Output output = new Output();

        System.out.println("\nTESTING OF " + directory);
        System.out.println("From 'test_data_methods.csv' file\n");
        System.out.println(" --- Inputs entries from test_data_methods.csv --- ");
        System.out.println("Must be only 6 following entries (not 9 i.e. without 3 duplicates): ");
        System.out.println("* First, F.T, 11111");
        System.out.println("* Second,S.D,22222");
        System.out.println("* Third,T.D,33333");
        System.out.println("* Fourth,F.H,44444");
        System.out.println("* Fifth,F.H,55555");
        System.out.println("* Sixth,S.H,66666");

        input.readerCSV(directory, false);

        System.out.println("Directory entries after method was initialized:");
        output.outputInTable(directory);


        System.out.println("\n --- Lookup by extension method --- ");
        System.out.println("Searches for 'Sixth' and 'First' extension number.");

        System.out.println("Sixth's number: " + directory.lookupExtension("Sixth"));
        System.out.println("First's number: " + directory.lookupExtension("First"));


        System.out.println("\n --- Update extension number by surname method --- ");
        System.out.println("Entry to be updated: 'Fifth' to '51515' number");
        System.out.println("Entry to be updated: 'Fourth' to '42424' number");

        directory.updateExtensionUsingName("Fifth", "51515");
        directory.updateExtensionUsingName("Fourth", "42424");

        System.out.println("Directory entries after method was initialized:");
        output.outputInTable(directory);


        System.out.println("\n --- Delete entry by surname method --- ");
        System.out.println("Deletes 'First' and 'Fourth' entries.");

        directory.deleteEntryUsingName("First");
        directory.deleteEntryUsingName("Fourth");

        System.out.println("Directory entries after method was initialized:");
        output.outputInTable(directory);


        System.out.println("\n --- Delete entry by extension number method --- ");
        System.out.println("Deletes '66666' and '22222' entries");

        directory.deleteEntryUsingExtension("66666");
        directory.deleteEntryUsingExtension("22222");

        System.out.println("Directory entries after method was initialized:");
        output.outputInTable(directory);


        System.out.println("\n --- Return Array List method --- ");
        System.out.println("Must return array list with following left entries in the directory:");
        System.out.println("* Third,T.D,33333");
        System.out.println("* Fifth,F.H,51515");

        System.out.println("Array List with hash codes: " + directory.toArrayList());
        System.out.println("Which is:");
        for(int i = 0; i < directory.toArrayList().size(); i++){
            System.out.println("* " + directory.toArrayList().get(i).getSurname() + "," +
                    directory.toArrayList().get(i).getInitials() + "," +
                    directory.toArrayList().get(i).getNumber());
        }
        System.out.println("\n");
    }
}