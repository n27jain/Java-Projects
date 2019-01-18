package grade12;

import TextIO;

public class NumberSworder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TextIO.readFile("NewInputs.txt");// Read our input
		
		
		int[] intArray = new int[20];// We will only review 20 ints.
		
		for(int i=0;i<20;i++){// for loop that gets a new int per line up to 20 ints. 
			intArray[i]=TextIO.getlnInt();// we add to the array the new line added.
		}
		
		int temp;
		boolean sorted;// a true/ false motion. 
		// Traverse the list until no more swaps made
		do {
		  sorted = true; // Initialize default
		  // Start the loop from 1, not 0
		  for (int i = 1; i < intArray.length; i++) {
		    // If elements i-1 and i are out of order,
		    // then swap elements i-1 and i
			  
			  
		    if (intArray[i - 1] > intArray[i]) {// If the value before the current one is higher...
		      temp = intArray[i-1];// temp is 
		      intArray[i-1] = intArray[i];
		      intArray[i] = temp;
		      sorted = false;
		    } // if
		  } // for
		} while (!sorted);
		
		for(int x : intArray){
			System.out.println(x);
		}
	}

}
