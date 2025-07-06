package multiThreading.daemon;

/**
 * <b>Custom Thread Implementation Example</b>
 * 
 * <p>This class demonstrates how to properly extend the Thread class in Java,
 * with a focus on proper exception handling and thread lifecycle management.</p>
 *
 * <p><b>Key Features:</b>
 * <ul>
 *   <li>Proper exception handling in thread's run method</li>
 *   <li>Thread naming for better debugging</li>
 *   <li>Graceful thread termination</li>
 *   <li>Thread state monitoring</li>
 *   <li>Resource cleanup in finally block</li>
 * </ul>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Always handle InterruptedException properly</li>
 *   <li>Clean up resources in finally blocks</li>
 *   <li>Use thread naming for better debugging</li>
 *   <li>Document thread-safety of your implementation</li>
 *   <li>Consider implementing Runnable instead of extending Thread</li>
 * </ul>
 */
public class MyThread extends Thread {
    private static final int DEFAULT_ITERATIONS = 10;
    private final String threadName;
    private volatile boolean running = true;

    /**
     * Creates a new thread with a default name.
     */
    public MyThread() {
        this("MyThread-" + System.currentTimeMillis() % 1000);
    }

    /**
     * Creates a new thread with the specified name.
     *
     * @param name the name of the thread (used for identification)
     */
    public MyThread(String name) {
        super(name);
        this.threadName = name;
    }

    /**
     * The main execution method of the thread.
     * 
     * <p>This method demonstrates proper exception handling and resource cleanup
     * in a thread's run method.</p>
     */
    @Override
    public void run() {
        System.out.println(threadName + " started. Is daemon: " + isDaemon());
        
        try {
            for (int i = 0; i < DEFAULT_ITERATIONS && running; i++) {
                // Check for interruption
                if (Thread.interrupted()) {
                    System.out.println(threadName + " was interrupted");
                    break;
                }
                
                try {
                    // Simulate some work
                    System.out.println(threadName + " - Count: " + i);
                    
                    // Sleep to simulate work and allow for interruption
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e) {
                    System.out.println(threadName + " was interrupted during sleep");
                    // Restore the interrupted status
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } finally {
            // Cleanup resources
            cleanup();
            System.out.println(threadName + " is terminating");
        }
    }
    
    /**
     * Requests the thread to stop gracefully.
     * The thread will complete its current iteration and then terminate.
     */
    public void stopGracefully() {
        System.out.println("Requesting " + threadName + " to stop...");
        running = false;
        this.interrupt(); // Interrupt if the thread is sleeping
    }
    
    /**
     * Performs cleanup when the thread is about to terminate.
     * This method is called in the finally block of the run method.
     */
    private void cleanup() {
        // Release any resources here
        System.out.println(threadName + " is cleaning up resources...");
        // Example: close files, database connections, etc.
    }
    
    /**
     * <b>Thread Implementation Best Practices:</b>
     * 1. Always handle InterruptedException properly
     *    - Either rethrow it
     *    - Or restore the interrupt status with Thread.currentThread().interrupt()
     *    
     * 2. Clean up resources in finally blocks
     *    - Ensures resources are released even if an exception occurs
     *    
     * 3. Use volatile or other synchronization for shared variables
     *    - Ensures visibility of changes across threads
     *    
     * 4. Prefer implementing Runnable over extending Thread
     *    - More flexible (can extend another class)
     *    - Better separation of concerns
     *    
     * 5. Document thread-safety
     *    - Clearly document which methods are thread-safe
     *    - Document any synchronization requirements
     */
}
