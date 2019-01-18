package chapter4;

import TextIO;

public class testings {

	public static int errorCheck(String[] args) {
		int check;
		
		while(check<1||check>10){
			// while case number is less than 1 or greater than 10.
			System.out.println("That briefcase doesn’t exist!");// It does not exist.
			System.out.println("Enter briefcase number "+(i));//ask again.
			check=TextIO.getInt();// get number again.
		}

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
}

