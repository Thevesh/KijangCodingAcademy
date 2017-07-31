import java.util.Scanner;

// this file gives a sample of pulling in user input and processing it to give a conditional response

public class basics_GetUserInput {

	public static void main(String[] args) {
		
		Scanner kijang = new Scanner(System.in);
		
		System.out.println("Oi mister pick a number");
		int x = kijang.nextInt();
		
		if (x < 10) {
			System.out.println("U r a loser. Pick a bigger number");
		}
		
		else if (x < 100) {
			System.out.println("U r ok la.");
		}
		
		else {
			System.out.println("U r a big playah. Dat wat i lik to see");
		}
	}

}
