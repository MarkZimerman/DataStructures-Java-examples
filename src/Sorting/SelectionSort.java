package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = findMinInRange(array, i, array.length);
            swap(array, i, minIndex);
//            System.out.println("    Current array: " + Arrays.toString(array));
        }
    }

    private static int findMinInRange(int[] array, int startIndex, int endIndex) {
        int minValue = array[startIndex];
        int minIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
//        System.out.println("Min found in range [" + startIndex + "-" + (array.length - 1) + "], min = " + minValue + " on index " + minIndex);
        return minIndex;
    }

    private static void swap(int[] array, int left, int right) {
        if (left == right) return;
//        System.out.println("Swap: " + array[left] + "<>" + array[right]);
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
