package HashTables;

public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap(5);
        myHashMap.put(6, "Six1");
        myHashMap.put(7, "Seven1");
        myHashMap.put(8, "Eight1");
        myHashMap.put(6, "Six2");
        myHashMap.put(11, "Eleven");

        System.out.println(myHashMap);
        System.out.println("TEST: Get '6': " + myHashMap.get(6));
        System.out.println("TEST: Remove '11': " + myHashMap.remove(11));
        System.out.println(myHashMap);
    }
}
