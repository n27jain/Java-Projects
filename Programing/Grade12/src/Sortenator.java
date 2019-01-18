import submits.TextIO;


public class Sortenator {
	/**
	 * 
	 *We read 2000 doubles and then we compare the time each sorting method takes.
	 *
	 * * @author Naman Jain 12/20/2016
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] numbArray=numbArray();// our arrayMaker method
		bubble(numbArray);// bubbleSorting
		
		numbArray=numbArray();// //refresh the array
		insert(numbArray);// insertSorting
		
		numbArray=numbArray();// refresh the array
		selection(numbArray);//numbArray
		
		
	}
	
	public static double[] numbArray (){
		// reads from textfile
		double [] out= new double [2000];// we have 2000 doubles to arrange
		
		TextIO.readFile("Double2000.txt");// Read our input
		
		for(int i=0;i<2000;i++){// While loop that runs until the last line is read.
			
			String take= TextIO.getln();
			double convert= Double.parseDouble(take);// convert into double
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
			  
			  
			  if (checking[i - 1] < checking[i]) {// If the value before the current one is higher...
			      temp = checking[i-1]; // temp is the value that if before the current.
			      checking[i-1] = checking[i];// we swap the values
			      checking[i] = temp;// swap again
			      sorted = false;// not true because we have made a switch.
			    } // if
			  } // for
			} while (!sorted);// keep doing this so long as there is a switch required
		
		
		end=System.currentTimeMillis();// Count the time when we stopped.
		
		duration= (end-start)/1000.0;// Find difference to find time.
		
		System.out.println("The time bubblesort took was : "+duration);// return message
	
		
	}
	
	public static void insert(double [] numbArray){
	// We're gonna use insertSort
		
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
			  
			  temp=checking[i];// Our double that is to be checked is int i index.
			  
			  int x= i;
			  
				  while(x>0&&temp<checking[x-1]){
					 // When our checked value is less then the value before.
		
					  sorted=false; // Because the while loop has been run, a switch is required and detected.
					  checking[x]=checking[x-1];// Because we know the past double is suppose to come after the tested double, will shift the double to the next index.
					 
					  x--;// The x counts down each time to test a previous double. 
					  // When the condition is not true, it means that any previous index is alphabetically correct and the checked double is in the right place.
				  }
			  if (sorted==false){
				  checking[x]= temp;// If we did some sorting, we look at the last index checked and and replace it with the double we checked. 
			 
			  }
		} 
		end=System.currentTimeMillis();//final time;
		duration= (end-start)/1000.0;// Find difference to find time.
		System.out.println("The time InsertSort took was : "+duration);
		
		
		
	}
	
	public static void selection(double [] numbArray){
		// Were gonna use selectionSort
		
		double [] checking=numbArray;// We don't want to change our original file. The other methods need the same unorganized file.
		long start;// Our initial start time.
		long end;// Our end time
		double duration;// find difference between start and end and you will find duration.
		
		start=System.currentTimeMillis();// start counting the initial time
		for(int x=0; x<checking.length; x++){
				// set each of the index in the array.
				
			double check= checking[x];// The checked double is temporary this changes along with the index.
			int index= x;// We use this int to know which double to point to. It will point to the double in the array that is the lowest value. 
			
			for(int i=x+1; i<checking.length;i++){
				// Check the first number in the array after current index being checked.
				if (checking[i]<checking[index]){// if our checked double is less value then the current lowest value that the pointer is pointing to. 
					index=i;// Our pointer points to the current index unless a number in another index is lesser.	
				}	
			}
			double tempo= checking[index]; // temp is the temporary value that is the value of the lowest double in the remaining array unchecked.
			checking[index]=check;// The lowest pointer is replaced with the value that was initially  being checked. 
			checking[x]=tempo;// The initially checked value is replaced with the lowest unchecked array value.
			
		}
		end=System.currentTimeMillis();// start counting the initial time
		duration= (end-start)/1000.0;//find the duration
		System.out.println("The time selectonSort took was : "+duration);// return message
		
			
}
	
}
