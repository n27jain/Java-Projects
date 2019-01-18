package selectionSort;

import submits.TextIO;

public class SelectionNumSworder {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *This app uses selection sort to arrange 20 numbers from least to greatest. 
	 	 * @author Naman Jain 11/18/2016
		 */
		TextIO.readFile("NewInputs.txt");// Read our input
		
		
		int[] intArray = new int[20];// We will only review 20 ints.
		
		for(int i=0;i<20;i++){// for loop that gets a new int per line up to 20 ints. 
			intArray[i]=TextIO.getlnInt();// we add to the array the new line added.
		}
		
		for(int x=0; x<intArray.length; x++){
			// set each of the index in the array.
			
			int check= intArray[x];// The checked integer is temporary this changes along with the index.
			int index= x;// We use this int to know which int to point to. It will point to the int in the array that is the lowest value. 
			
			for(int i=x+1; i<intArray.length;i++){
				// Check the first number in the array after current index being checked.
				if (intArray[i]<intArray[index]){// if our checked int is less value then the current lowest value that the pointer is pointing to. 
					index=i;// Our pointer points to the current index unless a number in another index is lesser.	
				}	
			}
			int tempo= intArray[index]; // temp is the temporary value that is the value of the lowest integer in the remaining array unchecked.
			intArray[index]=check;// The lowest pointer is replaced with the value that was initially  being checked. 
			intArray[x]=tempo;// The initially checked value is replaced with the lowest unchecked array value.
			
		}
		for(int x : intArray){// Print stream
			System.out.println(x);
		}
		
		
	}

}
