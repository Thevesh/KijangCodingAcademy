import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class project_Hangman {

	public static void main(String[] args) {
		
		String answer = "litmadhatta";
		
		Scanner user = new Scanner (System.in);
		
		String[] actual = new String[answer.length()];
		for (int i = 0; i < answer.length(); i++){
			actual[i] = String.valueOf(answer.charAt(i));
		}
		
		String[] solution = new String[answer.length()];
		for (int i = 0; i < solution.length; i++){
			solution[i] = "_";
		}
		
		int wrong = 0;

		System.out.println("Welcome to hangman.");
		System.out.println("You have 5 wrong guesses. Begin.");
		System.out.println(NicePrint(solution));
		System.out.println("");
		
		while (!Arrays.equals(actual, solution)){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
			System.out.println("Enter your guess!");
			String guess = user.nextLine();
			

			int correct = 0;
			
			for(int i = 0; i < actual.length; i++){
				if (guess.equals(actual[i])) {
					solution[i] = actual[i];
					correct++;
				}
			}
			
			if (correct == 0)  {
				System.out.println("");
				System.out.println("Wrong!");
				wrong ++;
				System.out.println(GUI(wrong));
			}
		
			if (Arrays.equals(actual, solution)) {
				System.out.println("");
				System.out.println("You win!");
			}
			if (wrong < 5) System.out.println(NicePrint(solution));
			if (wrong == 5) break;

		}

	
	}
	
	public static String NicePrint (String[] array){
		System.out.println("");
		System.out.print("[");
		for (int i = 0; i < array.length; i++){
			if(array[i].equals("_")) System.out.print(" _ ");
			else System.out.print(array[i] + " ");
		}
		System.out.println("]");
		return "";
	}
	
	public static String GUI (int n){
		
		if (n == 1) {
			System.out.println("    ___");
			System.out.println("   |   ");
			System.out.println("   |   ");
			System.out.println("   |   ");
			System.out.println("   |   ");
			System.out.println("   |   ");
			System.out.println(" _|_");
			System.out.println("");
			System.out.println("4 wrong guesses left.");
		}
		
		if (n == 2) {
			System.out.println("    ___");
			System.out.println("   |     |");
			System.out.println("   |     o ");
			System.out.println("   |    ");
			System.out.println("   |    ");
			System.out.println("   |    ");
			System.out.println(" _|_");
			System.out.println("");
			System.out.println("3 wrong guesses left.");
		}
		
		if (n == 3) {
			System.out.println("    ___");
			System.out.println("   |     |");
			System.out.println("   |     o ");
			System.out.println("   |    /|");
			System.out.println("   |    ");
			System.out.println("   |    ");
			System.out.println(" _|_");
			System.out.println("");
			System.out.println("2 wrong guesses left.");
		}
		

		if (n == 4) {
			System.out.println("    ___");
			System.out.println("   |     |");
			System.out.println("   |     o ");
			System.out.println("   |    /|");
			System.out.println("   |     |");
			System.out.println("   |     ");
			System.out.println(" _|_");
			System.out.println("");
			System.out.println("1 wrong guess left.");
		}
		
		if (n == 5) {
			System.out.println("    ___");
			System.out.println("   |     |");
			System.out.println("   |     o ");
			System.out.println("   |    /|");
			System.out.println("   |     |");
			System.out.println("   |    / ");
			System.out.println(" _|_");
			System.out.println("");
			System.out.println("GAME OVER loser.");
		}
		
		
		
		return ("");

	}
	

}
