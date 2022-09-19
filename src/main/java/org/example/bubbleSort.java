package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class bubbleSort implements Sorter{

    public bubbleSort(){
    }

    public static Logger logger = LogManager.getLogger(Starter.class);

    public int[] sortArray(int[] arrayToEnd) throws bubbleSortException{
        try {
            long startTime = System.nanoTime();

            int[] arrayToStart = new int[arrayToEnd.length];

            for (int i = 0; i < arrayToEnd.length; i++)
            {
                arrayToStart[i]=arrayToEnd[i];
            }

            bubble(arrayToEnd);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            Printer.print(arrayToStart, arrayToEnd, duration, SortTypes.bubbleSort);

            return arrayToEnd;
    }catch (NullPointerException e) {
        logger.error(e.getMessage(),e);
    } catch(Exception e) {
        logger.error(e.getMessage(),e);
    } finally {
        logger.trace("In Finally");
        System.out.println("This always executes");
    }
        return null;
    }

    private static int[] bubble(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
        return arrayToSort;
    }
}