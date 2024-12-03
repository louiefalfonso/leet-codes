/*
 Game Winner

 - Two players, Alice and Bob, take turns to play a game.
 - The game consists of a number of rounds.
 - Each player has a score, and the player with the higher score at the end of all rounds wins.
 - If their scores are tied, the result is a draw.

 */

 import java.util.Scanner;

public class GameWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read scores for Alice and Bob
        int aliceScore = 0;
        int bobScore = 0;

        System.out.println("Enter scores for Alice and Bob for 3 rounds:");
        for (int i = 0; i < 3; i++) {
            int aliceRoundScore = scanner.nextInt();
            int bobRoundScore = scanner.nextInt();

            // Compare scores for this round
            if (aliceRoundScore > bobRoundScore) {
                aliceScore++;
            } else if (bobRoundScore > aliceRoundScore) {
                bobScore++;
            }
            // If scores are equal, no one gets a point
        }

        // Determine the winner
        if (aliceScore > bobScore) {
            System.out.println("Alice wins with score: " + aliceScore);
        } else if (bobScore > aliceScore) {
            System.out.println("Bob wins with score: " + bobScore);
        } else {
            System.out.println("It's a draw with score: " + aliceScore);
        }

        scanner.close();
    }
}
