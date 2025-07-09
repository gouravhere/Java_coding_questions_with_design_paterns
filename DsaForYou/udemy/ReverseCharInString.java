package DsaForYou.udemy;

/**
 * This class demonstrates how to reverse each word in a string while maintaining the word order.
 * Example: "Java is awesome!" becomes "avaJ si !emosewa"
 */
public class ReverseCharInString {
    public static void main(String[] args) {
        String s = "Java is awesome!";
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Reverse each word using StringBuilder's reverse() method
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            result.append(reversedWord);

            // Add space after each word except the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        /*
        Using Streams-

        String result = Arrays.stream(s.split(" "))  // Split into stream of words
                .map(word -> new StringBuilder(word).reverse())  // Reverse each word
                .collect(Collectors.joining(" "));  // Join with space between words
         */
        System.out.println(result);
    }
}
