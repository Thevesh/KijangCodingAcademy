import java.util.Scanner;
import java.util.Random;

public class blackjack {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
// create a random number generator and a scanner for user input
	
		Random generate = new Random();
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
		
// first, deal two cards to the player
		
		int r1 = generate.nextInt(51);;
		
		while (Cards[r1] == 0){
			r1 = generate.nextInt(51);
		}
		
		int p_c1 = Cards[r1];
		Cards[r1] = 0;
		// System.out.println(p_c1);
		System.out.println(Display(p_c1));
		
		int r2 = generate.nextInt(51);;
		
		while (Cards[r2] == 0){
			r2 = generate.nextInt(51);
		}
		
		int p_c2 = Cards[r2];
		Cards[r2] = 0;
		// System.out.println(p_c2);
		System.out.println(Display(p_c2));

		System.out.println("");
		
// next, deal two cards to the house
		
		int r3 = generate.nextInt(51);
		
		while (Cards[r3] == 0){
			r3 = generate.nextInt(51);
		}
		
		int h_c1 = Cards[r3];
		Cards[r3] = 0;
		// System.out.println(h_c1);
		// System.out.println(Display(h_c1));
		
		int r4 = generate.nextInt(51);
		
		while (Cards[r4] == 0){
			r4 = generate.nextInt(51);
		}
		
		int h_c2 = Cards[r4];
		Cards[r4] = 0;
		// System.out.println(h_c2);
		// System.out.println(Display(h_c2));
		
		
		int p_total = RoyaltyHandler(p_c1%13) + RoyaltyHandler(p_c2%13);
		int h_total = RoyaltyHandler(h_c1%13) + RoyaltyHandler(h_c2%13);
		
		if (Blackjack(p_total) && !Blackjack(h_total)) System.out.println("Blackjack! You win!!!"); 
		if (Blackjack(h_total) && !Blackjack(p_total)) System.out.println("The house has a blackjack. The house always wins."); 
		if (Blackjack(h_total) && Blackjack(p_total)) System.out.println("Draw."); 
		
		System.out.println("Would you like another card?");
		int response = kijang.nextInt();

// if player says no, game ends. 
		
		if (response == 0){
			if (p_total > h_total) System.out.println("You win. Take home $" + (bet_player + bet_house));
			else System.out.println ("You've lost your $" + bet_player + ". The house had " + h_total + ". Go home, loser");
		}
		
// if player says yes, continue
		
		if (response == 1){
			int r5 = generate.nextInt(51);;
			
			while (Cards[r5] == 0){
				r5 = generate.nextInt(51);
			}
			
			int p_c3 = Cards[r5];
			Cards[r5] = 0;
			// System.out.println(p_c3);
			System.out.println(Display(p_c3));
		
			p_total += RoyaltyHandler(p_c3%13);
		}

		System.out.println("");
		if (Fold(p_total)) System.out.println("You fold. Get lost.");	
		else if (p_total > h_total) System.out.println("You win. Take home $" + (bet_player + bet_house));
		else System.out.println ("You've lost your $" + bet_player + ". The house had " + h_total + ". Go home, loser.");
		
	}
	
	public static int RoyaltyHandler (int n){
		if (n == 1) return 11;
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
