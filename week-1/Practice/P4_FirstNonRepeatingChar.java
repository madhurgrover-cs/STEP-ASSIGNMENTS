public class P4_FirstNonRepeatingChar {
    public static void main(String[] args) {
        String test1 = "swiss";
        String test2 = "aabbcc";
        
        char res1 = findFirstNonRepeatingChar(test1);
        if (res1 != '\0') {
            System.out.println("\"" + test1 + "\" -> '" + res1 + "'");
        } else {
            System.out.println("\"" + test1 + "\" -> No Non-Repeating Character Found");
        }
        
        char res2 = findFirstNonRepeatingChar(test2);
        if (res2 != '\0') {
            System.out.println("\"" + test2 + "\" -> '" + res2 + "'");
        } else {
            System.out.println("\"" + test2 + "\" -> No Non-Repeating Character Found");
        }
    }
    
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0'; // Return null character if none found
    }
}
