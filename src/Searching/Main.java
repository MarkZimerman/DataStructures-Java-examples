package Searching;

public class Main {
    public static void main(String[] args) {
        int[] testArray = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
//        int index = LinearSearch.find(testArray, 9);
//        int index = BinarySearch.find(testArray, 3);
//        int index = TernarySearch.find(testArray, 21);
//        int index = JumpSearch.find(testArray, 30);
//        int index = ExponentialSearch.find(testArray, 3);
//        System.out.println("Found on index: " + index);

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(i + ": found " + testArray[i] + " on place " + TernarySearch.find(testArray, testArray[i]));
        }
    }
}
