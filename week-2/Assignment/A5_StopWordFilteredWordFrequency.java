import java.util.*;

public class A5_StopWordFilteredWordFrequency {
    // Method to filter stop words and print word frequency
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordsArray));
        
        // Convert to lowercase and strip punctuation
        String cleanFeedback = feedback.replace(".", "").replace(",", "").toLowerCase();
        
        // Split text into words
        String[] words = cleanFeedback.split("\\s+");
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count frequency of remaining unique words
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        // Print each unique word with its count
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
