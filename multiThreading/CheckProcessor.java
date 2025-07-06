package multiThreading;

import java.util.concurrent.TimeUnit;

/**
 * <b>Interview Focus: Thread Interruption and Daemon Threads</b>
 * 
 * <p>This class demonstrates proper thread interruption handling and the use of daemon threads
 * in Java, which are essential concepts for writing robust concurrent applications.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Thread interruption mechanism</li>
 *   <li>Daemon vs non-daemon threads</li>
 *   <li>Proper cleanup in thread termination</li>
 *   <li>Handling InterruptedException</li>
 *   <li>Thread state management</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What's the difference between daemon and non-daemon threads?</li>
 *   <li>How does thread interruption work in Java?</li>
 *   <li>What's the proper way to stop a thread?</li>
 *   <li>How do you handle InterruptedException?</li>
 *   <li>What's the difference between interrupted() and isInterrupted()?</li>
 * </ol>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Always check thread interruption status in long-running tasks</li>
 *   <li>Clean up resources in finally blocks</li>
 *   <li>Restore the interrupt status when catching InterruptedException</li>
 *   <li>Use daemon threads for background tasks that shouldn't prevent JVM shutdown</li>
 *   <li>Document thread-safety of your classes</li>
 * </ul>
 */
public class CheckProcessor implements Runnable {
    private volatile boolean running = true;
    private final String processorName;

    /**
     * Creates a new CheckProcessor with default name.
     */
    public CheckProcessor() {
        this("CheckProcessor-" + System.currentTimeMillis() % 1000);
    }

    /**
     * Creates a new CheckProcessor with the specified name.
     *
     * @param name the name of the processor (used for logging)
     */
    public CheckProcessor(String name) {
        this.processorName = name;
    }

    /**
     * The main processing loop that runs in a separate thread.
     * This method demonstrates proper handling of thread interruption
     * and cleanup of resources.
     */
    @Override
    public void run() {
        System.out.println(processorName + " started. Thread: " + Thread.currentThread().getName());
        
        try {
            while (running && !Thread.currentThread().isInterrupted()) {
                try {
                    // Simulate some work
                    processCheck();
                    
                    // Check for interruption periodically
                    if (Thread.interrupted()) {
                        throw new InterruptedException("Thread was interrupted");
                    }
                    
                    // Alternative way using sleep that throws InterruptedException
                    TimeUnit.MILLISECONDS.sleep(500);
                    
                } catch (InterruptedException e) {
                    System.out.println(processorName + " was interrupted during sleep");
                    // Restore the interrupted status
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } finally {
            // Cleanup resources
            cleanup();
            System.out.println(processorName + " is shutting down");
        }
    }
    
    /**
     * Simulates processing a check.
     * 
     * @throws InterruptedException if the thread is interrupted during processing
     */
    private void processCheck() throws InterruptedException {
        // Simulate CPU-intensive work
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += i;
            
            // Check for interruption in CPU-bound loops
            if (Thread.interrupted()) {
                throw new InterruptedException("Processing was interrupted");
            }
        }
        System.out.println(processorName + " processed check with result: " + result);
    }
    
    /**
     * Performs cleanup when the processor is shutting down.
     */
    private void cleanup() {
        // Release any resources here
        System.out.println(processorName + " cleaning up resources...");
    }
    
    /**
     * Requests the processor to stop gracefully.
     */
    public void stopProcessing() {
        running = false;
    }

    /**
     * Demonstrates different ways to create and manage threads with interruption handling.
     * 
     * @param args command line arguments (not used)
     * @throws InterruptedException if the main thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Interruption Demo ===");
        
        // Example 1: Basic thread with interruption
        System.out.println("\n--- Example 1: Basic Thread ---");
        Thread worker = new Thread(new CheckProcessor("Worker-1"));
        worker.start();
        
        // Let it run for a while
        Thread.sleep(2000);
        
        // Interrupt the thread
        System.out.println("Interrupting worker thread...");
        worker.interrupt();
        worker.join(1000); // Wait for the thread to finish
        
        // Example 2: Daemon thread
        System.out.println("\n--- Example 2: Daemon Thread ---");
        Thread daemon = new Thread(new CheckProcessor("Daemon-1"));
        daemon.setDaemon(true); // Mark as daemon thread
        daemon.start();
        
        // Daemon threads don't prevent JVM from exiting
        System.out.println("Main thread exiting. Daemon thread will be terminated.");
        
        // Example 3: Using a flag for graceful shutdown
        System.out.println("\n--- Example 3: Graceful Shutdown ---");
        CheckProcessor processor = new CheckProcessor("Processor-1");
        Thread processorThread = new Thread(processor);
        processorThread.start();
        
        // Let it run for a while
        Thread.sleep(1500);
        
        // Graceful shutdown
        System.out.println("Requesting processor to stop...");
        processor.stopProcessing();
        processorThread.join();
        
        System.out.println("\n=== Demo Complete ===");
    }
    
    /**
     * <b>Interview Questions Addressed:</b>
     * 1. What's the difference between daemon and non-daemon threads?
     *    - Daemon threads don't prevent JVM from exiting when all non-daemon threads complete
     *    
     * 2. How does thread interruption work in Java?
     *    - Interruption is a cooperative mechanism, not preemptive
     *    - Requires the thread to check its interruption status
     *    
     * 3. What's the proper way to stop a thread?
     *    - Use a volatile boolean flag or interruption
     *    - Clean up resources in finally blocks
     *    
     * 4. How do you handle InterruptedException?
     *    - Either rethrow it or restore the interrupt status
     *    - Don't swallow it without proper handling
     *    
     * 5. What's the difference between interrupted() and isInterrupted()?
     *    - interrupted() clears the interrupt status
     *    - isInterrupted() doesn't change the interrupt status
     */
}
