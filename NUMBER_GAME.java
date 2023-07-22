import java.util.Random;
import java.util.Scanner;

public class NUMBER_GAME {
    private static final int Min_Number = 1;
    private static final int Max_Number = 100;
    private static final int Max_Attempts = 10;

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        int totalRounds = 0;
        int totalAttempts = 0;
        boolean playAgain;

        do {
            int targetNumber = generateRandomNumber(Min_Number, Max_Number);
            int attempts = 0;
            int guess;

            System.out.println("\nRound " + (totalRounds + 1) + ":");
            System.out.println("Please guess the number between " + Min_Number + " and " + Max_Number);

            while (attempts < Max_Attempts) {
                System.out.println("Attempt " + (attempts + 1));
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("The Number you entered is Too Low! Please Try again.");
                } else {
                    System.out.println("The Number you entered is Too High! Please Try again.");
                }
            }

            if (attempts == Max_Attempts) {
                System.out.println("You have reached the maximum number of your attempts and you ran out of tries.... You Lose!");
                System.out.println("The correct number was " + targetNumber + ".");
            }

            totalRounds++;

            System.out.print("Do you want to play again? (Yes/No): ");
            playAgain = scanner.next().equalsIgnoreCase("Yes");
        } while (playAgain);

        if (totalRounds > 0) {
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.println("Thank You for playing. You played " + totalRounds + " rounds and your score is " + averageAttempts + ".");
        } else {
            System.out.println("Game Over. Thank you for playing the number guessing game!");
        }

        scanner.close();
    }
}
