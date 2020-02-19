import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {

        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();

        Input input = new Input();
        Output output = new Output();

        // calls method which checks if user wants to add any entries to directory manually
        input.userInputCheck(arrayDirectory, arrayListDirectory, hashMapDirectory);

        // calls a method which adds all entries from csv file to directories
        input.readerCSV(arrayDirectory, arrayListDirectory, hashMapDirectory);

        output.outputInTable(hashMapDirectory);
        output.writerCSV(arrayListDirectory);

    }
}
