package DsaForYou.recursion;

public class Fibonacci {
    public static void main(String[] args) {

        int n = 3;
        int first = 0;
        int result = 1;
        if (n == 0) {
            System.out.println("0");
        } else if (n == 1 || n == 2) {
            System.out.println("1");
        }
        for (int i = 2; i <= n; i++) {

            int sum = first + result;
            first = result;
            result = sum;

        }
        System.out.println(result);
    }
}
