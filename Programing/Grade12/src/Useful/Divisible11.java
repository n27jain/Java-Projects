package Useful;



import Useful.TextIO;
public class Divisible11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Naman Jain
		// 29/04/2016
		
		double in=0;
		System.out.println("What number would you like to check for 11-divisibility?");// Ask for number.
		
		in=TextIO.getlnDouble();// get double so that u can enter unlimited numbers
		double out=0;
		
		
				

		while(in%10==0){
			
			out=in/10;
			 
			System.out.printf("%1.0f", out);// allows unlimited digits.

			System.out.println("");
		
		}
		
		int maxLength=0;	
		String convert="" + out;
		char at;
		int minus;
		int stringToInt=0;
		
		for(int i=convert.length();convert.length()>2;i--){
			
			maxLength=i-1;
			
			at=convert.charAt(i);
			
			minus=Character.getNumericValue(at);
			
			convert=convert.substring(0, maxLength);// trim
			
			stringToInt=Integer.parseInt(convert);
			
			stringToInt=stringToInt-minus;
			
			System.out.println(stringToInt);
			
			convert=""+stringToInt;
			
		}
				
				
				
				
		
			
	}		
	
}

	