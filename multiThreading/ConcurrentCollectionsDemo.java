package multiThreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>Interview Focus: Concurrent Collections in Java</b>
 * 
 * <p>This class demonstrates thread-safe collections in Java, their performance characteristics,
 * and common use cases in concurrent programming.</p>
 * 
 * <p><b>Key Concepts Covered:</b>
 * <ul>
 *   <li>ConcurrentHashMap vs Collections.synchronizedMap</li>
 *   <li>CopyOnWriteArrayList vs Collections.synchronizedList</li>
 *   <li>BlockingQueue implementations (ArrayBlockingQueue, LinkedBlockingQueue)</li>
 *   <li>ConcurrentLinkedQueue and ConcurrentLinkedDeque</n>
 *   <li>ConcurrentSkipListMap and ConcurrentSkipListSet</li>
 *   <li>Performance comparison of different concurrent collections</li>
 * </ul>
 */
public class ConcurrentCollectionsDemo {
    private static final int THREAD_COUNT = 10;
    private static final int OPERATIONS_PER_THREAD = 10000;
    
    /**
     * <b>Interview Question:</b> What's the difference between ConcurrentHashMap and Collections.synchronizedMap?
     * <b>Answer:</b>
     * - ConcurrentHashMap:
     *   - Thread-safe without locking the entire table
     *   - Uses lock striping (multiple locks for different segments)
     *   - Higher throughput for concurrent access
     *   - Doesn't throw ConcurrentModificationException
     * - Collections.synchronizedMap:
     *   - Wraps a HashMap with synchronized methods
     *   - Locks the entire map for each operation
     *   - Better for infrequent writes and frequent reads
     *   - Throws ConcurrentModificationException during iteration if modified
     */
    public static void demonstrateConcurrentMaps() throws InterruptedException {
        System.out.println("\n=== ConcurrentHashMap vs synchronizedMap ===");
        
        // ConcurrentHashMap - thread-safe with high concurrency
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        testMapPerformance(concurrentMap, "ConcurrentHashMap");
        
        // Synchronized wrapper - thread-safe but with global lock
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        testMapPerformance(synchronizedMap, "Synchronized HashMap");
        
        // Hashtable - legacy thread-safe map
        Map<String, Integer> hashtable = new Hashtable<>();
        testMapPerformance(hashtable, "Hashtable");
    }
    
    private static void testMapPerformance(Map<String, Integer> map, String mapName) throws InterruptedException {
        System.out.println("\nTesting performance of: " + mapName);
        long startTime = System.currentTimeMillis();
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        String key = "key-" + threadId + "-" + j;
                        map.put(key, j);
                        map.get(key);
                        if (j % 1000 == 0) {
                            map.size(); // Some read operations
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("%s: %d operations in %d ms%n", 
                         mapName, 
                         THREAD_COUNT * OPERATIONS_PER_THREAD * 2, 
                         duration);
    }
    
    /**
     * <b>Interview Question:</b> When would you use CopyOnWriteArrayList vs Collections.synchronizedList?
     * <b>Answer:</b>
     * - CopyOnWriteArrayList:
     *   - Thread-safe with snapshot iterators (no ConcurrentModificationException)
     *   - Ideal for read-heavy, rarely modified lists
     *   - Creates new copy on modification (expensive writes, cheap reads)
     *   - No locking during iteration
     * - Collections.synchronizedList:
     *   - Wraps ArrayList with synchronized methods
     *   - Better for write-heavy scenarios
     *   - Throws ConcurrentModificationException if modified during iteration
     *   - Requires manual synchronization for compound operations
     */
    public static void demonstrateConcurrentLists() throws InterruptedException {
        System.out.println("\n=== CopyOnWriteArrayList vs synchronizedList ===");
        
        // CopyOnWriteArrayList - thread-safe with snapshot iterators
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        testListPerformance(copyOnWriteList, "CopyOnWriteArrayList");
        
        // Synchronized wrapper - thread-safe with global lock
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        testListPerformance(synchronizedList, "Synchronized ArrayList");
        
        // Demonstrate ConcurrentModificationException
        try {
            System.out.println("\nDemonstrating ConcurrentModificationException:");
            List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
            for (String item : list) {
                list.add("D"); // Throws ConcurrentModificationException
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        // No ConcurrentModificationException with CopyOnWriteArrayList
        System.out.println("No exception with CopyOnWriteArrayList:");
        List<String> safeList = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C"));
        for (String item : safeList) {
            safeList.add("D"); // No exception
        }
        System.out.println("List size: " + safeList.size());
    }
    
    private static void testListPerformance(List<String> list, String listName) throws InterruptedException {
        System.out.println("\nTesting performance of: " + listName);
        long startTime = System.currentTimeMillis();
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        String value = "value-" + threadId + "-" + j;
                        list.add(value);
                        if (j % 1000 == 0) {
                            list.size(); // Some read operations
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("%s: %d operations in %d ms%n", 
                         listName, 
                         THREAD_COUNT * OPERATIONS_PER_THREAD, 
                         duration);
    }
    
    /**
     * <b>Interview Question:</b> What are BlockingQueues and when would you use them?
     * <b>Answer:</b>
     * - Thread-safe queues that support blocking operations
     * - Main implementations:
     *   - ArrayBlockingQueue: Bounded, array-backed
     *   - LinkedBlockingQueue: Optionally bounded, linked nodes
     *   - PriorityBlockingQueue: Unbounded, priority-ordered
     *   - SynchronousQueue: No capacity, hand-off mechanism
     * - Common use cases:
     *   - Producer-consumer patterns
     *   - Thread pool implementations
     *   - Work stealing algorithms
     */
    public static void demonstrateBlockingQueues() throws InterruptedException {
        System.out.println("\n=== BlockingQueue Implementations ===");
        
        // ArrayBlockingQueue - bounded queue with array backing
        BlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(1000);
        testBlockingQueue(arrayQueue, "ArrayBlockingQueue");
        
        // LinkedBlockingQueue - optionally bounded, linked nodes
        BlockingQueue<String> linkedQueue = new LinkedBlockingQueue<>(1000);
        testBlockingQueue(linkedQueue, "LinkedBlockingQueue");
        
        // SynchronousQueue - no capacity, hand-off mechanism
        BlockingQueue<String> syncQueue = new SynchronousQueue<>();
        testSynchronousQueue(syncQueue);
    }
    
    private static void testBlockingQueue(BlockingQueue<String> queue, String queueName) 
            throws InterruptedException {
        System.out.println("\nTesting: " + queueName);
        
        // Producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String item = "Item-" + i;
                    queue.put(item); // Blocks if full
                    System.out.println("Produced: " + item);
                    Thread.sleep(100);
                }
                queue.put("DONE"); // Signal completion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                String item;
                while (!(item = queue.take()).equals("DONE")) { // Blocks if empty
                    System.out.println("Consumed: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
    }
    
    private static void testSynchronousQueue(BlockingQueue<String> queue) 
            throws InterruptedException {
        System.out.println("\n=== SynchronousQueue Demo ===");
        System.out.println("A SynchronousQueue has zero capacity and blocks until both producer and consumer are ready.");
        
        // Producer
        new Thread(() -> {
            try {
                System.out.println("Producer waiting to put...");
                queue.put("Hand-off item");
                System.out.println("Producer completed hand-off");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        // Let producer start first
        Thread.sleep(1000);
        
        // Consumer
        new Thread(() -> {
            try {
                System.out.println("Consumer trying to take...");
                String item = queue.take();
                System.out.println("Consumer received: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    
    /**
     * <b>Interview Question:</b> What are ConcurrentSkipListMap and ConcurrentSkipListSet?
     * <b>Answer:</b>
     * - Thread-safe implementations of SortedMap and SortedSet
     * - Based on skip list data structure (probabilistic alternative to balanced trees)
     * - Provide O(log n) time complexity for most operations
     * - Maintain elements in sorted order
     * - Non-blocking for reads, fine-grained locking for writes
     * - Use cases:
     *   - When you need a thread-safe sorted map/set
     *   - When you need range operations on concurrent collections
     */
    public static void demonstrateConcurrentSkipLists() {
        System.out.println("\n=== ConcurrentSkipListMap and ConcurrentSkipListSet ===");
        
        // ConcurrentSkipListMap
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(3, "Three");
        skipListMap.put(1, "One");
        skipListMap.put(4, "Four");
        skipListMap.put(2, "Two");
        
        System.out.println("ConcurrentSkipListMap (sorted): " + skipListMap);
        System.out.println("First entry: " + skipListMap.firstEntry());
        System.out.println("Last entry: " + skipListMap.lastEntry());
        System.out.println("Head map (keys < 3): " + skipListMap.headMap(3));
        
        // ConcurrentSkipListSet
        ConcurrentSkipListSet<String> skipListSet = new ConcurrentSkipListSet<>(
            Arrays.asList("Zeta", "Alpha", "Gamma", "Beta")
        );
        
        System.out.println("\nConcurrentSkipListSet (sorted): " + skipListSet);
        System.out.println("First element: " + skipListSet.first());
        System.out.println("Subset (A-G): " + skipListSet.subSet("A", "H"));
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Concurrent Collections Demo ===\n");
        
        // Run demonstrations
        demonstrateConcurrentMaps();
        demonstrateConcurrentLists();
        demonstrateBlockingQueues();
        demonstrateConcurrentSkipLists();
        
        System.out.println("\n=== Demo Completed ===");
    }
}
