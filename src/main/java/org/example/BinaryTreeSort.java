package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeSort implements Sorter{
    public static Logger logger = LogManager.getLogger(Starter.class);

    public BinaryTreeSort(){
    }
    @Override
    public int[] sortArray(int[] arrayToEnd) throws BinaryTreeSortException{
        try{
            long startTime = System.nanoTime();

            int[] arrayToStart = new int[arrayToEnd.length];

            for (int i = 0; i < arrayToEnd.length; i++)
            {
                arrayToStart[i]=arrayToEnd[i];
            }

            binarySort(arrayToEnd);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            Printer.print(arrayToStart, arrayToEnd, duration, SortTypes.bubbleSort);

            return arrayToEnd;
        }
        catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
        } finally {
            logger.trace("In Finally");
            System.out.println("This always executes");
        }
        return null;
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class btree{
        Node root;
        public void add(int data){
            root = addRecursive(root, data);
        }
        private Node addRecursive(Node current, int data) {
            if (current == null) {
                return new Node(data);
            }

            if (data < current.data) {
                current.left = addRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = addRecursive(current.right, data);
            } else {
                return current;
            }

            return current;
        }
        public void inOrder(ArrayList array) {
            traverseInOrder(array, root);
        }

        public ArrayList traverseInOrder(ArrayList array, Node node) {
            if (node != null) {
                traverseInOrder(array,node.left);
                array.add(node.data);
                traverseInOrder(array,node.right);
            }
            return array;
        }

    }
    public int[] binarySort(int[] arrayToSort) {
        btree bt = new btree();

        for(int i:arrayToSort)
        {
            bt.add(i);
        }
        ArrayList newarray = new ArrayList();

        bt.inOrder(newarray);

        AtomicInteger i = new AtomicInteger();

        newarray.forEach((n) -> arrayToSort[i.getAndIncrement()]= (int) n);

        return arrayToSort;
    }
}