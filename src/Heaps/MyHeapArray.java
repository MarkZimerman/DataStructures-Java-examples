package Heaps;

public class MyHeapArray {
    int[] items;
    int size;

    public MyHeapArray() {
        this.items = new int[10];
    }

    public MyHeapArray(int size) {
        this.items = new int[size];
    }

    public void insert(int value){
        if (isFull()) throw new IllegalStateException("Heap is full");
        items[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");

        int root = items[0];
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    private void bubbleDown(){
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private int largerChildIndex(int index) {
        if(!hasLeftChild(index)) return index;
        if(!hasRightChild(index)) return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;

        boolean isValid = items[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid = isValid & items[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }

    private int rightChildIndex(int parentIndex){
        return parentIndex * 2 + 2;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        int index = size - 1;
        while (index > 0 && (items[index] > items[parent(index)])){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }
}
