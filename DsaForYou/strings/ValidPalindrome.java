package DsaForYou.strings;

import java.util.Locale;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {
    public static void main(String [] args){
        String s = "A man, a plan, a canal: Panama";
        String test = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left = 0;
        int right = test.length()-1;
        boolean isPalindrome = false;

        if(test.isEmpty() || test.length()==1){
            isPalindrome=true;
        }
        else{
            while(left<right){
                if(test.charAt(left)==test.charAt(right)){
                    isPalindrome=true;
                    left++;
                    right--;
                }
                else{
                    isPalindrome=false;
                    break;
                }

            }
        }

        System.out.println(isPalindrome);
    }
}
