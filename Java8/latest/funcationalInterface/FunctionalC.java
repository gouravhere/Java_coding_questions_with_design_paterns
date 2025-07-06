package Java8.latest.funcationalInterface;

/**
 * A concrete implementation of the FunctionalA interface.
 * This class demonstrates the traditional way of implementing a functional interface
 * by providing an implementation for the abstract method defined in the interface.
 * 
 * This approach was common before Java 8's lambda expressions and is still useful
 * when you need to provide more complex behavior that can't be easily expressed
 * with a lambda expression.
 */
public class FunctionalC implements FunctionalA {

    /**
     * Implements the myMethod() from FunctionalA interface.
     * This method prints a simple message to the console when called.
     * In a real-world scenario, this could contain any implementation logic
     * required by the FunctionalA interface.
     */
    @Override
    public void myMethod() {
        System.out.println("Inside A");
    }
}
