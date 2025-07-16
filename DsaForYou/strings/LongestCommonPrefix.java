package DsaForYou.strings;

/**
 * This class provides a solution to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, it returns an empty string.
 * 
 * <p>Time Complexity: O(S), where S is the sum of all characters in all strings
 * Space Complexity: O(1) - constant space used
 * 
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">LeetCode Problem</a>
 * @since 1.0
 */
public class LongestCommonPrefix {
    
    /**
     * Main method to demonstrate the functionality with example inputs.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs)); // Expected: "fl"
        
        // Additional test cases
        String[] test1 = {"dog", "racecar", "car"};
        System.out.println("Test 1: " + longestCommonPrefix(test1)); // Expected: ""
        
        String[] test2 = {"", ""};
        System.out.println("Test 2: " + longestCommonPrefix(test2)); // Expected: ""
        
        String[] test3 = {"ab", "a"};
        System.out.println("Test 3: " + longestCommonPrefix(test3)); // Expected: "a"
    }
    
    /**
     * Optimized solution to find the longest common prefix.
     * 
     * @param strs Array of strings to find the common prefix in
     * @return The longest common prefix, or an empty string if none exists
     * @throws IllegalArgumentException if the input array is empty
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        
        // Start with the first string as the prefix
        String prefix = strs[0];
        
        // Compare with each string in the array
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            
            // Reduce the prefix until it matches the beginning of the current string
            while (current.indexOf(prefix) != 0) {
                // Remove the last character from prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
