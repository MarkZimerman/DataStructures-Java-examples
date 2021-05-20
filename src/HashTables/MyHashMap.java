package HashTables;

import java.util.LinkedList;

public class MyHashMap {
    private LinkedList<Entry>[] array;

    public MyHashMap(int size) {
        if (size < 1) throw new IllegalStateException("Invalid HashMap initialization");
        this.array = new LinkedList[size];
    }

    public int hash(int key){
        return key % array.length;
    }

    public void put(int k, String v){
        int index = hash(k);

        if (array[index] == null) {
            array[index] = new LinkedList<>();
            System.out.println("Created new for " + v);
        }


        LinkedList<Entry> bucket = array[index];
        for (Entry entry : bucket){
            if (entry.key == k) {
                entry.value = v;
                return;
            }
        }

        bucket.addLast(new Entry(k, v));
    }

    public String get(int key){
        int index = hash(key);

        LinkedList<Entry> bucket = array[index];

        if(bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean remove(int key){
        int index = hash(key);
        LinkedList<Entry> bucket = array[index];

        if(bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    bucket.remove(entry);
                    return true;
                }
            }
        }
        return false;
    }

    class Entry {
        private Integer key;
        private String value;

        public Entry(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + ']';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                sb.append("Empty\n");
            } else {
                sb.append(array[i].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
