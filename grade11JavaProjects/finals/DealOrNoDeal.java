package chapter4;

public class DealOrNoDeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *DealOrNoDeal App helps a contestant make the decision of deal or no deal.
		 *App input includes the number of cases opened.
		 *Asks for all the cases that have been opened to determine what has been left over.
		 *Calculates what has been left over, and find the average.
		 *Asks for bankers offer.
		 *If the bankers offer is higher than the average then DEAL. 
		 *Otherwise, No DEAL.
		 * @author Naman Jain 6/5/2016
		 */
		
		
		int[]populate=populate();	//Create an array that has one value as a specific money amount in a case.
		int[]opened=WhatIsOpened();	// Create a new array that has the list of all cases that have been opened.
		
		
		int[]removed=removeCases(populate,opened);// We can remove the opened cases from the populated array.
		int average= average(removed,opened);// Now we can add the cases that were not removed to find the average of the unopened cases.
		
		System.out.println("What is the Banker’s offer? ");// Ask what the banker is offering.
		int banker=TextIO.getInt();// Get the bankers offer.
		
	
		System.out.println("The average of the remaining briefcases is $ "+average+"...");// Let the user know the average of the remaining cases.
		
		if(banker>average){
			// If the banker is ready to give more than the average...
			System.out.println("");// Space
			System.out.println("Deal! ");// DEAL!!!
		}
		else if(banker<=average){
			// If the Banker is stingy and offers less than or equal to the average of the remaining cases...
			System.out.println("");
			System.out.println("No Deal! ");// NO DEAL!!!
		}
	}

	
	
	
	private static int[]populate(){// This method generates 6 unique numbers.
		
		int[]pop=new int[10];// The output array.
		

		pop[0]=100;//100 dollars for case 1. NOTE case 1 will be converted to case 0.
		pop[1]=500;//same. case 2 will be converted to case 1 and so on. 
		pop[2]=1000;
		pop[3]=5000;
		pop[4]=10000;
		pop[5]=25000;
		pop[6]=50000;
		pop[7]=100000;
		pop[8]=500000;
		pop[9]=1000000;		
		
		return pop;// return the new array!!!
	}
	private static int[] WhatIsOpened(){
		
		int check=0;// This will be the case number that will be checked.
		int count=0;// This is the number of cases that will be opened. 
		
		while(count>10||count<1){
			//Ask for how many cases are open.
			// While the input is invalid keep doing so.
			
			System.out.println("How many briefcases have been opened? Enter from 1-10.");// ask for quantity of briefcases opened.
			count=TextIO.getInt();// Get the number.
		}
		int [] eliminate=new int[count];// This is the outputed array.
		
		for(int i=1;i<=eliminate.length;i++){
			// Ask for all of the cases used and remove them from the array.
			
			System.out.println("Enter briefcase number "+(i));// Asks for briefcase.
			
			check=TextIO.getInt();// takes the number.
			
			while(check<1||check>10){
				// while case number is less than 1 or greater than 10.
				System.out.println("That briefcase doesn’t exist!");// It does not exist.
				System.out.println("Enter briefcase number "+(i));//ask again.
				check=TextIO.getInt();// get number again.
			}
			
				for(int t=0;t<i;t++){
				// Check if the case has already been used.
					
					while(check==eliminate[t]){
			
						t=0;//restart the loop to check for repeat...
						
						System.out.println("That briefcase has already been opened!");// Let them know it already exists.
						System.out.println("Enter briefcase number "+(i));// but first ask for a new one.
						
						check=TextIO.getInt();// get a new check value.
						
						while(check<1||check>10){
							// while case number is less than 1 or greater than 10.
							System.out.println("That briefcase doesn’t exist!");// It does not exist.
							System.out.println("Enter briefcase number "+(i));//ask again.
							check=TextIO.getInt();// get number again.
						}
					}
					if(check!=eliminate[t]&&t==i-1){
						// when the loop has gone by and is on the last counter.
						// If the values did not match the past value...
						
						eliminate[i-1]=check;	// Check is the new value and replaces the current briefcase that is being asked.
						
					}
					
				}
		
			
		}
		return eliminate;// return edited array.
	}
	
	private static int[]removeCases(int[]populate,int[]opened){
		// This method removes the selected cases from the array.
		int[]out=populate;// the outputed array. Starts off ad the original array.
		
		for(int i=0;i<opened.length;i++){
			// checks each of the cases that will be removed.
			out[opened[i]-1]=0;// makes each of the corresponding cases 0.
			// Remember case 1= case 0. Case 2= case 1 and so on.
		}
		
		return out;// return edited array.
		
	}
	
	private static int average(int[]removeCases,int[]opened){
		// This method calculates the average of the remaining cases.
		
		int sets=10-(opened.length);// This the number of sets that are not opened. 
		//We take away the number of sets opened from 10 to get this value.
		int total=0;// This is the int that contains the sum of all of the unopened cases.
		int out;// This will be the return value.
		
		for(int i=0;i<removeCases.length;i++){
			// For loop that checks each term in the removeCases array, and adds it to find the total sum.
			// If the case is empty, it will just add 0. 
			
			total=total+removeCases[i];// total is the past total plus the current cases added.
		}
		out=total/sets;// Average formula includes the sum divided by the number of unopened cases.
		return out;// return the average. 
	}
}