package Searching;

public class LinearSearch {
    public static int find(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target) return i;
        return -1;
    }
}
