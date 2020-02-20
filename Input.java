import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Input extends MainClass{

    Scanner userInput = new Scanner(System.in);

    public Directory whichDirectory(){

        String directoryName;

        System.out.print("To which directory you would like to insert your entries? ");
        directoryName = userInput.next();

        while (!directoryName.equals("Array") && !directoryName.equals("array")
                && !directoryName.equals("ArrayList") && !directoryName.equals("arraylist")
                && !directoryName.equals("HashMap") && !directoryName.equals("hashmap")) {
            System.out.print("Error! Please choose 'Array', 'ArrayList' or 'HashMap'. ");
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

        System.out.print("Do you want to insert any entries to directory? ");
        inputAnswer = userInput.next();

        // checks if answer was Yes or No. Returns Error if it was not.
        while (!inputAnswer.equals("Yes") && !inputAnswer.equals("yes") &&
                !inputAnswer.equals("No") && !inputAnswer.equals("no")) {
            System.out.print("Error! Please choose 'Yes' or 'No'. ");
            inputAnswer = userInput.next();
        }

        if(inputAnswer.equals("Yes") || inputAnswer.equals("yes")){

            // calls entry input method
            userInput(directory);

            while(true){

                System.out.print("Do you want to insert one more entry? ");
                moreInput = userInput.next();

                // checks if answer was Yes or No. Returns Error if it was not.
                while (!moreInput.equals("Yes") && !moreInput.equals("yes") &&
                        !moreInput.equals("No") && !moreInput.equals("no")) {
                    System.out.print("Error! Please choose 'Yes' or 'No'. ");
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

        System.out.println("Please input the following.");
        System.out.print("Surname: ");
        surname = userInput.next();
        System.out.print("Initials: ");
        initials = userInput.next();
        System.out.print("Extension number: ");
        number = userInput.next();

        while(!number.matches("\\d+") || number.length() != 5){
            System.out.print("Error! Please input a number with 5 digits: ");
            number = userInput.next();
        }

        Entry newEntry = new Entry();
        newEntry.setEntry(surname, initials, number);

        directory.insertEntry(newEntry);
    }

    public void readerCSV(Directory directory) {
        String csvFile = "test_data.csv";
        BufferedReader br = null;
        String line = "";
        String variablesSplitBy = ",";

        StopWatch stopWatch = new StopWatch();

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null){
                String[] entry = line.split(variablesSplitBy);

                Entry newEntry = new Entry();
                newEntry.setEntry(entry[0], entry[1], entry[2]);

                directory.insertEntry(newEntry);
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
    }
}