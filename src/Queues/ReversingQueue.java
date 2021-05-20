package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversingQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        reverse(queue);
    }

    public static void reverse(Queue<Integer> queue){
//        Queue<Integer> buffer = new ArrayDeque<>();
        Stack<Integer> buffer = new Stack<>();
        while(!queue.isEmpty()){
            buffer.push(queue.remove());
        }
        while (!buffer.empty()){
            queue.add(buffer.pop());
        }

        System.out.println(queue);
    }
}
