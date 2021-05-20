package Searching;

import java.util.Arrays;

public class ExponentialSearch {
    public static int find(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return BinarySearch.find(array, target, left, right);
    }
}
