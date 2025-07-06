package Java8.latest.funcationalInterface.predicate;

import java.util.function.Predicate;

/**
 * This class demonstrates the usage of Java's Predicate functional interface
 * to check if the length of a string is greater than 5 characters.
 *
 * <p>Predicate is a functional interface in Java that represents a boolean-valued function
 * of one argument. It's commonly used for filtering or matching operations.</p>
 *
 * @see java.util.function.Predicate
 * @since 1.8
 */
public class LengthOfString {
    
    /**
     * The entry point of the application.
     * 
     * <p>This method demonstrates:
     * <ol>
     *   <li>Creating a Predicate to check string length</li>
     *   <li>Using the test() method to evaluate the predicate</li>
     *   <li>Printing the result of the predicate evaluation</li>
     * </ol>
     * </p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create a Predicate that tests if a string's length is greater than 5
        Predicate<String> lengthGreaterThanFive = string -> (string.length() > 5);
        
        // Test the predicate with the string "Gourav" (length = 6)
        boolean result = lengthGreaterThanFive.test("Gourav");
        System.out.println("Is 'Gourav' longer than 5 characters? " + result);
    }
}
