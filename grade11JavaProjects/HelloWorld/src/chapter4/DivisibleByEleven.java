package chapter4;

import TextIO;

public class DivisibleByEleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		long out=0;// initialize the input
		System.out.println("What number would you like to check for 11-divisibility?");// Ask for input
		
		out=TextIO.getlnLong();// use getlnLong to so that you can enter unlimited numbers // This will be saved for later.
		String check=convert(out);// This string determines length of the number and decides if its too long.
		
			out=checkInput(check,out);// check to make sure user does not exceed 12 digits!
		
		long in=out;//this is the long number that the program will be modifying.
	
		in=withoutTrailZeros(in);//Get rid of the trailing zeros
		
		String convert=convert(in);// convert the new long to string.
		
		int starter=convert.length();// the starting number is the length of the convert string.
		
		long edited = 0;// the new edited long the will be output. 
		
		
			edited=workAllgo(edited,starter,convert);// Use the algorithm method to get the final 2 digits.
		
		
	System.out.println(edited);	
			results(edited,out);// Final decision to let user know if their number is divisible by 11;
			
			
		
		
	
	}
	public static void results(long edited, long out){
		// Final decision to let user know if their number is divisible by 11;
		
	
		if(edited%11==0&&edited>10){
			//If the final number is divisible by 11... but is not less than 11. because (10%11==0) also.
			System.out.println("The number " +out+" is divisible by 11!");// Let the user know their number is divisible by ll;
		}
		else if(edited%11!=0||edited<11){
			// when the final number is not divisible by 11... or it is less than 11...
			System.out.println("The number " +out+" is not divisible by 11!");// Let the user know their number is not divisible by ll;
		
		}
	}
	public static long  checkInput(String check, long out){
		//method that checks to make sure only 12 digits have been entered.
		
		while(check.length()>12){
			// while the number is greater than 12 digits in length...
			
			System.out.println("That number is too big. Only 12 digits allowed!");// Let user know!
			
			out=TextIO.getlnLong();// getlong again!
			
			check=convert(out);// make a new check string to get the job done!
		}
		return out;// return the correct long number
	}
	
	public static long workAllgo(long edited,int starter, String convert){
		// The main portion of the algorithm.
		if(convert.length()>2){
			// if the length of the long is greater than 2... we apply the algorithm.
		
			for(int i=starter;convert.length()>2;i--){
				//for loop that checks each number of the long number starting for the last number to the first. 
				
				char a= convert.charAt(i-1);// Last number is now viewed as a char. (Char 1 = convert[0];)
				
				int minus=charConvert(a);// The char a is converted into an int to be later subtracted from the edited long.
				
				int max=i-1;// This number will be useful for trimming the number. Now the maximum length of the number is one less than before.
				
				convert=trimOut(convert,max);// TrimOut method is used. This is now stored as a string.
				
				edited=StConvert(convert);// The edited long is equal the string when converted into a long value.
			
				edited=edited-minus;// The minus value previously taken is taken out of the new edited long to produce the desired number for the next loop.
		
				convert=convert(edited);// convert the new number into the string.
				
				System.out.printf("%-40s",convert);// print out the string.
				
				System.out.println("");// leave space.
			}
		}
		else if(convert.length()<=2){
			// However, if the long is already 2 digits...
			edited=StConvert(convert);// We use this long automatically to finish the app.
		}
		return edited;// return the new 2 digit long.
	}
	
	public static long withoutTrailZeros(long in){
		// Method gets rid of trailing zeros.
		while(in%10==0){
			in=in/10;
			System.out.print(in);// allows unlimited digits.
	
			System.out.println("");// leave space
		}
		return in;// return long without the trailing zeros
	}

	public static String convert(long value){
		// method converts long into string
		String convert="" + value;// convert
		return convert; // return the converted string
	}
	
	public static String trimOut(String convert,int max){
		// String method that trims the string if it is too big.
		
	int maxLength=max;// this the maximum length of the string.
	
	String input=convert;// The input is the string the is put into the method.
	
	      return input.substring(0,maxLength);// return only up to the maximum.     
	}
	
	public static int charConvert(char a){
		// Converts char to int.
		
		int out=Character.getNumericValue(a);// converts...
		
		return out;// returns converted .
	}
	
	public static long StConvert(String convert){
		
		// Converts string back into long number.
		
		long decimal = Long.parseLong(convert);// converts
	
		return decimal;// returns converted long. 
	}
}
