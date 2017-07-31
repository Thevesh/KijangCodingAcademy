
public class algo_Recursion_Factorial {

	public static void main(String[] args) {

		double start = System.nanoTime(); // This is just for me to show you how long a program takes to run.
		
		int x = 31; // Have fun playing around with the numbers and see how the time taken to run a Factorial recursion grows!
		
		System.out.println(Factorial(x));

		System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
	}
	
	public static int Factorial (int n) {
		if (n <= 1) return 1;
		else return n * Factorial (n-1);
	}

}

