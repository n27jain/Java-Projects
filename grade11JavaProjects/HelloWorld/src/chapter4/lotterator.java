package chapter4;

import TextIO;

public class lotterator {
	/**
	 * an app that generates six unique random numbers
	 * between 1 and 49 and puts them into an array 
	 * – these are the winning numbers.
	 * Ask the user to guess one of the numbers
	 * Each time the user  guesses the app should tell the user whether it was a winning number or not.
	 * The player may have as many guesses as they want, to guess all six numbers. 
	 * @author Naman Jain 03/05/2016
     */
	
	
	public static void main(String[] args) {//This is the main method. All methods are in access here.
		// TODO Auto-generated method stub
		//
		int[]pop= new int[6];// This is the starting array. There are 6 numbers that will be generated.
		
		pop= populate();//The populate method is used to populate the six numbers into 6 unique numbers.
		
		System.out.println("I bet you can't guess my six numbers!");// Announce the challenge.
		
			for(int spec=1;pop[0]!=0||pop[1]!=0||pop[2]!=0||pop[3]!=0||pop[4]!=0||pop[5]!=0;spec++){
				// this loop calculates the number of times the app is used
				// It will run while the entire array does not contain a single 0.
				
				int pick=getUserNum();// Get the users guess using this method.
				
				int y = check(pop,pick); // Using the check method figure out if the number has been guess correctly.
				
				pop=removeFromArray(pop,y); // This method allows for the game to resolve what happens to the chosen number.
											// This method overwrites the old array and makes this the new array.
				
				System.out.println(" out of "+spec);// Once removeFromArray resolves, it will print the win or lose statement.
													// This is the added portion of the string that is completed 
													// to show the amount of guess that have been made.
			
				
			}// end of loop
			
	} // end of method
	
	
	private static int[]populate(){// This method generates 6 unique numbers.
		
	int[]pop=new int[6];// The output array.
	
		for(int i=0;i<pop.length;i++){// For loop that creates six random numbers. 
			
			int x=(int) (Math.random()*49+1);// random int x is a number form 1-49.
			
			for(int t=0;t<=i;t++){// This for loop verifies that the random int has not been used before.
									
				
				if (x!=pop[t]){// If the int has not been used it will be put into the array.
					pop[i]=x;	
					
				}
					
			}
			System.out.println(pop[i]);
			
			
				
			}
	return pop;// return the new array!!!
	
	
	}// end of method.
	
	
	private static int getUserNum(){// This is the method that asks for the guess;
		
		System.out.println("Please input a number from 1 to 49:");// Ask player for valid number.
		
		int x=TextIO.getInt();// Use getInt to get the guess.
		
		while(x>49||x<1){// While the number is not valid...
			
			System.out.println("That’s not between 1 and 49!");// give error message
			
			System.out.println("Please input a number from 1 to 49:"); // ask for the number again.
			
			 x=TextIO.getInt();// getInt again.
		}
		
		return x;// return the guess.
		
	}// end of method.
	
	
	
	private static int check(int[]populate,int getUserNum){// This method checks the array populate and the guess.
															// Then it outputs either -1 for the number not in array
															// Or the number itself that is in the array. 
		
		int check=-1;// Starts off as -1 output.
		
		for(int i=0;i<populate.length;i++){// For loop that searches every int in the array and compares it to the guess.
			
			if(getUserNum==populate[i]){// If the guess matches something...
				
				check=populate[i];// The output becomes the guess.
			}
		}
		
			return check;// Give the output
		
	
	}// End of method.
	
	
	
	
	private static int[]removeFromArray (int[]populate,int check){// This method replaces the old array with this new one;
		
		int[]x=populate;// allow our current output to be the previous array.
		
		int wow=1;// find out how many numbers have been guess correctly.
		
		for(int i=0; i<populate.length; i++){// For loop to check the zeros in the array. These will be used to show how many have numbers have been guessed correctly.
					
					if (populate[i]==0){// Whenever a zero is detected...
						
						wow++;// Add one to the amount guessed correctly.
					}
		}
		
					
		if(check==-1){// If the check method detects no match then we simply output this line;
			wow--;
		
			System.out.print("That's not one of my numbers! You've guessed "+wow);	// Give the statement.
			
		}
		
		
		
		for(int i=0; i<populate.length; i++){// Lastly, check and find the guessed number in the array if it even exists.
			
			if(populate[i]==check){ // when the guess matches the array...
				
				x[i]=0;// that number int the array is reduced to 0.
				
			System.out.print("You got one of my numbers! You've guessed "+wow);//Congratulate them!!!
			}
			
			
		
		}
		
		return x;// return the new array!
		
	}	// end of method.
	
}// end of file

