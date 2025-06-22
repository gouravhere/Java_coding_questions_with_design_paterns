package DsaForYou;

public class SecondLargest {
    /**
     * Main method for demonstrating the secondLargest method.
     *
     * This method finds the second largest element in an array of integers.
     * The array is initialized with the following values: {-10, -40, -25, -12, -25, -10}.
     * The second largest element is then printed out.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {-10 ,-40 ,-25 ,-12 ,-25 ,-10};
        System.out.println("Second largest element: " + secondLargest(arr));
    }
    /**
     * Finds the second largest element in an array of integers.
     *
     * @param arr the array of integers
     * @return the second largest element in the array
     */
    public static int secondLargest(int[] arr) {
        // Initialize max and secondMax variables to the minimum possible value
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        // Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            // If the current element is greater than the maximum, update the
            // maximum and second maximum
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            // If the current element is not the maximum but is greater than the
            // second maximum, update the second maximum
            else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }
        // Return the second largest element, or -1 if there is no second largest element
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
