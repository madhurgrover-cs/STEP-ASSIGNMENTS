public class A3_TrafficSignalStreak {
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
    
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log");
            return;
        }
        
        char longestChar = signalLog.charAt(0);
        int maxStreak = 1;
        
        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }
        
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestChar = currentChar;
        }
        
        System.out.printf("Longest Streak: '%c' repeated %d times.\n", longestChar, maxStreak);
    }
}
