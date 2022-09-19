package org.example;

public class SortFactory {

    public Sorter getSorter(SortTypes sortType){

        Sorter sort = switch (sortType) {
            case bubbleSort -> new bubbleSort();
            case MergeSort -> new MergeSort();
            case BinaryTreeSort -> new BinaryTreeSort();
            default -> null;
        };
        return sort;
    }
}