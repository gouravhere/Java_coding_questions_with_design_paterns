package DsaForYou.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array arr and a chunk size size, return a chunked array.

A chunked array contains the original elements in arr, but consists of subarrays each of length size.
The length of the last subarray may be less than size if arr.length is not evenly divisible by size.

Please solve it without using lodash's _.chunk function.



Example 1:

Input: arr = [1,2,3,4,5], size = 1
Output: [[1],[2],[3],[4],[5]]
Explanation: The arr has been split into subarrays each with 1 element.
Example 2:

Input: arr = [1,9,6,3,2], size = 3
Output: [[1,9,6],[3,2]]
Explanation: The arr has been split into subarrays with 3 elements. However, only two elements are left for the 2nd subarray.
Example 3:

Input: arr = [8,5,3,2,6], size = 6
Output: [[8,5,3,2,6]]
Explanation: Size is greater than arr.length thus all elements are in the first subarray.
Example 4:

Input: arr = [], size = 1
Output: []
Explanation: There are no elements to be chunked so an empty array is returned.
 */
public class Chunks {

    public static void main (String[] args){
       int[] arr = {1,2,3,4,5};
        int chunkSize = 2;
        List<List<Integer>> result =chunks(arr,chunkSize);
        for(List<Integer>chunk : result){
            System.out.print(chunk);
        }
    }
    public static List<List<Integer>> chunks(int []arr, int chunkSize){
        List<List<Integer>> list = new ArrayList<>();
        int j =0;
        while (j< arr.length){
            List<Integer> chunk = new ArrayList<>();
            for(int i =0; i<chunkSize && j<arr.length;i++){
                chunk.add(arr[j]);
                j++;
            }
            list.add(chunk);
        }

        return list;
    }
}
