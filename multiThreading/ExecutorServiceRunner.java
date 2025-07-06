package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <b>Interview Focus: ExecutorService and Thread Pools</b>
 * 
 * <p>This class demonstrates the use of ExecutorService for managing thread pools and executing
 * tasks asynchronously, which is a fundamental concept in Java concurrency.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Thread pool management with ExecutorService</li>
 *   <li>Difference between newFixedThreadPool and newSingleThreadExecutor</li>
 *   <li>Task submission using execute() and submit()</li>
 *   <li>Graceful shutdown of ExecutorService</li>
 *   <li>Thread pool sizing considerations</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What's the difference between newFixedThreadPool and newCachedThreadPool?</li>
 *   <li>When would you use newSingleThreadExecutor vs newFixedThreadPool(1)?</li>
 *   <li>What's the difference between execute() and submit() methods?</li>
 *   <li>How do you properly shut down an ExecutorService?</li>
 *   <li>What are the common thread pool implementations in Java?</li>
 * </ol>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Always shutdown ExecutorService when done to prevent resource leaks</li>
 *   <li>Consider using try-with-resources for ExecutorService (Java 19+)</li>
 *   <li>Choose appropriate thread pool size based on task characteristics</li>
 *   <li>Handle uncaught exceptions in tasks</li>
 *   <li>Consider using ThreadFactory for custom thread creation</li>
 * </ul>
 */
public class ExecutorServiceRunner {

    /**
     * Demonstrates different ways to use ExecutorService for task execution.
     * 
     * <p><b>Key Features Demonstrated:</b>
     * <ul>
     *   <li>Creating different types of thread pools</li>
     *   <li>Submitting tasks for execution</li>
     *   <li>Graceful shutdown of thread pools</li>
     *   <li>Handling task execution results</li>
     * </ul>
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the current thread is interrupted while waiting
     */
    public static void main(String[] args) {
        // Example 1: Single-threaded executor
        System.out.println("=== Example 1: Single-threaded Executor ===");
        executeWithExecutor(Executors.newSingleThreadExecutor());
        
        // Example 2: Fixed thread pool with 2 threads
        System.out.println("\n=== Example 2: Fixed Thread Pool (2 threads) ===");
        executeWithExecutor(Executors.newFixedThreadPool(2));
        
        // Example 3: Cached thread pool
        System.out.println("\n=== Example 3: Cached Thread Pool ===");
        executeWithExecutor(Executors.newCachedThreadPool());
    }
    
    /**
     * Demonstrates task execution using the provided ExecutorService.
     * 
     * @param executorService the ExecutorService to use for task execution
     */
    private static void executeWithExecutor(ExecutorService executorService) {
        try {
            // Submit multiple tasks for execution
            System.out.println("Submitting tasks...");
            
            // Using execute() for fire-and-forget tasks
            executorService.execute(new Task1());
            
            // Using submit() when you need a Future to track completion
            // Note: submit() can take both Runnable and Callable
            executorService.submit(new Task2());
            
            // Submit a lambda expression as a task
            executorService.submit(() -> {
                System.out.println("Task 3 executed by " + Thread.currentThread().getName());
            });
            
            // Submit a task with a result
            var future = executorService.submit(() -> {
                Thread.sleep(500);
                return "Result from Task 4";
            });
            
            // Process the result when it's available
            try {
                String result = future.get(1, TimeUnit.SECONDS);
                System.out.println("Task 4 result: " + result);
            } catch (Exception e) {
                System.err.println("Error getting task result: " + e.getMessage());
            }
            
        } finally {
            // Always shutdown the executor service when done
            shutdownExecutor(executorService);
        }
    }
    
    /**
     * Shuts down the ExecutorService gracefully.
     * 
     * @param executorService the ExecutorService to shut down
     */
    private static void shutdownExecutor(ExecutorService executorService) {
        // Initiate graceful shutdown
        executorService.shutdown();
        
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks
                System.out.println("Forcing shutdown...");
                executorService.shutdownNow();
                
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * <b>Interview Questions Addressed:</b>
     * 1. What's the difference between newFixedThreadPool and newCachedThreadPool?
     *    - Fixed: Fixed number of threads, queue for pending tasks
     *    - Cached: Creates new threads as needed, reuses available threads
     *    
     * 2. When would you use newSingleThreadExecutor vs newFixedThreadPool(1)?
     *    - newSingleThreadExecutor() has an unconfigurable wrapper with different behavior
     *    - newFixedThreadPool(1) is more flexible for future modifications
     *    
     * 3. What's the difference between execute() and submit() methods?
     *    - execute() is from Executor interface, doesn't return a result
     *    - submit() returns a Future and can handle both Runnable and Callable
     *    
     * 4. How do you properly shut down an ExecutorService?
     *    - Call shutdown() first, then awaitTermination(), then shutdownNow() if needed
     *    
     * 5. What are the common thread pool implementations in Java?
     *    - FixedThreadPool, CachedThreadPool, ScheduledThreadPool, WorkStealingPool
     */
}
