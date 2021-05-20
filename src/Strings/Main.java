package Strings;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String string = "hello";
        String sentence = "Trees are beautiful";
        System.out.println("Vowels count: " + countVowels(string));
        System.out.println("Reverse: " + reverse(string));
        System.out.println("Reverse words: " + reverseWords(sentence));

        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println("Check rotation: " + checkRotation(str1, str2));
        String duplicated = "Helloooooo!";

        System.out.println("Remove duplicates from '" + duplicated + "': " + removeDuplicate(duplicated));
        System.out.println(findMostRepeatedCharacter(duplicated));

        String lowerCase = "  a  tree    is beautiful           ";
        System.out.println("Capitalize: " + capitalizeAndClean(lowerCase));

        System.out.println("Anagram? " + checkAnagram("abdcd", "abcdd"));
        System.out.println("Palindrome? " + checkPalindrome("abba"));
    }

    public static int countVowels(String string) {
        if (string == null) return 0;

        // Implementation with set:
        final char[] VOWELS = {'a', 'e', 'o', 'u', 'i'};
        Set<Character> vowelsSet = new HashSet<>();
        for (char chr: VOWELS)
            vowelsSet.add(chr);

        // Implementation with String
        // String vowels ="aeoui";

        int vowelsCount = 0;
        for (char chr: string.toLowerCase().toCharArray()) {
            // if (vowels.indexOf(chr) != -1)
            if (vowelsSet.contains(chr))
                vowelsCount++;
        }
        return vowelsCount;
    }

    public static String reverse(String string) {
        if (string == null) return "";

//        /*
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length() - 1; i >= 0 ; i--) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
//        */

        /*
        Stack<Character> stack = new Stack<>();
        for (char chr: string.toCharArray())
            stack.push(chr);

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty())
            buffer.append(stack.pop());

        return buffer.toString();
         */
    }

    public static String reverseWords(String string) {
        if (string == null) return "";

        /*
        Stack<String> stack = new Stack<>();
        for (String word : string.split(" "))
            stack.push(word);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) sb.append(" ");
        }

        return sb.toString();
         */

        String[] words = string.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean checkRotation(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        /*
        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();
        if (array1.length != array2.length) return false;

        int firstIndex = string2.indexOf(array1[0]);
        for (int i = 0; i < array1.length; i++)
            if (array1[i] != array2[firstIndex++ % array1.length])
                return false;

        return true;
         */

        // Allocates more space then variant 1
        return (str1.length() == str2.length() && (str1 + str1).contains(str2));
    }

    public static String removeDuplicate(String string) {
        if (string == null) return "";

        Set<Character> seen = new HashSet<>();
        StringBuffer output = new StringBuffer();
        for (char chr : string.toCharArray()) {
            if (!seen.contains(chr)) {
                seen.add(chr);
                output.append(chr);
            }
        }

        return output.toString();
    }

    public static char findMostRepeatedCharacter(String string) {
        if (string == null || string.isEmpty())
            throw new IllegalArgumentException();

        /*
        Map<Character, Integer> map = new HashMap<>();

        for (char chr : string.toCharArray()) {
            if (!map.containsKey(chr)) {
                map.put(chr, 1);
                continue;
            }
            map.put(chr, map.get(chr) + 1);
        }

        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
         */

        // Implementation using array of ASCII:
        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for (char chr : string.toCharArray())
            frequencies[chr]++; // chr is downcasted to it's ASCII code

        int max = 0;
        char result = Character.MIN_VALUE;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }

        return result;
    }

    public static String capitalizeAndClean(String string) {
        if (string == null || string.trim().isEmpty())
            return "";

        /*
        List<String> words = new ArrayList<>();
        for (String item: string.split(" ")) {
            String wrd = item.trim();
            if (!wrd.isEmpty())
                words.add(wrd);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            char firstCharacter = currentWord.toUpperCase().charAt(0);

            if (currentWord.length() > 1)
                stringBuilder.append(firstCharacter + currentWord.substring(1));
            else
                stringBuilder.append(firstCharacter);
            if (i < words.size() - 1) stringBuilder.append(" ");
        }

        return stringBuilder.toString();
         */

        String[] words = string
                .trim()
                .replaceAll(" +", " ")
                .split(" ");
        for (int i = 0; i < words.length; i++)
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        return String.join(" ", words);
    }

    public static boolean checkAnagram(String string1, String string2) {
        if (string1 == null || string2 == null || string1.length() != string2.length())
            return false;

        /*
        Set<Character> set = new HashSet<>();
        for (char chr : string1.toCharArray())
            set.add(chr);

        for (char chr: string2.toCharArray())
            if (!set.contains(chr)) return false;

        return true;
         */

        char[] array1 = string1.toLowerCase().toCharArray();
        Arrays.sort(array1);

        char[] array2 = string2.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);

        // Or use histograms array (character array as ASCII in findMostRepeatedCharacter())
    }

    public static boolean checkPalindrome(String string) {
        if (string == null)
            return false;
        /*
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length / 2; i++)
            if (chars[i] != chars[chars.length - 1 - i])
                return false;
         */

        int left = 0;
        int right = string.length() - 1;
        while (left < right)
            if (string.charAt(left++) !=string.charAt(right--))
                return false;

        return true;
    }
}
