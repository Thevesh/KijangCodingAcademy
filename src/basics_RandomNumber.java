import java.util.Random;

public class basics_RandomNumber {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		
		
		Random generate = new Random();
		
		// we'll do it 10 times to see the effect
		
		for (int i = 1; i < 10; i ++) {
		int x = generate.nextInt(50);  //this creates a random integer within the range 0-50
		System.out.println(x);
		}
		
		System.out.println("");
		
		for (int i = 1; i < 10; i ++) {
			int y = generate.nextInt(49) + 1;  //this creates a random integer within the range 0-50
			System.out.println(y);
		}
	

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
