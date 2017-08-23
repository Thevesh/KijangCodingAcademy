import java.util.Random;

public class CoinFlipper {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		Random generate = new Random();
		
		double bound = 1000;
		
		double heads = 0;
		double tails = 0;
		
		double result = 0;
		
		for (int i = 1; i < bound+1; i++){
		
		for (int j = 1; j < 100; j++){
			int flip = generate.nextInt(2);
			
			if(flip == 0) heads ++;
			else tails ++;
		}
		
		double proportion = heads/(heads + tails);
		
		if (proportion < 0.49 || proportion > 0.51) {
			result ++;
			System.out.println(proportion);
		}
		
		}
		
		System.out.println(result/bound);

		System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
	}

}
