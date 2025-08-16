package multiThreading;

/**
 * <b>Java Multithreading Interview Guide</b>
 * 
 * <p>This file serves as a comprehensive guide to Java multithreading concepts
 * commonly tested in technical interviews. It provides a structured overview
 * with key points and references to detailed examples in other files.</p>
 * 
 * <p><b>Table of Contents:</b>
 * 1. Thread Basics
 * 2. Synchronization
 * 3. Thread Pools & Executors
 * 4. Thread Coordination
 * 5. Concurrent Collections
 * 6. Advanced Topics
 * 7. Common Interview Questions
 */
public class MultithreadingInterviewGuide {
    
    /**new
     * <b>1. Thread Basics</b>
     * 
     * <p><b>Key Concepts:</b>
     * - Thread lifecycle (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED)
     * - Creating threads (extending Thread vs implementing Runnable)
     * - Daemon vs non-daemon threads
     * - Thread priorities
     * 
     * <p><b>See Also:</b>
     * - {@link ThreadExample}
     * - {@link multiThreading.daemon.DaemonDemo}
     */
    public static class ThreadBasics {}
    
    /**
     * <b>2. Synchronization</b>
     * 
     * <p><b>Key Concepts:</b>
     * - Synchronized methods and blocks
     * - Object vs Class level locking
     * - Volatile keyword
     * - Atomic variables
     * - ReentrantLock and ReadWriteLock
     * 
     * <p><b>Common Interview Questions:</b>
     * - What is the difference between synchronized method and block?
     * - What is the volatile keyword and when would you use it?
     * - What is the difference between ReentrantLock and synchronized?
     * 
     * <p><b>See Also:</b>
     * - {@link SynchronizationAndThreadPoolsDemo}
     */
    public static class Synchronization {}
    
    /**
     * <b>3. Thread Pools & Executors</b>
     * 
     * <p><b>Key Concepts:</b>
     * - Executor framework
     * - ThreadPoolExecutor
     * - ScheduledThreadPoolExecutor
     * - Callable and Future
     * - CompletableFuture
     * 
     * <p><b>Common Interview Questions:</b>
     * - What are the different types of thread pools in Java?
     * - What's the difference between submit() and execute()?
     * - How does ThreadPoolExecutor work internally?
     * 
     * <p><b>See Also:</b>
     * - {@link ExecutorServiceRunner}
     * - {@link CallableRunner}
     * - {@link ThreadCoordinationDemo#demonstrateCompletableFuture()}
     */
    public static class ThreadPools {}
    
    /**
     * <b>4. Thread Coordination</b>
     * 
     * <p><b>Key Concepts:</b>
     * - wait(), notify(), notifyAll()
     * - CountDownLatch
     * - CyclicBarrier
     * - Phaser
     * - Semaphore
     * - Exchanger
     * 
     * <p><b>Common Interview Questions:</b>
     * - What's the difference between CountDownLatch and CyclicBarrier?
     * - What is a Phaser and when would you use it?
     * - How does Semaphore work?
     * 
     * <p><b>See Also:</b>
     * - {@link ThreadCoordinationDemo}
     */
    public static class ThreadCoordination {}
    
    /**
     * <b>5. Concurrent Collections</b>
     * 
     * <p><b>Key Concepts:</b>
     * - ConcurrentHashMap
     * - CopyOnWriteArrayList/Set
     * - BlockingQueue implementations
     * - ConcurrentLinkedQueue/Deque
     * - ConcurrentSkipListMap/Set
     * 
     * <p><b>Common Interview Questions:</b>
     * - What's the difference between ConcurrentHashMap and Collections.synchronizedMap?
     * - When would you use CopyOnWriteArrayList?
     * - What are the different BlockingQueue implementations?
     * 
     * <p><b>See Also:</b>
     * - {@link ConcurrentCollectionsDemo}
     */
    public static class ConcurrentCollections {}
    
    /**
     * <b>6. Advanced Topics</b>
     * 
     * <p><b>Key Concepts:</b>
     * - Java Memory Model
     * - Happens-before relationship
     * - ThreadLocal
     * - Fork/Join Framework
     * - CompletableFuture
     * - Thread Dump Analysis
     * 
     * <p><b>Common Interview Questions:</b>
     * - What is the Java Memory Model?
     * - What is the happens-before relationship?
     * - How does ThreadLocal work internally?
     */
    public static class AdvancedTopics {}
    
    /**
     * <b>7. Common Interview Questions</b>
     * 
     * <p><b>Basic Level:</b>
     * 1. What is the difference between process and thread?
     * 2. What are the different ways to create a thread?
     * 3. What is the difference between start() and run() methods?
     * 
     * <p><b>Intermediate Level:</b>
     * 1. What is thread starvation and how to prevent it?
     * 2. What is thread contention?
     * 3. What is a deadlock and how to prevent it?
     * 
     * <p><b>Advanced Level:</b>
     * 1. How does ConcurrentHashMap achieve thread-safety?
     * 2. What is false sharing and how to avoid it?
     * 3. How would you design a thread-safe cache?
     * 
     * <p><b>Practical Problems:</b>
     * 1. Implement a thread-safe singleton
     * 2. Implement a producer-consumer pattern
     * 3. Implement a thread pool from scratch
     */
    public static class InterviewQuestions {}
    
    /**
     * <b>8. Best Practices</b>
     * 
     * <p><b>Do's:</b>
     * - Use higher-level concurrency utilities from java.util.concurrent
     * - Prefer concurrent collections over synchronized wrappers
     * - Always use proper exception handling in threads
     * - Use thread pools instead of creating new threads directly
     * - Document thread-safety guarantees
     * 
     * <p><b>Don'ts:</b>
     * - Don't use Thread.stop()
     * - Avoid excessive synchronization
     * - Don't synchronize on non-final objects
     * - Avoid deadlocks by acquiring locks in a consistent order
     * 
     * <p><b>Performance Tips:</b>
     * - Use the right granularity of locking
     - Consider lock striping for high-contention scenarios
     * - Use concurrent collections for high-concurrency scenarios
     * - Consider using non-blocking algorithms when possible
     */
    public static class BestPractices {}
    
    /**
     * <b>9. Common Pitfalls</b>
     * 
     * <p><b>1. Race Conditions:</b>
     * - Symptoms: Inconsistent results in concurrent execution
     * - Solution: Proper synchronization or atomic variables
     * 
     * <p><b>2. Deadlocks:</b>
     * - Symptoms: Threads stuck waiting for each other
     * - Solution: Lock ordering, timeouts, or deadlock detection
     * 
     * <p><b>3. Thread Leaks:</b>
     * - Symptoms: Increasing number of threads over time
     * - Solution: Proper thread pool management
     * 
     * <p><b>4. Memory Consistency Errors:</b>
     * - Symptoms: Inconsistent view of shared data
     * - Solution: Proper use of volatile, final, or synchronization
     */
    public static class CommonPitfalls {}
    
    public static void main(String[] args) {
        System.out.println("Java Multithreading Interview Guide");
        System.out.println("==================================");
        System.out.println("This file serves as a reference guide for Java multithreading interview preparation.");
        System.out.println("Explore the nested classes for detailed information on each topic.");
        System.out.println("Run individual demo files for practical examples.");
    }
}
