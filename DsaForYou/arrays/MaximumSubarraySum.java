package DsaForYou.arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i],currentSum +nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);

        /*
        Or using if statement
        ***********************************************
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum < 0) {
                currentSum = 0;
            } else if (currentSum > maxSum) {
                maxSum = currentSum;
            }

        }
        System.out.println(maxSum);
        ***********************************************
         */

    }
}
