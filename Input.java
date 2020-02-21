import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input extends MainClass{

    Scanner userInput = new Scanner(System.in);

    Output output = new Output();

    PerformanceAnalysis performanceAnalysis = new PerformanceAnalysis();

    public void userMenu() throws IOException {

        String answer;
        String directoryName = null;
        Directory directory = null;
        boolean firstCommand = true;

        System.out.print("-What would you like to do? " +
                "Input 'menu' to get a list of available actions. ");
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
                System.out.println(" - directory -  sets which directory to initialize for usage.");
                System.out.println(" - input -      starts manual input of entries to directory.");
                System.out.println(" - csvIn -      reads CSV file and puts all the entries to the directory.");
                System.out.println(" - csvOut -     puts all the directory entries to CSV file.");
                System.out.println(" - table -      returns a table with entries in ASCII format.");
                System.out.println(" - analysis -   runs analysis of Array, Array List and HashMap directories methods.");
                System.out.println(" - exit -       ends the program.");
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
            else if((answer.equals("input") || answer.equals("Input")) && directory != null) {
                userInputCheck(directory);
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

    public Directory whichDirectory(){

        String directoryName;

        System.out.print("-Which directory you would like to use? ");
        directoryName = userInput.next();

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

            // calls entry input method
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

    public void userInput(Directory directory) {

        String surname, initials, number;

        System.out.println("-Please input the following.");
        System.out.print("Surname: ");
        surname = userInput.next();
        System.out.print("Initials: ");
        initials = userInput.next();
        System.out.print("Extension number: ");
        number = userInput.next();

        while(!number.matches("\\d+") || number.length() != 5){
            System.out.print("-Error! Please input a number with 5 digits: ");
            number = userInput.next();
        }

        Entry newEntry = new Entry();
        newEntry.setEntry(surname, initials, number);

        directory.insertEntry(newEntry);
    }

    public ArrayList<Double> readerCSV(Directory directory, boolean countTime) {

        StopWatch stopWatch = new StopWatch();

        ArrayList<Double> executionTimeList = new ArrayList<>();

        double executionTime;

        BufferedReader br = null;
        String variablesSplitBy = ",";
        String line;

        try{
            br = new BufferedReader(new FileReader("test_data.csv"));
            while ((line = br.readLine()) != null){
                String[] entry = line.split(variablesSplitBy);

                Entry newEntry = new Entry();
                newEntry.setEntry(entry[0], entry[1], entry[2]);

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