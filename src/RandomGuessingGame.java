import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RandomGuessingGame {

	private int low;
	private int high;
	private int numOfGuesses;
	private int guess;
	private boolean continuePlaying = true;

	public boolean isContinuePlaying() {
		return continuePlaying;
	}

	public void setContinuePlaying(boolean continuePlaying) {
		this.continuePlaying = continuePlaying;
	}

	public boolean PlayRandomGuessingGame() {
		@SuppressWarnings("resource")
		Scanner randomGameInput = new Scanner(System.in);

		System.out.println("Tänk på ett heltal i ett intervall.");
		System.out.println("Ange var intervallet slutar och startar: ");

		Random randomNumber = new Random();
		low = randomGameInput.nextInt();
		high = randomGameInput.nextInt();
		numOfGuesses = 0;

		System.out.println("Du har valt intervallet " + low + "-" + high);

		// Skapar ett set för att stoppa in integers i för att garantera att gissningarna är unika.
		Set<Integer> validate = new HashSet<>(); 

		// Sätter winCondition till false och körs så länge wincondition är false
		boolean winCondition = false; 
		while(!winCondition) {
			
			// Genererer första gissningen som ett slumpat tal mellan spelarens satta intervall
			guess = randomNumber.nextInt(high-low) + low; 
			
			// Om "validate" redan innehåller integern i "guess", slumpa fram ett nytt tal. Gör detta tills det slumpade talet är ett tal som inte finns i "validate"
			while(validate.contains(guess)) { 
				guess = randomNumber.nextInt(high-low) + low;
			}
			// Lägger till "guess" i vårt set "validate"
			validate.add(guess);
			System.out.println("Är talet du tänker på " + guess + "? [Ja/Högre/Lägre]");
			
			// Ökar "numOfGuesses" med ett, eftersom vi gissar en gång
			numOfGuesses++; 
			String playerInput = randomGameInput.next().toLowerCase();

			// Om spelaren säger att deras tal är högre än det gissade talet så sätter vi den nya lägstanivån till samma nivå som "guess" och slumpar
			// fram ett nytt tal i den nya intervallen. Talet stoppas sedan in i set, förutsatt att det inte redan finns där, då slumpas ett nytt tal fram.
			if (playerInput.equals("högre")) { 
				low = guess;
				guess = randomNumber.nextInt(high-low) + low;
				while (validate.contains(guess)) {
					guess = randomNumber.nextInt(high-low) + low;
				}
				validate.add(guess);

				// Samma tanke som ovan, fast om spelaren väljer lägre. "high" sätts då till samma tal som "guess" och blir det övre taket på intervallen.
			} if (playerInput.equals("lägre")) {
				high = guess;
				guess = randomNumber.nextInt(high-low) + low;
				while(validate.contains(guess)) {
					guess = randomNumber.nextInt(high-low) + low;
				}
				validate.add(guess);

				// Om spelaren säger att gissningen är rätt, berätta hur många försök det tog och fråga om spelaren vill spela igen och starta om från början i så fall.	
			} if (playerInput.equals("ja")) {
				System.out.println("Det tog mig " + numOfGuesses + " försök att gissa rätt!");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = randomGameInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					continuePlaying = false;
					System.out.println("Ok, tack för idag!\n");
				}
			} else {
				System.out.println("Felaktig input, ange 'Ja', 'Högre' eller 'Lägre'");

			}
//			randomGameInput.close();
		}
		return continuePlaying;
	}
}
