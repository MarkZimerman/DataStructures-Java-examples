package HashTables;

import java.util.HashSet;
import java.util.Set;

public class Exercise2 {
    public static void main(String[] args) {
        String sentence = "green apple";
        System.out.println("Found first repeated: " + ex2(sentence));
        System.out.println("Found first repeated: " + ex2_2(sentence));
    }

    public static char ex2(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char ch: chars){
            if(set.contains(ch)){
               return ch;
            }
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public static char ex2_2(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char ch: chars){
            set.add(ch);
        }

        int count;
        for(char ch: set){
            System.out.println("Check " + ch);
            count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) count++;
            }
            System.out.println("Count = " + count);
            if (count > 1) return ch;
        }

        return 'z';
    }

}
