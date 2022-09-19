package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSort implements Sorter{

    public static Logger logger = LogManager.getLogger(Starter.class);



    @Override
    public int[] sortArray(int[] arrayToEnd) throws MergeSortException{
        try {
            long startTime = System.nanoTime();

            int[] arrayToStart = new int[arrayToEnd.length];

            for (int i = 0; i < arrayToEnd.length; i++)
            {
                arrayToStart[i]=arrayToEnd[i];
            }

            mergeArray(arrayToEnd,arrayToEnd.length);

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

    public static void mergeArray(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeArray(l, mid);
        mergeArray(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    }
