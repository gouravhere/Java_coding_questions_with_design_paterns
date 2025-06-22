package collections.set;

import collections.comparator.StringBufferComparator;

import java.util.Set;
import java.util.TreeSet;

public class StringBufferTreeSet {

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
/**
 * Demonstrates the use of a TreeSet with StringBuffer elements.
 * <p>
 * This method attempts to add several StringBuffer objects to a TreeSet
 * and print the contents. However, since StringBuffer does not implement
 * Comparable, this will throw a ClassCastException if executed.
 * <p>
 * Note: This code will not work prior to Java 11 as TreeSet requires
 * elements to implement Comparable or a Comparator to be provided.
 * @param args command line arguments (not used)
 */

/* <<<<<<<<<<  688ce92c-ce7a-4968-8c68-fed8bdaf0eb5  >>>>>>>>>>> */
    public static void main(String[] args) {
        // Set<StringBuffer> treeSet = new TreeSet<StringBuffer>(); // we can do this in two ways
        Set<StringBuffer> treeSet = new TreeSet<StringBuffer>(new StringBufferComparator());
        treeSet.add(new StringBuffer("I"));
        treeSet.add(new StringBuffer("J"));
        treeSet.add(new StringBuffer("A"));
        treeSet.add(new StringBuffer("C"));
        treeSet.add(new StringBuffer("G"));
        for (StringBuffer s : treeSet) {
            System.out.println(s);
        }
        System.out.println(treeSet);

        //if you use this before java 11, it will throw exception
        //java.lang.UnsupportedOperationException
        //class cast exception String buffer can not be cast to Comparable
    }
}
