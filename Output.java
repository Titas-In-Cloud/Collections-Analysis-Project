import java.io.*;
import java.util.List;

public class Output {

    public void outputInTable(Directory directory){

        String leftAlignFormat = "| %-14s | %-9s | %-9s |%n";

        String surname, initials, number;

        List<Entry> list;
        list = directory.toArrayList();

        System.out.format("+----------------+-----------+-----------+%n");
        System.out.format("| Surname        | Initials  | Extension |%n");
        System.out.format("+----------------+-----------+-----------+%n");

        for(int i = 0; i < list.size(); i++){
            surname = list.get(i).getSurname();
            initials = list.get(i).getInitials();
            number = list.get(i).getNumber();

            System.out.format(leftAlignFormat, surname, initials, number, i*i);
        }

        System.out.format("+----------------+-----------+-----------+%n");
    }

    public void writerCSV(Directory directory) throws IOException {

        BufferedWriter br = new BufferedWriter((new FileWriter("directoryEntries.csv")));
        StringBuilder sb = new StringBuilder();

        String surname, initials, number;

        List<Entry> list;
        list = directory.toArrayList();

        for (Entry entry : list) {
            surname = entry.getSurname();
            initials = entry.getInitials();
            number = entry.getNumber();

            sb.append(surname);
            sb.append(",");
            sb.append(initials);
            sb.append(",");
            sb.append(number);
            sb.append("\n");
        }

        br.write(sb.toString());
        br.close();

    }
}
