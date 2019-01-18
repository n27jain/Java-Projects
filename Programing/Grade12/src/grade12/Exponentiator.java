package grade12;

public class Exponentiator {

	public static void main(String[] args) {
		
		/**
		*Create an app that asks the user for a base and an exponent and calculates [base][exponent] recursively.
		* The exponent must be a positive whole number, but the base may be any rational number.
		* You may not use Math.pow(), obviously.
		* * @author Naman Jain 04/13/2017
		*/
		
		System.out.println("Enter the base:");// take the base value
		
		double base= TextIO.getDouble();// this is a double value because a decimal can be present
		
		int power;// the power number
		
		do {
			
		System.out.println("Enter the exponent. It cannot be less than 0. ");//ask for the exponent.
		
		 power= TextIO.getlnInt();// take it. It will always be a positive int.
		 
		}while(power<0);// We keep asking in case the input is invalid.
		
		
		double out=work(power, base);// use the work method. This is the recursion method.
		
		System.out.println(out);// Print out the double value that is calculated
		
	}

	
	public static double work(int power, double base){ // we take the base and the power and then calculate
		 
	   if(power==0)// equal to 0
		   

	        return 1;// return 1. x^0=1 (always true)
	   else
	      return work(power - 1, base) * base;// 5^5= 5^4*5
	   
	}
	
		
	
}
