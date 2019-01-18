package Useful;

import submits.TextIO;

public class RomanNumerals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Create a simple Roman calculator for sums ONLY.
		 * All input is assumed to be correct. 
		 * Final sum must be conveyed in Roman Numerals.
		 * @author Naman Jain 6/5/2016
		 */
			// Declare variables
		String in;// This is the input.
		String first;// This is the first Roman numeral found.
		String second;// This is the second one.
		
		int one;// This is the English number that will be converted from the first Roman numeral.
		int two;// This is the second English number.
		int total;// This will be the sum of the numbers.
		
		String out;// This will be the final sum Roman Numeral.
		
		System.out.println("Enter a Roman Sum:");// Asks for command.
		
		in=TextIO.getln();// Get the Assumed accurate input.
		
		first=numberOne(in);// We break the Roman Numeral that comes before the '+' sign.
		
		second=numberTwo(in);// Now we get the second number after the '+'.
		
		one=convertToNormal(first);//Now we convert them into modern numbers.
		two=convertToNormal(second);// Ditto.
		
		total=one+two;// Add to get the sum.
		
		out=backToRome(total);// Convert the modern number back to Roman.
		
		if(total<1000){
		// Only if the sum is less than 1000...
		System.out.print(in+out);// Print desired line.
		}
	}
	
	public static String numberOne(String in){
		// Find the '+' sign and keep only letter before it.
		
		String out = "";// output starts blank.
		
		for(int i=0;in.charAt(i)!='+';i++){
			//Checks each letter until the letter + shows up.
			out=out+in.charAt(i);// Stores those letters as the output.
		}
		return out;// Returns the first roman numeral.
	}
	
	public static String numberTwo(String in){
		// Same as numberOne but keeps after the '+' sign.
		
		// Declare variables.
		String out = "";// This is the original output but needs to be flipped.
		
		String newOut="";// This is the flipped output.
		
			for(int i=(in.length())-2;in.charAt(i)!='+';i--){
				// Check the string backwards until '+' is detected.
				// Note. We use in.length()-2 because we want to ignore the equal sign.
				
				out=out+in.charAt(i);// The string after the '+' sign is recorded.
				
				//i.e II+DCCCLXXXVIII. out becomes IIIVXXXLCCCD.
			}
			for(int x=out.length()-1; x>-1;x--){
				// The loop checks starts with the last char and records it.
				// The string it mirrored.
				
				newOut=newOut+out.charAt(x);// The output is modified. 		
			}
		return newOut;// return the output.
	}
	
	public static int convertToNormal(String in){
		// This method converts any Roman numeral into modern numbers.	
		
		// Declare Variables.
		char[] exam=new char[in.length()];// Create an array of letters.
		int [] modern=new int [in.length()];// Convert each char into a modern int.
		int total=0;// output. Starts off as nothing.
		
			for(int i=0;i<=in.length()-1;i++){
				// Take the input and break it into letters.
				exam[i]=in.charAt(i);	
			}
			
			for(int i=0;i<=(in.length())-1;i++){
				// now each letter can be classified as a number.
				
				if(exam[i]=='I'){
					// if I, then value is 1
					modern[i]=1;	
				}
				else if (exam[i]=='V'){
					// if V, then value is 5
					modern[i]=5;
				}
				else if (exam[i]=='X'){
					// if X, then value is 10
					modern[i]=10;
				}
				else if (exam[i]=='L'){
					// if L, then value is 50
					modern[i]=50;
				}
				else if (exam[i]=='C'){
					// if C, then value is 100
					modern[i]=100;
				}
				else if (exam[i]=='D'){
					// if D, then value is 500
					modern[i]=500;
				}
				else if (exam[i]=='M'){
					// if M, then value is 1000
					modern[i]=1000;
				}
			}
			
			
			total=modern[modern.length-1];// The sum starts off with the last amount.
			
			for(int i=modern.length-1;i>0;i--){
				// we will check the values from last to beginning
				// i.e.  100,50,5,1,1,1,  will be checked like this 1,1,1,5,50,100.
				
				if(modern[i]>modern[i-1]){
					// if the current letter value is greater than the one before it...
					
					total=total-modern[i-1];// subtract the past value.
				}
				else if (modern[i]<modern[i-1]||modern[i-1]==modern[i]){
					// if the current letter value is less or equal to the previous value...
					
					total=total+modern[i-1];// Add the past value.
				}
				
				
			}
		return total;// return the converted value.
	}
	
	public static String backToRome(int in){
		
		int x=in;// This the the variable that needs to be converted.
		int check;// We will use this variable to tackle many problems. 
		String total="";// This is the output. Starts off as a blank string.
		
		if (x>1000){
		// if the value if greater than 1000.
			
			System.out.println("CONCORDIA CUM VERITATE");// Give them this statement
		}	
			// If the number is less than 1000 it its valid.
			// We will first remove the hundreds term.
		
		else if(x>=900){
			// If it is 900 or more...
			
			total=total+"CM";// Our string will start off as CM.
			x=x-900;// We take away 900 from the number to get the 50's and 10's place.
		}
		else if(x>=500){
			// Now the number is between 500-800.
			
			check=(x/100)-5;// We will check how many hundreds are after 500. 600 has one extra hundred.
			x=  x-(x/100)*100;// X will be reduced by the value based on the hundred term.
			total= total+"D";// The string will now have D for the 500...
			
				for(int q=check;q!=0;q--){
					// AND a C for each extra hundred. 
					total=total+"C";// We add this to the end of the string each time.
				}
		}
		else if(x>=400){
			// Another special case. When input is 400, you will write like 500-100...
			
			total=total+"CD";// SO Romans write CD.
			
			x=x-400;// Reduce this term to work on other terms later.
		}
		else if(x<400){
			// From 100-300...
			
			check=x/100;// Divide by 100 to find out how many hundreds terms.
				
			for(int q=check;q!=0;q--){
				
				// Use for loop to add each terms letter.
				total=total+"C";
				
				x=x-100;// And Subtract the terms to let the lower terms.
			}
		}	
	
		
		if(x<100){
			// This tackles the 50s and 10s place.
			
			if(x>90){
				//90-99.Special case
				
				x=x-90;	// remove 90 to get the one's term.
				
				total=total+"XC";// Add XC to the string.
			}
			else if(x>50){
				// 50-80. Else if because it only works if the above is not true.
				
				check=(x/10)-5;// find the 10's, then subtract to find the extras.
				x=x-50;// Reduce by 50.
				
				total=total+"L";// Add letter L to signify 50.
				
				for(int q=check;q!=0;q--){
					// Remove each extra hundred term.
					
					x=x-10;// Reduce.
					
					total=total+"X";// Add an X for each one.
				}
			}
			else if(x>=40){
				// 40-49.Special case
				
				x=x-40;// reduce by 40.
				
				total=total+"XL";// This is how 40 is written.
			}
			else if(x>=10){
				// 10-30.
				
				check=x/10;// Find number of terms.
				
				for(int q=check;q!=0;q--){
					// Use number of terms to...
					
					x=x-10;// Remove it for the one's term.
					
					total=total+"X";//Add X for each term.
				}
			}
		}
		
		if(x<10){
			// Ones term.
			
			if(x==9){
				// When the number is 9. Special case.
				
				total=total+"IX";// Written as IX.
			}
			else if(x>=5){
				//5,6,7,8.
				
				check=x-5;// Count number of extras.
				
				total=total+"V";// Add V to signify 5.
				
				for(int q=check;q!=0;q--){
					// Add an I for each extra term.
					
					total=total+"I";
				}
			}
			else if(x==4){
				// Special case.
				
				total=total+"IV";// Written as this.
			}
			else if(x<4){
				// 1,2,3
				
				for(int q=x;q!=0;q--){
					// Add an I for each number.
					
					total=total+"I";
				}
			}
			
		}
	return total;	// Return the new Roman Numeral String.
		
	}
	
}
