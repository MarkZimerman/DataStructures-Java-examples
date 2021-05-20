package Queues;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class MyQueues {
    public static void main(String[] args) {
//        ArrayQueue2 queue = new ArrayQueue2(5);
//        MyQueueStack2 queue = new MyQueueStack2(5);
//        MyQueueTwoStacks queue = new MyQueueTwoStacks(5);
//         MyPriorityQueue queue = new MyPriorityQueue(5);
         MoshPriorityQueue queue = new MoshPriorityQueue();


//        MyQueueStack queue = new MyQueueStack(5);

//        System.out.println("Is Empty: " + queue.isEmpty());
//        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(2);
        queue.enqueue(6);


//        queue.enqueue(6);
        System.out.println(queue);
        System.out.println("-----------------------");

        while(!queue.isEmpty()) System.out.println(queue.dequeue());
//        System.out.println("Is Empty: " + queue.isEmpty());
//        System.out.println("Is Full: " + queue.isFull());
//
//        queue.enqueue(4);
//        queue.enqueue(5);
//        System.out.println(queue);
//        System.out.println("Peek: " + queue.peek());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
        /*System.out.println(queue);
        System.out.println("Peek: " + queue.peek());
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println(queue);
        queue.enqueue(11);
*/

//        System.out.println(queue);
//        System.out.println("Is Empty: " + queue.isEmpty());
//        queue.enqueue(6);
//        System.out.println(queue);
        queue.enqueue(9);
        System.out.println(queue);

//        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Peek: " + queue.peek());

//        arrayQueue.testLoop(12);
//        System.out.println(queue);
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Peek: " + queue.peek());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println(queue);
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//        queue.enqueue(9);
//        System.out.println(queue);

//        int[] playArr = {1, 3, 4, 5, 6};
//        insertInto(playArr, 1, 2);
//        insertInto(playArr, 5, 99);
    }
    private static int[] shiftArray(int[] array, int pos){
        int[] buffer = Arrays.copyOf(array, array.length + 1);
        for (int i = array.length - 1; i >= pos ; i--) {
            buffer[i + 1] = array[i];
        }
        return buffer;
    }

    private static void insertInto(int[] array, int pos, int item){
        int[] buffer = shiftArray(array, pos);
        buffer[pos] = item;
        System.out.println(Arrays.toString(buffer));
    }
}

class ArrayQueue {
    private int[] items;
    private int head = 0;
    private int tail = 0;
    private int size = 0;


    public ArrayQueue(int size) {
        this.items = new int[size];
    }

    public void testLoop(int length){
        char[] array = new char[5];
        Arrays.fill(array,'_');
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = i % array.length;
            array[index] = 'X';
            System.out.println(Arrays.toString(array));
            array[index] = '_';
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public void enqueue(int value){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        items[tail++ % items.length] = value;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        int item = items[head];
        items[head++] = 0;
        size--;
        return item;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return items[head % items.length];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}

class MyQueueStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> reversed = new Stack<>();

    private int capacity;
    private int size;

    public MyQueueStack(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int value){
        if (size == capacity) throw new IllegalStateException("Size limit");
        if (stack.empty()) {
            stack.push(value);
        } else {
            reverse();
            stack.push(value);
            reverse();
        }
        size++;
    }

    public int dequeue(){
        if (size == 0) throw new IllegalStateException("Queue is empty");
        int result = stack.pop();
        size--;
        return result;
    }

    public int peek(){
        return stack.peek();
    }

    private void reverse(){
        Stack<Integer> buffer = new Stack<>();

        while (!stack.empty()) {
            buffer.push(stack.pop());
        }
        stack = buffer;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

class MyQueueStack2 {
    int size;
    int count = 0;
    Stack<Integer> stack = new Stack<>();

    public MyQueueStack2(int size){
        this.size = size;
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException("Stack is full");
        stack.push(item);
        count++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        reverse();
        Integer item = stack.pop();
        reverse();
        count--;
        return item.intValue();
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        reverse();
        Integer item = stack.peek();
        reverse();
        return item.intValue();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean isFull(){
        return count >= this.size;
    }

    private void reverse(){
        Stack<Integer> buffer = new Stack<>();
        while (!stack.empty()){
            buffer.push(stack.pop());
        }
        this.stack = buffer;
    }
}

class MyQueueTwoStacks {
    private int size;
    private int count = 0;
    private Stack<Integer> income = new Stack<>();
    private Stack<Integer> outcome = new Stack<>();

    public MyQueueTwoStacks(int size) {
        this.size = size;
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException("Queue is full");
        income.push(item);
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        if (outcome.isEmpty()) reverseInToOut();
        count--;
        return outcome.pop();
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        if (outcome.isEmpty()) reverseInToOut();
        return outcome.peek();
    }

    private void reverseInToOut(){
        while(!income.isEmpty()){
            outcome.push(income.pop());
        }
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public boolean isFull(){
        return this.count >= size;
    }

    @Override
    public String toString() {
        return "in: " + income.toString() + ", out: " + outcome.toString();
    }
}

class ArrayQueue2 {
    int front = 0;
    int rear = 0;
    int size;
    int[] array;

    public ArrayQueue2(int size){
        if(size < 1) throw new IllegalStateException("Invalid ArrayQueue initialization");
        this.array = new int[size];
        this.size = 0;
    }

    public void enqueue(int item){
        System.out.println("F=" + front + " R=" + rear + " Full? - " + isFull());
        if (isFull()) throw new IllegalStateException("Queue is full");
        int position = rear++ % array.length;
        array[position] = item;
        size++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        int position = front++ % array.length;
        int item = array[position];
        array[position] = 0;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return array[front % array.length];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[ ");
//        for (int i = front; i < rear; i++) {
//            sb.append(array[i]);
//            sb.append(" ");
//        }
//        sb.append(']');
//        return sb.toString();
        return Arrays.toString(array);
    }
}

class MyPriorityQueue {
    private int[] array;
    private int rear = 0;
    private int count = 0;

    public MyPriorityQueue(int size) {
        this.array = new int[size];
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException("Queue is full");
        insert(item);
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int item = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        count--;
        return item;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return array[0];
    }

    private void insert(int item){
        System.out.println("INSERT: " + item);
        if (isEmpty()) {
            array[0] = item;
            return;
        }

        if (count == 1){
            if (array[0] < item){
                array[1] = item;
                return;
            }

            array[1] = array[0];
            array[0] = item;
            return;
        }

        if(item > array[count - 1]){
            array[count] = item;
        }

        for (int i = count - 1; i >= 0 ; i--) {
            if (item < array[i] && item >= array[i - 1]){
                System.out.println("TARGET POSITION IS " + i);
                array = insertInto(array, i, item);
                break;
            }
        }
    }

    private static int[] insertInto(int[] array, int pos, int item){
//        int[] buffer = Arrays.copyOf(array, array.length + 1);
        int[] buffer = array;
        for (int i = array.length - 1; i >= pos ; i--) {
//            buffer[i + 1] = array[i];
            buffer[i] = array[i - 1];
        }

        buffer[pos] = item;
        return buffer;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}

class MoshPriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException("Queue is full");

        items[shiftItemsToInsert(item)] = item;
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return items[--count];
    }

    private int shiftItemsToInsert(int item){
        int i;
        for (i = count - 1; i >= 0; i--) {
            if(items[i] > item){
                items[i+1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}