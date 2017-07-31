import java.util.Scanner;
import java.util.Random;

public class project_Blackjack {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
// create a random number generator and a scanner for user input
	
		Random generate = new Random();
		int randomInt = 0;
		Scanner kijang = new Scanner(System.in);
		
// define the card value array 
		int [] Cards = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};
		
// start the betting
		
		int bet_house = generate.nextInt(100) +1;
		
		System.out.println("The house has put $" + bet_house);
		System.out.println("");
		
		System.out.println("How much do you want to bet?");
		int bet_player = kijang.nextInt();
		System.out.println("");
		System.out.println("You have succesfully placed $" + bet_player + " on this game. Good luck! (You'll need it)");
		System.out.println("");
		
// start the game

		
// first, create two arrays of 5 cards max for both the player and house
		
		int [] player = {-1,-1,-1,-1,-1};
		int[] house = {-1,-1,-1,-1,-1};
		
// deal two card to the player and the house, as follows: player/house/player/house
		
		// player Card 1
		
		randomInt = generate.nextInt(51);;
		
		while (Cards[randomInt] == 0){
			randomInt = generate.nextInt(51);
		}
	
		System.out.println(Display(Cards[randomInt]));
		player[0] = Cards[randomInt]%13;
		Cards[randomInt] = 0;
		
		// house Card 1
		
		randomInt = generate.nextInt(51);
		
		while (Cards[randomInt] == 0){
			randomInt = generate.nextInt(51);
		}

		// System.out.println(Display(Cards[randomInt]));
		house[0] = Cards[randomInt]%13;
		Cards[randomInt] = 0;
		
		// player Card 2
		
		randomInt = generate.nextInt(51);;
		
		while (Cards[randomInt] == 0){
			randomInt = generate.nextInt(51);
		}
		
		System.out.println(Display(Cards[randomInt]));
		player[1] = Cards[randomInt]%13;
		Cards[randomInt] = 0;
		
		// house Card 2
		
		randomInt = generate.nextInt(51);
		
		while (Cards[randomInt] == 0){
			randomInt = generate.nextInt(51);
		}
		
		// System.out.println(Display(Cards[randomInt]));
		house[1] = Cards[randomInt]%13;
		Cards[randomInt] = 0;
		
// now, we ask the player if they want another card or not. they can have up to five cards.
		
		int position_p = 2; // this is the next array position to fill. we'll increment this as needed.
		
		while (position_p < 5){
			System.out.println("");
			System.out.println("Would you like another card?");
			int response = kijang.nextInt();
			
			if (response == 0) break; // if player says no, we stop dealing them cards.
			
			randomInt = generate.nextInt(51);;
			
			while (Cards[randomInt] == 0){
				randomInt = generate.nextInt(51);
			}
			
			System.out.println(Display(Cards[randomInt]));
			player[position_p] = Cards[randomInt]%13;
			Cards[randomInt] = 0;
			
			if (Fold(HandValue(player))){
				System.out.println("");
				System.out.println("Too smart for your own good. You've folded! Leave your $" + bet_player + " and move aside, rookie.");
				break;
			}
			
			position_p ++;
		}
		
		
// having served the player, we keep drawing cards for the house until it has at least 17
		
		int position_h = 2;
		
		while (HandValue(house) < 17){
			randomInt = generate.nextInt(51);
			
			while (Cards[randomInt] == 0){
				randomInt = generate.nextInt(51);
			}
			
			// System.out.println(Display(Cards[randomInt]));
			house[position_h] = Cards[randomInt]%13;
			Cards[randomInt] = 0;	
			position_h ++;
		}
		
// now, we have the final hands of the player and the house. we iterate through the results.
		
// possibilities (in this order): House Folds >> Player Wins >> Draw >> House Wins
		
			System.out.println("");
			
			if (!Fold(HandValue(player))) {
			if(Fold(HandValue(house))) System.out.println("The house has folded. Take home $" + (bet_player + bet_house) + ".");
			else if (HandValue(player) > HandValue(house)) System.out.println("You win. Take home $" + (bet_player + bet_house) + ". The house had " + HandValue(house) + ", btw.");
			else if (HandValue(player) == HandValue(house)) System.out.println("Draw. Take back your $" + bet_player + ".");
			else System.out.println ("You've lost your $" + bet_player + ". The house had " + HandValue(house) + ". Go home, rookie.");
			}
			

			System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
}
		

	public static int HandValue (int[] n){
		int sum = 0;
		
		for (int i = 0; i < n.length; i++){
			if (n[i] == -1) continue;
			sum += RoyaltyHandler(n[i]);
		}
		
		// next, we provide the special handling of the Ace
		// if the value of the hand (minus the Ace) is not more than 10, the Ace may count as 11
		
		for (int i = 0; i < n.length; i++){
			if (n[i] == 1 && (sum+10) <= 21) sum += 10;
		}
		
		return sum;
	}
	
	
	public static int RoyaltyHandler (int n){
		if (n == 0 || n == 11 || n == 12) return 10;
		else return n;
	}
	
	public static boolean Blackjack (int n){
		if (n == 21) return true;
		else return false;
	}
	
	public static boolean Fold (int n){
		if (n > 21) return true;
		else return false;
	}
	
	public static String Display (int n){
		
		String [] value = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
		String [] suit = {"Diamonds ♦", "Clubs ♣", "Hearts ♥", "Spades ♠"};
		
		return ( (value[(n-1)%13]).toString() + " of " + (suit[(n-1)/13]).toString());
	}

}
