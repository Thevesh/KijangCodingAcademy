
public class basics_2 {

	public static void main(String[] args) {
		
		// This shows you two ways to do a countdown from 10 to 1.
		
		// The first is a Do-While loop.
		
		int x = 10;

		do {
			System.out.println(x);
			x--;
		} 
		while (x > 0);
		
		// The second is a For loop.
		
		for (int i = 10; i > 0; i--){
			System.out.println(i);
		}
		
		// Pick whichever is convenient for you! Both the Do-While and For loops are fundamentals of coding.
	}


}
