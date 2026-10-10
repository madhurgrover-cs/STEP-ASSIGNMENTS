// P3_PairWithTargetSum.java
import java.util.HashSet;
import java.util.Set;

public class P3_PairWithTargetSum {
    /**
     * Optimal Approach: Hash Set Complement Lookup
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Brute Force Approach: Checking every pair
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSum(nums1, 9)); // true

        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums2, 20)); // false
    }
}
