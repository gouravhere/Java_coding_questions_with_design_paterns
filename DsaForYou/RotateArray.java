package DsaForYou;

import java.util.Arrays;

//Rotate Array
/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    /**
     * The main method demonstrates rotating an array of integers to the right by a specified number of steps.
     *
     * <p>This method initializes an array of integers and a rotation count. It then creates an instance of
     * the RotateArray class, calls the rotate method on the instance to perform the rotation, and finally
     * prints the rotated array to the console.</p>
     *
     * @param args the command line arguments (not used in this method)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        RotateArray obj = new RotateArray(); // create object
        obj.rotate(nums, k);                 // call instance method

        // Print rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * Rotate the given array of integers to the right by k steps.
     *
     * <p>This method performs an in-place rotation of the given array by k steps to the right.
     * The rotation is done by reversing the entire array, then reversing the first k elements,
     * and finally reversing the remaining elements.</p>
     *
     * @param nums the array of integers to be rotated
     * @param k the number of steps to rotate the array to the right
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * Reverses the elements of the given array between the specified start and end indices.
     *
     * <p>This method swaps elements in the array from the start index to the end index,
     * effectively reversing the order of the elements in that range.</p>
     *
     * @param nums the array of integers whose elements are to be reversed
     * @param start the starting index of the range to reverse
     * @param end the ending index of the range to reverse
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


