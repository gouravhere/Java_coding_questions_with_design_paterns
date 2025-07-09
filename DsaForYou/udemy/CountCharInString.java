package DsaForYou.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class demonstrates different ways to count character frequencies in a string.
 * It includes both traditional and Java 8 Stream-based implementations.
 */
public class CountCharInString {

    /**
     * Traditional implementation using HashMap to count character frequencies.
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(k) where k is the number of distinct characters
     * 
     * @param input The string to analyze
     * @return Map containing each character and its frequency
     */
    public static Map<Character, Integer> countCharsTraditional(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            charCountMap.merge(currentChar, 1, Integer::sum);
        }
        return charCountMap;
    }

    /**
     * Java 8 Stream-based implementation to count character frequencies.
     * More concise and functional approach.
     * 
     * @param input The string to analyze
     * @return Map containing each character and its frequency
     */
    public static Map<Character, Long> countCharsWithStreams(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    public static void main(String[] args) {
        String testString = "We will test how many char are there in this string";
        
        System.out.println("Traditional Implementation:");
        Map<Character, Integer> traditionalResult = countCharsTraditional(testString);
        System.out.println(traditionalResult);
        
        System.out.println("\nStream Implementation:");
        Map<Character, Long> streamResult = countCharsWithStreams(testString);
        System.out.println(streamResult);
    }
}
