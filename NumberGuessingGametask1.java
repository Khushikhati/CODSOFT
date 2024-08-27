import java.util.Scanner;

public class NumberGuessingGametask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxAttempts = 5; // Limit the number of attempts
        int roundsWon = 0;
        boolean playAgain;

        do {
            int myNumber = (int)(Math.random() * 100) + 1;  // Generate number between 1 and 100
            int userNumber = 0;
            int attempts = 0;

            System.out.println("New Round! You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.println("Guess my number (1-100):");
                userNumber = sc.nextInt();
                attempts++;

                if (userNumber == myNumber) {
                    System.out.println("WOOHOO... correct number!");
                    roundsWon++;
                    break;
                } else if (userNumber > myNumber) {
                    System.out.println("Your number is too large.");
                } else {
                    System.out.println("Your number is too small.");
                }
            }

            if (attempts == maxAttempts && userNumber != myNumber) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + myNumber);
            }

            System.out.println("Your score: " + roundsWon + " round(s) won.");

            System.out.println("Do you want to play again? (yes/no)");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Game Over! Your final score: " + roundsWon + " round(s) won.");
    }
}