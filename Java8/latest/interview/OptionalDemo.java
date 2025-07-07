package Java8.latest.interview;

import java.util.Optional;

/**
 * Optional Class in Java 8
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Container object which may or may not contain a non-null value</li>
 *     <li>Helps to handle null values more elegantly</li>
 *     <li>Reduces NullPointerExceptions</li>
 *     <li>Provides methods to check the presence of value and handle it appropriately</li>
 *     <li>Common methods: of(), ofNullable(), isPresent(), ifPresent(), orElse(), orElseGet(), orElseThrow()</li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What is Optional in Java 8?</li>
 *     <li>What is the difference between Optional.of() and Optional.ofNullable()?</li>
 *     <li>Difference between orElse() and orElseGet()?</li>
 *     <li>When to use Optional in Java?</li>
 *     <li>How to handle exceptions with Optional?</li>
 *     <li>What is the difference between ifPresent() and isPresent()?</li>
 *     <li>Can Optional be used as a method parameter or instance variable?</li>
 * </ol>
 *
 * @since Java 8
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // 1. Creating Optional objects
        System.out.println("=== 1. Creating Optional Objects ===");
        
        // Creates an Optional with a non-null value
        Optional<String> nonEmptyOptional = Optional.of("Hello");
        
        // Creates an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        
        // Creates an Optional that may contain a null value
        String nullableString = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableString);
        
        System.out.println("Non-empty Optional: " + nonEmptyOptional);
        System.out.println("Empty Optional: " + emptyOptional);
        System.out.println("Nullable Optional: " + nullableOptional);
        
        // 2. Checking value presence
        System.out.println("\n=== 2. Checking Value Presence ===");
        System.out.println("Is nonEmptyOptional present? " + nonEmptyOptional.isPresent());
        System.out.println("Is emptyOptional present? " + emptyOptional.isPresent());
        
        // 3. Conditional actions with ifPresent()
        System.out.println("\n=== 3. Conditional Actions ===");
        nonEmptyOptional.ifPresent(val -> System.out.println("Value is present: " + val));
        emptyOptional.ifPresent(val -> System.out.println("This won't be printed"));
        
        // 4. Default values with orElse() and orElseGet()
        System.out.println("\n=== 4. Default Values ===");
        String value1 = nonEmptyOptional.orElse("Default Value");
        String value2 = emptyOptional.orElse("Default Value");
        
        System.out.println("Value from non-empty: " + value1);
        System.out.println("Value from empty: " + value2);
        
        // orElseGet() with Supplier - lazy evaluation
        String value3 = emptyOptional.orElseGet(() -> {
            System.out.println("Executing orElseGet()");
            return "Default from Supplier";
        });
        System.out.println("Value from orElseGet: " + value3);
        
        // 5. Throwing exceptions with orElseThrow()
        System.out.println("\n=== 5. Throwing Exceptions ===");
        try {
            String value = emptyOptional.orElseThrow(() -> new RuntimeException("Value not found"));
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // 6. Filtering and mapping
        System.out.println("\n=== 6. Filtering and Mapping ===");
        nonEmptyOptional.filter(val -> val.length() > 3)
                       .ifPresent(val -> System.out.println("Filtered value: " + val));
        
        Optional<String> upperCaseOptional = nonEmptyOptional.map(String::toUpperCase);
        System.out.println("Mapped to uppercase: " + upperCaseOptional.get());
        
        // 7. Chaining Optionals with flatMap()
        System.out.println("\n=== 7. Chaining Optionals ===");
        Optional<String> flatMapped = nonEmptyOptional.flatMap(val -> Optional.of(val + " World"));
        System.out.println("FlatMapped value: " + flatMapped.get());
        
        // 8. Real-world example
        System.out.println("\n=== 8. Real-world Example ===");
        User user = new User("john_doe", "john@example.com");
        // User user = null; // Uncomment to test with null user
        
        String email = Optional.ofNullable(user)
                             .flatMap(User::getEmail) // getEmail returns Optional<String>
                             .orElse("No email provided");
        
        System.out.println("User email: " + email);
    }
    
    static class User {
        private String username;
        private String email;
        
        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }
        
        public String getUsername() {
            return username;
        }
        
        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
    
    /**
     * <b>Interview Questions with Answers:</b>
     * 
     * <p><b>1. What is the difference between Optional.of() and Optional.ofNullable()?</b>
     * <p>Answer:
     * - Optional.of(value) throws NullPointerException if the value is null
     * - Optional.ofNullable(value) creates an empty Optional if the value is null
     * 
     * <p><b>2. What is the difference between orElse() and orElseGet()?</b>
     * <p>Answer:
     * - orElse() is always evaluated, regardless of whether the Optional has a value
     * - orElseGet() is only evaluated when the Optional is empty (lazy evaluation)
     * - orElseGet() takes a Supplier, while orElse() takes a value
     * 
     * <p><b>3. When should you use Optional in Java?</b>
     * <p>Answer:
     * - As a return type for methods that might not return a value
     * - To explicitly indicate that a method may return null
     * - To chain multiple operations that might return null
     * - To avoid NullPointerException in a more functional way
     * 
     * <p><b>4. What is the difference between ifPresent() and isPresent()?</b>
     * <p>Answer:
     * - isPresent() returns a boolean indicating if a value is present
     * - ifPresent() takes a Consumer and executes it only if a value is present
     * - ifPresent() is more functional and concise
     * 
     * <p><b>5. Can Optional be used as a method parameter or instance variable?</b>
     * <p>Answer:
     * - Not recommended for method parameters as it complicates the API
     * - Not recommended for instance variables as it's designed for return types
     * - Better to use Optional for return types and handle null checks in the method body
     */
}
