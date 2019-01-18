
package submits;

public class Matrixenator {

	/**
	 * Create an app asks the user for the dimensions of two matrices, 
	 * then inputs the numbers for the matrices by element. 
	 * The user then should choose an operation + - * on the matrices. 
	 * When completed, the user can choose to:
	 * 	print the current matrices with dimensions
	 * perform another operation on the same matrices
	 * swap the matrices and perform another operation replace one matrix with new input, or 
        restart with two new matrices.
	 * Remember that two matrices can only be added or subtracted if their dimensions are the same, 
	 * and they can only be multiplied if the columns of the first equals the rows of the second!
	 * * @author Naman Jain 02/16/2017
	 */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// On startup--- app asks user for the first two arrays and an operation
		
				System.out.println("Enter the dimesions of the Martix 1.");// ask for the first matrix
				
				int[][]matrix= inputMaker();// input method
				
				System.out.println("Enter the dimesions of the Martix 2.");// ask for the second matrix
				
				int[][]matrix2= inputMaker();// input method
				
				System.out.println("Plese enter the operation sign (*,+,or -) :");// ask for the operation
				char operation;
				operation=TextIO.getlnChar();
				
				while(operation!='*'&&operation!='+'&&operation!='-'){// while we do not get valid operations
					//message
					System.out.println("Thats not a valid operation!");
					System.out.println("Plese enter the operation sign (*,+,or -) :");
					
					operation=TextIO.getlnChar();//get it again
				}
				
				if (operation=='*'){// multiplication
					Multiworker(matrix,matrix2);// call the Multiworker method to multiply
					
				}
				else if (operation=='+'){
					Addworker(matrix,matrix2);// call the Addworker method to add
					
				}
				else if (operation=='-'){
					Subworker(matrix,matrix2);// call the Subworker method to subtract
				}
		
		int pick=0;// users choice, starts off as zero initially 
		
		// Now the menu is opened. 
		// User can now perform a variety of functions
		
		do{
			
			System.out.println("");//space
			System.out.println(" Welcome Boss!");
			System.out.println(" What do you wanna do? Enter the number before the command:");
			System.out.println("");//space
			
			// options
			System.out.println(" 1. Enter 2 new matrices.");
			System.out.println(" 2. Replace a matrix");
			System.out.println(" 3. Apply annother opperation");
			System.out.println(" 4. Print current matrices");
			System.out.println(" 5. Swap the matrices");
			
			System.out.println(" 0. Terminate program.");// press 0 to exit
			
			pick= TextIO.getlnInt();// Take input command.
			
			while (pick>5||pick<0){
				// If the user enters something that is not an option...
					
				System.out.println("Oops! Thats not an option. Try again!");//error message.
				pick= TextIO.getlnInt();// Take input command again.
				
				}
			
			if (pick==1){// option one overwrites the old matrices
				
				System.out.println("Enter the dimesions of the Martix 1.");// ask for the first matrix
				
				matrix= inputMaker();// input method
				
				System.out.println("Enter the dimesions of the Martix 2.");// ask for the second matrix
				
				matrix2= inputMaker();// input method
			}
			
			else if(pick==2){// option 2 allows user to overwrite one matrix
				System.out.println("Would you like to replace matrix 1 or 2? (Enter 1 or 2)  :");// ask for the targeted matrix
				
				int choice=TextIO.getlnInt();//
				
				while (choice<0||choice>2){// invalid entries
					System.out.println("Invalid entery. Please enter either 1 or 2. You may exit to main menu by pressing 0.");
				}
				
				if (choice==0){
					// do nothing and you will return to the menu
				}
				else{
					if(choice==1){
						matrix=inputMaker();// replace matrix 1 with new input
					}
					else if(choice==2){
						matrix2=inputMaker();// replace matrix 2 with new input.
					}
				}
			}
			
			else if (pick==3){ //option 3 allows user to apply another operation to the already entered matrices
				
				System.out.println("Plese enter the operation sign ( *,+,or - ) :");// ask for the operation
				
				operation=TextIO.getlnChar();
				
				while(operation!='*'&&operation!='+'&&operation!='-'){// while we do not get valid operations
					//message
					System.out.println("Thats not a valid operation!");
					System.out.println("Plese enter the operation sign (*,+,or -) :");
					
					operation=TextIO.getlnChar();//get it again
				}
				
				if (operation=='*'){
					Multiworker(matrix,matrix2);// call the Multiworker method to multiply
					
				}
				else if (operation=='+'){
					Addworker(matrix,matrix2);// call the Addworker method to add
					
				}
				else if (operation=='-'){
					Subworker(matrix,matrix2);// call the Subworker method to subtract
					
				}
			}
			
			else if (pick==4){// option 4 prints the arrays
				
				System.out.println("");//space	
				System.out.println("First:");// The title of matrix 1
				System.out.println("");//space

				printer(matrix);// print the matrix
				
				System.out.println("");//space
				System.out.println("Second:");// title of matrix 2
				
				printer(matrix2);//print the matrix
			}
			
			else if (pick==5){// option 5 switches the two arrays. 
				
				int[][]copy= matrix;
				matrix=matrix2;// make matrix 1 matrix 2
				matrix2=copy;// make matrix 2 matrix 1
			}
			else if (pick==0){
				// exit
				
				System.out.println("FINSHED? BYE BYE!!!");// exit message
			}
			
		} while(pick!=0);// We keep the menu running so as long as the user does not wish to terminate the program.
	}

	public static int [][] inputMaker(){
		// Makes the 3d array of data.
		
		
		System.out.println("Please enter the number of rows:");// ask
		
		int row= TextIO.getInt();// get number of rows
		
		System.out.println("Please enter the number of columns:");// ask
		
		int col= TextIO.getInt();// get number of columns 

		
		int[][] input = new int[row][col];// out return value that needs to be populated
		
		for(int q=0;q<input.length;q++){// keep looping until the 3-d array is filled. This counter goes by the row
			
			for(int i=0; i<input[0].length;i++){// fill each column of that row
				
				
				System.out.println("Enter ["+q+"] ["+i+"] :");// ask
				
				input[q][i]=TextIO.getInt();// get
			}
		}
		return input;//return
	}
	
	public static void Multiworker (int[][] matrix, int[][] matrix2){
		
		// after getting two sets of matrices, we use this method to multiply the matrices out. 
		
		int worker[][]= new int [matrix.length][matrix2[0].length];// we will output this calculated data.
		
		if(matrix[0].length==matrix2.length){// the number of columns are equal to the number of rows of the second matrix
			
			// Multiply elements by row of Q
			for (int i = 0; i < matrix.length; i++) {
				
			  // Multiply elements by col
			  for (int j = 0; j < matrix2[0].length; j++) {
					
			    // Inner indices are the same
			    // (col of A * row of B)
			    for (int k = 0; k < matrix[0].length; k++) {

			      // p is the product matrix
			      worker[i][j] += matrix[i][k] * matrix2[k][j];
			    }
			  }
			}

			printer(worker);// We print out the product array using printer method
		}
		
		
		else{
			// The dimensions of the matrices prevent the opperation...
			System.out.println("Sorry. Your matricies cannot be multiplied due to incompatible dimesions.");
		}
	}
	
	public static void Addworker(int[][] matrix, int[][] matrix2){
		
		// Matrix added method. 
		int worker[][]= new int [matrix.length][matrix.length];// we know that in adding, both matrices will have the same dimensions
		
		if(matrix.length==matrix2.length&&matrix[0].length==matrix2[0].length){// When both matrices match in dimensions 
			
			for (int i = 0; i < matrix.length; i++) {// for entire 2d array (9 values)...
				
				  for (int j = 0; j < matrix[0].length; j++) {
						
				      worker[i][j] = matrix[i][j]+matrix2[i][j];// add each term corresponding to the same cordinates
				    }
			}
			printer(worker);// once we are done, we can print out the sum. 
		}
		else{// dimesions are not valid
			
			System.out.println("Sorry. Your matricies cannot be added due to incompatible dimesions.");// message
		}
	}
	
	public static void Subworker(int[][] matrix, int[][] matrix2){
		// Find the difference of the arrays. Basically the same as Addworker. Read explanations above. 
		
		int worker[][]= new int [matrix.length][matrix.length];
		
		if(matrix.length==matrix2.length&&matrix[0].length==matrix2[0].length){
			
			for (int i = 0; i < matrix.length; i++) {// for entire 2d array (9 values)...
				
				  for (int j = 0; j < matrix[0].length; j++) {
						
				      worker[i][j] = matrix[i][j]-matrix2[i][j];// subtract and save into the new array. 
				    }
			}
			printer(worker);//print result
		}
		else{
			
			System.out.println("Sorry. Your matricies cannot be subtracted due to incompatible dimesions.");// message
		}
	}
	
	public static void printer(int[][] in){
		// PRINT ANY 3-D ARRAY
		
		for (int i = 0; i < in.length; i++) {// Print desired matrix
			
			for(int q=0; q<in[0].length;q++){
				
				System.out.print(" "+in[i][q]+" ");// print each term. We only use .print as opposed to .println so we can show dimensions 
			}
		System.out.println();// space for next row
	}

	}


}
