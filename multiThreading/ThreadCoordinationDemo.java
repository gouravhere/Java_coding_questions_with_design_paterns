package multiThreading;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Interview Focus: Thread Coordination in Java</b>
 * 
 * <p>This class demonstrates various thread coordination mechanisms in Java,
 * which are commonly discussed in technical interviews.</p>
 * 
 * <p><b>Key Concepts Covered:</b>
 * <ul>
 *   <li>CountDownLatch - Wait for threads to complete before proceeding</li>
 *   <li>CyclicBarrier - Synchronize threads at a common point</li>
 *   <li>Phaser - Reusable barrier with dynamic parties</li>
 *   <li>Semaphore - Control access to a shared resource</li>
 *   <li>Exchanger - Exchange data between threads</li>
 *   <li>CompletableFuture - Asynchronous programming</li>
 * </ul>
 */
public class ThreadCoordinationDemo {
    
    /**
     * <b>Interview Question:</b> What is CountDownLatch and when would you use it?
     * <b>Answer:</b>
     * - A synchronization aid that allows one or more threads to wait until
     *   a set of operations being performed in other threads completes
     * - Use cases:
     *   - Wait for all services to start before processing requests
     *   - Wait for all players to be ready before starting a game
     */
    public static void demonstrateCountDownLatch() throws InterruptedException {
        System.out.println("\n=== CountDownLatch Example ===");
        final int THREAD_COUNT = 3;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(THREAD_COUNT);
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " waiting to start...");
                    startLatch.await(); // Wait for the start signal
                    
                    // Do some work
                    System.out.println("Thread " + threadId + " is working...");
                    Thread.sleep(1000);
                    
                    System.out.println("Thread " + threadId + " completed.");
                    doneLatch.countDown(); // Signal completion
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        
        // All threads are waiting, let them start
        System.out.println("Starting all threads...");
        startLatch.countDown();
        
        // Wait for all threads to complete
        doneLatch.await();
        System.out.println("All threads have completed their work.");
    }
    
    /**
     * <b>Interview Question:</b> What's the difference between CountDownLatch and CyclicBarrier?
     * <b>Answer:</b>
     * - CountDownLatch:
     *   - One-time use
     *   - Threads wait for a count to reach zero
     *   - Count is set at creation
     * - CyclicBarrier:
     *   - Can be reused
     *   - Threads wait for each other at a common barrier point
     *   - Can have a barrier action
     */
    public static void demonstrateCyclicBarrier() {
        System.out.println("\n=== CyclicBarrier Example ===");
        final int THREAD_COUNT = 3;
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> 
            System.out.println("All threads reached the barrier. Continuing..."));
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " working before barrier...");
                    Thread.sleep(1000 + new Random().nextInt(1000));
                    System.out.println("Thread " + threadId + " reached the barrier.");
                    
                    // Wait for all threads to reach this point
                    barrier.await();
                    
                    // Continue after all threads reach the barrier
                    System.out.println("Thread " + threadId + " continuing after barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
    
    /**
     * <b>Interview Question:</b> What is a Phaser and when would you use it?
     * <b>Answer:</b>
     * - A reusable synchronization barrier that supports dynamic parties
     * - More flexible than CyclicBarrier and CountDownLatch
     * - Use cases:
     *   - Complex multi-phase computations
     *   - When number of parties can change
     */
    public static void demonstratePhaser() {
        System.out.println("\n=== Phaser Example ===");
        Phaser phaser = new Phaser(1); // Register self (the main thread)
        
        // Create and start tasks
        for (int i = 0; i < 3; i++) {
            phaser.register(); // Register a new party for each task
            final int taskId = i;
            new Thread(() -> {
                System.out.println("Task " + taskId + " starting phase 1");
                phaser.arriveAndAwaitAdvance(); // Wait for all tasks to complete phase 1
                
                System.out.println("Task " + taskId + " starting phase 2");
                phaser.arriveAndDeregister(); // Complete and deregister
            }).start();
        }
        
        // Allow threads to proceed and wait for them to complete
        phaser.arriveAndDeregister();
    }
    
    /**
     * <b>Interview Question:</b> What is a Semaphore and how does it work?
     * <b>Answer:</b>
     * - A counting semaphore that controls access to a shared resource
     * - Maintains a set of permits that threads can acquire and release
     * - Can be used for:
     *   - Resource pooling
     *   - Throttling
     *   - Implementing bounded collections
     */
    public static void demonstrateSemaphore() throws InterruptedException {
        System.out.println("\n=== Semaphore Example ===");
        final int PERMITS = 2; // Only 2 threads can access the resource at a time
        Semaphore semaphore = new Semaphore(PERMITS);
        
        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " trying to acquire permit");
                    semaphore.acquire();
                    System.out.println("Thread " + threadId + " acquired permit");
                    
                    // Simulate work
                    Thread.sleep(2000);
                    
                    System.out.println("Thread " + threadId + " releasing permit");
                    semaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
            
            // Stagger thread creation
            Thread.sleep(300);
        }
    }
    
    /**
     * <b>Interview Question:</b> What is an Exchanger and when would you use it?
     * <b>Answer:</b>
     * - A synchronization point where threads can exchange objects
     * - Each thread presents an object on entry and receives its partner's object on exit
     * - Use cases:
     *   - Producer-consumer patterns
     *   - Pipeline processing
     */
    public static void demonstrateExchanger() {
        System.out.println("\n=== Exchanger Example ===");
        Exchanger<String> exchanger = new Exchanger<>();
        
        // Producer thread
        new Thread(() -> {
            try {
                String data = "Data from producer";
                System.out.println("Producer sending: " + data);
                String response = exchanger.exchange(data);
                System.out.println("Producer received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate work
                String data = "Data from consumer";
                System.out.println("Consumer sending: " + data);
                String response = exchanger.exchange(data);
                System.out.println("Consumer received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    
    /**
     * <b>Interview Question:</b> What is CompletableFuture and how is it different from Future?
     * <b>Answer:</b>
     * - CompletableFuture is an enhanced Future that supports:
     *   - Chaining of async operations
     *   - Combining multiple futures
     *   - Exception handling
     *   - Manual completion
     * - Unlike Future, it provides non-blocking operations and better composition
     */
    public static void demonstrateCompletableFuture() {
        System.out.println("\n=== CompletableFuture Example ===");
        
        // Simple async operation
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Running async computation...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 42;
        }).thenAccept(result -> 
            System.out.println("Async result: " + result)
        );
        
        // Combine multiple futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        
        future1.thenCombine(future2, (a, b) -> a + b)
              .thenAccept(sum -> System.out.println("Sum of futures: " + sum));
        
        // Handle exceptions
        CompletableFuture.supplyAsync(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred: " + ex.getMessage());
                return "Recovery value";
            }
            return result;
        }).thenAccept(System.out::println);
        
        // Wait for all operations to complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Thread Coordination Demo ===\n");
        
        // Run each demonstration
        demonstrateCountDownLatch();
        demonstrateCyclicBarrier();
        demonstratePhaser();
        demonstrateSemaphore();
        demonstrateExchanger();
        demonstrateCompletableFuture();
        
        System.out.println("\n=== All demonstrations completed ===");
    }
}
