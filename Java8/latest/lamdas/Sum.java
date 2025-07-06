package Java8.latest.lamdas;

/**
 * A functional interface that represents an operation that takes two integer parameters
 * and performs an operation on them without returning any result.
 * 
 * This interface is annotated with @FunctionalInterface, which means it's intended
 * to be used with lambda expressions, method references, or method and constructor
 * references via the :: operator.
 */
@FunctionalInterface
public interface Sum {
    
    /**
     * Performs an operation on the given integer arguments.
     * 
     * @param a the first integer argument
     * @param b the second integer argument
     */
    void sum(int a, int b);
}
