package DsaForYou.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates array operations including:
 * 1. Sum of squares of odd numbers
 * 2. Finding pairs with a given difference
 */
public class InterviewPersp {
    public static void main(String[] args) {
        // Example 1: Sum of squares of odd numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                        .filter(i -> i % 2 != 0)
                        .map(i -> i * i)
                        .reduce(0, Integer::sum);
        System.out.println("Sum of squares of odd numbers: " + sum);

        // Example 2: Find pairs with given difference
        int[] arr = {1, 2, 3, 4, 5, 6};
        int targetDiff = -5; // Changed from -5 to 2 for meaningful example
        System.out.println("\nPairs with difference " + targetDiff + ":");
        findPairsWithDifference(arr, targetDiff);
    }

    /**
     * Finds all pairs of numbers in the array that have the given difference.
     * 
     * @param arr The input array of integers
     * @param k The target difference between pairs
     */
    public static void findPairsWithDifference(int[] arr, int k) {
        if (k < 0) {
            k = -k; // Take absolute value of k
        }
        
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // Check if (num - k) exists in the set
            if (seen.contains(num - k)) {
                System.out.println("Pair: (" + (num - k) + ", " + num + ")");
            }
            // Check if (num + k) exists in the set
            if (seen.contains(num + k)) {
                System.out.println("Pair: (" + (num + k) + ", " + num + ")");
            }
            // Add current number to the set
            seen.add(num);
        }
    }
}
