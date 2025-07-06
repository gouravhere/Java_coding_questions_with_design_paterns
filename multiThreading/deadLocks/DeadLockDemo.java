package multiThreading.deadLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>Interview Focus: Deadlocks in Java</b>
 * 
 * <p>This class demonstrates a classic deadlock scenario in Java and provides
 * solutions to prevent and detect deadlocks.</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>What is a deadlock and how it occurs</li>
 *   <li>Four necessary conditions for deadlock (Coffman conditions)</li>
 *   <li>Deadlock prevention strategies</li>
 *   <li>Deadlock detection and recovery</li>
 *   <li>Using java.util.concurrent.locks for better lock management</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What is a deadlock and how can you prevent it?</li>
 *   <li>What are the four necessary conditions for a deadlock?</li>
 *   <li>How would you detect and recover from a deadlock?</li>
 *   <li>What's the difference between deadlock, livelock, and starvation?</li>
 *   <li>How can you avoid deadlocks when acquiring multiple locks?</li>
 * </ol>
 */
public class DeadLockDemo implements Runnable {
    private static final FirstResource firstResource = new FirstResource();
    private static final SecondResource secondResource = new SecondResource();
    
    // Using ReentrantLock for better lock management
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public DeadLockDemo() {
        // Start a new thread that will cause a deadlock
        new Thread(this, "Deadlock-Thread").start();
        
        // In the main thread, acquire locks in reverse order (potential deadlock)
        System.out.println("Main thread attempting to acquire locks...");
        secondResource.method1(firstResource); // This will cause a deadlock
    }
    
    public static void main(String[] args) {
        System.out.println("=== Deadlock Demonstration ===\n");
        
        // Uncomment to run the deadlock example
        // new DeadLockDemo();
        
        // Run the deadlock-free version
        System.out.println("\n=== Deadlock-Free Solution ===");
        new DeadLockFreeSolution();
    }

    @Override
    public void run() {
        System.out.println("Second thread attempting to acquire locks...");
        firstResource.method1(secondResource);
    }
    
    /**
     * <b>Deadlock-Free Solution</b>
     * 
     * <p>This inner class demonstrates how to prevent deadlocks by:
     * 1. Acquiring locks in a consistent global order
     * 2. Using tryLock() with timeout
     * 3. Properly releasing locks in finally blocks</p>
     */
    private static class DeadLockFreeSolution {
        public DeadLockFreeSolution() {
            // Start a new thread with deadlock prevention
            new Thread(() -> processWithDeadlockPrevention("Thread-1", firstResource, secondResource), 
                      "Deadlock-Free-Thread").start();
            
            // Main thread with deadlock prevention
            processWithDeadlockPrevention("Main-Thread", secondResource, firstResource);
        }
        
        private void processWithDeadlockPrevention(String threadName, Resource first, Resource second) {
            boolean acquiredFirst = false;
            boolean acquiredSecond = false;
            
            try {
                // Try to acquire first lock with timeout
                System.out.printf("%s: Attempting to acquire first lock...%n", threadName);
                acquiredFirst = lock1.tryLock(1, TimeUnit.SECONDS);
                
                if (acquiredFirst) {
                    System.out.printf("%s: Acquired first lock.%n", threadName);
                    
                    // Simulate some work
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    
                    // Try to acquire second lock with timeout
                    System.out.printf("%s: Attempting to acquire second lock...%n", threadName);
                    acquiredSecond = lock2.tryLock(1, TimeUnit.SECONDS);
                    
                    if (acquiredSecond) {
                        System.out.printf("%s: Acquired second lock. Doing work...%n", threadName);
                        // Critical section
                        first.access(second);
                    } else {
                        System.out.printf("%s: Could not acquire second lock. Giving up...%n", threadName);
                    }
                } else {
                    System.out.printf("%s: Could not acquire first lock. Giving up...%n", threadName);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s: Thread was interrupted.%n", threadName);
            } finally {
                // Release locks in reverse order of acquisition
                if (acquiredSecond) {
                    System.out.printf("%s: Releasing second lock.%n", threadName);
                    lock2.unlock();
                }
                if (acquiredFirst) {
                    System.out.printf("%s: Releasing first lock.%n", threadName);
                    lock1.unlock();
                }
            }
        }
    }
    
    /**
     * <b>Deadlock Prevention Strategies:</b>
     * 1. <b>Lock Ordering:</b> Always acquire locks in a consistent global order
     * 2. <b>Lock Timeout:</b> Use tryLock() with timeout to avoid indefinite waiting
     * 3. <b>Deadlock Detection:</b> Periodically check for deadlocks using ThreadMXBean
     * 4. <b>Resource Hierarchy:</b> Define a strict order for acquiring resources
     * 5. <b>Lock Striping:</b> Use concurrent collections that employ lock striping
     * 
     * <b>Deadlock Detection Example:</b>
     * <pre>
     * ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
     * long[] threadIds = threadMXBean.findDeadlockedThreads();
     * if (threadIds != null) {
     *     System.out.println("Deadlock detected!");
     *     // Handle deadlock (e.g., log, alert, or recover)
     * }
     * </pre>
     */
}

/**
 * Common interface for resources to demonstrate deadlock prevention
 */
interface Resource {
    void access(Resource other);
}
