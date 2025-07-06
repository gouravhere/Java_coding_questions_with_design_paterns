package multiThreading;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <b>Interview Focus: Callable, Future, and ExecutorService</b>
 * 
 * <p>This class demonstrates the use of Callable and Future interfaces along with ExecutorService
 * for concurrent task execution with return values, a key concept in Java concurrency.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Callable vs Runnable interfaces</li>
 *   <li>Future for asynchronous computation results</li>
 *   <li>ExecutorService for thread pool management</li>
 *   <li>invokeAny() and invokeAll() methods</li>
 *   <li>Graceful shutdown of ExecutorService</li>
 *   <li>Exception handling in concurrent tasks</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What's the difference between Callable and Runnable?</li>
 *   <li>How does Future.get() work and what are its blocking characteristics?</li>
 *   <li>What's the difference between submit() and execute() methods?</li>
 *   <li>How do you handle timeouts with Future.get()?</li>
 *   <li>What's the difference between shutdown() and shutdownNow()?</li>
 * </ol>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Always shutdown ExecutorService when done</li>
 *   <li>Use try-with-resources for ExecutorService when possible</li>
 *   <li>Handle InterruptedException appropriately</li>
 *   <li>Consider timeouts for Future.get() to avoid indefinite blocking</li>
 *   <li>Use appropriate thread pool size</li>
 * </ul>

/**
 * A simple Callable task that returns a greeting message after a delay.
 * This demonstrates how to create tasks that return results and can throw exceptions.
 * 
 * <p><b>Key Points:</b>
 * <ul>
 *   <li>Implements Callable&lt;String&gt; to return a String result</li>
 *   <li>Can throw checked exceptions (unlike Runnable)</li>
 *   <li>Used with ExecutorService for asynchronous execution</li>
 *   <li>Results are retrieved via Future object</li>
 * </ul>
 */
class CallableTask implements Callable<String> {
    private final String name;
    
    /**
     * Creates a new CallableTask with the specified name.
     * 
     * @param name the name to include in the greeting message
     */
    public CallableTask(String name) {
        this.name = name;
    }

    /**
     * Computes a greeting message after a simulated delay.
     * 
     * @return A greeting message that includes the provided name
     * @throws InterruptedException if the thread is interrupted while sleeping
     * 
     * <p><b>Interview Note:</b> This method can throw checked exceptions,
     * which will be wrapped in an ExecutionException when retrieved via Future.get()
     */
    @Override
    public String call() throws InterruptedException {
        // Simulate some processing time
        Thread.sleep(1000);
        
        // Simulate a potential error condition
        if ("error".equals(name)) {
            throw new IllegalStateException("Simulated error for name: " + name);
        }
        
        return "Hello " + name;
    }
}


/**
 * This class demonstrates various ways to use Callable and Future with ExecutorService
 * for concurrent task execution with return values.
 */
public class CallableRunner {

    /**
     * Demonstrates different ways to use ExecutorService with Callable tasks.
     * 
     * <p><b>Key Features Demonstrated:</b>
     * <ul>
     *   <li>Submitting a single Callable task and getting a Future</li>
     *   <li>Using Future.get() with timeout</li>
     *   <li>Handling exceptions from Callable tasks</li>
     *   <li>Using invokeAny() to get the first completed task's result</li>
     *   <li>Using invokeAll() to execute multiple tasks</li>
     *   <li>Graceful shutdown of ExecutorService</li>
     * </ul>
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the current thread is interrupted while waiting
     * @throws ExecutionException if a computation threw an exception
     */
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        // Note: In real applications, prefer using ThreadPoolExecutor for more control
        ExecutorService executorService = null;
        
        try {
            executorService = Executors.newFixedThreadPool(3);
            
            // Example 1: Submit a single task and get its Future
            System.out.println("=== Example 1: Single Task Submission ===");
            Future<String> future = executorService.submit(new CallableTask("Single Task"));
            
            try {
                // Get the result, waiting if necessary with a timeout
                String result = future.get(2, TimeUnit.SECONDS);
                System.out.println("Task result: " + result);
            } catch (TimeoutException e) {
                System.err.println("Task timed out");
                // Cancel the task if it times out
                future.cancel(true);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Example 2: Handle exceptions from Callable
            System.out.println("\n=== Example 2: Exception Handling ===");
            Future<String> failedFuture = executorService.submit(new CallableTask("error"));
            try {
                // This will throw ExecutionException because the task throws an exception
                System.out.println(failedFuture.get());
            } catch (ExecutionException e) {
                System.err.println("Task failed with: " + e.getCause().getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Example 3: Using invokeAny() - gets the first completed task's result
            System.out.println("\n=== Example 3: invokeAny() ===");
            List<CallableTask> tasks = List.of(
                new CallableTask("First"),
                new CallableTask("Second"),
                new CallableTask("Third")
            );
            
            try {
                String firstResult = executorService.invokeAny(tasks);
                System.out.println("First completed task result: " + firstResult);
            } catch (ExecutionException e) {
                System.err.println("All tasks failed: " + e.getCause().getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Example 4: Using invokeAll() - gets results of all tasks
            System.out.println("\n=== Example 4: invokeAll() ===");
            try {
                var futures = executorService.invokeAll(tasks, 2, TimeUnit.SECONDS);
                for (var f : futures) {
                    try {
                        if (f.isDone() && !f.isCancelled()) {
                            System.out.println("Task result: " + f.get());
                        } else {
                            System.out.println("Task was cancelled or didn't complete in time");
                        }
                    } catch (ExecutionException e) {
                        System.err.println("Task failed: " + e.getCause().getMessage());
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted while waiting for tasks to complete");
            }
            
        } finally {
            // Always shutdown the executor service when done
            if (executorService != null) {
                System.out.println("\nShutting down executor service...");
                // Initiate orderly shutdown
                executorService.shutdown();
                
                try {
                    // Wait a while for existing tasks to terminate
                    if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                        // Cancel currently executing tasks
                        executorService.shutdownNow();
                        // Wait a while for tasks to respond to being cancelled
                        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                            System.err.println("Executor service did not terminate");
                        }
                    }
                } catch (InterruptedException e) {
                    // (Re-)Cancel if current thread also interrupted
                    executorService.shutdownNow();
                    // Preserve interrupt status
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    /**
     * <b>Interview Questions Addressed:</b>
     * 1. What's the difference between Callable and Runnable?
     *    - Callable can return a result and throw checked exceptions
     *    - Runnable's run() returns void and can't throw checked exceptions
     *    
     * 2. What happens if you call Future.get() on a task that threw an exception?
     *    - It throws an ExecutionException wrapping the original exception
     *    
     * 3. What's the difference between shutdown() and shutdownNow()?
     *    - shutdown() initiates an orderly shutdown, shutdownNow() tries to stop all executing tasks
     *    
     * 4. How do you handle timeouts with Future.get()?
     *    - Use the overloaded get(long timeout, TimeUnit unit) method
     *    
     * 5. What's the difference between submit() and execute()?
     *    - submit() returns a Future and can accept Callable or Runnable
     *    - execute() doesn't return a result and only accepts Runnable
     */
}
