
public class recursion_fibonacci {
	
	public static void main (String [] args) {
		
		double start = System.nanoTime(); // This is just for me to show you how long a program takes to run.
		
		int x = 45;
		
		System.out.println(Fibonacci(x));

		System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
	}
	
	public static int Fibonacci (int n) {
		if (n <= 2) return 1;
		else return Fibonacci(n-1) + Fibonacci(n-2);
	}

}