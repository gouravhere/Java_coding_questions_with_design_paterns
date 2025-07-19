package DsaForYou.strings;

/*
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

 */
public class LongestPalindromicSubset {
    public static void main(String[] args) {
        String s = "babad";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = lengthCalc(i, i, s);
            int l2 = lengthCalc(i, i + 1, s);
            int lmax = Math.max(l1, l2);

            if (lmax > end - start) {
                start = i - (lmax - 1) / 2;
                end = i + lmax / 2;
            }

        }
        System.out.println(s.substring(start, end + 1));
    }

    private static int lengthCalc(int left, int right, String s) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
