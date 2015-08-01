package ba.bitcamp.homework.guessingNumbers;

import java.util.Scanner;

public class GuessingNumbers {

	public static int maxGuess = 10;

	/**
	 * Random number
	 * <p>
	 * Generates number in a range 0-100 and saves it
	 * for user to guess which number is it.
	 * 
	 * @return - returns random number.
	 */
	public static int randomNumber() {

		int number = (int) (Math.random() * 10 + 1);
		return number;
	}

	/**
	 * User input.
	 * <p>
	 * Using Scanner this method allows user to insert number.
	 * @return - returns the number user guesses it is imagined.
	 */
	public static int userInput() {
		
		Scanner in = new Scanner(System.in);
		
		int randomNumber = randomNumber();
		int counter = 0;
		int guess = 0;
		int wins = 0;
		int loses = 0;
		int gamesPlayed = 0;
		
		do{
		System.out.println("Guess the number from 1 to 100: ");

		int userInput = in.nextInt();
		} while (guess == randomNumber);
		//5in.close();
		return guess;

	}

	/**
	 * This method compares user input and imagined number.
	 * 
	 * @param userInput
	 *            = user input number
	 * @param number
	 *            = imagined number
	 * 
	 * 
	 */
	public static void guess(int userInput, int number) {

		int counter = 1;
		int wins = 0;
		int loses = 0;
		int gamesPlayed = 0;

		while (counter <= maxGuess) {

			while (userInput != number) {

				if (userInput > number) {

					System.out.println("It is lower than that! ");
					userInput();
					counter++;

				} else if (userInput < number) {
					System.out.println("It is bigger than this one!");
					userInput();
					counter++;
				}
			}
			if (counter <= maxGuess && number == userInput) {

				System.out.println("Bingo!");
				System.out.printf("You guessed the number in %d guesses.\n",
						counter);
				wins++;
				break;
			}

		}
		if (userInput != number) {

			System.out.println("You did not guess it.");
			loses++;

		}

		gamesPlayed += wins + loses;
		System.out.println("Games played: " + gamesPlayed);
		System.out.println("Wins: " + wins + "  Loses: " + loses);

	}

	/**
	 * This method asks a player if he wants to play again or not.
	 * 
	 * @param userInput0or1
	 *            = 1 for yes, 0 for no
	 * @return
	 * 
	 *         Returns boolean value.
	 */
	public static boolean again() {
		Scanner in = new Scanner(System.in);
		boolean again = true;

		System.out.println("If you want play again enter 1, if not enter 0! ");

		int userInput0or1 = in.nextInt();

		if (userInput0or1 != 1) {

			again = false;
			System.exit(0);
		}

		in.close();
		return again;

	}

	public static void main(String[] args) {

		boolean again = true;
		while (again == true) {

			int num = randomNumber();
			int user = userInput();

			guess(user, num);

			again = again();
		}

	}

}
