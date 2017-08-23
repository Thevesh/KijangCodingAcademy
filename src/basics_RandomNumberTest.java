import java.util.Random;
import java.util.Scanner;

public class basics_RandomNumberTest {

	public static void main(String[] args) {

		Scanner user = new Scanner (System.in);
		Random generate = new Random();
		
		System.out.println("Define number of trials.");
		int tries = user.nextInt();
		System.out.println("");
		
		double one = 0;
		double two = 0;
		double three = 0;
		
		for (int i = 1; i < tries+1 ; i++){
			int rand = generate.nextInt(3) +1;
			
			if (rand == 1) one++;
			else if (rand == 2) two++;
			else three++;
		}
		

		double one_rate = (double) Math.round(((one/(one+two+three))*100)*100000)/100000;
		double two_rate = (double) Math.round(((two/(one+two+three))*100)*100000)/100000;
		double three_rate = (double) Math.round(((three/(one+two+three))*100)*100000)/100000;
		
		System.out.println("Ones : " + one_rate + "%");
		System.out.println("Twos : " + two_rate + "%");
		System.out.println("Threes : " + three_rate + "%");
		
		
	}

}
