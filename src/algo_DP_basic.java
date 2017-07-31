
public class algo_DP_basic {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int sumFinal = 0;
		
		int[][] triangle = {
				{3}, 
				{7,4},
				{2,4,6},
				{8,5,9,3}
				};
		
	    for (int i = triangle[0].length - 1; i >= 0; i--){
	    	for (int j = triangle[1].length - 1; j >= 0; j--){
	    		for (int k = triangle[2].length; k >= 0;  k--){
	    			for (int l = triangle[3].length; l >= 0;  l--){
	    				
	    				if (Math.abs(j-i) > 1 || Math.abs(k-j) > 1 || Math.abs(l - k) > 1) continue;
	    				
	    				int sumTemp = triangle[0][i] + triangle[1][j] + triangle[2][k] + triangle[3][l];
	    				if (sumTemp > sumFinal) sumFinal = sumTemp;
	    			}
	    		}
	    	}
	    }
	    
		System.out.println(sumFinal);

		System.out.println("Your code took " + ((System.nanoTime() - start) / 1000000000) + " seconds to execute.");
	}
	
}

