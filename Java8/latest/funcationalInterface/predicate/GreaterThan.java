package Java8.latest.funcationalInterface.predicate;

import java.util.function.Predicate;

/**
 * This class demonstrates the use of Java's Predicate functional interface
 * to check if a number is greater than 20.
 *
 * <p>A Predicate is a functional interface that represents a boolean-valued function
 * of one argument. It's commonly used for filtering or matching operations in collections.</p>
 *
 * @see java.util.function.Predicate
 * @since 1.8
 */
public class GreaterThan {
    
    /**
     * The entry point of the application.
     * 
     * <p>This method demonstrates:
     * <ol>
     *   <li>Creating a Predicate to check if a number is greater than 20</li>
     *   <li>Using the test() method to evaluate the predicate</li>
     *   <li>Printing the result of the predicate evaluation</li>
     * </ol>
     * </p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create a Predicate that tests if a number is greater than 20
        Predicate<Integer> isGreaterThanTwenty = number -> (number > 20);
        
        // Test the predicate with the number 19
        boolean result = isGreaterThanTwenty.test(19);
        System.out.println("Is 19 greater than 20? " + result);
    }
}
