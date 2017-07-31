import java.math.BigInteger;

public class recursion_factorial_biginteger {

	public static void main(String[] args) {

		double start = System.nanoTime(); // This is just for me to show you how long a program takes to run.
		
		BigInteger x = BigInteger.valueOf(1000); // Have fun playing around with the numbers and see how the time taken to run a Factorial recursion grows!
		
		System.out.println(Factorial(x));

		System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
	}
	
	public static BigInteger Factorial (BigInteger n) {
		if (n.equals(BigInteger.ONE)) return BigInteger.ONE;
		else return n.multiply(Factorial(n.subtract(BigInteger.ONE)));
	}

}

