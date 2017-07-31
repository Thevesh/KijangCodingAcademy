import java.util.Arrays;

public class project_Encryption_ClearToCipher {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		String cleartext = "Write whatever you want. For instance, 'The Quick Brown Fox Jumped Over The Lazy Dog'.";
		String key = "pass";
		
		int[] ciphertext = new int[cleartext.length()];
		int check = 0;
		
		for (int i = 0; i < cleartext.length(); i++){
			ciphertext[i] = cleartext.charAt(i)^key.charAt(check);
			check ++;
			if (check == key.length()) check = 0;
		}
		
		System.out.println(Arrays.toString(ciphertext));
		
		System.out.println("");
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
