package DsaForYou.strings;

public class AskedInEY {
    /*

Gourav Sharma was invited to the meeting.


Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.n

Example 1:

Input: s = "ab-cd"

Output: "dc-ba"

Example 2:

Input: s = "a-bC-dEf-ghIj"

Output: "j-Ih-gfE-dCba"

Example 3:

Input: s = "Test1ng-Meet=code-Q!"

Output: "Qedo1ct-eeMg=ntse-T!"

 */
        public static void main(String[] args) {
            String s = "Test1ng-Meet=code-Q!";
            System.out.println(reversel(s));

        }
        public static String reversel(String s){
            char[] c = s.toCharArray();
            int left=0;
            int right=s.length()-1;

            while(left < right){
                if(!Character.isLetter(c[left])){
                    left++;
                }
                else if(!Character.isLetter(c[right])){
                    right--;
                }
                else{
                    char temp=c[left];
                    c[left]=c[right];
                    c[right]=temp;
                    left++;
                    right--;
                }
            }
            return new String(c);

        }
    }

