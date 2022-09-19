package org.example;

import java.util.Arrays;

public class Printer {
    public static void print(int[] arrayToSort, int[] arrayToEnd, long time, SortTypes sort){
        System.out.println("Unsorted array: "+ Arrays.toString(arrayToSort)+"\nThe method used: "+sort+"\nThe sorted array: "+  Arrays.toString(arrayToEnd) +"\ntime taken: "+time+"\n");
    }



    //The unsorted randomly generated array
   // The sort algorithm to be used
    //The sorted array after the algorithm has been executed
    //The time taken You are required to test both the functionality of the program and the performance of the algorithms (speed tests)
}
