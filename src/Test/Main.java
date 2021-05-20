package Test;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Main {

    private class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//            solution(2, 4, 2,4);
//            solution(18, 2);
/*
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum;
//        for (int i = 10; i < 100; i++) {
//        int[] testArr = {10, 15, 34, 70, 44, 81, 55, 23, 71};
        int[] testArr = {10, 12, 33, 70, 44};
        for (int i = 0; i < testArr.length; i++) {
            sum = calculateSum(testArr[i]);
//            map.put(i, calcSum(i));
            if (map.containsKey(sum)) {
                map.get(sum).add(testArr[i]);
                continue;
            }
            ArrayList<Integer> al = new ArrayList<>();
            al.add(testArr[i]);

            map.put(sum, al);
        }

        int max = -1;
        ArrayList<Integer> bucket = null;
        for (ArrayList<Integer> ali : map.values()) {
            if (ali.size() < 2) continue;
            ali.sort(Comparator.reverseOrder());
            int summ = ali.get(0) + ali.get(1);
            if (max < summ) {
                max = summ;
                bucket = ali;
            }
        }

        if (bucket == null) {
            System.out.println("No pairs");
        } else {

            System.out.println("Max pairs: [" + bucket.get(0) + ", " + bucket.get(1) + "] SUM = " + max);
        }


        System.out.println(map);
        */

        int[] testArr = {10, 15, 34, 70, 44, 81, 55, 23, 71};
        System.out.println(taskMicrosoft1(testArr));
    }

    public static int solution(int N, int K) {
        // where N = desired coins to leave casino
        // where K = maximum "all-in" times to play
        // @returns minimum number of rounds

        // chip = coin
        // all-in = all coins
        // win! = 2xCoins
        // NOTE: betting just one chip is never considered playing all-in!
        // P.S. I never played in casino or poker... :(

        // 8
        // 1x 1, 2, 3, 4<<, 8   5
        // 2x 1, 2<<, 4<<, 8    4

        // 18

        // N=18, K=2
//
        Set<Integer> targetAllIns = new HashSet<>();
        for (int i = 1; i <= K; i++) {
            System.out.println(N / (i*2));
            targetAllIns.add((int)Math.floor(N / (i*2)));
        }

        System.out.println(targetAllIns);

        int wallet = 1;
        int round = 1;
        while(wallet < N) {
//            ++round;
            if (targetAllIns.contains(wallet)) {
                wallet = wallet*2;
            } else {
                wallet++;
            }
            System.out.println("after the " + round + " round: " + wallet);
            round++;
        }

        System.out.println(round - 1);
        return 0;
    }

    public static int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8

        // vectorLength = Math.sqrt( Math.pow(x1-y1) + Math.pow(x2-y2) )
        // maxLength?? (x1max - y1min) + (x2min - y2max)
        //
        // 1) SORT
        // 2) CHOOSE

        int[] array = {A, B, C, D};
        Arrays.sort(array);

        System.out.println(maxVectorLength(array));

        return 0;
    }

    private static int maxVectorLength(int[] coord) {
        return (int)(Math.pow((coord[3] - coord[0]), 2) + Math.pow((coord[2] - coord[1]), 2));
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
            System.out.println("Max pairs: [" + bucketWithMaxValue.get(0) + ", " + bucketWithMaxValue.get(1) + "] SUM = " + max);
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
