import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceAnalysis {

    public void directoryPerformance(String directoryType) throws IOException {

        double executionTime;
        ArrayList<Double> executionTimeList = new ArrayList<>();

        // 3 arrays to store execution times of methods:
        // index 0 entry average/best/worst execution times
        // index 1 lookup average/best/worst execution times
        // index 2 deletion by surname average/best/worst execution times
        // index 3 deletion by number average/best/worst execution times
        double[] averageExecutionTime = new double[4];
        double[] bestExecutionTime = {999999999, 999999999, 999999999, 999999999};
        double[] worstExecutionTime = {0, 0, 0, 0};
        double totalExecutionTimeEntry = 0, totalExecutionTimeLookup = 0;
        double totalExecutionTimeDeletionSurname = 0, totalExecutionTimeDeletionNumber = 0;

        Directory newDirectory = new ArrayDirectory();

        StopWatch stopWatch = new StopWatch();
        Input input = new Input();
        Output output = new Output();

        String surname, number;

        for (int i = 0; i < 10000; i++) {
            if(directoryType.equals("Array")) { newDirectory = new ArrayDirectory(); }
            if(directoryType.equals("ArrayList")) { newDirectory = new ArrayListDirectory(); }
            if(directoryType.equals("HashMap")) { newDirectory = new HashMapDirectory(); }

            // get execution times of input method in array list
            executionTimeList = input.readerCSV(newDirectory, true);

            // checks if each execution time is worse or better than before tested method times
            for (Double aDouble : executionTimeList) {
                totalExecutionTimeEntry += aDouble;
                if (aDouble <= bestExecutionTime[0]) {
                    bestExecutionTime[0] = aDouble;
                }
                if (aDouble >= worstExecutionTime[0]) {
                    worstExecutionTime[0] = aDouble;
                }
            }

            // finds an object's surname in the middle of the directory
            surname = directoryMiddleSurnameFinder(newDirectory);

            // counts execution time of lookup extension method
            stopWatch.start();
            newDirectory.lookupExtension(surname);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            // checks if time was worse or better than during past tests
            totalExecutionTimeLookup += executionTime;
            if(executionTime <= bestExecutionTime[1]) { bestExecutionTime[1] = executionTime; }
            if(executionTime >= worstExecutionTime[1]) { worstExecutionTime[1] = executionTime; }

            // counts execution time of delete entry by surname method
            stopWatch.start();
            newDirectory.deleteEntryUsingName(surname);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            // checks if time was worse or better than during past tests
            totalExecutionTimeDeletionSurname += executionTime;
            if(executionTime <= bestExecutionTime[2]) { bestExecutionTime[2] = executionTime; }
            if(executionTime >= worstExecutionTime[2]) { worstExecutionTime[2] = executionTime; }

            // finds an object's number in the middle of the directory
            number = directoryMiddleNumberFinder(newDirectory);

            // counts execution time of delete entry by extension method
            stopWatch.start();
            newDirectory.deleteEntryUsingExtension(number);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            // checks if time was worse or better than during past tests
            totalExecutionTimeDeletionNumber += executionTime;
            if(executionTime <= bestExecutionTime[3]) { bestExecutionTime[3] = executionTime; }
            if(executionTime >= worstExecutionTime[3]) { worstExecutionTime[3] = executionTime; }
        }

        // counts average execution times of each method
        averageExecutionTime[0] = totalExecutionTimeEntry / 10000 / executionTimeList.size();
        averageExecutionTime[1] = totalExecutionTimeLookup / 10000;
        averageExecutionTime[2] = totalExecutionTimeDeletionSurname / 10000;
        averageExecutionTime[3] = totalExecutionTimeDeletionNumber / 10000;

        // calls a method which writes all the results to the txt file and saves it
        output.performanceAnalysisTxtFile(directoryType, averageExecutionTime, bestExecutionTime, worstExecutionTime);
    }

    // finds an entry which is in the middle of the directory and returns it's surname
    public String directoryMiddleSurnameFinder(Directory directory){

        List<Entry> list = directory.toArrayList();
        return list.get(list.size()/2).getSurname();
    }

    // finds an entry which is in the middle of the directory and returns it's number
    public String directoryMiddleNumberFinder(Directory directory){

        List<Entry> list = directory.toArrayList();
        return list.get(list.size()/2).getNumber();
    }
}