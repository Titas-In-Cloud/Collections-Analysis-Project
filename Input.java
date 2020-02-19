import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Input extends MainClass{

    public void userInputCheck(Directory directory1, Directory directory2, Directory directory3){

        Scanner user_input = new Scanner(System.in);

        String inputAnswer, moreInput;

        System.out.print("Do you want to insert any entries to directory? ");
        inputAnswer = user_input.next();

        // checks if answer was Yes or No. Returns Error if it was not.
        while(true){
            if(inputAnswer.equals("Yes") || inputAnswer.equals("yes") ||
                    inputAnswer.equals("No") || inputAnswer.equals("no")) {
                break;
            }
            System.out.print("Error! Please choose 'Yes' or 'No'. ");
            inputAnswer = user_input.next();
        }

        if(inputAnswer.equals("Yes") || inputAnswer.equals("yes")){

            // calls entry input method
            userInput(directory1, directory2, directory3);

            while(true){

                System.out.println("Do you want to insert one more entry to directory? ");
                moreInput = user_input.next();

                // checks if answer was Yes or No. Returns Error if it was not.
                while(true){
                    if(moreInput.equals("Yes") || moreInput.equals("yes") ||
                            moreInput.equals("No") || moreInput.equals("no")) {
                        break;
                    }
                    System.out.print("Error! Please choose 'Yes' or 'No'. ");
                    moreInput = user_input.next();
                }

                // calls entry input method if user wants to add more entries to directories
                // breaks loop if user does not want to add more entries to directories
                if(moreInput.equals("Yes") || moreInput.equals("yes")){
                    userInput(directory1, directory2, directory3);
                } else break;
            }
        }
    }

    public void userInput(Directory directory1, Directory directory2, Directory directory3) {

        String surname, initials, number;

        Scanner user_input = new Scanner(System.in);

        System.out.println("Please input the following.");
        System.out.print("Surname: ");
        surname = user_input.next();
        System.out.print("Initials: ");
        initials = user_input.next();
        System.out.print("Extension number: ");
        number = user_input.next();

        while(number.length() != 5){
            System.out.print("Error! Please input a number with 5 digits: ");
            number = user_input.next();
        }

        Entry newEntry = new Entry();
        newEntry.setEntry(surname, initials, number);

        directory1.insertEntry(newEntry);
        directory2.insertEntry(newEntry);
        directory3.insertEntry(newEntry);
    }

    public void readerCSV(Directory directory1, Directory directory2, Directory directory3) {
        String csvFile = "test_data.csv";
        BufferedReader br = null;
        String line = "";
        String variablesSplitBy = ",";

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null){
                String[] entry = line.split(variablesSplitBy);

                Entry newEntry = new Entry();
                newEntry.setEntry(entry[0], entry[1], entry[2]);

                directory1.insertEntry(newEntry);
                directory2.insertEntry(newEntry);
                directory3.insertEntry(newEntry);
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