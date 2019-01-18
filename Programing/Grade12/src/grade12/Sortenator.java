package grade12;

import java.util.ArrayList;

import searching.TextIO;
import searching.list;

public class Sortenator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		double[] numbArray=numbArray();// our arrayMaker method
		bubble(numbArray);// bubbleSorting
		
	}
	
	public static double[] numbArray (){
		double [] out= new double [2000];// we have 2000 doubles to arrange
		
		TextIO.readFile("RosterNames.txt");// Read our input
		
		for(int i=0;i<2000;i++){// While loop that runs until the last line is read.
			
			String take= TextIO.getln();
			double convert= Double.parseDouble(take);
			out[i]=convert;// keep adding the line to the array.
		}	
		TextIO.readStandardInput();// Return to normal reading method.
		return out;// We return the generated array.
	}
	
	public static void bubble(double [] numbArray){
		// Were gonna use bubbleSort
		double [] checking=numbArray;// We don't want to change our original file. The other methods need the same unorganized file.
		long start;// Our initial start time.
		long end;// Our endtime
		double duration;// find difference between start and end and you will find duration.
		
		double temp;
		boolean sorted;// a true/ false motion. 
		// Traverse the list until no more swaps made
		start=System.currentTimeMillis();// start counting the intial time
		do {
		  sorted = true; // Initialize default
		  // Start the loop from 1, not 0
		  for (int i = 1; i < checking.length; i++) {
		    // If elements i-1 and i are out of order,
		    // then swap elements i-1 and i
			  
			  
			  if (checking[i - 1] > checking[i]) {// If the value before the current one is higher...
			      temp = checking[i-1]; 
			      checking[i-1] = checking[i];
			      checking[i] = temp;
			      sorted = false;
			    } // if
			  } // for
			} while (!sorted);
		
		
		end=System.currentTimeMillis();// Count the time when we stopped.
		
		duration= start-end;// Find difference to find time.
		
		System.out.println("The time bubblesort took was : "+duration);
		
	}
	
	public static void insert(double [] numbArray){
	// Were gonna use insertSort
		
		double [] checking=numbArray;// We don't want to change our original file. The other methods need the same unorganized file.
		long start;// Our initial start time.
		long end;// Our endtime
		double duration;// find difference between start and end and you will find duration.
		double temp;// This will be the string that is the first string. It will replace the second string if the second string is alphabetically earlier. 
		
		boolean sorted;// a true/ false motion. 
		
		start=System.currentTimeMillis();// start counting the initial time
		for (int i = 1; i < checking.length; i++) {
	  		// We will not check the first index (0) because the second index will be compared to the first.
			  sorted = true; // Boolean starts of as true and will remain so if there are no switches made.
			  
			  temp=checking[i];// Our string that is to be checked is int i.
			  
			  int x= i;
			  
				  while(x>0&&temp<checking[x-1]){
					 
					  // We are using comapareToIgnoreCase method.
					  // When one string has a letter that is a higher value,
					  // it means it is closer to z in the alphabet. 
					  // If our string is supposed to be earlier than the compared string, .compareTo will out put a negative number.
					  // A switch is then required.
					  // If 0 it means strings are same. 
				
					  sorted=false; // Because the while loop has been run, a switch is required and detected.
					  checking[x]=checking[x-1];// Because we know the past string is suppose to come after the tested string, will shift the string to the next index.
					 
					  x--;// The x counts down each time to test a previous string. 
					  // When the condition is not true, it means that any previous index is alphabetically correct and the checked string si in the right place.
				  }
			  if (sorted==false){
				  checking[x]= temp;// If we did some sorting, we look at the last index checked and and replace it with the string we checked. 
			 
			  }
		} 
		end=System.currentTimeMillis();//final time;
		duration= start-end;// Find difference to find time.
		System.out.println("The time InsertSort took was : "+duration);
		
	}
	
	public static void insert(double [] numbArray){
		// Were gonna use insertSort
			
			double [] checking=numbArray;// We don't want to change our original file. The other methods need the same unorganized file.
			long start;// Our initial start time.
			long end;// Our endtime
			double duration;// find difference between start and end and you will find duration.
			double temp;// This will be the string that is the first string. It will replace the second string if the second string is alphabetically earlier. 
	

}
