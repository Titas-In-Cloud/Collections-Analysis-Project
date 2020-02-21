import javax.swing.*;
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

        JFileChooser directoryChooser = new JFileChooser();

        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.setDialogTitle("Specify CSV file save folder.");
        directoryChooser.showSaveDialog(null);

        String savePath = directoryChooser.getSelectedFile().getAbsolutePath();

        BufferedWriter br = new BufferedWriter(new FileWriter(savePath + "\\directory.csv"));
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

        JFileChooser directoryChooser = new JFileChooser();

        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.setDialogTitle("Specify " + directoryType + " analysis.txt Save Folder");
        directoryChooser.showSaveDialog(null);

        String savePath = directoryChooser.getSelectedFile().getAbsolutePath();

        if(directoryType.equals("Array")){
            try {
                PrintWriter writer = new PrintWriter(new File(savePath + "\\array_directory_analysis.txt"));
                writer.write("Array Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[0])+ "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[0]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[0]) + "ns\n\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[1]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[1]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[1]) + "ns\n\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[2]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[2]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[2]) + "ns\n\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[3]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[3]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[3]) + "ns\n\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(directoryType.equals("ArrayList")){
            try {
                PrintWriter writer = new PrintWriter(new File(savePath + "\\array_list_directory_analysis.txt"));
                writer.write("Array List Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[0])+ "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[0]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[0]) + "ns\n\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[1]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[1]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[1]) + "ns\n\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[2]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[2]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[2]) + "ns\n\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[3]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[3]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[3]) + "ns\n\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(directoryType.equals("HashMap")){
            try {
                PrintWriter writer = new PrintWriter(new File(savePath + "\\hash_map_directory_analysis.txt"));
                writer.write("HashMap Directory Execution Times Analysis \n \n");
                writer.write("Entry method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[0])+ "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[0]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[0]) + "ns\n\n");
                writer.write("Lookup by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[1]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[1]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[1]) + "ns\n\n");
                writer.write("Deletion by surname method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[2]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[2]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[2]) + "ns\n\n");
                writer.write("Deletion by number method:\n");
                writer.write("Average time: " + Math.round(averageExecutionTime[3]) + "ns\n");
                writer.write("Worst time: " + Math.round(worstExecutionTime[3]) + "ns\n");
                writer.write("Best time: " + Math.round(bestExecutionTime[3]) + "ns\n\n");
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
