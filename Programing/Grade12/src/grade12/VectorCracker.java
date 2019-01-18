package grade12;

import submits.TextIO;

public class VectorCracker {
	/**
	 *VectorCracker App helps  students add their vectors for physics homework.
	 *Input will be written as 130 [W60N].
	 *Any errors will be detected, and user will be asked to enter again.
	 *If the net vector is 0. User will be given in the information, "No Displacement".
	 *Consists of arrayMaker Method that stores a set amount of vectors.
	 *checker method that checks for all vector errors and formatting errors, indicates if the input is valid, and displays error messages. 
	 *decimalChecker method is a simple for loop that verifies if a numerical value has more than one decimal point.
	 *component method that breaks each string vector into x and y components.
	 *addem method, that does the remaining work, by adding the x and y arrays to find displacement and uses tan function to calclaute degree.
	 *This is all done nicely and formatted to a certain decimal point.
	 * @author Naman Jain 04/10/2016
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main Method. Completes all the work.
		
		int vectorCount;// int vectorCount this is the variable that stores the amount of vectors that will be added.
		
		// Start up message. 
		System.out.println("Welcome Master.");
		System.out.println("I am VICTOR and welcome to VecotorCracker©");
		System.out.println("");//space
		System.out.println("");// space
		System.out.println("Please enter the amount of vectors that I will have to add. ");
		
		vectorCount=TextIO.getlnInt();// GetlnInt to get the number of vectors that will be added.
		// Alight!!! If use enters a weird int, it will use all numbers before the weirdness. i.e 123.dfajskfjsd= 123.
		
		System.out.println("OK! We will create "+vectorCount+" vectors.");// message.
		
		String[] entry= arrayMaker(vectorCount);// Array entry. use arrayMaker method to create the array.
		String addwork=components(entry);// This string is the final output. We use the component method.
		System.out.println("OK! Were done your work! Your Welcome!!!");// Display the work has been completed.
		System.out.println(addwork);// Print out the final vector.
		System.out.println("");//space
		System.out.println("");// space

	}
	
	public static String[] arrayMaker(int vectorCount){
		
		// arrayMaker method creates the array.
		// It uses vectorCount to determine how long the array must be. 
		//It calls for the checker method to detect errors, if any.
		
		String[]out=new String[vectorCount];
		int checker;// start by making checker 99. This will help start the while loop.
		
		for(int i=0;i<vectorCount;i++){
			checker=99;
			
			while(checker==99){
				// while the input is not verified
				
				System.out.println("");
				System.out.println("Please enter vector "+(i+1)+" in the format bellow:");
				System.out.println("First enter the magnitude followed by a space.");
				System.out.println("Then use [ bracket followed by the first direction and degree value.");
				System.out.println("Lastly, put the final direction and close with ] bracket.");
				System.out.println("i.e 130 [N30W] or 130 [W60N] or 130 [N].");
			
				out[i]=TextIO.getln();// Keep getting the new vector.
			
				checker=checker(out[i]);// now we check for errors and if any, how many.
			
				if(checker==0){// if there are no errors...
					
					checker=0;// give exit condition. When checker is not 99  the loop exits.
				}
				else if(checker>0){
					// if there are many errors.
					System.out.println("There are "+checker+" errors in total!!!");// let the user know how many.
					System.out.println("Enter it again");// ask to enter again.
					checker=99;// reset the loop.
				}
			}
		}
		return out;// return the new filled arrays. 
	}
	public static int checker(String check){
		// this method checks the inputed vectors. 
				// Displays all of the errors made.
				// Uses a ton of if statements instead of else if statements.
				// This is because the vectors must undergo all of the error checks so that the error can be displayed.
				// This method can be called multiple times, but does not convert the string into appropriate format.
				
				String out=check;// We will target the string from the array that is being inspected.
				char d1;	// First direction followed by the [
				char d2;// Second direction.
				char br1;// first bracket
				char br2;// second bracket
				double degree;	// if a number is detected, it must convert degree1 and degree2( if valid) into a number.
				int numOfErrors=0; // In case the user makes more than one mistake.
				String [] parts;// When there is a space, it will break the string into an array of strings.
				
				if (check.contains(" ")==false){
					// now you must look really far up to see the if statement that is being compared.
					// If there is not space bar applied.
					System.out.println("Error 9. There is no space int the input. We cannot procced with a space.");// Error 9.
					numOfErrors++;
				}
				// Note: The rest of the errors cannot be displayed because they require a space in the input for accessibility.
				
				else if(out.contains(" ")){// if there is any space char...
					
					parts= out.split(" ");// When there is a space, it will break the string into an array of strings.
					
					if(parts.length!=2){
						// If there is more than one space.
						// If there is only 2 strings... nothing happens because systemError is still 0.
						System.out.println("	Error 1. User has entered more than one space."); // This is Error 1. 
						numOfErrors++;// counts number of errors.
					}
					else if(parts.length==2){
						
					d1=parts[1].charAt(1);// first direction is d1.
					d2=parts[1].charAt(parts[1].length()-2);//second direction.
					br1=parts[1].charAt(0);// first bracket
					br2=parts[1].charAt(parts[1].length()-1);// last bracket.
					
						if(parts[0].matches("[0.0-9.0]+")==false){
							// .matches checks if a string only contains the range within the square brackets.
							// We need to make sure it is a double value. This is because the magnitude can be a decimal.
							// if the string does not contain just numbers...
							// It must have any other symbol besides numbers.
						
							System.out.println("	Error 2. The magnitude was entered incorrectly. Use only real numbers and decimal."); // This is error 2. 
							numOfErrors++;
						}
						if (decimalChecker(parts[0])==1){
							// Using the decimalChecker we can determine if there were more than one decimal place. 
							System.out.println("	Error 3. The magnitude contains more than one decimal place.");// Print error message.
							numOfErrors++;
						}
						if(br1!='[' || br2!=']'){
							// The second string contains the direction.
							// if statement instead of else if because more than 2 errors can be found. Same reasoning for some bellow.
							// If the first char and the last char is not '[' and  ']' square brackets...
							// Note: If user has only one direction. 130 [N]. first and last char meet the situation.
							System.out.println("	Error 4.  Invalid '[' or ']' bracket input .");// error 3. 
							numOfErrors++;
						}
						if(d1!='N'&&d1!='E'&&d1!='S'&&d1!='W'&&d2!='N'&&d2!='E'&&d2!='S'&&d2!='W'){
							// When the second char and second last char is not a direction.
							// Note: If user has only one direction. 130 [N]. Second char is N and second last char is also N. It meets the situation. 
							System.out.println("	Error 5. Directions are not valid directions.");// error 4. 
							numOfErrors++;
						}
						
						if (d1=='N'&&d2=='S'||d1=='S'&&d2=='N'){
							// It is incorrect input if the 2 directions are the same. 
							// it is incorrect if they both are vertical or horizontal directions.
							System.out.println("	Error 6.Both directions are vertical.");// error 5
							numOfErrors++;
						}
						if(d1=='E'&& d2=='W'||d1=='W'&&d2=='E'){
							// horizontal 
							System.out.println("	Error 7. Both directions are horizontal.");// error 6
							numOfErrors++;
						}

						// NOTE: So Far we know that the direction 
						//contains the right brackets
						//has valid directions. 
						// Now we need to make sure the 1<degree<90. ( 90 degree just means one direction)
						if (parts[1].length()>3){
							// If the direction had a degree. i.e [N] is 3 chars long. [N23E] is more than 3 chars long.
							// This is to prevent the app from crashing when there is no degree value to convert. 
							
							String splitD=""+d1;// convert d1 into a string to split the string into the bracket and the rest of the direction.
							
							String[] dParts= out.split(splitD);// not only [  and  23N] remains.
							
							String remain=dParts[1];// the 23N] is remaining.
							
							String splitD2=""+d2;// Convert d2 into string.
							
							String[] checker= remain.split(splitD2);
							// this will convert 23N] into 23 and ] will be ignored;
							
							if (checker[0].matches("[0.0-9.0]+")==false){
								// If the numerical section contains anything except numbers...
								System.out.println("	Error 8. Invalid degree. Degree cannot contain anything except numbers.");// error 7.
								numOfErrors++;
								
								
								
							}
							if (decimalChecker(checker[0])==1){
								// Using the decimalChecker we can determine if there were more than one decimal place. 
								System.out.println("	Error 9. The degree contains more than one decimal place.");// Print error message.
								numOfErrors++;
							}
							else if(checker[0].matches("[0.0-9.0]+")){
								
								// if the string is only numbers...
								
								degree = Double.parseDouble(checker[0]);// convert the string into degree.
								// We use else if  because of parseDouble. 
								//If there is no degree value, or if the degree string contains more than one decimal
								// It will crash the app. 
								
								if(degree<=0||degree>=90){
									//if the degree quantity is too high or too low...
								System.out.println("	Error 10. Degree cannot contain a number higher than 89 and must be greater than 0.");// error 8.
								numOfErrors++;
								}
							}
						}	
					}
							
					}
					
				return numOfErrors;// This will return the number of errors that were found. If none, then it will remain zero.
	}

	public static int decimalChecker(String in){
		// A small method that checks if a string contains more than one decimal.
		
		int pick=0;// This number increases every time a decimal is detected.
		int out=0;// This will be the output. 0 is for no error, and 1 means there are errors.
		//Remember, if there are no decimals or only 1 decimal, out will not change. 
		
		for (int q=0; q<in.length(); q++){
			// for loop checks every char of string. 
			
			char a=in.charAt(q);// char a is the char that is checked.
			if(a=='.'){// if it is a decimal...
				pick++;// increase the number of decimals found.
			}
		}
		if (pick>1){
			// if there are more than one decimals...
			
			out=1;	// return value is 1.
		}
		return out;// return the return value. 
	}

	public static String components(String[] arrayMaker){
	// This method takes the inputed array, breaks it into two arrays.
			// Each array stores either N or S components, or E and W components.
			// We use the addem method to help generate the final output.
			// We do not need to round our values yet, this way we can get a much more accurate answer.
			
			String [] input=arrayMaker;
			String [] parts;// this will be used to break the string into magnitude and directions.
			double [] y=new double[input.length];// this stores N and S components.
			double [] x=new double[input.length];// this store the E and W components.
			double magnitude;// This is the decimal magnitude.
			double sideL;// This is the left direction.
			double sideR;// This is the right direction.
			double degree;// This is the degree calculated.
			String out;// This will be returned.
		
		for(int i=0;i<input.length;i++){
			// for loop works with each of the Strings in the Array. 
			parts= input[i].split(" ");// We break the string again.
			char d1=parts[1].charAt(1);// first direction is d1. We do not look at d2 until unless there is a second direction. 
			magnitude = Double.parseDouble(parts[0]);// Get the magnitude. 
			if(parts[1].length()==3)	{
				// if the direction is simply a direction without degree value. i.e [N]
				if(d1=='N'){
					y[i]=magnitude;// make the y magnitude.
					x[i]=0;// make x magnitude zero. 	
				}
				else if(d1=='S'){
					y[i]=-magnitude;// make the y magnitude.
					x[i]=0;// make x magnitude zero. 
				}
				else if(d1=='E'){
					x[i]=magnitude;// make the x magnitude.
					y[i]=0;// make y magnitude zero. 
				}
				else if(d1=='W'){
					x[i]=-magnitude;// make the x magnitude.
					y[i]=0;// make y magnitude zero. 
				}	
			}
			else{
			// This means that there is definitely another direction.	
				
			char d2=parts[1].charAt(parts[1].length()-2);//second direction.
			String splitD=""+d1;// convert d1 into a string to split the string into the bracket and the rest of the direction.
			String[] dParts= parts[1].split(splitD);// not only [  and  23N] remains.
			String remain=dParts[1];// the 23N] is remaining.
			String splitD2=""+d2;// Convert d2 into string.
			String[] checker= remain.split(splitD2);// only 23 is left.
			
			degree = Double.parseDouble(checker[0]);// convert string into double.
			double degreeToRadian=Math.toRadians(degree);// We convert degree into a radian value. Java uses radian. 
			
			sideL=(magnitude*(Math.cos(degreeToRadian)));// Left side is the first component.
			sideR=(magnitude*(Math.sin(degreeToRadian)));// Right side is the second component. 
	
			
				if(d1=='N'){// If the first direction is N.
					y[i]=sideL;// y array is filled.
				}
				else if(d1=='S'){// If the first direction is S.
					y[i]=-sideL;// y array is filled with negative value..
				}
				// Same for east and west.
				else if(d1=='E'){
					x[i]=sideL;
				}
				else if(d1=='W'){
					x[i]=-sideL;
				}
				// If the second direction 
				if(d2=='N'){// is N.
					y[i]=sideR;// y array is filled.
				}
				else if(d2=='S'){// is S.
					y[i]=-sideR;// y array is filled with negative value.
				}
				// Same for east and west.
				else if(d2=='E'){
					x[i]=sideR;
				}
				else if(d2=='W'){
					x[i]=-sideR;
				}
			}
		}
		out=addem(x,y);// Now we use the created arrays and our addem method to essentially, add'em!
		return out;// We return the string addem.
}

	public static String addem(double[] x, double [] y) {
		// TODO Auto-generated method stub
		// This method adds the array values.
		// Then it determines the magnitude of resultant vector and the direction.
		// Finally it gives all of the information in a nice compact string. 
	
		double xtot=0;// This is the  x totaled double.
		double ytot=0;// This is the y totaled double.
		char dx = 'E';// default east if the value of xtot is not found to be negative.
		char dy = 'N';// default North if the value of ytot is not found to be negative.
		String out;	// This will be the output string. 
		double result;// This is a double that stores the resultant vectors magnitude.
		double newDegree;// This stores the newdegree.
		
		for(int i=0;i<x.length;i++){
			// This adds the arrays.
			xtot=xtot+x[i];// X array.
			ytot=ytot+y[i];// Y array.
		}
		xtot=Math.round(xtot*100.0)/100.0;// reduce to two decimal points. 
		ytot=Math.round(ytot*100.0)/100.0;// same as above.
		
		// We reduce the total to 2 decimal places in case we get values like 0.001
		// Student would most probably consider that rounded to 0. 
		// This would prevent really small degrees like 0.002 degrees. 
		
		if(xtot<0){
			// When xtot is a negative value.
			dx='W';
			xtot=xtot*-1;// convert the magnitude into positive value.
		}
		if (ytot<0){
			// When y direction is negative.
			dy='S';
			ytot=ytot*-1;// convert the magnitude into positive value.
		}
		if (xtot==0&&ytot==0){
			// if the resultant vector does not have any magnitude, the vector is 0;
			out=("No displacement. 0 ");// This is the output. 
		}
		
		else if (xtot==0){
			// if the x components add up to 0, that means there is only a y direction.
			result=ytot;
			out=(result+" ["+dy+"]");
		}
		else if (ytot==0){
			// same as the if statement above, but this time there is only an x direction.
			result=xtot;
			out=(result+" ["+dx+"]");
		}
		
		else{
			// If there is both and x or a y component.
			result=Math.sqrt((Math.pow(xtot, 2))+(Math.pow(ytot, 2)));// (x^2+y^2)square rooted!
			result=Math.round(result*100.0)/100.0;// rounds to the nearest hundredth. 
			// using Pythagorean theorem, we find the resultant vector.
			// for the angle, we use tan law.
			// to get 130 [Vertical direction 35 Horizontal direction] format, we must do inverse tan degree=x/y.
			
			newDegree=Math.toDegrees(Math.atan((xtot)/(ytot)));// we have the degree
			newDegree=Math.round(newDegree*100.0)/100.0;// round this degree by two decimal places. 
			
			out=(result+" ["+dy+newDegree+dx+"]");// This is formatted to output the brand new vector.
		}
		return out;// Return the new output.
	}
}