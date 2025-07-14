package DsaForYou.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * TwoSum class has a method TwoSums which takes an array of integers and a target integer as input
     * and returns an array of two indices, such that the sum of the elements at those two indices in the input array
     * is equal to the target.
     *
     * The approach is to use a HashMap to store the elements of the array as keys and their indices as values.
     * Then for each element in the array, calculate the second number which will add up to the target.
     * Check if the HashMap contains the second number, if yes, return the indices of the two numbers.
     * If not, add the current element and its index to the HashMap.
     */
    public static void main (String[] args){
        int target = 13;
        int[] array = {2,7,13,6,10};
        int[] result = TwoSums(array,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] TwoSums(int[] nums, int target){

        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int secondNum = target - nums[i];
            if(m.containsKey(secondNum)){
                return new int[]{m.get(secondNum),i};

            }
            m.put(nums[i], i);

        }
        return new int[0];
    }
}
