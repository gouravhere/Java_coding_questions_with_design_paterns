package DsaForYou.recursion;

/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 101
Output: true
Explanation: 101 reads as 101 from left to right and from right to left.
Example 4:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 1121;
        int reverse = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            System.out.println(false);
            return;
        }
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        System.out.println(x == reverse || x == reverse / 10);
    }

}
