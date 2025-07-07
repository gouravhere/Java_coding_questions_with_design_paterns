package Java8.latest.interview;

import java.util.function.*;

/**
 * Functional Interfaces in Java 8
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Functional interfaces have exactly one abstract method (can have multiple default/static methods)</li>
 *     <li>Can be marked with @FunctionalInterface annotation (optional but recommended)</li>
 *     <li>Common functional interfaces in java.util.function package:</li>
 *     <ul>
 *         <li>Predicate<T> - takes an argument, returns boolean</li>
 *         <li>Function<T,R> - takes one argument, produces a result</li>
 *         <li>Consumer<T> - takes one argument, returns void</li>
 *         <li>Supplier<T> - takes no arguments, returns a result</li>
 *         <li>UnaryOperator<T> - takes one argument, produces result of same type</li>
 *         <li>BinaryOperator<T> - takes two arguments of same type, produces result of same type</li>
 *     </ul>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What is a functional interface?</li>
 *     <li>What is @FunctionalInterface annotation?</li>
 *     <li>Can a functional interface have default/static methods?</li>
 *     <li>What are the most commonly used functional interfaces in Java 8?</li>
 *     <li>Difference between Predicate and Function?</li>
 *     <li>What is method reference? How is it related to lambda expressions?</li>
 *     <li>What is the difference between Consumer and Supplier?</li>
 * </ol>
 *
 * @since Java 8
 */
public class FunctionalInterfacesDemo {

    public static void main(String[] args) {
        // 1. Predicate - tests a condition
        System.out.println("=== 1. Predicate ===");
        Predicate<String> isLongerThan5 = s -> s.length() > 5;
        System.out.println("Is 'Hello' longer than 5? " + isLongerThan5.test("Hello"));
        
        // Predicate chaining
        Predicate<String> startsWithH = s -> s.startsWith("H");
        System.out.println("Starts with H and length > 5: " + 
            isLongerThan5.and(startsWithH).test("Hello World"));
        
        // 2. Function - transforms input to output
        System.out.println("\n=== 2. Function ===");
        Function<String, Integer> length = String::length;
        System.out.println("Length of 'Hello': " + length.apply("Hello"));
        
        // Function chaining
        Function<Integer, String> addExclamation = i -> i + "!";
        Function<String, String> toUpper = String::toUpperCase;
        
        Function<String, String> processString = toUpper;
        System.out.println("Processed string: " + processString.apply("hello"));
        
        // 3. Consumer - performs action on input
        System.out.println("\n=== 3. Consumer ===");
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello");
        
        // Consumer chaining
        Consumer<String> printLength = s -> System.out.println("Length: " + s.length());
        printUpperCase.andThen(printLength).accept("Hello");
        
        // 4. Supplier - provides a result
        System.out.println("\n=== 4. Supplier ===");
        Supplier<Double> randomValue = Math::random;
        System.out.println("Random value: " + randomValue.get());
        
        // 5. UnaryOperator - function where input and output are of same type
        System.out.println("\n=== 5. UnaryOperator ===");
        UnaryOperator<String> addGreeting = s -> "Hello " + s;
        System.out.println(addGreeting.apply("World"));
        
        // 6. BinaryOperator - takes two inputs of same type, returns one of same type
        System.out.println("\n=== 6. BinaryOperator ===");
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("10 + 20 = " + add.apply(10, 20));
        
        // 7. Custom Functional Interface
        System.out.println("\n=== 7. Custom Functional Interface ===");
        Calculator addCalc = (a, b) -> a + b;
        Calculator multiplyCalc = (a, b) -> a * b;
        
        System.out.println("10 + 5 = " + calculate(10, 5, addCalc));
        System.out.println("10 * 5 = " + calculate(10, 5, multiplyCalc));
        
        // 8. Method References
        System.out.println("\n=== 8. Method References ===");
        // Static method reference
        Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("Parsed number: " + parseInt.apply("123"));
        
        // Instance method reference
        String str = "Hello";
        Supplier<Integer> strLength = str::length;
        System.out.println("Length: " + strLength.get());
    }
    
    // Custom functional interface
    @FunctionalInterface
    interface Calculator {
        int operate(int a, int b);
    }
    
    // Method using the custom functional interface
    private static int calculate(int a, int b, Calculator calculator) {
        return calculator.operate(a, b);
    }
    
    /**
     * <b>Interview Questions with Answers:</b>
     * 
     * <p><b>1. What is a functional interface?</b>
     * <p>Answer: A functional interface is an interface that contains exactly one abstract method. 
     * It can have any number of default or static methods. The @FunctionalInterface annotation 
     * is used to ensure that the interface has exactly one abstract method.
     * 
     * <p><b>2. What is the difference between Predicate and Function?</b>
     * <p>Answer:
     * - Predicate<T> takes one argument and returns a boolean. Used for testing conditions.
     * - Function<T,R> takes one argument of type T and returns a result of type R. Used for transformations.
     * 
     * <p><b>3. Can a functional interface have default/static methods?</b>
     * <p>Answer: Yes, a functional interface can have any number of default and static methods, 
     * but it must have exactly one abstract method. The presence of default/static methods 
     * doesn't affect its status as a functional interface.
     * 
     * <p><b>4. What is the difference between Consumer and Supplier?</b>
     * <p>Answer:
     * - Consumer<T> takes one argument and returns no result (void). Used for performing operations.
     * - Supplier<T> takes no arguments and returns a result. Used for providing values.
     */
}
