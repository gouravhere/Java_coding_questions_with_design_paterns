package collections.linkList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("Gourav");
        list.add("Sourav");
        list.add("NoName");
        list.add("Test3");

        java.util.ListIterator<String> itr = list.listIterator();
        // Forward traversal
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        // Backward traversal
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }
}
