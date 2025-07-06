package Java8.latest.lamdas.interfaces.defaultMethod;

/**
 * FunctionalA is a functional interface that demonstrates the concept of default methods
 * in Java 8+ interfaces. A functional interface contains exactly one abstract method
 * but can have multiple default methods with implementations.
 *
 * <p>This interface shows how default methods can provide backward compatibility
 * when adding new methods to existing interfaces.</p>
 *
 * @since 1.8
 */
public interface FunctionalA {
    
    /**
     * A default method that provides a concrete implementation.
     * Default methods were introduced in Java 8 to allow adding new methods
     * to interfaces without breaking existing implementations.
     *
     * <p>This method prints "Inside A" to demonstrate the default behavior.
     * Implementing classes can choose to override this method to provide
     * their own implementation.</p>
     *
     * @implNote The default implementation prints "Inside A" to the standard output.
     */
    default void myMethod() {
        System.out.println("Inside A");
    }
}
