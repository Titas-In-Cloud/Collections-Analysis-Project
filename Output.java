import java.io.*;
import java.util.List;

public class Output {

    public void outputInTable(Directory directory){

        String leftAlignFormat = "| %-14s | %-9s | %-9s |%n";

        String surname, initials, number;

        List<Entry> list = directory.toArrayList();

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

        BufferedWriter br = new BufferedWriter((new FileWriter("test_directory.csv")));
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

    public void performanceAnalysisTxtFile(String directoryType, double[] averageExecutionTime,
                                           double[] bestExecutionTime, double[] worstExecutionTime) throws IOException{

        if(directoryType.equals("Array")){
            try {
                FileWriter writer = new FileWriter("array_directory_analysis.txt");
                writer.write("Array Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + averageExecutionTime[0] + "\n");
                writer.write("Worst time: " + worstExecutionTime[0] + "\n");
                writer.write("Best time: " + bestExecutionTime[0] + "\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[1] + "\n");
                writer.write("Worst time: " + worstExecutionTime[1] + "\n");
                writer.write("Best time: " + bestExecutionTime[1] + "\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[2] + "\n");
                writer.write("Worst time: " + worstExecutionTime[2] + "\n");
                writer.write("Best time: " + bestExecutionTime[2] + "\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + averageExecutionTime[3] + "\n");
                writer.write("Worst time: " + worstExecutionTime[3] + "\n");
                writer.write("Best time: " + bestExecutionTime[3] + "\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(directoryType.equals("ArrayList")){
            try {
                FileWriter writer = new FileWriter("array_list_directory_analysis.txt");
                writer.write("Array List Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + averageExecutionTime[0] + "\n");
                writer.write("Worst time: " + worstExecutionTime[0] + "\n");
                writer.write("Best time: " + bestExecutionTime[0] + "\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[1] + "\n");
                writer.write("Worst time: " + worstExecutionTime[1] + "\n");
                writer.write("Best time: " + bestExecutionTime[1] + "\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[2] + "\n");
                writer.write("Worst time: " + worstExecutionTime[2] + "\n");
                writer.write("Best time: " + bestExecutionTime[2] + "\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + averageExecutionTime[3] + "\n");
                writer.write("Worst time: " + worstExecutionTime[3] + "\n");
                writer.write("Best time: " + bestExecutionTime[3] + "\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(directoryType.equals("HashMap")){
            try {
                FileWriter writer = new FileWriter("hash_map_directory_analysis.txt");
                writer.write("HashMap Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + averageExecutionTime[0] + "\n");
                writer.write("Worst time: " + worstExecutionTime[0] + "\n");
                writer.write("Best time: " + bestExecutionTime[0] + "\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[1] + "\n");
                writer.write("Worst time: " + worstExecutionTime[1] + "\n");
                writer.write("Best time: " + bestExecutionTime[1] + "\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + averageExecutionTime[2] + "\n");
                writer.write("Worst time: " + worstExecutionTime[2] + "\n");
                writer.write("Best time: " + bestExecutionTime[2] + "\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + averageExecutionTime[3] + "\n");
                writer.write("Worst time: " + worstExecutionTime[3] + "\n");
                writer.write("Best time: " + bestExecutionTime[3] + "\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }
}
