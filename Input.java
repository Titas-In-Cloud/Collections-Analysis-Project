import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

    Output output = new Output();

    PerformanceAnalysis performanceAnalysis = new PerformanceAnalysis();
    TestMethods testMethods = new TestMethods();

    // user input menu where the methods are called to be executed
    public void userMenu() throws IOException {

        String answer;
        String answerToObject;
        String newExtensionNumber;
        String directoryName = null;
        Directory directory = null;
        boolean firstCommand = true;

        System.out.println("-What would you like to do? " +
                "Input 'menu' to get a list of available actions. ");
        System.out.print("Action: ");
        answer = userInput.next();

        while(true) {
            if(answer.equals("directory") || answer.equals("Directory")){
                directory = whichDirectory();
                if(directory.toString().contains("ArrayDirectory")) { directoryName = "Array"; }
                if(directory.toString().contains("ArrayListDirectory")) { directoryName = "Array List"; }
                if(directory.toString().contains("HashMapDirectory")) { directoryName = "HashMap"; }
                System.out.println("-You chose " + directoryName + " directory.");
            }
            else if(answer.equals("menu") || answer.equals("Menu")) {
                System.out.println("Action menu:");
                System.out.println(" - directory -    sets which directory to initialize for usage.");
                System.out.println(" - input -        starts manual input of entries to directory.");
                System.out.println(" - deleteName -   deletes object by it's surname.");
                System.out.println(" - deleteNumber - deletes object by it's extension number.");
                System.out.println(" - updateNumber - updates extension number by object's surname.");
                System.out.println(" - csvIn -        reads CSV file and puts all the entries to the directory.");
                System.out.println(" - csvOut -       puts all the directory entries to CSV file and saves it.");
                System.out.println(" - table -        returns a table with entries of directory in ASCII format.");
                System.out.println(" - analysis -     runs analysis of Array, Array List and HashMap directories methods.");
                System.out.println(" - test -         runs tests of Array, Array List and HashMap methods.");
                System.out.println(" - exit -         ends the program.");
            }
            else if(answer.equals("exit") || answer.equals("Exit")){
                System.out.println("-Program was closed.");
                break;
            }
            else if(answer.equals("analysis") || answer.equals("Analysis")){
                performanceAnalysis.directoryPerformance("Array");
                performanceAnalysis.directoryPerformance("ArrayList");
                performanceAnalysis.directoryPerformance("HashMap");
                System.out.println("-Analysis was done successfully and " +
                        "txt files were created with method running times.");
            }
            else if(answer.equals("test") || answer.equals("Test")){
                testMethods.runTestMethods();
            }
            else if((answer.equals("input") || answer.equals("Input")) && directory != null) {
                userInputCheck(directory);
            }
            else if((answer.equals("deletename") || answer.equals("deleteName")) && directory != null){
                System.out.print("-What object you would like to delete? Please specify it's surname: ");
                answerToObject = userInput.next();
                boolean containsSurname = false;
                List<Entry> list = directory.toArrayList();
                for (Entry entry : list) {
                    if (entry.getSurname().equals(answerToObject)) {
                        containsSurname = true;
                        break;
                    }
                }
                if(containsSurname){
                    directory.deleteEntryUsingName(answerToObject);
                    System.out.println("-Object was successfully deleted.");
                } else System.out.println("-Error! There is no object with " +
                        answerToObject + " surname in the directory");
            }
            else if((answer.equals("deletenumber") || answer.equals("deleteNumber")) && directory != null) {
                System.out.print("-What object you would like to delete? Please specify it's number: ");
                answerToObject = userInput.next();
                boolean containsNumber = false;
                List<Entry> list = directory.toArrayList();
                for (Entry entry : list) {
                    if (entry.getNumber().equals(answerToObject)) {
                        containsNumber = true;
                        break;
                    }
                }
                if(containsNumber){
                    directory.deleteEntryUsingExtension(answerToObject);
                    System.out.println("-Object was successfully deleted.");
                } else System.out.println("-Error! There is no object with " +
                        answerToObject + " extension number in the directory");
            }
            else if((answer.equals("updatenumber") || answer.equals("updateNumber")) && directory != null){
                System.out.print("-Which object's extension number you would like to update? " +
                        "Please specify it's surname: ");
                answerToObject = userInput.next();
                boolean containsSurname = false;
                List<Entry> list = directory.toArrayList();
                for (Entry entry : list) {
                    if (entry.getSurname().equals(answerToObject)) {
                        containsSurname = true;
                        break;
                    }
                }
                if(containsSurname){
                    System.out.print("-Input new extension number: ");
                    newExtensionNumber = userInput.next();
                    while(!newExtensionNumber.matches("\\d+") || newExtensionNumber.length() != 5) {
                        System.out.print("-Error! Please input a number with 5 digits: ");
                        newExtensionNumber = userInput.next();
                    }
                    directory.updateExtensionUsingName(answerToObject, newExtensionNumber);
                    System.out.println("-Object was successfully updated.");
                } else System.out.println("-Error! There is no object with " +
                        answerToObject + " surname in the directory");
            }
            else if((answer.equals("csvin") || answer.equals("csvIn")) && directory != null){
                readerCSV(directory, false);
                System.out.println("-Entries from CSV file were successfully put to the " + directoryName + " directory.");
            }
            else if((answer.equals("csvout") || answer.equals("csvOut")) && directory != null){
                output.writerCSV(directory);
                System.out.println("-CSV file was successfully created with entries from " + directoryName + " directory.");
            }
            else if((answer.equals("table") || answer.equals("Table")) && directory != null){
                output.outputInTable(directory);
            }
            else if(firstCommand) {
                System.out.println("-Error! Please input 'menu' to get menu of available actions. ");
                firstCommand = false;
            }
            else if(directory == null) {
                System.out.println("-Please input 'directory' to initialize directory first.");
            }
            else System.out.println("-Error! Please input 'menu' to get menu of available actions. ");

            System.out.print("Action: ");
            answer = userInput.next();
        }
    }

    // asks user which directory he wants to choose for usage
    public Directory whichDirectory(){

        String directoryName;

        System.out.print("-Which directory you would like to use? ");
        directoryName = userInput.next();

        // checks if inputted value is a valid directory
        while (!directoryName.equals("Array") && !directoryName.equals("array")
                && !directoryName.equals("ArrayList") && !directoryName.equals("arraylist")
                && !directoryName.equals("HashMap") && !directoryName.equals("hashmap")) {
            System.out.print("-Error! Please choose 'Array', 'ArrayList' or 'HashMap'. ");
            directoryName = userInput.next();
        }
        switch (directoryName) {
            case "Array":
                return new ArrayDirectory();
            case "array":
                return new ArrayDirectory();
            case "ArrayList":
                return new ArrayListDirectory();
            case "arraylist":
                return new ArrayListDirectory();
            case "HashMap":
                return new HashMapDirectory();
            case "hashmap":
                return new HashMapDirectory();
            default:
                return null;
        }
    }

    // checks if user wants to add entries manually or not
    public void userInputCheck(Directory directory){

        String inputAnswer, moreInput;

        System.out.print("-Do you want to insert any entries to directory? ");
        inputAnswer = userInput.next();

        // checks if answer was Yes or No. Returns Error if it was not.
        while (!inputAnswer.equals("Yes") && !inputAnswer.equals("yes") &&
                !inputAnswer.equals("No") && !inputAnswer.equals("no")) {
            System.out.print("-Error! Please choose 'Yes' or 'No'. ");
            inputAnswer = userInput.next();
        }

        if(inputAnswer.equals("Yes") || inputAnswer.equals("yes")){

            // calls manual entry entry method
            userInput(directory);

            while(true){

                System.out.print("-Do you want to insert one more entry? ");
                moreInput = userInput.next();

                // checks if answer was Yes or No. Returns Error if it was not.
                while (!moreInput.equals("Yes") && !moreInput.equals("yes") &&
                        !moreInput.equals("No") && !moreInput.equals("no")) {
                    System.out.print("-Error! Please choose 'Yes' or 'No'. ");
                    moreInput = userInput.next();
                }

                // calls entry input method if user wants to add more entries to directories
                // breaks loop if user does not want to add more entries to directories
                if(moreInput.equals("Yes") || moreInput.equals("yes")){
                    userInput(directory);
                } else break;
            }
        }
    }

    // manual user input of entries
    public void userInput(Directory directory) {

        String surname, initials, number;

        System.out.println("-Please input the following.");
        System.out.print("Surname: ");
        surname = userInput.next();
        System.out.print("Initials: ");
        initials = userInput.next();
        System.out.print("Extension number: ");
        number = userInput.next();

        // number must be 5 digit integer
        while(!number.matches("\\d+") || number.length() != 5){
            System.out.print("-Error! Please input a number with 5 digits: ");
            number = userInput.next();
        }

        Entry newEntry = new Entry();
        newEntry.setEntry(surname, initials, number);

        directory.insertEntry(newEntry);
    }

    // method which reads csv file and puts objects to directory
    // countTime - tells if there is need to count elapsed time of entry method or not
    public ArrayList<Double> readerCSV(Directory directory, boolean countTime) {

        StopWatch stopWatch = new StopWatch();

        ArrayList<Double> executionTimeList = new ArrayList<>();

        double executionTime;

        BufferedReader br = null;
        String variablesSplitBy = ",";
        String line;

        try{
            br = new BufferedReader(new FileReader("test_data_unique.csv"));
            // reads each string line in csv file and splits it to 3 variables which are put to directory
            while ((line = br.readLine()) != null){
                String[] entry = line.split(variablesSplitBy);

                Entry newEntry = new Entry();
                newEntry.setEntry(entry[0], entry[1], entry[2]);

                // counts elapsed time of insertEntry method if countTime is true
                if(countTime){
                    stopWatch.start();
                    directory.insertEntry(newEntry);
                    stopWatch.stop();

                    executionTime = stopWatch.getElapsedTime();
                    executionTimeList.add(executionTime);

                    stopWatch.reset();

                } else directory.insertEntry(newEntry);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(br != null){
                try{
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return executionTimeList;
    }
}