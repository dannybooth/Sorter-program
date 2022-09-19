# Sort Manager Project
Allows you to pick one sorting method (binary tree search, bubble sort, or merge sort) and the size of array you want to sort. After answering these questions the array is randomized and array is sorted using the selected method. Printed to the console are the unsorted array, the method used, the sorted array and the time taken. All methods sort numbers from smallest to largest.
<h3>Explanation</h3>

This program stores each method as a enum, so they can communicate from the same interface so it can use the method called "sortArray". I also used the factory method so I didn't have to specifY the concrete classes.

<h3>Bubble sort</h3>

```java
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
```
This method compares each number left to right to their adjacent numbers and swaps them if they're larger until the numbers are all sorted from smallest  to largest.

<h3>Merge Sort</h3>
```java
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
```
The array is split in half several times until the numbers have been complete separated. The numbers are than gradually combined back together by adding the smallest number to the start of the new array.

<h3>Binary Tree Sort</h3>
```java
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
```
The array is first added to a binary tree. It starts the first value of the array as the root and sorts the smallest numbers to the left and the larger ones to the right. When searching for the numbers to sort from smallest to largest the tree is searched all the way to the left to get the first value and keeps doing that until it gets all the numbers in the sorted array.

<h3>Exceptions</h3>
```java
catch (NullPointerException e) {
logger.error(e.getMessage(), e);
}catch(Exception e) {
logger.error(e.getMessage(),e);
} finally {
logger.trace("In Finally");
System.out.println("This always executes");
}
```
For each method I used catch methods for if the user entered any empty arrays somehow then the program would catch that error and keep going but also throw that error into the log file so it can be recorded. I tested this in my assertion test files by testing against null and checking if it outputted null.
In finally it'll print that it has executed to tell us that everything has been executed regardless of an exception or not.