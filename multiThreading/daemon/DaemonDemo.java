package multiThreading.daemon;

/**
 * <b>Interview Focus: Daemon Threads in Java</b>
 * 
 * <p>This class demonstrates the concept of daemon threads in Java, which are low-priority
 * threads that run in the background to perform tasks such as garbage collection, finalization,
 * and other housekeeping tasks.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Daemon vs non-daemon threads</li>
 *   <li>Thread priority and JVM behavior</li>
 *   <li>Use cases for daemon threads</li>
 *   <li>Thread lifecycle and JVM shutdown</li>
 *   <li>Best practices for daemon thread usage</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What is a daemon thread in Java?</li>
 *   <li>What's the difference between daemon and non-daemon threads?</li>
 *   <li>When would you use a daemon thread?</li>
 *   <li>Can you convert a non-daemon thread to a daemon thread?</li>
 *   <li>What happens to daemon threads when the JVM exits?</li>
 * </ol>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Use daemon threads for background tasks that should not prevent JVM shutdown</li>
 *   <li>Set daemon status before starting the thread</li>
 *   <li>Don't use daemon threads for tasks that require cleanup or finalization</li>
 *   <li>Be cautious with I/O operations in daemon threads</li>
 *   <li>Document thread-safety and daemon status in your code</li>
 * </ul>
 */
public class DaemonDemo {
    
    /**
     * Demonstrates the behavior of daemon threads in Java.
     * 
     * <p><b>Key Features Demonstrated:</b>
     * <ul>
     *   <li>Checking if the current thread is a daemon</li>
     *   <li>Creating and configuring a daemon thread</li>
     *   <li>Observing JVM behavior with daemon threads</li>
     *   <li>Proper thread lifecycle management</li>
     * </ul>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Check if the main thread is a daemon (should be false)
        System.out.println("Is main thread a daemon? " + 
                          Thread.currentThread().isDaemon());
        
        // Example 1: Create a daemon thread
        System.out.println("\n=== Example 1: Daemon Thread ===");
        createAndStartDaemonThread();
        
        // Example 2: Non-daemon thread keeps JVM alive
        System.out.println("\n=== Example 2: Non-Daemon Thread ===");
        createAndStartNonDaemonThread();
        
        // Give some time for threads to start
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }
        
        System.out.println("\nMain thread is about to complete. " +
                          "JVM will exit when only daemon threads remain.");
    }
    
    /**
     * Creates and starts a daemon thread.
     * Daemon threads don't prevent the JVM from exiting.
     */
    private static void createAndStartDaemonThread() {
        System.out.println("Creating a daemon thread...");
        MyThread daemonThread = new MyThread();
        
        // Must set daemon status before starting the thread
        daemonThread.setDaemon(true);
        
        System.out.println("Is thread a daemon? " + daemonThread.isDaemon());
        daemonThread.start();
    }
    
    /**
     * Creates and starts a non-daemon thread.
     * Non-daemon threads keep the JVM alive until they complete.
     */
    private static void createAndStartNonDaemonThread() {
        System.out.println("Creating a non-daemon thread...");
        MyThread nonDaemonThread = new MyThread("Non-Daemon-Thread");
        
        // By default, threads are non-daemon
        // Non-daemon threads will keep the JVM running
        System.out.println("Is thread a daemon? " + nonDaemonThread.isDaemon());
        nonDaemonThread.start();
    }
    
    /**
     * <b>Interview Questions Addressed:</b>
     * 1. What is a daemon thread in Java?
     *    - A low-priority thread that runs in the background and doesn't prevent JVM shutdown
     *    
     * 2. What's the difference between daemon and non-daemon threads?
     *    - JVM exits when only daemon threads remain
     *    - Non-daemon threads keep the JVM running until they complete
     *    
     * 3. When would you use a daemon thread?
     *    - For background tasks like monitoring, logging, or cleanup that shouldn't block JVM shutdown
     *    
     * 4. Can you convert a non-daemon thread to a daemon thread?
     *    - Only before the thread is started; throws IllegalThreadStateException otherwise
     *    
     * 5. What happens to daemon threads when the JVM exits?
     *    - They're abandoned abruptly without running finally blocks or releasing resources
     */
}
