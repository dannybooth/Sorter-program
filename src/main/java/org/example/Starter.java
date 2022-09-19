package org.example;
import java.util.Random;
import java.util.Scanner;

public class Starter {

    public static void start() throws bubbleSortException, BinaryTreeSortException, MergeSortException {
        SortFactory sortFactory=new SortFactory();

        Scanner myObj = new Scanner(System.in);
        SortTypes method = null;
        System.out.println("Enter the sorting method you wish to use (bubble sort, merge sort or binary tree sort): ");
        while(method==null) {
            String methodChoice = myObj.nextLine().toLowerCase();

            if (methodChoice.equals("bubble sort")) {
                method = SortTypes.bubbleSort;
            } else if (methodChoice.equals("merge sort")) {
                method = SortTypes.MergeSort;
            } else if (methodChoice.equals("binary tree sort")) {
                method = SortTypes.BinaryTreeSort;
            }else{
                System.out.println("Please enter either bubble sort, merge sort or binary tree sort: ");
            }
        }
        String numChoice = null;
        System.out.println("Enter the amount of values you want in the array: ");
        Boolean check = false;

        while(check==false) {
            try {
                numChoice = myObj.nextLine();
                int num = Integer.parseInt(numChoice);
                if(num<2) {
                    System.out.println("please enter a number larger than 1: ");
                }
                else {
                    check = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("please enter a number: ");
            }
        }

        int[] a = new int[Integer.parseInt(numChoice)];

        for (int i = 0; i < Integer.parseInt(numChoice); i++) {
            Random rand = new Random();
            a[i] = rand.nextInt(100);
        }

        Sorter sort2=sortFactory.getSorter(method);
        sort2.sortArray(a);
    }
}
