import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Random;

public class project_MontyHall {
	
	public static void main (String [] args) throws InterruptedException{
		
		Scanner user = new Scanner (System.in);
		
		System.out.println("How many times would you like to repeat the game?");
		int tries = user.nextInt();
		System.out.println("");
		
		System.out.println("I'm gonna assume you're familiar with this game. Define your strategy.");
		System.out.println("1 for switch, 0 for stay.");
		int change = user.nextInt();
		
		double wins = 0;
		double losses = 0;
		
		// This loop handles the game.
		
		for (int i = 0; i < tries; i++){
			
			int[] doors = Doors(i);


			/*System.out.println("");
			System.out.println("Monty Hall is setting up the game.");
			System.out.println("Game ready in  3...");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.println("                          2...");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.println("                          1...");
			TimeUnit.MILLISECONDS.sleep(600);
			
			System.out.println("");
			System.out.println("Pick a door. 1, 2, or 3");
			int choice = user.nextInt() -1;
			System.out.println("");*/
			
			int choice = 0;
			
			int open = Refine(doors,choice);
			System.out.println("You picked Door " + (choice + 1) + ".");
			System.out.println("The host has opened Door " + (open+1) + ".");
			System.out.println("It's a goat!");
			
			int choice_new;
			if (change == 0) choice_new = choice;
			else choice_new = 3 - choice - open;
			
			if (change == 0) System.out.println("You've stayed with your door.");
			if (change == 1) System.out.println("You've switched to Door " + (choice_new + 1) + ".");
			
			if(doors[choice_new] == 1){
				wins ++;
				double win_rate = (wins)/(wins + losses);
				System.out.println("It's a car! You win!");
				System.out.println("");
				
				System.out.println("Number of wins: " + (int) wins);
				System.out.println("Number of losses: " + (int) losses);
				double percentage = (double) Math.round((win_rate*100)*100)/100;
				System.out.println("Win ratio: " + percentage + "%");
				
			}
			
			if(doors[choice_new] == 0){
				losses ++;
				double win_rate = (wins)/(wins + losses);
				System.out.println("It's a goat. You lose!");
				System.out.println("");
				
				System.out.println("Number of wins: " + (int) wins);
				System.out.println("Number of losses: " + (int) losses);
				double percentage = (double) Math.round((win_rate*100)*100)/100;
				System.out.println("Win ratio: " + percentage + "%");
			}
			
			System.out.println("");
			System.out.println("----------------------");
			TimeUnit.MILLISECONDS.sleep(0);
			
		}
		
		
	}
	
	
	// This function generates the randomly placed car and goats.
	public static int[] Doors (int n){

		Random generate = new Random();
		
		int [] doors = {2,2,2};
		int car = generate.nextInt(3);
		
		for (int i = 0; i < 3; i++){
			if (i  == car) doors[i] = 1;
			else doors[i] = 0;
		}
		
		return doors;
	}
	
	// This function tells us which door the host should open.
	public static int Refine (int[] doors, int choice){
		
		int fake_value = 3;
		for (int i = 0; i < 3; i++){
			if (doors[i] == 0 && i != choice) fake_value = i;
		}
		
		return fake_value;
	}

}
