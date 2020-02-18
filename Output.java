import java.util.List;

public class Output {

    public void output(Directory directory){

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

}
