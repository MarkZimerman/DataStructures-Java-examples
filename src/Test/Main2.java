package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {

        int[] testArr = {10, 15, 34, 70, 44, 81, 55, 23, 71};
        System.out.println(taskMicrosoft1(testArr));
    }

    private static int taskMicrosoft1(int[] array) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int internalSum;
        int currentNumber;

        for (int i = 0; i < array.length; i++) {
            currentNumber = array[i];
            internalSum = calculateSum(currentNumber);
            if (map.containsKey(internalSum)) {
                map.get(internalSum).add(currentNumber);
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.add(currentNumber);
            map.put(internalSum, list);
        }

        int max = -1;
        ArrayList<Integer> bucketWithMaxValue = null;
        for (ArrayList<Integer> bucket : map.values()) {
            if (bucket.size() < 2)
                continue;

            bucket.sort(Comparator.reverseOrder());
            int sum = bucket.get(0) + bucket.get(1);
            if (max < sum) {
                max = sum;
                bucketWithMaxValue = bucket;
            }
        }

        if (bucketWithMaxValue != null) {
            System.out.println("Max pairs: [" +
                    bucketWithMaxValue.get(0) + ", " + bucketWithMaxValue.get(1) + "] SUM = " + max);
            return max;
        }

        return -1;
    }

    private static int calculateSum(int number) {
        int sum = 0;
        for (char num : String.valueOf(number).toCharArray())
            sum += Integer.parseInt(String.valueOf(num));

        return sum;
    }
}
