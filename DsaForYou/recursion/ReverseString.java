package DsaForYou.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";
        char[] arr = s.toCharArray();
        char temp;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != ' ' && arr[right] != ' ') {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            left++;
            right--;
        }
        System.out.println(new String(arr));
    }

}
