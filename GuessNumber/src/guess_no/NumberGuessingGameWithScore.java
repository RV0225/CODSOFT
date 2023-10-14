package guess_no;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameWithScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalAttempts = 0;
        int totalRoundsWon = 0;

        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 10; // Set the maximum number of attempts

            System.out.println("****Guess a number between 1 to 100****");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                totalAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Higher number please");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Lower number please");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    totalRoundsWon++;
                    break;
                }

                if (numberOfAttempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was " + numberToGuess + ".");
                }
            }

            System.out.println("Score for this round:");
            System.out.println("Attempts: " + numberOfAttempts);
            System.out.println("Rounds won: " + totalRoundsWon);

            System.out.print("Play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over!");
        System.out.println("Total Score:");
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Total Rounds Won: " + totalRoundsWon);
        scanner.close();
    }
}