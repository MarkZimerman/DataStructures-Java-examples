package Heaps;

public class PriorityQueueWithHeap {
    MyHeapArray heap;

    public PriorityQueueWithHeap(int size) {
        this.heap = new MyHeapArray(size);
    }

    public void enqueue(int value){
        heap.insert(value);
    }

    public int dequeue(){
        return heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
