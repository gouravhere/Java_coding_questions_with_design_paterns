package Java8.latest.funcationalInterface;

/**
 * A functional interface that demonstrates the basic structure of a functional interface in Java 8+.
 * A functional interface is an interface that contains exactly one abstract method.
 * It can have any number of default and static methods but only one abstract method.
 * The @FunctionalInterface annotation ensures that the interface has exactly one abstract method.
 */
@FunctionalInterface
public interface FunctionalA {
    
    /**
     * Performs an operation that doesn't take any parameters and doesn't return any result.
     * The actual behavior is defined by the implementing class or lambda expression.
     */
    void myMethod();
}
