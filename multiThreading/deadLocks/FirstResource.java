package multiThreading.deadLocks;

/**
 * <b>First Resource in Deadlock Example</b>
 * 
 * <p>This class represents the first resource in a potential deadlock scenario.
 * It demonstrates how improper lock acquisition order can lead to deadlocks.</p>
 * 
 * <p><b>Thread Safety:</b>
 * This class is thread-safe but can lead to deadlocks when used incorrectly
 * with SecondResource due to nested synchronized blocks.</p>
 */
public class FirstResource implements Resource {
    private final String name = "FirstResource";
    private final Object lock = new Object();

    /**
     * Method that can potentially cause a deadlock when called from multiple threads.
     * 
     * @param otherResource the second resource to interact with
     * @throws IllegalStateException if the thread is interrupted
     */
    public synchronized void method1(SecondResource otherResource) {
        System.out.println(Thread.currentThread().getName() + " - " + name + ".method1()");
        
        // Simulate some work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Thread was interrupted", e);
        }

        System.out.println(Thread.currentThread().getName() + " - Invoking method2 on SecondResource");
        otherResource.method2();
    }
    
    /**
     * Method that can be called by other resources.
     * This is part of the potential deadlock scenario.
     */
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " - " + name + ".method2()");
    }
    
    /**
     * Implements the Resource interface method to demonstrate deadlock prevention.
     * This version uses a private lock object instead of synchronizing on 'this'.
     * 
     * @param other the other resource to interact with
     */
    @Override
    public void access(Resource other) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " - " + name + " is accessing another resource");
            
            // Simulate some work
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            
            // Access the other resource in a deadlock-free way
            if (other instanceof SecondResource) {
                ((SecondResource) other).safeAccess();
            }
        }
    }
    
    /**
     * Safe method that can be called by other resources without causing deadlocks.
     */
    public void safeAccess() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " - " + name + ".safeAccess()");
        }
    }
    
    @Override
    public String toString() {
        return name;
    }
}
