package Java8.latest.funcationalInterface.predicate;

import java.util.function.Predicate;

/**
 * <b>Interview Focus: String Operations with Predicate</b>
 * 
 * <p>This class demonstrates the use of Java's Predicate functional interface
 * to perform string length validations, a common requirement in real-world applications.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Using Predicate for string validation</li>
 *   <li>String length operations in Java</li>
 *   <li>Null-safety in functional programming</li>
 *   <li>Method references vs lambda expressions</li>
 *   <li>Composing multiple string validations</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>How do you validate string length in Java 8+?</li>
 *   <li>What's the difference between String.length() and String.codePointCount()?</li>
 *   <li>How would you handle null checks in a Predicate?</li>
 *   <li>How can you chain multiple string validations?</li>
 *   <li>What are the performance implications of different string operations?</li>
 * </ol>
 *
 * <p><b>Real-world Use Cases:</b>
 * <ul>
 *   <li>Form input validation</li>
 *   <li>Password policy enforcement</li>
 *   <li>Data cleaning and normalization</li>
 *   <li>API request validation</li>
 * </ul>
 *
 * @see java.util.function.Predicate
 * @see java.lang.String#length()
 * @since 1.8
 */
public class LengthOfString {
    
    /**
     * Demonstrates string length validation using Predicate with various examples.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Basic string length validation</li>
     *   <li>Null-safe predicate implementation</li>
     *   <li>Chaining multiple validations</li>
     *   <li>Boundary condition testing</li>
     * </ul>
     *
     * <p><b>Interview Tip:</b> Always consider edge cases like null values,
     * empty strings, and whitespace when working with string validations.</p>
     *
     * <p><b>Performance Note:</b> String.length() is an O(1) operation in Java
     * as strings cache their length.</p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Example 1: Basic length check
        // Interview Question: What's the problem with this simple implementation?
        Predicate<String> unsafeLengthCheck = string -> (string.length() > 5);
        
        // Example 2: Null-safe implementation
        // Interview Question: Why is this better than the previous version?
        Predicate<String> lengthGreaterThanFive = string -> {
            if (string == null) return false;  // Handle null case
            return string.length() > 5;
        };
        
        // Example 3: Using method reference (alternative approach)
        // Interview Question: When would you use method references over lambdas?
        // Predicate<String> lengthGreaterThanFive = LengthOfString::isLongerThanFive;
        
        // Test cases
        System.out.println("=== String Length Validation ===");
        testStringLength(lengthGreaterThanFive, "Gourav", true);      // Length 6 > 5
        testStringLength(lengthGreaterThanFive, "Java", false);       // Length 4 <= 5
        testStringLength(lengthGreaterThanFive, "", false);           // Empty string
        testStringLength(lengthGreaterThanFive, null, false);         // Null check
        testStringLength(lengthGreaterThanFive, "Hello ", true);      // Length 6 with space
        
        // Example 4: Chaining multiple validations
        System.out.println("\n=== Chained Validations ===");
        Predicate<String> hasUpperCase = s -> s != null && !s.equals(s.toLowerCase());
        Predicate<String> hasNumber = s -> s != null && s.matches(".*\\d.*");
        
        // Combined predicate for password validation
        Predicate<String> isStrongPassword = lengthGreaterThanFive
                .and(hasUpperCase)
                .and(hasNumber);
        
        testPasswordStrength(isStrongPassword, "Password123", true);   // Valid
        testPasswordStrength(isStrongPassword, "weak", false);         // Too short
        testPasswordStrength(isStrongPassword, "nopassword", false);   // No numbers or uppercase
        testPasswordStrength(isStrongPassword, "12345678", false);     // No letters
        testPasswordStrength(isStrongPassword, null, false);           // Null check
    }
    
    /**
     * Helper method to test string length validation.
     * 
     * @param validator The predicate to test with
     * @param input The string to validate
     * @param expected The expected result of validation
     */
    private static void testStringLength(Predicate<String> validator, String input, boolean expected) {
        boolean result = validator.test(input);
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println(String.format("[%s] '%s' %s length > 5: %s", 
            status, 
            input == null ? "null" : input,
            result ? "has" : "does not have",
            expected == result ? "(as expected)" : "(unexpected)"));
    }
    
    /**
     * Helper method to test password strength validation.
     * 
     * @param validator The password strength validator
     * @param password The password to test
     * @param expected The expected validation result
     */
    private static void testPasswordStrength(Predicate<String> validator, String password, boolean expected) {
        boolean result = validator.test(password);
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println(String.format("[%s] Password '%s' is %s (Expected: %s)", 
            status,
            password == null ? "null" : password,
            result ? "strong" : "weak",
            expected ? "strong" : "weak"));
    }
    
    /**
     * Alternative implementation using a method reference.
     * This shows how we can extract the validation logic to a separate method.
     * 
     * @param str The string to check
     * @return true if string length > 5, false otherwise
     */
    private static boolean isLongerThanFive(String str) {
        return str != null && str.length() > 5;
    }
}
