package DsaForYou.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Given a Stream of Arrays in Java, the task is to Flatten the Stream using forEach() method. Examples:
Input: arr[][] = {{ 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 }}
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

Input: arr[][] = {{'G', 'e', 'e', 'k', 's'}, {'F', 'o', 'r'}}
Output: [G, e, e, k, s, F, o, r]
 */
public class ArrayFlat {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } };
        System.out.print("Flattened using Streams: ");
        flatWithStreams(arr);
        System.out.print("Flattened using Recursion: ");
        flatWithRecursion(arr);
    }

    // Flatten using Streams
    private static void flatWithStreams(int[][] arr) {
        List<Integer> newArray = new ArrayList<>();
        java.util.Arrays.stream(arr)
                .flatMapToInt(java.util.Arrays::stream)
                .forEach(newArray::add);
        System.out.println(newArray);
    }

    // Flatten using Recursion
    private static void flatWithRecursion(int[][] arr) {
        List<Integer> newArray = new ArrayList<>();
        flattenRecursive(arr, 0, 0, newArray);
        System.out.println(newArray);
    }

    private static void flattenRecursive(int[][] arr, int row, int col, List<Integer> result) {
        if (row == arr.length) {
            return;
        }
        if (col == arr[row].length) {
            flattenRecursive(arr, row + 1, 0, result);
            return;
        }
        result.add(arr[row][col]);
        flattenRecursive(arr, row, col + 1, result);
    }

}
