package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] array) {
        // Max for range
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }

        // Create rangeArray
        int[] rangeArray = new int[max + 1];

        // Traverse for filling a rangeArray
//        for (int i = 0; i < array.length; i++)
//            rangeArray[array[i]]++;
//        // same as:
        for (int item : array) {
            rangeArray[item]++;
        }

        // Traverse for restoring a original array
        int k = 0;
        for (int i = 0; i < rangeArray.length; i++)
//            if (rangeArray[i] > 0)
                for (int j = 0; j < rangeArray[i]; j++)
                    array[k++] = i;
    }
}
