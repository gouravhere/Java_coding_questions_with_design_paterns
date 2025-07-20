package DsaForYou.recursion;

public class FactorialTrailingZero {
    public static void main(String[] args) {
        int n = 100; // Example input
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        System.out.println("Number of trailing zeros in factorial: " + res);
    }
}
