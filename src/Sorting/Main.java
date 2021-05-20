package Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] testArray = {8, 2, 4, 1, 3};
        int[] testArray = {7, 3, 1, 4, 6, 2, 3};

        System.out.println("Origin: " + Arrays.toString(testArray));

//        BubbleSort.sort(testArray);
//        SelectionSort.sort(testArray);
//        InsertionSort.sort(testArray);
//        MergeSort.sort(testArray);
//        QuickSort.sort(testArray);
//        CountingSort.sort(testArray);
        BucketSort.sort(testArray);

        System.out.println("Sorted: " + Arrays.toString(testArray));
    }
}
