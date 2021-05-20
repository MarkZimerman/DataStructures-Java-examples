package Sorting;

public class MergeSort {
    public static void sort(int[] array) {
        if (array.length < 2) return;

        // Division index
        int middle = array.length / 2;

        // Divided left half
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        // Divided right half
        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        // Sort each half
        sort(left);
        sort(right);

        // Merge the result together
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0; // Where i - left half index, j - right half, k - result index

        // Merging from two part into result
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        // Adding remaining values from left half, if exist
        while (i < left.length)
            result[k++] = left[i++];

        // Adding remaining values from right half, if exist
        while (j < right.length)
            result[k++] = right[j++];
    }
}
