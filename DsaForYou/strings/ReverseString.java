package DsaForYou.strings;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Original: " + new String(s));
        reverseString(s);
        System.out.println("Reversed: " + new String(s));
    }

    public static void reverseString(char[] s) {
        int n = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if (i < n) {
                char temp = s[n];
                s[n] = s[i];
                s[i] = temp;
                n--;
            }
        }
    }
}
