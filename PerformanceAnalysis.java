public class PerformanceAnalysis {

    public void directoryPerformance(String type) {

        double executionTime;
        double totalExecutionTimeEntry = 0, totalExecutionTimeLookup = 0, totalExecutionTimeDeletionSurname = 0, totalExecutionTimeDeletionNumber = 0;
        double averageExecutionTimeEntry, averageExecutionTimeLookup, averageExecutionTimeDeletionSurname, averageExecutionTimeDeletionNumber;
        double worstExecutionTimeEntry = 0, bestExecutionTimeEntry = 999999999;
        double worstExecutionTimeLookup = 0, bestExecutionTimeLookup = 999999999;
        double worstExecutionTimeDeletionSurname = 0, bestExecutionTimeDeletionSurname = 999999999;
        double worstExecutionTimeDeletionNumber = 0, bestExecutionTimeDeletionNumber = 999999999;

        Directory newDirectory = new ArrayDirectory();

        StopWatch stopWatch = new StopWatch();
        Input input = new Input();
        Output output = new Output();

        for (int i = 0; i < 10000; i++) {
            if(type.equals("Array")) { newDirectory = new ArrayDirectory(); }
            if(type.equals("ArrayList")) { newDirectory = new ArrayListDirectory(); }
            if(type.equals("HashMap")) { newDirectory = new HashMapDirectory(); }

            stopWatch.start();
            input.readerCSV(newDirectory);
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeEntry += executionTime;
            if(executionTime <= bestExecutionTimeEntry) { bestExecutionTimeEntry = executionTime; }
            if(executionTime >= worstExecutionTimeEntry) { worstExecutionTimeEntry = executionTime; }

            // create a method which will find variable in the middle of directory

            stopWatch.start();
            newDirectory.lookupExtension("Third");
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeLookup += executionTime;
            if(executionTime <= bestExecutionTimeLookup) { bestExecutionTimeLookup = executionTime; }
            if(executionTime >= worstExecutionTimeLookup) { worstExecutionTimeLookup = executionTime; }

            // create a method which will find variable in the middle of directory

            stopWatch.start();
            newDirectory.deleteEntryUsingName("Third");
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeDeletionSurname += executionTime;
            if(executionTime <= bestExecutionTimeDeletionSurname) { bestExecutionTimeDeletionSurname = executionTime; }
            if(executionTime >= worstExecutionTimeDeletionSurname) { worstExecutionTimeDeletionSurname = executionTime; }

            // create a method which will find variable in the middle of directory

            stopWatch.start();
            newDirectory.deleteEntryUsingExtension("22222");
            stopWatch.stop();

            executionTime = stopWatch.getElapsedTime();
            stopWatch.reset();

            totalExecutionTimeDeletionNumber += executionTime;
            if(executionTime <= bestExecutionTimeDeletionNumber) { bestExecutionTimeDeletionNumber = executionTime; }
            if(executionTime >= worstExecutionTimeDeletionNumber) { worstExecutionTimeDeletionNumber = executionTime; }
        }

        averageExecutionTimeEntry = totalExecutionTimeEntry / 10000;
        averageExecutionTimeLookup = totalExecutionTimeLookup / 10000;
        averageExecutionTimeDeletionSurname = totalExecutionTimeDeletionSurname / 10000;
        averageExecutionTimeDeletionNumber = totalExecutionTimeDeletionNumber / 10000;

        if(type.equals("Array")) { System.out.println("Execution times of an Array directory."); }
        if(type.equals("ArrayList")) { System.out.println("Execution times of an Array List directory."); }
        if(type.equals("HashMap")) { System.out.println("Execution times of an HashMap directory."); }

        System.out.println("Average time of entry: " + averageExecutionTimeEntry +
                ", best: " + bestExecutionTimeEntry +
                ", worst: " + worstExecutionTimeEntry);

        System.out.println("Average time of lookup by surname: " + averageExecutionTimeLookup +
                ", best: " + bestExecutionTimeLookup +
                ", worst: " + worstExecutionTimeLookup);

        System.out.println("Average time of deletion by surname: " + averageExecutionTimeDeletionSurname +
                ", best: " + bestExecutionTimeDeletionSurname +
                ", worst: " + worstExecutionTimeDeletionSurname);

        System.out.println("Average time of deletion by number: " + averageExecutionTimeDeletionNumber +
                ", best: " + bestExecutionTimeDeletionNumber +
                ", worst: " + worstExecutionTimeDeletionNumber);

        System.out.println("");
    }
}