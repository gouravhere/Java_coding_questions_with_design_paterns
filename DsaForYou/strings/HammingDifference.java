package DsaForYou.strings;

/**
 * This class provides methods to calculate the Hamming distance between two strings or integers.
 * Hamming distance is the number of positions at which the corresponding symbols are different.
 * 
 * <p>Time Complexity: O(n) where n is the length of the strings/bit length of integers
 * Space Complexity: O(1) - constant space used
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Hamming_distance">Hamming Distance on Wikipedia</a>
 * @since 1.0
 */
public class HammingDifference {
    
    /**
     * Main method to demonstrate the usage of Hamming distance calculation.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Example with integers
        int x = 1;  // Binary: 01
        int y = 4;  // Binary: 100
        System.out.println("Hamming distance between " + x + " and " + y + " is: " + hammingDistance(x, y));
        
        // Example with strings
        String s1 = "karolin";
        String s2 = "kathrin";
        System.out.println("Hamming distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + 
                         hammingDistance(s1, s2));
    }
    
    /**
     * Calculates the Hamming distance between two strings of equal length.
     * 
     * @param s1 the first string
     * @param s2 the second string
     * @return the Hamming distance between the two strings
     * @throws IllegalArgumentException if the input strings have different lengths
     */
    public static int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Strings must be of equal length");
        }
        
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
    
    /**
     * Calculates the Hamming distance between two integers (the number of differing bits).
     * 
     * @param x the first integer
     * @param y the second integer
     * @return the Hamming distance between the two integers
     */
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        
        // Count the number of set bits in the XOR result
        while (xor != 0) {
            distance += xor & 1;  // Add 1 if the least significant bit is 1
            xor = xor >>> 1;      // Unsigned right shift
        }
        
        return distance;
    }
}

