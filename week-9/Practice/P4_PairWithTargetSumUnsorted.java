// P4_PairWithTargetSumUnsorted.java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P4_PairWithTargetSumUnsorted {
    /**
     * Approach 1: Hash Set
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean hasPairWithSumHashSet(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(target - x)) return true;
            set.add(x);
        }
        return false;
    }

    /**
     * Approach 2: Sorting + Two Pointers
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) or O(n) for copy
     */
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSumHashSet(nums1, 9)); // true
        System.out.println(hasPairWithSumTwoPointers(nums1, 9)); // true

        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSumHashSet(nums2, 20)); // false
        System.out.println(hasPairWithSumTwoPointers(nums2, 20)); // false
    }
}
