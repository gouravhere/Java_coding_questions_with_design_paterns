package ioStreams;

import java.util.StringTokenizer;
/**
 * Demonstrates the use of the String Tokenizer class to split a string into its component tokens.
 *
 */
public class StringTokenizerDemo {
    public static void main (String[] args){
        String s = "Hi checking String Tokenizer";

        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }

}
