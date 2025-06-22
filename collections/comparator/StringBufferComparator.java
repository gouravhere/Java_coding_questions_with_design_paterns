package collections.comparator;

import java.util.Comparator;

public class StringBufferComparator implements Comparator<StringBuffer> {

    /**
     * Compares two StringBuffer objects lexicographically by converting them to Strings.
     *
     * @param o1 the first StringBuffer object to be compared
     * @param o2 the second StringBuffer object to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is
     *         less than, equal to, or greater than the second
     */
    @Override
    public int compare(StringBuffer o1, StringBuffer o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s1.compareTo(s2);
    }
}
