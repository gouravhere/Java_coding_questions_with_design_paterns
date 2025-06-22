package collections.map;

import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    /**
     * A main method that demonstrates the use of a LinkedHashMap to store and
     * traverse a collection of key-value pairs.
     * <p>
     * This program adds 12 entries to a LinkedHashMap, and then prints out the
     * contents of the Map in a key-value format.
     * <p>
     * By comparing the two outputs, the user can see the effects of the LinkedHashMap
     * class, which is that it stores key-value pairs in a Map, and
     * automatically removes all duplicate keys from a collection.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String , Integer> map = new LinkedHashMap<String , Integer>();
        map.put("Gourav", 1);
        map.put("Sharma", 2);
        map.put("Sourav", 3);
        map.put("Amit", 4);
        map.put("Gourav", 5);
        map.put("Sharma", 6);
        map.put("Sourav", 7);
        map.put("Amit", 8);
        map.put("Gourav", 9);
        map.put("Sharma", 10);
        map.put("Sourav", 11);
        map.put("Amit", 12);

        for(Map.Entry<String , Integer> entry : map.entrySet()){
            System.out.println("Key is: "+entry.getKey()+" -- Value is: "+entry.getValue());
        }
    }


}
