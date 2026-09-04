public class A5_MovieReviewWordProfiler {
    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.print("\"" + review + "\" -> ");
        classifyWordLengths(review);
    }
    
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        
        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }
        
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }
}
