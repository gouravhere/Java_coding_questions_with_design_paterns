package Java8.latest.streams;

import java.util.*;
import java.util.stream.*;

/**
 * A comprehensive demonstration of Java 8+ Streams API.
 * Streams provide a declarative approach to process collections of data.
 *
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Stream operations are either <i>intermediate</i> (return a stream) or <i>terminal</i> (produce a result)</li>
 *     <li>Streams are <i>lazy</i> - computation happens only when a terminal operation is invoked</li>
 *     <li>Streams can be created from Collections, Arrays, I/O channels, or generator functions</li>
 *     <li>Stream operations don't modify the source data</li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What is the difference between Collection and Stream?</li>
 *     <li>Explain the difference between intermediate and terminal operations</li>
 *     <li>What is the purpose of the peek() method?</li>
 *     <li>How does parallel stream work and when would you use it?</li>
 *     <li>What is the difference between map() and flatMap()?</li>
 * </ol>
 *
 * @since Java 8
 * @see java.util.stream
 */
public class StreamsDemo {

    /**
     * Main method demonstrating various Stream operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Creating Streams
        System.out.println("=== 1. Creating Streams ===");
        
        // From a Collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        System.out.println("From Collection: " + names);
        
        // From values
        Stream<String> streamFromValues = Stream.of("Apple", "Banana", "Cherry");
        System.out.print("From values: ");
        streamFromValues.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 2. Intermediate Operations
        System.out.println("=== 2. Intermediate Operations ===");
        
        // Filter and Map
        System.out.println("Filter and Map (names starting with 'A' to uppercase):");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .map(String::toUpperCase)
             .forEach(System.out::println);
             
        // Sorted
        System.out.println("\nSorted names in reverse order:");
        names.stream()
             .sorted(Comparator.reverseOrder())
             .forEach(System.out::println);
             
        // 3. Terminal Operations
        System.out.println("\n=== 3. Terminal Operations ===");
        
        // Collect to List
        List<String> filteredNames = names.stream()
                                       .filter(name -> name.length() > 3)
                                       .toList();
        System.out.println("Names longer than 3 chars: " + filteredNames);
        
        // Count
        long count = names.stream().filter(name -> name.length() > 3).count();
        System.out.println("Count of names longer than 3 chars: " + count);
        
        // Reduce
        Optional<String> longestName = names.stream()
                                         .reduce((name1, name2) -> 
                                             name1.length() > name2.length() ? name1 : name2);
        System.out.println("Longest name: " + longestName.orElse("No names found"));
        
        // 4. Advanced Operations
        System.out.println("\n=== 4. Advanced Operations ===");
        
        // FlatMap
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("Apple", "Banana"),
            Arrays.asList("Cherry", "Date", "Elderberry")
        );
        System.out.println("Flattened list of lists:");
        listOfLists.stream()
                  .flatMap(Collection::stream)
                  .forEach(System.out::println);
                  
        // Grouping By
        System.out.println("\nGrouping by name length:");
        Map<Integer, List<String>> groupedByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);
        
        // 5. Parallel Streams
        System.out.println("\n=== 5. Parallel Streams ===");
        System.out.println("Processing with parallel stream:");
        names.parallelStream()
            .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));
    }
    
    /**
     * Helper method to demonstrate method references in streams.
     *
     * @param s the string to process
     * @return the processed string
     */
    public static String processString(String s) {
        return s.toUpperCase();
    }
}
