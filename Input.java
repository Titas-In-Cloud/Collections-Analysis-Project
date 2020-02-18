import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Input extends MainClass{

    public void userInput(Directory directory) {

        String surname, initials;
        int number;

        Scanner user_input = new Scanner(System.in);

        System.out.println("Please input the following: ");
        System.out.print("Surname: ");
        surname = user_input.next();
        System.out.print("Initials: ");
        initials = user_input.next();
        System.out.print("Extension number: ");
        number = user_input.nextInt();

        while(String.valueOf(number).length() != 5){
            System.out.print("Error! Please input number with 5 digits: ");
            number = user_input.nextInt();
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

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null){
                String[] entry = line.split(variablesSplitBy);

                Entry newEntry = new Entry();

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