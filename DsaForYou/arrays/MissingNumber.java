package DsaForYou.arrays;

/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2

Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * @param args the input array
     */
    public static void main(String[] args){

        int [] nums = {9,6,4,2,3,5,7,0,1};
        int n = nums.length;
        int actualSum = 0;
        int expectedSum = n*(n+1)/2;
        for(int num:nums){
            actualSum+=num;
        }
        System.out.println(expectedSum-actualSum);
    }
}
