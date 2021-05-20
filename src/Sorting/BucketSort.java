package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    private final static int NUMBER_OF_BUCKETS = 3;
    public static void sort(int[] array) {
        // You can also provide desired buckets count via method parameters
        List<List<Integer>> buckets = createBuckets(array, NUMBER_OF_BUCKETS);
        
        // Sorting buckets and restoring original array
        int k = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int item: bucket) {
                array[k++] = item;
            }
        }
    }

    private static List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();

        // Initialize empty lists in buckets
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        // Filling buckets
        for (int i = 0; i < array.length; i++) {
            int bucket = array[i] / numberOfBuckets;
            buckets.get(bucket).add(array[i]);
        }

        return buckets;
    }
}
