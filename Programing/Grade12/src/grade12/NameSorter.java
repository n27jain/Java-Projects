package grade12;

import submits.TextIO;

public class NameSorter {

	public static void main(String[] args) {
		
		/**
		 * For this app we are given 10 strings that have to be arranged alphabetically. 
		 * We assume that the input is accurate and upper/lower cases can be ignored. 
	 	 * @author Naman Jain 01/11/2016
		 */
		
	TextIO.readFile("NameInputs.txt");// Read our input
		
		String[] list = new String[122];// We will only review 20 ints.
		
		for(int i=0;i<122;i++){// for loop that gets a new int per line up to 20 ints. 
			list[i]=TextIO.getln();// we add to the array the new line added.
		}
		
		System.out.println(" Here is the input given: ");// Title
		for(String x : list){// PrintStream
			
			System.out.println(x);// print each string in the array
			
		}
		
		System.out.println();//space
		
		String temp;// This will be the string that is the first string. It will replace the second string if the second string is alphabetically earlier. 
		
		boolean sorted;// a true/ false motion. 
		
		int count=0;// To see how many times the loop is played. 
		
		// Traverse the list until no more swaps made
		
		do {
			
		  count++;// Increase the amount of counting to see how many times the app does the while loop.
			
		  sorted = true; // Boolean starts of as true and will remain so if there are no switches made.
		  
		  for (int i = 1; i < list.length; i++) {
			  count++;// Increase the amount of counting to see how many time the app runs on sorting. 
			  
			  if(list[i-1].compareToIgnoreCase(list[i])>0){
				  count++;// Increase the amount of counting to see how many times the app checks the array.
				  // We are using comapareToIgnoreCase method.
				  // When one string has a letter that is a higher value,
				  // it means it is closer to z in the alphabet. 
				  // If this method returns a positive number it means that that string is alphabetically below the other one.
				  // A switch is then required.
				  // If 0 it means strings are same. 
				  // If negative value, this string comes alphabetically first.
				  
				  temp = list[i-1];// temp is the first string.
			      list[i-1] = list[i];// The first string is replaced with the second one.
			      list[i] = temp;// the second string becomes the first one. 
			      sorted = false;  // The statement is false because we have found a switch.
			  }
		  } 
		  
		} while (!sorted);// while the loop is not true we keep going...
		
		System.out.println(" Here it is sorted: ");//Title
		for(String x : list){// PrintStream
			System.out.println(x);// print each string in the new array.
			
		}
		System.out.println("The number of times ran " +count);
	}
}
