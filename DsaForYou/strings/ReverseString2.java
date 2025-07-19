package DsaForYou.strings;

public class ReverseString2 {
    /*
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

    If there are fewer than k characters left, reverse all of them.
    If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.



    Example 1:

    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    Example 2:

    Input: s = "abcd", k = 2
    Output: "bacd"
     */
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        char [] str = s.toCharArray();
        for(int i =0;i<s.length();i+=2*k){
            int end =i+k-1;
            if(end>s.length()-1){
                end  = s.length()-1;
            }
            rev(i,end,str);
        }
        System.out.println(str);
    }

    private static void rev(int i , int end , char[] str){
        while(i<end){
            char temp = str[i];
            str[i] = str[end];
            str[end]=temp;
            i++;end--;
        }
    }
}
