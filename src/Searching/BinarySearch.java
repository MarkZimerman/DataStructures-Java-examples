package Searching;

public class BinarySearch {
    public static int find(int[] array, int target) {
        return findIterative(array, target);
//        return find(array, target, 0, array.length);
    }

    private static int findIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (right >= left) {
            middle = (left + right) / 2;
//            System.out.println("R=" + right + ", L=" + left + ", M=" + middle);
            if (array[middle] == target) return middle;
            else if (array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    public static int find(int[] array, int target, int left, int right) {
        if (left > right) return -1;

        int middle = (left + right) / 2;
        if (array[middle] == target) return middle;

        if (target < array[middle])
            return find(array, target, left, middle - 1);
        return find(array, target, middle + 1, right);
    }


}
