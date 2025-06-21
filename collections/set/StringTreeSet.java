package collections.set;

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
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("I");
        treeSet.add("J");
        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("G");
        treeSet.add("H");
        treeSet.add("B");
        treeSet.add("D");
        treeSet.add("E");
        treeSet.add("F");
        for (String s : treeSet) {
            System.out.println(s);
        }
        System.out.println(treeSet);


    }
}
