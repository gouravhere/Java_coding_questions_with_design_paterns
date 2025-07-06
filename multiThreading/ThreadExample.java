package multiThreading;

/**
 * <b>Interview Focus: Thread Creation in Java</b>
 * 
 * <p>This class demonstrates two fundamental ways to create threads in Java:
 * 1. By extending the Thread class
 * 2. By implementing the Runnable interface</p>
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>Thread lifecycle and states</li>
 *   <li>Thread creation approaches</li>
 *   <li>Thread priorities and scheduling</li>
 *   <li>Thread.join() for thread coordination</li>
 *   <li>Thread.yield() for thread scheduling hints</li>
 * </ul>
 *
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What's the difference between extending Thread and implementing Runnable?</li>
 *   <li>When would you use Thread.yield()?</li>
 *   <li>How does Thread.join() work?</li>
 *   <li>What are thread priorities and how do they affect execution?</li>
 *   <li>What's the difference between start() and run() methods?</li>
 * </ol>
 *
 * <p><b>Best Practices:</b>
 * <ul>
 *   <li>Prefer implementing Runnable over extending Thread (composition over inheritance)</li>
 *   <li>Use thread pools instead of creating threads directly for better resource management</li>
 *   <li>Always handle InterruptedException appropriately</li>
 *   <li>Be cautious with thread priorities as they are platform-dependent</li>
 * </ul>
 */

/**
 * Task1 demonstrates thread creation by extending the Thread class.
 * This approach is less flexible as Java doesn't support multiple inheritance.
 */
class Task1 extends Thread {
    /**
     * The run method contains the code that will be executed in the new thread.
     * It prints numbers from 0 to 10 (inclusive).
     * 
     * <p><b>Interview Note:</b> The JVM calls this method when the thread is started.
     * Never call run() directly; use start() to begin execution in a new thread.</p>
     */
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.print(i + " ");
            // Thread.yield() could be used here to hint the scheduler
        }
    }
}
/**
 * Task2 demonstrates thread creation by implementing the Runnable interface.
 * This is the preferred approach as it allows for better design flexibility.
 */
class Task2 implements Runnable {
    /**
     * The run method contains the code that will be executed in the new thread.
     * It prints numbers from 11 to 21 (inclusive).
     * 
     * <p><b>Interview Note:</b> Implementing Runnable is generally preferred because:
     * 1. It allows the class to extend another class
     * 2. It's more flexible for use with thread pools
     * 3. It separates the task from the thread execution</p>
     */
    @Override
    public void run() {
        for (int i = 11; i < 22; i++) {
            System.out.print(i + " ");
            // Thread.sleep(100) could be added for demonstration of timing issues
        }
    }
}
/**
 * This class demonstrates basic thread creation and management in Java.
 * It shows how to create and start threads using both approaches and
 * demonstrates thread priorities and coordination.
 */
public class ThreadExample {

    /**
     * Demonstrates thread creation, priorities, and basic thread coordination.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Creating threads by extending Thread class</li>
     *   <li>Creating threads by implementing Runnable</li>
     *   <li>Setting thread priorities</li>
     *   <li>Using join() for thread coordination</li>
     *   <li>Using yield() to suggest thread scheduling</li>
     * </ul>
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if any thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starting...");
        
        // Create and start first thread (extending Thread)
        Task1 thread1 = new Task1();
        thread1.setName("Task1-Thread");
        
        // Setting thread priority (1=min, 5=normal, 10=max)
        // Note: Priorities are just hints to the scheduler and may be ignored
        thread1.setPriority(Thread.MAX_PRIORITY);  // 10
        
        System.out.println("Starting Task1 thread...");
        thread1.start();
        
        // Uncomment to make main thread wait for thread1 to complete
        // thread1.join();
        
        // Create and start second thread (implementing Runnable)
        Task2 task2 = new Task2();
        Thread thread2 = new Thread(task2, "Task2-Thread");
        thread2.setPriority(Thread.NORM_PRIORITY);  // 5
        
        System.out.println("Starting Task2 thread...");
        thread2.start();
        
        // Demonstrate Thread.yield() - gives up CPU temporarily
        Thread.yield();
        
        // Main thread continues execution
        System.out.println("\nMain thread continuing execution...");
        
        // Wait for both threads to complete
        thread1.join();
        thread2.join();
        
        System.out.println("\nAll threads have completed execution.");
    }
    
    /**
     * <b>Interview Questions Addressed:</b>
     * 1. What's the difference between start() and run()?
     *    - start() creates a new thread and calls run() in that thread
     *    - run() executes in the current thread
     *    
     * 2. What does Thread.yield() do?
     *    - Suggests that the current thread is willing to yield its current use of a processor
     *    - The scheduler is free to ignore this hint
     *    
     * 3. What's the purpose of join()?
     *    - Waits for the thread to die before continuing execution
     *    - Useful for thread coordination
     *    
     * 4. How do thread priorities work?
     *    - Range from 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY)
     *    - Higher priority threads are more likely to be scheduled
     *    - Priorities are just hints and may be ignored by the JVM
     */
}
