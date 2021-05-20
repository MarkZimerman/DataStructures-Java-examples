package LinkedLists;

import java.util.NoSuchElementException;

public class LinkedListExercise {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(99);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        myLinkedList.addLast(13);
        myLinkedList.print();
//        myLinkedList.deleteFirst();
//        myLinkedList.print();
//        myLinkedList.deleteLast();
//        myLinkedList.print();
//        System.out.println(myLinkedList.contains(99));
//        System.out.println(myLinkedList.indexOf(11));
        System.out.println(myLinkedList.getKthFromEnd(1));
        myLinkedList.reverse2();
        myLinkedList.print();
    }
}

class MyLinkedList {
    public Node first;
    public Node last;

    public void reverse2(){
        Node previous = first;
        Node current = first.getNext();
        Node next;

        while(current != null){
            next = current.getNext();
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromEnd(int k){
        Node current = first;
        Node result = first;
        int i = 0;
        while (current != null){
            if(i >= k){
                result = result.getNext();
            }
            current = current.getNext();
            i++;
        }
        if (k > i) throw new IllegalArgumentException();
        return result.value;
    }

    public void reverse(){

        Node direct = first;
        Node prev;

        MyLinkedList result = new MyLinkedList();
        while (direct != null){
//            System.out.println(current.value);
            result.addFirst(direct.getValue());

            prev = direct;
            // Incrementer:
            direct = direct.next;
            prev.next = null;
        }
        first = result.first;
        this.print();

    }

    public void addFirst(int value){
        if (isEmpty()){
            first = last = new Node(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int value){
        if (isEmpty()){
            addFirst(value);
            return;
        }

        Node newLast = new Node(value);
        last.setNext(newLast);
        last = newLast;
    }

    public void deleteFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) first = last = null;
        Node target = first;
        first = target.getNext();
        target.setNext(null);
    }

    public void deleteLast(){
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }

//        Node target = last;
//        if (first.getNext() == null){
//            first = null;
//            return;
//        }
        Node currentNode = first;
        while (true){
            if (currentNode.getNext() == last){
                currentNode.setNext(null);
                last = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }
    }

    public boolean contains(int value){
        if (indexOf(value) >= 0) return true;
        return false;
    }

    public int indexOf(int value){
        Node currentNode = first;
        int index = 0;
        while (true){
            if(currentNode.getValue() == value) return index;
            if(currentNode.getNext() == null) break;
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("[]");
            return;
        }
        if(first == last) {
            System.out.println("["+first.getValue()+"]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node currentNode = first;
        while(true){
//            System.out.println(currentNode.getValue() + ", next: " + (currentNode.getNext() == null ? "null" : currentNode.getNext().getValue()));
            sb.append(currentNode.getValue());
            if (currentNode.getNext() == null ) break;
            sb.append(", ");
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
