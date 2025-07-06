package multiThreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>Interview Focus: Synchronization and Thread Pools in Java</b>
 * 
 * <p>This class demonstrates key synchronization concepts and thread pool usage,
 * which are common topics in Java technical interviews.</p>
 * 
 * <p><b>Key Concepts Covered:</b>
 * <ul>
 *   <li>Synchronized methods and blocks</li>
 *   <li>ReentrantLock and ReadWriteLock</li>
 *   <li>Volatile keyword and atomic variables</li>
 *   <li>Thread pools and ExecutorService</li>
 *   <li>Callable and Future</li>
 *   <li>Thread-safe collections</li>
 * </ul>
 */
public class SynchronizationAndThreadPoolsDemo {
    
    // Shared counter to demonstrate thread safety issues
    private static int unsafeCounter = 0;
    private static volatile int volatileCounter = 0;  // Volatile doesn't solve all thread-safety issues!
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    
    // Shared map to demonstrate concurrent collections
    private static Map<String, Integer> sharedMap = new HashMap<>();
    private static Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
    
    // Locks for explicit locking
    private static final Object lockObject = new Object();
    private static final Lock reentrantLock = new ReentrantLock();
    
    /**
     * <b>Interview Question:</b> What's the difference between synchronized methods and blocks?
     * <b>Answer:</b> 
     * - Synchronized method locks on the entire object (instance method) or class (static method)
     * - Synchronized block allows locking on any object and provides more fine-grained control
     * - Block is generally preferred as it reduces the scope of locking
     */
    public static synchronized void incrementSynchronizedMethod() {
        unsafeCounter++;
    }
    
    public static void incrementSynchronizedBlock() {
        synchronized (SynchronizationAndThreadPoolsDemo.class) {  // Class level lock
            unsafeCounter++;
        }
    }
    
    /**
     * <b>Interview Question:</b> What's the difference between volatile and synchronized?
     * <b>Answer:</b>
     * - volatile ensures visibility of changes across threads but doesn't provide atomicity
     * - synchronized provides both visibility and atomicity
     * - volatile is good for flags, but not for compound operations
     */
    public static void incrementVolatile() {
        volatileCounter++;  // Not thread-safe despite being volatile!
    }
    
    /**
     * <b>Interview Question:</b> What are atomic variables and when to use them?
     * <b>Answer:</b>
     * - Atomic classes (AtomicInteger, AtomicReference, etc.) provide thread-safe operations on single variables
     * - They use CAS (Compare-And-Swap) operations for better performance than synchronization
     * - Ideal for counters and simple shared state
     */
    public static void incrementAtomic() {
        atomicCounter.incrementAndGet();
    }
    
    /**
     * <b>Interview Question:</b> What's the difference between ReentrantLock and synchronized?
     * <b>Answer:</b>
     * - ReentrantLock provides the same behavior as synchronized but with more features:
     *   - Can check if lock is held (tryLock)
     *   - Can specify timeout when trying to acquire lock
     *   - Can be made fair (longest-waiting thread gets the lock)
     *   - Can be interrupted while waiting for lock
     */
    public static void incrementWithReentrantLock() {
        reentrantLock.lock();
        try {
            unsafeCounter++;
        } finally {
            reentrantLock.unlock();  // Always in finally to ensure unlock
        }
    }
    
    /**
     * <b>Interview Question:</b> What are thread pools and why use them?
     * <b>Answer:</b>
     * - Thread pools manage a pool of worker threads
     * - Benefits:
     *   - Reuse threads to avoid thread creation overhead
     *   - Control resource usage (limit number of concurrent threads)
     *   - Provide task queuing and scheduling
     */
    public static void demonstrateThreadPools() throws ExecutionException, InterruptedException {
        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        // Submit tasks using Runnable (no result)
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Submit tasks using Callable (with result)
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Calculating sum...");
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });
        
        // Get the result (blocks until done)
        System.out.println("Sum from 1 to 100 is: " + future.get());
        
        // Shutdown the executor
        executor.shutdown();
        
        // Wait for all tasks to complete or timeout after 5 seconds
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forcing shutdown...");
            executor.shutdownNow();
        }
    }
    
    /**
     * <b>Interview Question:</b> What's the difference between shutdown() and shutdownNow()?
     * <b>Answer:</b>
     * - shutdown(): Initiates an orderly shutdown where previously submitted tasks are executed,
     *               but no new tasks will be accepted
     * - shutdownNow(): Attempts to stop all actively executing tasks, halts the processing of
     *                 waiting tasks, and returns a list of the tasks that were awaiting execution
     */
    public static void demonstrateShutdown() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Submit some tasks
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started");
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " completed");
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " was interrupted");
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Shutdown the executor
        executor.shutdown();
        
        try {
            // Wait for tasks to complete, but no more than 2 seconds
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks completed, forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * <b>Interview Question:</b> What are the different types of thread pools in Java?
     * <b>Answer:</b>
     * 1. newFixedThreadPool(n): Fixed number of threads, shared unbounded queue
     * 2. newCachedThreadPool(): Creates threads as needed, reuses available threads
     * 3. newSingleThreadExecutor(): Single worker thread, tasks execute sequentially
     * 4. newScheduledThreadPool(n): For scheduling tasks to run after a delay or periodically
     * 5. newWorkStealingPool(): Work-stealing thread pool using all available processors
     */
    public static void demonstrateDifferentPools() {
        // Fixed thread pool
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        // Cached thread pool - creates new threads as needed, but reuses previously constructed threads
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        // Single thread executor - tasks execute sequentially
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        
        // Scheduled thread pool - for delayed or periodic tasks
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // Schedule a task to run after a delay
        scheduledPool.schedule(() -> 
            System.out.println("This task runs after 1 second"), 
            1, TimeUnit.SECONDS);
            
        // Schedule a task to run repeatedly
        scheduledPool.scheduleAtFixedRate(() -> 
            System.out.println("This task runs every 2 seconds"), 
            0, 2, TimeUnit.SECONDS);
            
        // Shutdown all executors when done
        fixedPool.shutdown();
        cachedPool.shutdown();
        singleThread.shutdown();
        scheduledPool.shutdown();
    }
    
    /**
     * <b>Interview Question:</b> What is ThreadLocal and when to use it?
     * <b>Answer:</b>
     * - ThreadLocal provides thread-local variables
     * - Each thread has its own, independently initialized copy of the variable
     * - Common uses:
     *   - Per-thread context (e.g., user sessions, transaction IDs)
     *   - Performance optimization for thread-unsafe classes (e.g., SimpleDateFormat)
     */
    private static final ThreadLocal<Random> threadLocalRandom = ThreadLocal.withInitial(Random::new);
    
    public static void demonstrateThreadLocal() {
        // Each thread gets its own Random instance
        System.out.println("Thread " + Thread.currentThread().getName() + 
                          " random: " + threadLocalRandom.get().nextInt(100));
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Synchronization and Thread Pools Demo ===\n");
        
        // Demonstrate thread safety issues and solutions
        System.out.println("=== Thread Safety Examples ===");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        // Submit tasks that increment counters in different ways
        for (int i = 0; i < 1000; i++) {
            executor.submit(SynchronizationAndThreadPoolsDemo::incrementSynchronizedMethod);
            executor.submit(SynchronizationAndThreadPoolsDemo::incrementVolatile);
            executor.submit(SynchronizationAndThreadPoolsDemo::incrementAtomic);
        }
        
        // Shutdown and wait for tasks to complete
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("\nCounter values after concurrent updates:");
        System.out.println("Synchronized counter: " + unsafeCounter);
        System.out.println("Volatile counter (not thread-safe): " + volatileCounter);
        System.out.println("Atomic counter: " + atomicCounter.get());
        
        // Demonstrate thread pools
        System.out.println("\n=== Thread Pool Examples ===");
        demonstrateThreadPools();
        
        // Demonstrate different types of thread pools
        System.out.println("\n=== Different Types of Thread Pools ===");
        demonstrateDifferentPools();
        
        // Demonstrate ThreadLocal
        System.out.println("\n=== ThreadLocal Example ===");
        for (int i = 0; i < 3; i++) {
            new Thread(SynchronizationAndThreadPoolsDemo::demonstrateThreadLocal).start();
        }
        
        System.out.println("\n=== All examples completed ===");
    }
}
