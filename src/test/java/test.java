import org.example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    int[] a1 = {100,4,3,9,50};
    int[] a2 = {3,4,9,50,100};
    int[] b = {1,2,3,4,5};
    int[] c1 = {77,5,51,1,8,7,9,20};
    int[] c2 = {1,5,7,8,9,20,51,77};
    int[] d1 = {2,0};
    int[] d2 = {0,2};
    int[] e1 = {7,-2,0,-100};
    int[] e2 = {-100,-2,0,7};
    int[] f = {};
    int[] g = {10};
    SortFactory sortFactory=new SortFactory();
    @Test
    @DisplayName("bubble sort tests")
    void bubbleSort() throws bubbleSortException, BinaryTreeSortException, MergeSortException {
        Sorter sort=sortFactory.getSorter(SortTypes.bubbleSort);

        assertEquals(Arrays.toString(a2), Arrays.toString(sort.sortArray(a1)));
        assertEquals(Arrays.toString(b), Arrays.toString(sort.sortArray(b)));
        assertEquals(Arrays.toString(c2), Arrays.toString(sort.sortArray(c1)));
        assertEquals(Arrays.toString(d2), Arrays.toString(sort.sortArray(d1)));
        assertEquals(Arrays.toString(e2), Arrays.toString(sort.sortArray(e1)));
        assertEquals(Arrays.toString(f), Arrays.toString(sort.sortArray(f)));
        assertEquals("null", Arrays.toString(sort.sortArray(null)));
        assertEquals(Arrays.toString(g), Arrays.toString(sort.sortArray(g)));
    }
    @Test
    @DisplayName("merge sort tests")
    void mergeSorting() throws bubbleSortException, BinaryTreeSortException, MergeSortException {
        Sorter sort=sortFactory.getSorter(SortTypes.MergeSort);
        assertEquals(Arrays.toString(a2), Arrays.toString(sort.sortArray(a1)));
        assertEquals(Arrays.toString(b), Arrays.toString(sort.sortArray(b)));
        assertEquals(Arrays.toString(c2), Arrays.toString(sort.sortArray(c1)));
        assertEquals(Arrays.toString(d2), Arrays.toString(sort.sortArray(d1)));
        assertEquals(Arrays.toString(e2), Arrays.toString(sort.sortArray(e1)));
        assertEquals(Arrays.toString(f), Arrays.toString(sort.sortArray(f)));
        assertEquals("null", Arrays.toString(sort.sortArray(null)));
        assertEquals(Arrays.toString(g), Arrays.toString(sort.sortArray(g)));
    }

    @Test
    @DisplayName("binary tree sort tests")
    void binarySorting() throws bubbleSortException, BinaryTreeSortException, MergeSortException {
        Sorter sort=sortFactory.getSorter(SortTypes.BinaryTreeSort);
        assertEquals(Arrays.toString(a2), Arrays.toString(sort.sortArray(a1)));
        assertEquals(Arrays.toString(b), Arrays.toString(sort.sortArray(b)));
        assertEquals(Arrays.toString(c2), Arrays.toString(sort.sortArray(c1)));
        assertEquals(Arrays.toString(d2), Arrays.toString(sort.sortArray(d1)));
        assertEquals(Arrays.toString(e2), Arrays.toString(sort.sortArray(e1)));
        assertEquals(Arrays.toString(f), Arrays.toString(sort.sortArray(f)));
        assertEquals("null", Arrays.toString(sort.sortArray(null)));
        assertEquals(Arrays.toString(g), Arrays.toString(sort.sortArray(g)));
    }
}