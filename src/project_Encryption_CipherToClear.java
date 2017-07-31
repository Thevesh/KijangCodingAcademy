
import java.util.Scanner;
public class project_Encryption_CipherToClear {

	public static void main(String[] args) {

		Scanner kijang = new Scanner(System.in);
		
		System.out.println("Key in the password:");
		String password = kijang.nextLine();
		
		int [] cleartext = new int [Ciphertext.length];
		
		int j = 0;
		for (int i = 0; i < Ciphertext.length; i++){
			cleartext[i] = Ciphertext[i]^password.charAt(j);
			j++;
			if (j == password.length()) j = 0;
		}
		
		System.out.println("");
		
		for (int i = 0; i < cleartext.length; i++){
			System.out.print(Character.toString((char) cleartext[i]));
		}
		
	}
	

	
	
	public static int[] Ciphertext = {
			39, 19, 26, 7, 21, 65, 4, 27, 17, 21, 22, 5, 21, 19, 83, 10, 31, 20, 83, 4, 17, 15, 7, 93, 80, 39, 28, 1, 80, 8, 29, 0, 4, 0, 29, 16, 21, 77, 83, 84, 36, 9, 22, 83, 33, 20, 26, 16, 27, 65, 49, 1, 31, 22, 29, 83, 54, 14, 11, 83, 58, 20, 30, 3, 21, 5, 83, 60, 6, 4, 1, 83, 36, 9, 22, 83, 60, 0, 9, 10, 80, 37, 28, 20, 87, 79
	};


	

	
}




