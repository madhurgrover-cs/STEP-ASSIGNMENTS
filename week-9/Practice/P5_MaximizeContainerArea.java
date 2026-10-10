// P5_MaximizeContainerArea.java
public class P5_MaximizeContainerArea {
    /**
     * Optimal Two Pointers Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(heights[left], heights[right]);
            int area = width * h;
            if (area > maxArea) {
                maxArea = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute Force Approach
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int maxContainerAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights)); // 49
    }
}
