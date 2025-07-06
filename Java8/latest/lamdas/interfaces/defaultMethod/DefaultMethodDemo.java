package Java8.latest.lamdas.interfaces.defaultMethod;

/**
 * DefaultMethodDemo is a demonstration class that showcases the usage of default methods
 * in Java interfaces and how they interact with class implementations.
 *
 * <p>This class implements the FunctionalA interface and demonstrates how default methods
 * can be used and overridden in implementing classes.</p>
 *
 * @see FunctionalA
 * @see FunctionalB
 * @since 1.8
 */
public class DefaultMethodDemo implements FunctionalA {
    
    /**
     * The entry point of the application.
     * 
     * <p>This method demonstrates:
     * <ol>
     *   <li>Creating an instance of FunctionalB which implements FunctionalA</li>
     *   <li>Calling the overridden myMethod() implementation</li>
     *   <li>Showing how default methods work in interface implementations</li>
     * </ol>
     * </p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Create an instance of FunctionalB but refer to it using FunctionalA reference
        FunctionalA a = new FunctionalB();
        
        // Call the method - this will use the implementation from FunctionalB
        a.myMethod();
    }
}
