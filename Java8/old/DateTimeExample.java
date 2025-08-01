package Java8.old;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * <b>Interview Focus: Java 8 Date/Time API (java.time package)</b>
 * 
 * <p>This class demonstrates the modern Java Date/Time API introduced in Java 8,
 * which is a crucial topic for Java developer interviews.</p>
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *   <li>ZonedDateTime: Handles date and time with timezone information</li>
 *   <li>ZoneId: Represents a time-zone ID, such as 'America/New_York'</li>
 *   <li>Instant: A point on the time-line, useful for machine time</li>
 *   <li>Duration: A time-based amount of time, such as '34.5 seconds'</li>
 * </ul>
 * :
 * <p><b>Interview Questions This Example Helps With:</b>
 * <ol>
 *   <li>What are the main classes in Java 8 Date/Time API?</li>
 *   <li>How do you handle time zones in Java 8?</li>
 *   <li>What's the difference between Instant and LocalDateTime?</li>
 *   <li>How do you measure time between two instants?</li>
 *   <li>What are the advantages over old Date and Calendar classes?</li>
 * </ol>
 * 
 * <p><b>Real-world Use Cases:</b>
 * <ul>
 *   <li>Scheduling events across different time zones</li>
 *   <li>Logging timestamps in distributed systems</li>
 *   <li>Calculating durations between events</li>
 *   <li>Handling daylight saving time changes</li>
 * </ul>
 * 
 * @see java.time.ZonedDateTime
 * @see java.time.ZoneId
 * @see java.time.Instant
 * @see java.time.Duration
 * @since 1.8
 */
public class DateTimeExample {
    /**
     * Demonstrates practical usage of Java 8 Date/Time API with common interview scenarios.
     * 
     * <p><b>Key Points Demonstrated:</b>
     * <ul>
     *   <li>Getting current date/time with timezone information</li>
     *   <li>Working with different time zones</li>
     *   <li>Measuring time between two instants</li>
     *   <li>Available time zone IDs in the system</li>
     * </ul>
     * 
     * <p><b>Interview Tip:</b> Be prepared to discuss thread-safety of these classes
     * and how they compare to the older Date and Calendar classes.</p>
     *
     * @param args command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Example 1: Current date and time with system default timezone
        // Interview Question: How is this different from LocalDateTime.now()?
        ZonedDateTime currentTime = ZonedDateTime.now();
        System.out.println("\n--- Current Date/Time with Timezone ---");
        System.out.println("Current time with timezone: " + currentTime);
        
        // Example 2: Get all available time zone IDs
        // Interview Question: Why might you need to work with time zones in your application?
        System.out.println("\n--- Available Time Zone IDs ---");
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("Number of available time zones: " + availableZoneIds.size());
        // Print first 5 time zones as an example
        availableZoneIds.stream().limit(5).forEach(System.out::println);
        
        // Example 3: Working with a specific time zone
        // Interview Question: How does Java handle daylight saving time changes?
        System.out.println("\n--- Time in Specific Timezone ---");
        String timeZone = "America/New_York";
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of(timeZone));
        System.out.println("Current time in " + timeZone + ": " + newYorkTime);
        
        // Example 4: Measuring time between two instants
        // Interview Question: What's the difference between Instant.now() and System.currentTimeMillis()?
        System.out.println("\n--- Measuring Time Duration ---");
        Instant start = Instant.now();
        
        // Simulate some processing time
        try {
            Thread.sleep(100); // 100ms delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        
        System.out.println("Start time: " + start);
        System.out.println("End time:   " + end);
        System.out.println("Duration:   " + duration.toMillis() + " milliseconds");
        
        // Example 5: Time zone conversion
        // Interview Question: How would you convert a ZonedDateTime to another timezone?
        System.out.println("\n--- Time Zone Conversion ---");
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime tokyoTime = utcTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("UTC Time:   " + utcTime);
        System.out.println("Tokyo Time: " + tokyoTime);

}
}
