package Java8.latest.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Lambda Expressions in Java 8
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Lambda expressions provide a clear and concise way to represent one method interface using an expression</li>
 *     <li>They enable functional programming in Java</li>
 *     <li>Syntax: (parameters) -> expression or (parameters) -> { statements; }</li>
 *     <li>Optional type declaration: No need to declare the type of a parameter</li>
 *     <li>Optional parenthesis around parameter: No need to declare a single parameter in parenthesis</li>
 *     <li>Optional curly braces: No need to use curly braces in expression body if the body contains a single statement</li>
 *     <li>Optional return keyword: The compiler automatically returns the value if the body has a single expression</li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What is a lambda expression in Java 8?</li>
 *     <li>What is the syntax of lambda expression in Java 8?</li>
 *     <li>What is a functional interface? How it is related to the lambda function?</li>
 *     <li>What is the meaning of "effectively final" in lambda expressions?</li>
 *     <li>Can we override a default method of functional interface?</li>
 *     <li>What is the difference between a lambda expression and an anonymous class?</li>
 *     <li>What are method references? How are they related to lambda expressions?</li>
 * </ol>
 *
 * @since Java 8
 */
public class LambdaExpressionsDemo {

    // Functional interface with single abstract method
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
        
        // Can have default methods
        default void printResult(int result) {
            System.out.println("Result: " + result);
        }
    }

    public static void main(String[] args) {
        LambdaExpressionsDemo demo = new LambdaExpressionsDemo();
        
        // 1. Basic Lambda Expressions
        System.out.println("=== 1. Basic Lambda Expressions ===");
        
        // With type declaration
        MathOperation addition = (int a, int b) -> a + b;
        
        // Without type declaration
        MathOperation subtraction = (a, b) -> a - b;
        
        // With return statement and curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        
        // Without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;
        
        System.out.println("10 + 5 = " + demo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + demo.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + demo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + demo.operate(10, 5, division));
        
        // 2. Lambda with forEach
        System.out.println("\n=== 2. Lambda with forEach ===");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        
        // Using lambda in forEach
        names.forEach(name -> System.out.println("Hello, " + name));
        
        // Using method reference (equivalent to above)
        names.forEach(System.out::println);
        
        // 3. Effectively Final Variables
        System.out.println("\n=== 3. Effectively Final Variables ===");
        String greeting = "Hello, "; // This is effectively final
        // greeting = "Hi, "; // Uncommenting this will cause compilation error
        
        names.forEach(name -> System.out.println(greeting + name));
        
        // 4. Built-in Functional Interfaces
        System.out.println("\n=== 4. Built-in Functional Interfaces ===");
        
        // Predicate - takes one argument, returns boolean
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println("Does 'Alice' start with 'A'? " + startsWithA.test("Alice"));
        
        // Function - takes one argument, produces result
        Function<String, Integer> length = String::length;
        System.out.println("Length of 'Hello': " + length.apply("Hello"));
        
        // Consumer - takes one argument, returns void
        Consumer<String> print = System.out::println;
        print.accept("Hello from Consumer!");
        
        // Supplier - takes no arguments, returns a result
        Supplier<Double> randomValue = Math::random;
        System.out.println("Random value: " + randomValue.get());
        
        // 5. Lambda vs Anonymous Class
        System.out.println("\n=== 5. Lambda vs Anonymous Class ===");
        
        // Using anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from anonymous class");
            }
        }).start();
        
        // Using lambda
        new Thread(() -> System.out.println("Running from lambda")).start();
    }
    
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }
    
    /**
     * <b>Interview Questions with Answers:</b>
     * 
     * <p><b>1. What is a lambda expression in Java 8?</b>
     * <p>Answer: A lambda expression is a short block of code which takes in parameters and returns a value. 
     * Lambda expressions are similar to methods, but they do not need a name and can be implemented right in the body of a method.
     * 
     * <p><b>2. What is the difference between a lambda expression and an anonymous class?</b>
     * <p>Answer: 
     * - Lambda expressions can only be used with functional interfaces (interfaces with a single abstract method)
     * - Anonymous classes can be used with interfaces (any number of methods) and abstract/concrete classes
     * - Lambda expressions don't create a new scope, while anonymous classes do
     * - 'this' keyword inside lambda refers to the enclosing class, while in anonymous class it refers to the anonymous class itself
     * - Lambda expressions are more concise and readable for simple implementations
     * 
     * <p><b>3. What is the meaning of "effectively final" in lambda expressions?</b>
     * <p>Answer: A variable or parameter whose value is never changed after it is initialized is effectively final. 
     * Lambda expressions can use local variables that are effectively final, but cannot modify them. This is because 
     * local variables live on the stack and are not guaranteed to be thread-safe.
     */
}
