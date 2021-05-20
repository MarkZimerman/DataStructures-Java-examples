package Stacks;

import java.util.Arrays;

public class MyStackApp {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println("-----------");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Is stack empty: " + stack.isEmpty());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        stack.print();
        System.out.println("Is stack empty: " + stack.isEmpty());
    }
}

class MyStack {
    private final int DEFAULT_SIZE = 10;
    private int index = -1;
    private int[] stack;

    public MyStack(){
        this.stack = new int[DEFAULT_SIZE];
    }

    public MyStack(int initialSize) {
        if (initialSize <= 0) throw new IllegalArgumentException("Please provide correct initial size");
        this.stack = new int[initialSize];
    }

    public void push(int value){
        checkStackSize();
        stack[++index] = value;
    }

    public int pop(){
        if (index < 0) throw new IllegalStateException("Stack is empty");
        int value = stack[index];
        index--;
        return value;
    }

    public boolean isEmpty(){
        return index < 0;
    }

    public int peek(){
        return stack[index];
    }

    public void print(){
        System.out.println("Stack size: " + stack.length);
        System.out.println("Current index: " + index);
        if (index < 0){
            System.out.println("[]");
        } else {
            System.out.print("[ ");
            for (int i = 0; i < index + 1; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.print("]");
        }
        System.out.println();
    }

    private void checkStackSize() {
        if (index == stack.length - 1){
            System.out.println("Enlarging stack from " + stack.length + " to " + stack.length * 2);
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
    }
}
