package DsaForYou.udemy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class demonstrates how to reverse each word in a string using Java Streams.
 * Example: "Java is awesome!" becomes "avaJ si !emosewa"
 */
public class ReverseCharInString {
    public static void main(String[] args) {
        String s = "Java is awesome!";
        
        String result = Arrays.stream(s.split(" "))  // Split into stream of words
                .map(word -> new StringBuilder(word).reverse())  // Reverse each word
                .collect(Collectors.joining(" "));  // Join with space between words
        
        System.out.println(result);
    }
}
