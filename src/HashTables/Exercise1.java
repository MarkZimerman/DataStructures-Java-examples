package HashTables;

import java.util.HashMap;
import java.util.Map;

public class Exercise1 {
    public static void main(String[] args) {
        String sentence = "a green apple";
        System.out.println("Found first: " + ex1(sentence));
        System.out.println("Found first: " + ex1m(sentence));
    }

    // My Wrong but working solution:
    public static char ex1(String input){
        char[] arr = input.toCharArray();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] == arr[i]) {
                    found = true;
                    break;
                }
                found = false;
            }
            if (found == false) {
                return arr[i];
            }
        }
        return Character.MIN_VALUE;
    }

    // Mosh
    private static char ex1m(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch: chars){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars){
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }
}
