import submits.TextIO;

public class matrices {

	/**
	 *Create an app that 
	 *asks the user to input two 3x3 matrices 
	 *then multiplies them together.
	 * * @author Naman Jain  1/24/2017
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Please enter the data for the first array:");
		
		int[][] matrix = inputMaker();// a set of data 3X3 created using input maker method.
		
		System.out.println("Please enter the data for the second array:");
		
		int[][] matrix2 = inputMaker();// a set of data 3X3 created using input maker method.
		
		int[][] worker= worker(matrix, matrix2);// We do the calculations using the worker method.
		
		printstream(matrix, matrix2, worker);// We use our data derivation and print the stream in desired format.
	}
	
	public static int [][] inputMaker(){
		// Makes the 3d array of data.
		
		int[][] input = new int[3][3];// out return value
		
		for(int q=0;q<input.length;q++){// keep looping unlt the 3d array is filled.
			
			for(int i=0; i<input[0].length;i++){// fill each row.
				
				System.out.println("Enter ["+q+"] ["+i+"] :");// ask
				input[q][i]=TextIO.getInt();// get
				
			}
		}
		return input;//return
		
	}
	public static int [][] worker (int[][] matrix, int[][] matrix2){
		
		// after getting two sets of matrices, we use this method to multiply the matrices out. 
		
		int worker[][]= new int [3][3];// we will output this calculated data.
		
		for (int i = 0; i < matrix.length; i++) {// for entire 2d array (9 values)...
			
			// Mr.Tan's code modified
			  // Multiply elements by col
			  for (int j = 0; j < matrix2[0].length; j++) {
					
			    // Inner indices are the same
			    // (col of A * row of B)
			    for (int k = 0; k < matrix[0].length; k++) {

			      // p is the product matrix
			      worker[i][j] += matrix[i][k] * matrix2[k][j];// add the last multiplication value to the current.
			    }
			  }
			}
		return worker;// return the product of the matrices
	}
	
	public static void printstream(int[][] matrix, int[][] matrix2,int [][] worker){
		
		// Printstream in the desired format.
		
			for (int i = 0; i < 3; i++) {// Print the matrices and is product
				
				System.out.println();// space
				System.out.print("[ ");// Open bracket
				
				for (int j = 0; j < 3; j++){
					
					System.out.print(matrix[i][j]+ " ");// print each value of the first matrix's row
					
				}
				System.out.print("]");// close bracket
				
				if(i==1){
					
					System.out.print(" * ");// if we are in the second column, 
					//we will put this multiplication star in the desired format. 
				}
				
				System.out.print(" [ ");// Open bracket for next matrix
				for (int q = 0; q < 3; q++){
					
					System.out.print(matrix2[i][q]+ " ");// print each value of the second matrix's row
					
				}
				System.out.print("]");// close
				
				if (i==1){
					System.out.print(" = "); // If we are in the second row, we put this = sign.
				}
				System.out.print(" [ ");// Open bracket
				
				for (int w = 0; w < 3; w++){
					
					System.out.print(worker[i][w]+ " ");// print each value of the product matrix's row
					
				}
				System.out.print("]");// close
			}
			
	}
	
	
	
}
