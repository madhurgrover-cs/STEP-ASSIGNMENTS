// A4_HotWeatherAlertWindows.java
public class A4_HotWeatherAlertWindows {
    /**
     * Sliding Window Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || k <= 0 || readings.length < k) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentSum = 0;

        // Initial window of size k
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        int alerts = 0;
        if (currentSum >= targetSum) {
            alerts++;
        }

        // Slide the window forward
        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4)); // 3
    }
}
