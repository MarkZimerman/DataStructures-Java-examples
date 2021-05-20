package Stacks;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        StringReverser sr = new StringReverser();
        String string = "abcde";
        System.out.println("Reverse1: " + sr.reverse1(string));
        System.out.println("Reverse2: " + sr.reverse2(string));
        System.out.println("Reverse3: " + sr.reverse3(string));

        StringBalancer sb = new StringBalancer();
        String balanced = "(<title>{{code}}</title>)";
        System.out.println(sb.isBalanced(balanced));
    }
}

class StringBalancer {
    char[] left = {'(', '{', '<'};
    char[] right = {')', '}', '>'};

    public boolean isBalanced(String input){
        Stack<Character> buffer = new Stack<>();

        for (char ch: input.toCharArray()){
            if (isLeftBracket(ch)) buffer.push(ch);
            if (isRightBracket(ch)){
                if(buffer.empty()) {
                    System.out.println("Closed: " + ch); return false;}
                char lastBracket = buffer.pop();
                if (!isPair(lastBracket, ch)){

                    System.out.println("pair un match: " + lastBracket + " - " + ch);
                    return false;
                }
            }
        }
        System.out.println(buffer.toString());
        return buffer.empty();
    }

    private boolean isPair(char a, char b){
        for (int i = 0; i < left.length; i++) {
            if (left[i] == a){
                return b == right[i];
            }

        }
        return false;
    }

    private boolean isLeftBracket(char symbol){
        for (char open: left){
            if (symbol == open)
                return true;
        }
        return false;
    }

    private boolean isRightBracket(char symbol){
        for (char chr: right){
            if (symbol == chr)
                return true;
        }
        return false;
    }
}

class StringReverser {
    public String reverse1(String input){
        if (input == null) throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();

        for (Character symbol : input.toCharArray()){
            stack.push(symbol);
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }

    public String reverse2(String input){
        if (input == null) throw new IllegalArgumentException();
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public String reverse3(String input){
        if (input == null) throw new IllegalArgumentException();
        StringBuffer stringBuffer = new StringBuffer();

        char[] array = input.toCharArray();
        for (int i = array.length - 1; i >= 0 ; i--) {
            stringBuffer.append(array[i]);
        }
        return stringBuffer.toString();
    }
}