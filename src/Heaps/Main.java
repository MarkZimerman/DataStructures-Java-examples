package Heaps;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyHeapArray heap = new MyHeapArray();

        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
        System.out.println("done");

        MyHeapArray heapSort = new MyHeapArray();
        int[] array = {5, 3, 10, 1, 4, 2};
        for (int item : array){
            heapSort.insert(item);
        }

        // Desc
//        for (int i = 0; i < array.length; i++) {
        // Asc
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heapSort.remove();
        }



        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
