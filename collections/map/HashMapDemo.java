package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    /**
     * A main method that demonstrates the use of a HashMap to store and
     * traverse a collection of key-value pairs.
     * <p>
     * This program adds 4 entries to a HashMap, and then prints out the
     * contents of the Map in a key-value format.
     * <p>
     * By comparing the two outputs, the user can see the effects of the
     * HashMap class, which is that it stores key-value pairs in a Map, and
     * automatically removes all duplicate keys from a collection.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"Gourav");
        map.put(2,"Sharma");
        map.put(3,"Sourav");
        map.put(4,"Amit");

        Set set = map.keySet();
        for(Object s : set){
            System.out.println("Key is: "+s+" -- Value is: "+map.get(s));

        }
    }
}
