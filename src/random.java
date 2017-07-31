import java.util.Random;

public class random {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		
		
		Random touchngo = new Random();
		
		int count = 0;
		
	    while (count < 10){
	      int randomInt = touchngo.nextInt(1000);
	      if (randomInt > 100) {
	      System.out.println(randomInt);
	      count ++;
	      }
	    }

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
