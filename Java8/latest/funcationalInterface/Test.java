package Java8.latest.funcationalInterface;

/**
 * A test class that demonstrates the usage of functional interfaces with lambda expressions.
 * This class shows how to create an instance of a functional interface using a lambda expression
 * and then invoke its method.
 */
public class Test {
    
    /**
     * The main method that demonstrates functional interface usage with lambda expressions.
     * 
     * @param args Command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create an instance of FunctionalA using a lambda expression
        // The lambda expression provides the implementation for the myMethod() of FunctionalA
        FunctionalA a = () -> System.out.println("Inside A using Test Class");
        
        // Invoke the method defined in the functional interface
        a.myMethod();
    }
}
