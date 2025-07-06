package Java8.latest.lamdas.interfaces.defaultMethod;

/**
 * FunctionalB is a concrete class that implements the FunctionalA interface.
 * This class demonstrates how to provide a specific implementation of the
 * default method defined in the interface.
 *
 * <p>By implementing FunctionalA, this class can either use the default
 * implementation of myMethod() or provide its own implementation, as shown here.</p>
 *
 * @see FunctionalA
 * @since 1.8
 */
public class FunctionalB implements FunctionalA {
    
    /**
     * Provides a specific implementation of the myMethod() defined in FunctionalA.
     * This overrides the default implementation provided by the interface.
     *
     * <p>When this method is called, it prints "Inside B" to the standard output,
     * demonstrating that the class-specific implementation takes precedence over
     * the interface's default implementation.</p>
     *
     * @implNote This implementation prints "Inside B" to show method overriding behavior.
     */
    @Override
    public void myMethod() {
        System.out.println("Inside B");
    }
}
