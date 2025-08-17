package Java8.latest.lamdas;

import java.util.function.BiPredicate;

/**
 * A test class that demonstrates the usage of lambda expressions with a functional interface.
 * This class shows how to implement the Sum functional interface using a lambda expression
 * to perform addition of two integers.
 */
public class TestSum {
    
    /**
     * The main method that demonstrates the usage of lambda expressions with the Sum interface.
     * 
     * @param args Command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create an instance of Sum using a lambda expression
        // The lambda takes two integers, adds them, and prints the result
        Sum s = (a, b) -> System.out.println("Sum is " + (a + b));
        
        // Invoke the sum method with two integer arguments
        s.sum(10, 20);  // This will print: Sum is 30

    }
}
