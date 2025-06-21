package collections.linkList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    /**
     * This main method measures the time taken to add 1000000 elements to a
     * LinkedList. The time taken is printed to the console.
     * Other methods are same as ArrayList
     * @param args
     */
    public static void main(String[] args) {
        Object object[] = new Object[1000000];
        for (int i = 0; i < object.length; i++) {
            object[i] = new Object();
        }
        Long start = System.currentTimeMillis();
        List<Object> objects = new LinkedList<Object>();
        for(Object o : object) {
            objects.add(o);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
