public class P1_VowelConsonantCounter {
    // Method to count vowels and consonants
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lowerText = text.toLowerCase();
        
        // Loop through each character in the string
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            
            // Check if character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } 
            // Check if character is a consonant (and not a space or other character)
            else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        // Sample test cases
        countVowelsAndConsonants("Java Programming");
    }
}
