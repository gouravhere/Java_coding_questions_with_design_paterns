package collections.set;

import collections.comparator.StringComprator;

import java.util.TreeSet;

public class StringTreeSet {
    /**
     * A main method that demonstrates the use of a TreeSet to store and traverse
     * a collection of strings in a sorted order.
     * <p>
     * This program adds 10 strings to a TreeSet, and then prints out the
     * contents of the TreeSet in sorted order.
     * <p>
     * By comparing the two outputs, the user can see the effects of the TreeSet
     * class, which is that it stores elements in a sorted order, and
     * automatically removes all duplicate elements from a collection.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>(new StringComprator());
        treeSet.add("I");
        treeSet.add("JGSDS");
        treeSet.add("AGDGFD");
        treeSet.add("CGGFFV");
        treeSet.add("GHHHHTSTS");
        treeSet.add("HS");
        treeSet.add("BFF");
        treeSet.add("DSDSADADDASD");
        treeSet.add("EASDASD");
        treeSet.add("FSADAD");
        for (String s : treeSet) {
            System.out.println(s);
        }
       // System.out.println(treeSet);


    }
}
