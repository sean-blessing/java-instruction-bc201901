import java.util.Scanner;

//NOTE:  Must complete Project 5-3 before this one.
public class GuessTheNumberApp {

    public static void main(String[] args) {
    	
        Game.displayWelcomeMessage();

        // create the Scanner object
        Scanner sc = new Scanner(System.in);

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	Game game = new Game();
            // invite user to guess theNumber 
            Game.displayPleaseGuessMessage();

            // continue until the user guesses the number
            int guessNumber = 0;
            while (guessNumber != game.getTheNumber()) {
                // get a valid int from user
                guessNumber = Console.getIntWithinRange(sc, "Enter number: ", 0, 101);
                game.incrementNumberOfGuesses();

                // display result of guess to user
                if (guessNumber == game.getTheNumber()) {
                    game.displayCorrectGuessMessage();
                } else {
                    game.displayGuessAgainMessage(guessNumber);
                }
            }

            // see if the user wants to continue
            choice = Console.getChoiceString(sc, "Try again? (y/n): ", "y", "n");
            System.out.println();
        }
        System.out.println("Bye - Come back soon!");
        System.out.println();
    }



}
