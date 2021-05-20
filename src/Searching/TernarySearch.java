package Searching;

public class TernarySearch {
    public static int find(int [] array, int target) {
//        return find(array, target, 0, array.length - 1);
        return find(array, target, 0, array.length - 1);
    }

    private static int find(int[] array, int target, int left, int right) {
        if (left > right) return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (array[mid1] == target) return mid1;
        if (array[mid2] == target) return mid2;
        if (target < array[mid1]) return find(array, target, left, mid1 - 1);
        if (target > array[mid2]) return find(array, target, mid2 + 1, right);
        return find(array, target, mid1 + 1, mid2 - 1);
    }
}
