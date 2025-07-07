package Java8.latest.methodrefrence;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A demonstration class showcasing different types of method references in Java 8+.
 * Method references provide a way to refer to methods without executing them.
 * They are a form of lambda expression.
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Method references are a shorthand notation of a lambda expression to call a method</li>
 *     <li>They make the code more readable and concise</li>
 *     <li>Four types of method references:
 *     <ol>
 *         <li>Reference to a static method (Class::staticMethod)</li>
 *         <li>Reference to an instance method of a particular object (object::instanceMethod)</li>
 *         <li>Reference to an instance method of an arbitrary object of a particular type (Class::instanceMethod)</li>
 *         <li>Reference to a constructor (Class::new)</li>
 *     </ol>
 *     </li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What are method references and why are they useful?</li>
 *     <li>What are the different types of method references in Java 8?</li>
 *     <li>When would you use a method reference instead of a lambda expression?</li>
 *     <li>What's the difference between object::instanceMethod and Class::instanceMethod?</li>
 * </ol>
 *
 * @since Java 8
 * @see java.util.function
 */
public class MethodRefDemo {

    /**
     * A static method that prints numbers from 0 to 9.
     * This demonstrates a static method that can be referenced using method reference.
     */
    public static void myMethod() {
        int i = 0;
        while (i < 10) {
            System.out.println(Thread.currentThread().getName() + " - myMethod: " + i);
            i++;
            try {
                Thread.sleep(100); // Add small delay for better output readability
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Instance method that converts a string to uppercase.
     *
     * @param str the string to convert
     * @return the uppercase version of the string
     */
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * Main method demonstrating different types of method references.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== 1. Reference to a Static Method ===");
        // Using lambda expression
        Runnable lambdaRunnable = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - Lambda: " + i);
            }
        };
        
        // Using method reference (equivalent to above lambda)
        Runnable methodRefRunnable = MethodRefDemo::myMethod;
        
        // Start both threads
        new Thread(lambdaRunnable, "Lambda-Thread").start();
        new Thread(methodRefRunnable, "MethodRef-Thread").start();

        // Main thread execution
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Main: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n=== 2. Reference to an Instance Method of a Particular Object ===");
        MethodRefDemo demo = new MethodRefDemo();
        Function<String, String> toUpperFunc = demo::toUpperCase;
        System.out.println("Using instance method reference: " + toUpperFunc.apply("hello"));

        // Using Consumer with System.out::println
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("\n=== 3. Reference to an Instance Method of an Arbitrary Object ===");
        names.forEach(System.out::println);

        System.out.println("\n=== 4. Reference to a Constructor ===");
        // Using constructor reference
        Function<String, String> newString = String::new;
        String emptyString = newString.apply("");
        System.out.println("Created empty string with length: " + emptyString.length());
    }
}
