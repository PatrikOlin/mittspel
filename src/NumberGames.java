/*
 * 
 *  Namn: Patrik
 *  Datum 2017-10-02
 * 	Kurs: Java SE, Iftac
 * 
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumberGames {

	public static void main(String[] args) {

		boolean runGameSelect = true;
		while (runGameSelect) {
			Scanner keyboardInput = new Scanner(System.in);
			System.out.println("Hej! Välkommen till nummergissningsspelet!\nVad vill du spela? [Binary search/Random guess/Exit]");
			String gameChoice = keyboardInput.next().toLowerCase();

			if(gameChoice.contains("b")){
				BinarySearchGuessing binaryGame = new BinarySearchGuessing();
				while (binaryGame.isContinuePlaying()) {
					binaryGame.PlayBinarySearchGuessingGame();
				}
			} if (gameChoice.contains("r")) {
				RandomGuessingGame randomGame = new RandomGuessingGame();
				while (randomGame.isContinuePlaying()) {
					randomGame.PlayRandomGuessingGame();
				}
			} else if(gameChoice.contains("x")) {
				System.out.println("Hej då!");
				runGameSelect = false;
				keyboardInput.close();
			}
		}
	}
}
