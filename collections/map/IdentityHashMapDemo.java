package collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/*
This is a demonstration of IdentityHashMap in Java. Here's what's happening:

The code creates a new IdentityHashMap that maps String keys to Integer values: Map<String, Integer> map = new IdentityHashMap<String, Integer>()
It then creates two Integer objects with the same value (1):
Integer id1 = new Integer(1)
Integer id2 = new Integer(1)
The purpose of this code is to demonstrate a key difference between HashMap and IdentityHashMap. In IdentityHashMap, equality is determined by object identity (using == operator) rather than by the equals() method.

This means:

In a regular HashMap, id1 and id2 would be considered equal because they both represent the value 1
In an IdentityHashMap, id1 and id2 would be considered different keys because they are different objects in memory, even though they have the same value
 */
public class IdentityHashMapDemo {
    /**
     * A demonstration of how IdentityHashMap works differently from a regular HashMap.
     *
     * <p>
     * This program creates an IdentityHashMap that maps Integer keys to String values.
     * It adds two Integer objects with the same value (1) to the map, and then prints
     * the map.
     *
     * <p>
     * Because the map is an IdentityHashMap, the two Integer objects are considered
     * different keys, even though they have the same value. This is demonstrated by the
     * output of the program, which will print both key-value pairs.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new IdentityHashMap<Integer, String>();
        Integer id1 = new Integer(1);
        Integer id2 = new Integer(1);
        map.put(id1, "Gourav");
        map.put(id2, "Sharma");

        System.out.println(map);
    }
}
