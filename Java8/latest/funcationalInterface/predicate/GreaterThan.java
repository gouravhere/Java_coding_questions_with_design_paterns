package Java8.latest.funcationalInterface.predicate;

import java.util.function.Predicate;

/**
 * <b>Interview Focus: Java 8+ Predicate Interface</b>
 * 
 * <p>This class demonstrates the use of Java's Predicate functional interface
 * to check if a number is greater than 20. Predicates are a fundamental part of
 * functional programming in Java and are widely used in collection operations.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Predicate<T> is a functional interface that represents a boolean-valued function of one argument</li>
 *   <li>Contains a single abstract method: boolean test(T t)</li>
 *   <li>Commonly used in collection filtering and stream operations</li>
 *   <li>Includes default methods: and(), or(), negate() for logical operations</li>
 *   <li>Static method: isEqual() for creating equality-based predicates</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What is a Predicate in Java 8?</li>
 *   <li>How do you chain multiple predicates together?</li>
 *   <li>What's the difference between Predicate and Function?</li>
 *   <li>How would you use Predicate with Java Streams?</li>
 *   <li>What are the default methods in the Predicate interface?</li>
 * </ol>
 *
 * <p><b>Real-world Use Cases:</b>
 * <ul>
 *   <li>Filtering collections based on conditions</li>
 *   <li>Input validation</li>
 *   <li>Business rule evaluation</n>
 *   <li>Conditional processing in streams</li>
 * </ul>
 *
 * @see java.util.function.Predicate
 * @see java.util.stream.Stream#filter(Predicate)
 * @since 1.8
 */
public class GreaterThan {
    
    /**
     * Demonstrates basic usage of Predicate with a simple numerical comparison.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Creating a Predicate using lambda expression</li>
     *   <li>Using the test() method to evaluate the condition</li>
     *   <li>Basic boolean logic in functional programming</li>
     * </ul>
     *
     * <p><b>Interview Tip:</b> Be prepared to explain how you would handle edge cases
     * like null values or non-numeric inputs in a real-world scenario.</p>
     *
     * <p><b>Performance Consideration:</b> The test() operation is O(1) time complexity
     * for simple comparisons like this one.</p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Example 1: Basic Predicate to check if number > 20
        // Interview Question: What's the difference between these two predicate declarations?
        Predicate<Integer> isGreaterThanTwenty = number -> (number > 20);
        // Alternative using method reference (if we had a method for the check)
        // Predicate<Integer> isGreaterThanTwenty = GreaterThan::checkIfGreaterThanTwenty;
        
        // Test the predicate with different values
        // Interview Tip: Always test boundary conditions in interviews
        System.out.println("=== Basic Predicate Examples ===");
        testPredicate(isGreaterThanTwenty, 19);  // false
        testPredicate(isGreaterThanTwenty, 20);   // false (boundary case)
        testPredicate(isGreaterThanTwenty, 21);   // true
        
        // Example 2: Chaining Predicates
        // Interview Question: How would you combine multiple conditions?
        System.out.println("\n=== Chained Predicates ===");
        Predicate<Integer> isLessThanFifty = number -> (number < 50);
        
        // Using and() to combine predicates
        Predicate<Integer> inRange = isGreaterThanTwenty.and(isLessThanFifty);
        testPredicate(inRange, 25);  // true
        testPredicate(inRange, 15);  // false
        testPredicate(inRange, 55);  // false
        
        // Example 3: Using negate()
        // Interview Question: How would you check for numbers not in range?
        System.out.println("\n=== Negated Predicate ===");
        Predicate<Integer> notInRange = inRange.negate();
        testPredicate(notInRange, 25);  // false
        testPredicate(notInRange, 15);  // true
        testPredicate(notInRange, 55);  // true
    }
    
    /**
     * Helper method to test a predicate and print the result.
     * This demonstrates method organization and makes the test cases more readable.
     * 
     * @param predicate The predicate to test
     * @param number The number to test against the predicate
     */
    private static void testPredicate(Predicate<Integer> predicate, int number) {
        boolean result = predicate.test(number);
        System.out.println(String.format("Is %d greater than 20? %s", number, result));
    }
}
