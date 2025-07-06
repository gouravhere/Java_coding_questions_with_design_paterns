package Java8.latest.funcationalInterface;

/**
 * A functional interface that extends another functional interface (FunctionalA).
 * Even though it extends FunctionalA, it's still a valid functional interface
 * because it doesn't declare any new abstract methods - it just inherits myMethod()
 * from FunctionalA.
 * 
 * This demonstrates that a functional interface can extend another interface
 * without breaking the single abstract method rule, as long as it doesn't add
 * any new abstract methods.
 */
@FunctionalInterface
public interface FunctionalB extends FunctionalA {
    /**
     * This method is inherited from FunctionalA.
     * The @FunctionalInterface annotation ensures that we don't accidentally
     * add any additional abstract methods to this interface.
     */
    @Override
    void myMethod();
}
