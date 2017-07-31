
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class project_Roulette {

	public static void main(String[] args) throws InterruptedException {

		// create a random number generator and a scanner for user input
		
			Random generate = new Random();
			Scanner kijang = new Scanner(System.in);
			
// define the amount of money the player can start with

			System.out.println("Welcome to the Kijang Casino!");
			
			int wallet = 1000;
			int tries = 1;
			
			while (wallet > 0){
				
				int house = generate.nextInt(10000);

				System.out.println("");
				System.out.println("You have $" + wallet + " left.");
				System.out.println("There is a pot of $" + house + " on the table.");
				System.out.println("How much would you like to bet?");
				int bet = kijang.nextInt();
				
				if (bet == wallet){
					System.out.println("Wow! All in! A high roller!");
				}
				
				if (bet == 0) {
					System.out.println("Coward. Get outta the casino.");
					break;
				}

				System.out.println("");
				System.out.println("Nice. Now, pick a number between 1 and 38.");
				int hope = kijang.nextInt();
				
				int result;
				
				if (tries%4 == 0) {
					result = hope;
				}
				else result = generate.nextInt(37) + 1;

				
				System.out.println("The wheel has been spun. There's no turning back now.");
				System.out.println("Wait for it.....");
				TimeUnit.SECONDS.sleep(5);
				

				System.out.println("");
				System.out.println("The wheel comes up with " + result + "!!!!");
				
				if (hope == result){
					System.out.println("You've won $" + house + "!!!! What a stunning victory!");
					wallet += house;
					System.out.println("Would you like to try your luck again while you're on a streak? :D");
					int response = kijang.nextInt();
					
					if (response == 0) {
						System.out.println("Thank you for playing. See you next time! You leave with $" + wallet + ".");
						break;
					}
				}
				
				else {
					System.out.println("Tough luck. This just wasn't your time.");
					wallet -= bet;
					
					if (wallet == 0) System.out.println("Unfortunately, you're out of money. You're gonna have to leave for now, but do come back again! I just know you're meant to make it here!");
					
					else{
					System.out.println("Would you like to try your luck again? I'm sure that was a one-off!");
					int response = kijang.nextInt();
					
						if (response == 0) {
							System.out.println("Thank you for playing. See you next time! You leave with $" + wallet + ".");
							break;
						}
					}
				}	
				

				tries++;
			}
			
			
		}
}


