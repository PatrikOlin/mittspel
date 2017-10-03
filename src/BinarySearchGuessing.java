import java.util.Scanner;

public class BinarySearchGuessing {

	private int low;
	private int high;
	private int numOfGuesses;
	private int maxGuesses;
	private boolean continuePlaying = true;

	public boolean isContinuePlaying() {
		return continuePlaying;
	}

	public void setContinuePlaying(boolean continuePlaying) {
		this.continuePlaying = continuePlaying;
	}

	public boolean PlayBinarySearchGuessingGame() {
		 @SuppressWarnings("resource")
		Scanner binaryGameInput = new Scanner(System.in);

		System.out.println("Tänk på ett heltal i ett intervall.");
		System.out.println("Ange var intervallet slutar och startar: ");

		this.low = binaryGameInput.nextInt();
		this.high = binaryGameInput.nextInt();
		this.numOfGuesses = 0;

		System.out.println("Du har valt intervallet " + low + "-" + high);

		this.maxGuesses = (int) (Math.log(high) / Math.log(2));

		boolean winCondition = false;  
		while(!winCondition) { 

			int guess = (high + low) / 2; 
			System.out.println("Är talet du tänker på " + guess + "? [Ja/Högre/Lägre]");
			numOfGuesses++; 
			String playerInput = binaryGameInput.next().toLowerCase();

			if (playerInput.equals("högre")) { 
				low = guess;
				guess = (high + low) / 2;

			} if (playerInput.equals("lägre")) {
				high = guess;
				guess = (high + low) / 2;

			} if (playerInput.equals("ja")) {
				System.out.println("Det tog mig " + numOfGuesses + " försök att gissa rätt!");
				System.out.println("Det borde tagit mig " + maxGuesses + " gissningar.");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = binaryGameInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					System.out.println("Ok, tack för idag!\n");
					return continuePlaying = false;
				}
//				binaryGameInput.close();
			} else {
				System.out.println("Felaktig input, ange 'Ja', 'Högre' eller 'Lägre'");
			}
		}
		return continuePlaying;
	}
}
