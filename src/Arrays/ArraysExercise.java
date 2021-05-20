package Arrays;

import java.util.Arrays;

public class ArraysExercise {
    
    public static void main(String[] args) {

        MyArray<Integer> myArray = new MyArray(3);
        for (int i = 1; i <= 20; i++) {
            myArray.insert(i);
        }

        System.out.println(myArray);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Insert 56");
        myArray.insert(56);
        System.out.println("Insert 42");
        myArray.insert(42);

        System.out.println("Remove at index 0");
        myArray.removeAt(0);

        System.out.println("Size: " + myArray.size());
        System.out.println("Element with index 2: " + myArray.getAt(2));
        System.out.println("Index of 55: " + myArray.indexOf(55));
        System.out.println(myArray);
//        System.out.println("Max: " + myArray.max());
        Integer[] other = { 5, 8, 55, 18, 105 };
//        System.out.println(Arrays.toString(myArray.intersect(other)));
//        System.out.println(Arrays.toString(myArray.reverse()));
        System.out.println(myArray);
        System.out.println("Insert 99 at index 6");
        myArray.insertAt(99, 6);
        System.out.println(myArray);
//        System.out.println(Arrays.toString(myArray.toArray()));

    }
}

class MyArray<T> {
    private static final int DEFAULT_SIZE = 100;
    private Object[] container;
    private int size = 0;

    public MyArray(int initialCount) {
        if (initialCount < 1) throw new IllegalArgumentException("Initial value must be greater than 0");
        this.container = new Object[initialCount];
    }

    public MyArray() {
        this.container = new Object[DEFAULT_SIZE];
    }

    public T max(){
        Object max = container[0];

        for (int i = 1; i < size; i++) {
            // How to compare?
//            if (container[i] > max) max = (T) container[i];
        }

        return (T)max;
    }

    public void insertAt(T item, int index){
        if (container.length <= size + 1) {
            enlargeContainer();
        }

        for (int i = size; i > index; i--) {
            container[i] = container[i - 1];
        }
        container[index] = item;
        size++;
    }

//    public T[] intersect(T[] another){
//        MyArray<T> intersection = new MyArray();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < another.length; j++) {
//                if (container[i] == another[j]){
//                    intersection.insert((T)container[i]);
//                    break;
//                }
//            }
//        }
//        return intersection.toArray();
//    }

//    public T[] reverse(){
//        Object[] result = new Object[size];
//        int j = 0;
//        for (int i = size - 1; i >= 0; i--) {
//            result[j++] = getAt(i);
//        }
//        // How to cast Object[] to T[]??
//        return result;
//    }

//    public T[] toArray(){
//        // How to cast?
//        return Arrays.copyOfRange(container, 0, size, T);
//    }

    public void insert(T value){
        if (size == container.length){
            enlargeContainer();
        }
        container[size++] = value;
    }

    public void removeAt(int index){
        if (index >= size || index < 0) throw new IllegalArgumentException("Requested index is out of bounds");

        for (int i = index; i < size; i++) {
            container[i] = container[i + 1];
        }
        size--;
    }

    public int indexOf(int value){
        for (int i = 0; i < size; i++) {
            if (container[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public T getAt(int index){
        return (T)container[index];
    }

    private void enlargeContainer() {
        container = Arrays.copyOf(container, (int) (size * 1.5));
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(container[0]);
        for (int i = 1; i < size; i++) {
            sb.append(", ");
            sb.append(container[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
