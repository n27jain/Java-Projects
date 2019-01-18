package selectionSort;

import submits.TextIO;

public class SelectionNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *This app uses selection sort to arrange 20 names in alphabetically order.
		 *NOTE: When author says string with lowest value he means 
		 * that the string that is alphabetically earlier than the string it is being compared to.
	 	 * @author Naman Jain 11/18/2016
		 */
		
	TextIO.readFile("NameInputs.txt");// Read our input
		
		String[] list = new String[122];// We will only review 122 Strings.
		
		for(int i=0;i<122;i++){// for loop that gets a new String per line up to 122 Strings. 
			list[i]=TextIO.getln();// we add to the array the new line added.
		}
		
		for(int x=0; x<list.length; x++){
			// set each of the index in the array.
			
			String check= list[x];// The checked String is temporary this changes along with the index.
			int index= x;// We use this String to know which String to point to.
			//It will point to the String in the array that is the lowest value. 
			
			for(int i=x+1; i<list.length;i++){
				// Check the String in the array after current index being checked.
				
				if (list[i].compareToIgnoreCase(list[index])<0){
					// if our checked String is less value then the current lowest value String we have found. 
					index=i;// Our pointer points to the current index unless a String in another index is lesser.	
				}	
			}
			String tempo= list[index]; // temp is the temporary value that is the value of the lowest String in the remaining array unchecked.
			list[index]=check;// The lowest pointer is replaced with the String that was initially being checked. 
			list[x]=tempo;// The initially checked String is replaced with the lowest unchecked array String.	
		}

		for(String x : list){// PrintStream
			
			System.out.println(x);// print each string in the array	
		}

	}

}
