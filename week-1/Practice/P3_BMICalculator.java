public class P3_BMICalculator {
    public static void main(String[] args) {
        double[] heights = {1.70, 1.80, 1.65, 1.75, 1.60, 1.85, 1.90, 1.55, 1.68, 1.72};
        double[] weights = {60.0, 95.0, 50.0, 70.0, 45.0, 85.0, 110.0, 55.0, 75.0, 68.0};
        
        printWellnessReport(heights, weights);
    }
    
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }
    
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height | Weight | BMI   | Status");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%6d | %6.2f | %6.1f | %5.1f | %s\n", (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}
