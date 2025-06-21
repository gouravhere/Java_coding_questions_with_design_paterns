package Java8;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class DateTimeExample {
	public static void main(String[] args) {
		
		ZonedDateTime Example1 = ZonedDateTime.now();
		System.out.println(Example1);
		
		//for getting all the zone IDs
		Set<String> ZoneIDs = ZoneId.getAvailableZoneIds();
		System.out.println(ZoneIDs);
		
		//Using ZoneIds to get particular time zone
		ZonedDateTime CustomTime = ZonedDateTime.now(ZoneId.of("America/Marigot"));
		System.out.println(CustomTime);
		
		//duration time zone
		Instant start = Instant.now();
		Instant End = Instant.now();
		Duration between = Duration.between(start, End);
		System.out.println(between);
		
	}

}
