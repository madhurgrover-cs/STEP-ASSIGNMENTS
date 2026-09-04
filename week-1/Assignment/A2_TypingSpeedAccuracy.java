public class A2_TypingSpeedAccuracy {
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
    
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Strings must be of equal length.");
            return;
        }
        
        int matched = 0;
        int firstMismatch = -1;
        
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        
        double accuracy = ((double) matched / original.length()) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, original.length(), accuracy);
        
        if (firstMismatch != -1) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')\n",
                    (firstMismatch + 1), original.charAt(firstMismatch), typed.charAt(firstMismatch));
        } else {
            System.out.println(", No Mismatches");
        }
    }
}
