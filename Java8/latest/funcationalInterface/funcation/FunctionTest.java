package Java8.latest.funcationalInterface.funcation;

import java.util.function.Function;

/**
 * <b>Interview Focus: Java 8+ Function Interface</b>
 * 
 * <p>This class demonstrates the Function<T, R> interface, a core component of Java's
 * functional programming features introduced in Java 8. Understanding this is crucial for
 * Java developer interviews.</p>
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Function<T, R> is a functional interface that takes an input of type T and returns a result of type R</li>
 *   <li>Contains a single abstract method: R apply(T t)</li>
 *   <li>Commonly used in stream operations like map() and flatMap()</li>
 *   <li>Part of java.util.function package (introduced in Java 8)</li>
 * </ul>
 * 
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What is the Function interface in Java 8?</li>
 *   <li>How do you implement a Function in Java?</li>
 *   <li>What's the difference between Function, Supplier, and Consumer?</li>
 *   <li>How would you chain multiple functions together?</li>
 *   <li>What are the default methods in Function interface?</li>
 * </ol>
 * 
 * <p><b>Real-world Use Cases:</b>
 * <ul>
 *   <li>Data transformation in streams</li>
 *   <li>Converting between different object types</li>
 *   <li>Implementing strategy pattern</li>
 *   <li>Processing pipelines</li>
 * </ul>
 * 
 * @see java.util.function.Function
 * @since 1.8
 */
public class FunctionTest {
    
    /**
     * Demonstrates practical usage of Function interface with common interview scenarios.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Lambda expression implementation of Function interface</li>
     *   <li>Method reference alternative: String::length</li>
     *   <li>Handling potential exceptions (StringIndexOutOfBoundsException)</li>
     *   <li>Function composition (andThen, compose)</li>
     * </ul>
     * 
     * <p><b>Interview Tip:</b> Be prepared to explain how you would handle cases where
     * the string might be null or shorter than expected length.</p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Example 1: Basic Function to get string length
        // Interview Question: What's the difference between str -> str.length() and String::length?
        Function<String, Integer> stringLengthFunction = str -> {
            // Interview Tip: Always handle null checks in production code
            if (str == null) return 0;
            return str.length();
        };
        
        // Example 2: Function to get character at specific index
        // Interview Question: What exception might this throw? How would you handle it?
        Function<String, Character> charAtThreeFunction = str -> {
            // Interview Tip: Discuss defensive programming
            if (str == null || str.length() <= 3) {
                return '\0'; // Return null character as default
            }
            return str.charAt(3);
        };

        // Example 3: Using the functions
        // Interview Question: What's the time complexity of these operations?
        // Answer: O(1) for length(), O(1) for charAt() - both constant time operations
        System.out.println("\n--- Function Examples ---");
        
        // Using stringLengthFunction
        String name = "Gourav";
        System.out.println(String.format("Length of '%s': %d", 
            name, stringLengthFunction.apply(name)));
        
        // Using charAtThreeFunction with null check demonstration
        String text = "Learing Java 8 features";
        char result = charAtThreeFunction.apply(text);
        System.out.println(String.format("4th character of '%s': %c", text, result));
        
        // Interview Scenario: Function Composition
        // Example: First get length, then check if it's even
        System.out.println("\n--- Function Composition ---");
        Function<String, Boolean> isLengthEven = stringLengthFunction.andThen(len -> len % 2 == 0);
        System.out.println("Is length of 'Gourav' even? " + isLengthEven.apply("Gourav"));
    }
}
