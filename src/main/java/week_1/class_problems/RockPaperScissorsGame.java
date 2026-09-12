import java.util.Random;

public class Question1 {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int round = 1; round <= 5; round++) {
            String playerMove = moves[random.nextInt(moves.length)];
            String computerMove = moves[random.nextInt(moves.length)];

            String result = playRound(playerMove, computerMove);
            System.out.println("Round " + round + " — Player: " + playerMove + ", Computer: " + computerMove + " => " + result);

            if (result.equals("Player Wins")) {
                playerWins++;
            } else if (result.equals("Computer Wins")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        double winRate = (playerWins * 100.0) / 5;
        System.out.println("Final Summary: Wins: " + playerWins + " | Losses: " + computerWins + " | Draws: " + draws + " | Win %: " + winRate + "%");
    }
}
