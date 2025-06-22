package collections.comparator;

import java.util.Comparator;

public class StringComprator implements Comparator<String> {
    /**
     * Compares two strings by their length first, and if they have the same
     * length, by their lexicographical order.
     *
     * @param o1 the first string
     * @param o2 the second string
     * @return a negative integer, zero, or a positive integer as the first
     *         argument is less than, equal to, or greater than the second
     */
    public int compare(String o1, String o2) {

        int l1 = o1.length();
        int l2 = o2.length();
        if(l1<l2) return -1;
        else if(l1>l2) return 1;
        else return o1.compareTo(o2);
    }
}
