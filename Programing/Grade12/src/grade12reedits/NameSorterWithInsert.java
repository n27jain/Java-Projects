package grade12reedits;

import submits.TextIO;

public class NameSorterWithInsert {

public static void main(String[] args) {
		
		/**
		 * For this app we are given 10 strings that have to be arranged alphabetically. 
		 * We assume that the input is accurate and upper/lower cases can be ignored. 
	 	 * @author Naman Jain 11/18/2016
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
		
		int count=0;// We can use this int to determine how many loops the app takes to sort.
		
		// Traverse the list until no more swaps made
		
		
		  
		  for (int i = 1; i < list.length; i++) {
			  		// We will not check the first index (0) because the second index will be compared to the first.
			  sorted = true; // Boolean starts of as true and will remain so if there are no switches made.
			  count++;// Increase the amount of counting to see how many times the app runs the loop.
			 
			  temp=list[i];// Our string that is to be checked is int i.
			  
			  int x= i;
			  
				  while(x>0&&temp.compareToIgnoreCase(list[x-1])<0){
					 count++;// Increase the amount of counting to see how many times the app checks the array.
					  // We are using comapareToIgnoreCase method.
					  // When one string has a letter that is a higher value,
					  // it means it is closer to z in the alphabet. 
					  // If our string is supposed to be earlier than the compared string, .compareTo will out put a negative number.
					  // A switch is then required.
					  // If 0 it means strings are same. 
				
					  sorted=false; // Because the while loop has been run, a switch is required and detected.
					  list[x]=list[x-1];// Because we know the past string is suppose to come after the tested string, will shift the string to the next index.
					 
					  x--;// The x counts down each time to test a previous string. 
					  // When the condition is not true, it means that any previous index is alphabetically correct and the checked string si in the right place.
				  }
			  if (sorted==false){
			  list[x]= temp;// If we did some sorting, we look at the last index checked and and replace it with the string we checked. 
			 
			  }
		  } 
		System.out.println(" Here it is sorted: ");//Title
		
		for(String x : list){// PrintStream
			System.out.println(x);// print each string in the new array.
			
		}
		System.out.println("The number of times ran " +count);
	}
}


