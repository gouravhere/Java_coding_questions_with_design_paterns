package collections.navigable;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
    /**
     * A main method that demonstrates the use of a NavigableSet.
     * <p>
     * This program creates a TreeSet of integers, and then prints out the
     * results of several operations on the set.
     * <p>
     * By comparing the two outputs, the user can see the effects of the
     * NavigableSet class, which is that it stores elements in a sorted order, and
     * provides methods for retrieving elements in a sorted order, and
     * automatically removes all duplicate elements from a collection.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.add(60);

        System.out.println(set.ceiling(50));
        System.out.println(set.floor(40));
        System.out.println(set.higher(30));
        System.out.println(set.lower(20));
        System.out.println(set.pollFirst());
        System.out.println(set.pollLast());

        System.out.println(set.descendingSet());

    }
}

