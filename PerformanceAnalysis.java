import java.io.IOException;
import java.util.List;

public class PerformanceAnalysis {

    public void directoryPerformance(String directoryType) throws IOException {

        double executionTime;

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

            stopWatch.start();
            input.readerCSV(newDirectory);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeEntry += executionTime;
            if(executionTime <= bestExecutionTime[0]) { bestExecutionTime[0] = executionTime; }
            if(executionTime >= worstExecutionTime[0]) { worstExecutionTime[0] = executionTime; }

            // finds an object's surname in the middle of the directory
            surname = directoryMiddleSurnameFinder(newDirectory);

            stopWatch.start();
            newDirectory.lookupExtension(surname);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeLookup += executionTime;
            if(executionTime <= bestExecutionTime[1]) { bestExecutionTime[1] = executionTime; }
            if(executionTime >= worstExecutionTime[1]) { worstExecutionTime[1] = executionTime; }

            stopWatch.start();
            newDirectory.deleteEntryUsingName(surname);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeDeletionSurname += executionTime;
            if(executionTime <= bestExecutionTime[2]) { bestExecutionTime[2] = executionTime; }
            if(executionTime >= worstExecutionTime[2]) { worstExecutionTime[2] = executionTime; }

            // finds an object's number in the middle of the directory
            number = directoryMiddleNumberFinder(newDirectory);

            stopWatch.start();
            newDirectory.deleteEntryUsingExtension(number);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeDeletionNumber += executionTime;
            if(executionTime <= bestExecutionTime[3]) { bestExecutionTime[3] = executionTime; }
            if(executionTime >= worstExecutionTime[3]) { worstExecutionTime[3] = executionTime; }
        }

        averageExecutionTime[0] = totalExecutionTimeEntry / 10000;
        averageExecutionTime[1] = totalExecutionTimeLookup / 10000;
        averageExecutionTime[2] = totalExecutionTimeDeletionSurname / 10000;
        averageExecutionTime[3] = totalExecutionTimeDeletionNumber / 10000;

        output.performanceAnalysisTxtFile(directoryType, averageExecutionTime, bestExecutionTime, worstExecutionTime);
    }

    public String directoryMiddleSurnameFinder(Directory directory){

        List<Entry> list = directory.toArrayList();
        return list.get(list.size()/2).getSurname();
    }

    public String directoryMiddleNumberFinder(Directory directory){

        List<Entry> list = directory.toArrayList();
        return list.get(list.size()/2).getNumber();
    }
}