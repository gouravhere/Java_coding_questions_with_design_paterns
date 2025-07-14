package DsaForYou.arrays;

/**
 * Container With Most Water problem solution.
 * 
 * <p>This class provides a solution to find two lines that together with the x-axis form a container
 * that can hold the most water. The solution uses a two-pointer approach for optimal performance.</p>
 * 
 * <h2>Problem Statement:</h2>
 * <p>Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.</p>
 * 
 * <h2>Key Insights:</h2>
 * <ul>
 *   <li>Area between two lines is determined by the shorter line and the distance between them</li>
 *   <li>Two-pointer technique helps in optimizing from O(n²) to O(n) time complexity</li>
 *   <li>Always move the pointer pointing to the shorter line inwards</li>
 * </ul>
 * 
 * <h2>Time Complexity:</h2>
 * <p>O(n) - Single pass through the array with two pointers</p>
 * 
 * <h2>Space Complexity:</h2>
 * <p>O(1) - Only constant extra space is used</p>
 * 
 * <h2>Common Interview Questions:</h2>
 * <ol>
 *   <li>How would you approach this problem with a brute force solution?</li>
 *   <li>Why does moving the pointer at the shorter line work?</li>
 *   <li>Can you think of a case where this approach would fail?</li>
 *   <li>How would you modify this to find the actual lines instead of just the area?</li>
 * </ol>
 * 
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode Problem</a>
 * @since 1.0
 */
public class ContainerWithMostWater {

    /**
     * Main method to demonstrate the solution with a sample input.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("Maximum water that can be contained: " + maxArea);
    }

    /**
     * Calculates the maximum area of water that can be contained between two vertical lines.
     * 
     * @param height Array where each element represents the height of a vertical line
     * @return Maximum area of water that can be contained
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0; // Edge case: not enough lines to form a container
        }

        int maxArea = 0;
        int left = 0;                      // Left pointer starting from the beginning
        int right = height.length - 1;     // Right pointer starting from the end

        while (left < right) {
            // Calculate width between the two lines
            int width = right - left;
            
            // Calculate height of the container (minimum of the two lines)
            int containerHeight = Math.min(height[left], height[right]);
            
            // Update max area if current area is larger
            maxArea = Math.max(maxArea, width * containerHeight);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
