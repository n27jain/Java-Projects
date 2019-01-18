import submits.TextIO;


public class sales {

	/**
	 * Create an app that asks the user to input quarterly sales 
	 * for the past five years in a 5x4 array,
	 *  then prints the matrix in columns
	 *  and calculates the yearly total 
	 *  and quarterly averages into one-dimensional arrays.
	 * * @author Naman Jain  1/24/2017
	 */
	public static void main(String[] args) {
		
		
		int[][] sales = new int[5][4];// 5X4 array 
		
		System.out.println("Please enter the quarterly sales. 4 per year and up to 5 years. ");// message

		int[] total= new int[5];// One dimensional array that will store the values.
		int[] quarter= new int[4];// one dimensional array that stores the average quarter. 
		
		for(int q=0;q<sales.length;q++){
			
			System.out.println("Please enter year "+ (q+1));
			
			for(int i=0; i<sales[0].length;i++){
				
				System.out.println("Quarter "+ (i+1));
				sales[q][i]=TextIO.getlnInt();
				total[q]+=(sales[q][i]);// Keep adding each of the values for one year into a block of the array.
				quarter[i]+=sales[q][i];// If we asked for the first quarter, i=0. only time i= 0 again is if the second years quarter has been asked.
			}
		}
		
		
		// Find the average quarters.
		
		quarter[0]=(quarter[0])/5;
		quarter[1]=(quarter[1])/5;
		quarter[2]=(quarter[2])/5;
		quarter[3]=(quarter[3])/5;
		
		printStream(sales,total,quarter);
	
	}
	public static void printStream(int [] [] sales,int[] total,int [] quarter )	{
		
		// PrintStream method prints the required fields
		
	    for (int i = 0; i < sales.length; i++) {// Print the table
				
				for (int j = 0; j < sales[0].length; j++){
					
					System.out.printf("%10d", sales[i][j]);// Print f statement that formats the data into a table. 
					
				}
				System.out.println();// Space 
			
		}
	    
	    for (int i=0; i<sales.length; i++){ 
	    	
	    	System.out.println("Year "+(i+1)+" total : "+total[i]);
	    }
	    
	    System.out.println("Quarterly averages:");// Title
	    
	    for(int i=0; i<quarter.length;i++){
	    	
	    	System.out.printf("%10d", quarter[i]);
	    	
	    }
	    
}

}
