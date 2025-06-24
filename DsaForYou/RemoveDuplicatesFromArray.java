package DsaForYou;
/*
**Remove Duplicates from Sorted Array**

Given an integer array nums sorted in non-decreasing order, remove the duplicates
in-place such that each unique element appears only once. The relative order of the elements
should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique
 elements in the order they were present in nums initially.
 The remaining elements of nums are not important as well as the size of nums
 */
public class RemoveDuplicatesFromArray {
    /**
     * An example of how to remove duplicates from a sorted array in-place.
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates
     * in-place such that each unique element appears only once. The relative order of the elements
     * should be kept the same. Then return the number of unique elements in nums.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, 1,2,2,2, 3, 4, 5, 6, 7, 8, 9, 10};
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
