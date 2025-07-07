package Java8.latest.interview;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * Date/Time API in Java 8
 * 
 * <p><b>Key Concepts:</b>
 * <ul>
 *     <li>Immutable and thread-safe classes</li>
 *     <li>Clear separation between human and machine time</li>
 *     <li>Main classes:
 *     <ul>
 *         <li>LocalDate - date without time</li>
 *         <li>LocalTime - time without date</li>
 *         <li>LocalDateTime - date and time without timezone</li>
 *         <li>ZonedDateTime - date and time with timezone</li>
 *         <li>Instant - machine-readable timestamp (nanoseconds since epoch)</li>
 *         <li>Duration - time-based amount of time (seconds, nanoseconds)</li>
 *         <li>Period - date-based amount of time (years, months, days)</li>
 *     </ul>
 *     </li>
 * </ul>
 *
 * <p><b>Common Interview Questions:</b>
 * <ol>
 *     <li>What are the advantages of the new Date/Time API over the old Date/Calendar classes?</li>
 *     <li>Difference between Instant and LocalDateTime?</li>
 *     <li>How to convert between different date/time types?</li>
 *     <li>What is the difference between Period and Duration?</li>
 *     <li>How to format and parse dates in Java 8?</li>
 *     <li>What are TemporalAdjusters and how to use them?</li>
 *     <li>How to handle timezones in Java 8?</li>
 * </ol>
 *
 * @since Java 8
 */
public class DateTimeAPIDemo {

    public static void main(String[] args) {
        // 1. Basic Date/Time classes
        System.out.println("=== 1. Basic Date/Time Classes ===");
        
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);
        
        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + currentTime);
        
        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);
        
        // Specific date
        LocalDate specificDate = LocalDate.of(2023, Month.JANUARY, 1);
        System.out.println("Specific date: " + specificDate);
        
        // 2. Working with dates
        System.out.println("\n=== 2. Working with Dates ===");
        System.out.println("Day of week: " + today.getDayOfWeek());
        System.out.println("Day of month: " + today.getDayOfMonth());
        System.out.println("Day of year: " + today.getDayOfYear());
        System.out.println("Is leap year: " + today.isLeapYear());
        
        // 3. Modifying dates
        System.out.println("\n=== 3. Modifying Dates ===");
        System.out.println("Next week: " + today.plusWeeks(1));
        System.out.println("Previous month: " + today.minusMonths(1));
        System.out.println("With year 2024: " + today.withYear(2024));
        
        // 4. Temporal Adjusters
        System.out.println("\n=== 4. Temporal Adjusters ===");
        System.out.println("First day of month: " + today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Last day of month: " + today.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Next Monday: " + today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        
        // 5. Period and Duration
        System.out.println("\n=== 5. Period and Duration ===");
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);
        Period period = Period.between(birthday, today);
        System.out.println("Age: " + period.getYears() + " years, " + 
                         period.getMonths() + " months, " + 
                         period.getDays() + " days");
        
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Working hours: " + duration.toHours() + " hours");
        
        // 6. Formatting and Parsing
        System.out.println("\n=== 6. Formatting and Parsing ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted date time: " + formattedDateTime);
        
        LocalDateTime parsedDateTime = LocalDateTime.parse("31/12/2023 23:59:59", formatter);
        System.out.println("Parsed date time: " + parsedDateTime);
        
        // 7. Timezones
        System.out.println("\n=== 7. Timezones ===");
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZonedDateTime londonTime = ZonedDateTime.now(londonZone);
        System.out.println("Current time in London: " + londonTime);
        
        // 8. Instant (machine time)
        System.out.println("\n=== 8. Instant ===");
        Instant now = Instant.now();
        System.out.println("Current timestamp: " + now);
        System.out.println("Epoch seconds: " + now.getEpochSecond());
        
        // 9. ChronoUnit for time differences
        System.out.println("\n=== 9. ChronoUnit ===");
        long daysBetween = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("Days since birthday: " + daysBetween);
    }
    
    /**
     * <b>Interview Questions with Answers:</b>
     * 
     * <p><b>1. What are the advantages of the new Date/Time API over the old Date/Calendar classes?</b>
     * <p>Answer:
     * - Immutable and thread-safe
     - Clear separation between machine and human time
     - More intuitive API with fluent methods
     - Better timezone handling
     - No 0-based month confusion (January is 1, not 0)
     - Better support for date calculations and formatting
     
     * <p><b>2. What is the difference between Instant and LocalDateTime?</b>
     * <p>Answer:
     * - Instant represents a point in time on the time-line (machine time)
     * - LocalDateTime represents a date-time without a time-zone in the ISO-8601 calendar system
     * - Instant is typically used for logging events, LocalDateTime for human-readable date-time
     * 
     * <p><b>3. What is the difference between Period and Duration?</b>
     * <p>Answer:
     * - Period is date-based (years, months, days)
     * - Duration is time-based (hours, minutes, seconds, nanoseconds)
     * - Period handles daylight saving time, Duration does not
     * 
     * <p><b>4. How to handle timezones in Java 8?</b>
     * <p>Answer:
     * - Use ZonedDateTime for timezone-aware operations
     * - Use ZoneId to represent a timezone
     * - Convert between timezones using withZoneSameInstant()
     * - Use ZoneOffset for fixed timezone offsets
     * 
     * <p><b>5. What are TemporalAdjusters and when to use them?</b>
     * <p>Answer:
     * - TemporalAdjusters provide common date manipulations
     * - Examples: first/last day of month, next/previous day of week
     * - Can create custom adjusters by implementing TemporalAdjuster interface
     * - More readable than manual calculations
     */
}
