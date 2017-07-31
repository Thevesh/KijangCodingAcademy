import java.util.Scanner;

public class basics_1 {

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
