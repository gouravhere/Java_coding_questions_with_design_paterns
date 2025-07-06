package Java8.latest.funcationalInterface.predicate;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * <b>Interview Focus: Predicate Composition and Chaining</b>
 * 
 * <p>This class demonstrates advanced usage of Java's Predicate interface,
 * focusing on composing and chaining multiple predicates to create complex
 * conditions. This is a key concept for Java developer interviews.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Predicate composition using and(), or(), and negate()</li>
 *   <li>Method chaining for complex conditions</li>
 *   <li>Lazy evaluation in predicate chains</li>
 *   <li>Null safety in predicate composition</li>
 *   <li>Performance implications of predicate ordering</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>How do you combine multiple conditions in a Predicate?</li>
 *   <li>What's the difference between and() and or() in Predicate?</li>
 *   <li>How does lazy evaluation work with Predicate chains?</li>
 *   <li>How would you optimize a chain of predicates for performance?</li>
 *   <li>How do you handle null values in predicate chains?</li>
 * </ol>
 *
 * <p><b>Real-world Use Cases:</b>
 * <ul>
 *   <li>Complex filtering in data processing pipelines</li>
 *   <li>Business rule validation</li>
 *   <li>API request validation with multiple conditions</li>
 *   <li>Search and filter functionality</li>
 * </ul>
 *
 * @see java.util.function.Predicate
 * @see java.util.stream.Stream#filter(Predicate)
 * @since 1.8
 */
public class PredicateJoins {
    
    /**
     * Demonstrates various ways to combine and use Predicates with practical examples.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Basic predicate creation with lambda expressions</li>
     *   <li>Chaining predicates with logical operators</li>
     *   <li>Performance optimization through predicate ordering</li>
     *   <li>Null-safe predicate composition</li>
     *   <li>Practical filtering of collections</li>
     * </ul>
     *
     * <p><b>Interview Tip:</b> Be prepared to explain the difference between
     * eager and lazy evaluation in predicate chains, and how it affects performance.</p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Sample array of integers for demonstration
        // Note: In a real application, this would likely come from a data source
        int[] numbers = {5, 20, 1, 3, 55, 211, 22, 30, 15, 8, 0};
        
        // Basic predicates
        // Interview Question: Why use Integer instead of int in the Predicate generic type?
        Predicate<Integer> greaterThanTen = number -> number != null && number > 10;
        Predicate<Integer> isEven = number -> number != null && number % 2 == 0;
        
        // More complex predicates
        Predicate<Integer> isOdd = isEven.negate();
        Predicate<Integer> isPositive = number -> number != null && number > 0;
        
        // Demonstrate basic predicate usage
        System.out.println("=== Basic Predicate Usage ===");
        System.out.println("Numbers greater than 10:");
        filterAndPrint(greaterThanTen, numbers);

        // Demonstrate predicate composition
        System.out.println("\n=== Predicate Composition ===");
        
        // AND operation: Both conditions must be true
        System.out.println("\nNumbers greater than 10 AND even (optimized order):");
        // Interview Tip: Place the most restrictive condition first for better performance
        Predicate<Integer> greaterThanTenAndEven = isEven.and(greaterThanTen);
        filterAndPrint(greaterThanTenAndEven, numbers);
        
        // OR operation: Either condition can be true
        System.out.println("\nNumbers less than or equal to 10 OR odd:");
        Predicate<Integer> lessThanOrEqualTenOrOdd = greaterThanTen.negate().or(isOdd);
        filterAndPrint(lessThanOrEqualTenOrOdd, numbers);
        
        // Complex composition
        System.out.println("\n=== Complex Predicate Composition ===");
        System.out.println("Positive even numbers greater than 10 or odd numbers less than 5:");
        Predicate<Integer> complexCondition = 
            (isPositive.and(isEven).and(greaterThanTen))  // Positive, even, > 10
            .or(
                isOdd.and(greaterThanTen.negate())         // OR odd and <= 10
            );
        filterAndPrint(complexCondition, numbers);
        
        // Demonstrate null safety
        System.out.println("\n=== Null Safety ===");
        System.out.println("Non-null numbers (using method reference):");
        filterAndPrint(Objects::nonNull, numbers);
        
        // Performance consideration: Order of operations matters
        System.out.println("\n=== Performance Consideration ===");
        System.out.println("Inefficient: Checking isEven first then greaterThanTen");
        long startTime = System.nanoTime();
        Predicate<Integer> inefficient = isEven.and(greaterThanTen);
        filterAndPrint(inefficient, numbers);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        
        System.out.println("\nEfficient: Checking greaterThanTen first then isEven");
        startTime = System.nanoTime();
        Predicate<Integer> efficient = greaterThanTen.and(isEven);
        filterAndPrint(efficient, numbers);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
    }

    /**
     * Filters and prints elements from an array based on the given predicate.
     * Handles null values in the array gracefully.
     *
     * <p><b>Interview Tip:</b> Always document edge cases and null handling behavior.</p>
     *
     * @param predicate the predicate to test each element against (should handle null inputs)
     * @param array the array of integers to filter (may contain null values)
     */
    static void filterAndPrint(Predicate<Integer> predicate, int[] array) {
        if (array == null) {
            System.out.println("Input array is null");
            return;
        }
        
        System.out.print("[");
        String separator = "";
        for (Integer number : array) {
            if (predicate.test(number)) {
                System.out.print(separator + (number == null ? "null" : number));
                separator = ", ";
            }
        }
        System.out.println("]");
    }
}
