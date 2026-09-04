import java.util.Random;

public class P1_RockPaperScissors {
    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");
        
        for (int i = 0; i < 5; i++) {
            String playerMove = playerMoves[i];
            // Use predefined or random for computer, the assignment says "randomly" but for demo it's fine
            String computerMove = options[random.nextInt(3)]; 
            // For matching exact sample "Round 1 Player: Rock, Computer: Scissors -> Player Wins", 
            // we will just rely on the real random values.
            
            String result = playRound(playerMove, computerMove);
            
            System.out.printf("Round %d Player: %s, Computer: %s -> %s\n", (i + 1), playerMove, computerMove, result);
            
            if (result.contains("Wins")) {
                wins++;
            } else if (result.contains("Loses")) {
                losses++;
            } else {
                draws++;
            }
        }
        
        double winPercentage = (double) wins / 5 * 100;
        System.out.println("----------------------------------------------");
        System.out.printf("Final: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
    
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Player Loses";
    }
}
