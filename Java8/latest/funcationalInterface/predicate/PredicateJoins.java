package Java8.latest.funcationalInterface.predicate;

import java.util.function.Predicate;

/**
 * This class demonstrates the use of Java's Predicate interface
 * with method chaining and logical operations like and(), or(), and negate().
 *
 * <p>It shows how to combine multiple predicates to create more complex conditions
 * for filtering or processing collections of data.</p>
 *
 * @see java.util.function.Predicate
 * @since 1.8
 */
public class PredicateJoins {
    
    /**
     * The entry point of the application.
     * 
     * <p>This method demonstrates:
     * <ol>
     *   <li>Creating multiple Predicate instances</li>
     *   <li>Using predicate methods: and(), or(), negate()</li>
     *   <li>Filtering an array based on different predicate conditions</li>
     * </ol>
     * </p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Sample array of integers
        int[] numbers = {5, 20, 1, 3, 55, 211, 22};
        
        // Predicate to check if a number is greater than 10
        Predicate<Integer> greaterThanTen = number -> (number > 10);
        
        // Predicate to check if a number is even
        Predicate<Integer> isEven = number -> (number % 2 == 0);

        // Demonstrate different predicate combinations
        System.out.println("Numbers greater than 10:");
        filterAndPrint(greaterThanTen, numbers);

        System.out.println("\nEven numbers:");
        filterAndPrint(isEven, numbers);

        System.out.println("\nNumbers not greater than 10:");
        filterAndPrint(greaterThanTen.negate(), numbers);

        System.out.println("\nNumbers greater than 10 and even:");
        filterAndPrint(greaterThanTen.and(isEven), numbers);
    }

    /**
     * Filters and prints elements from an array based on the given predicate.
     *
     * @param predicate the predicate to test each element against
     * @param array the array of integers to filter
     */
    static void filterAndPrint(Predicate<Integer> predicate, int[] array) {
        for (int number : array) {
            if (predicate.test(number)) {
                System.out.println(number);
            }
        }
    }
}
