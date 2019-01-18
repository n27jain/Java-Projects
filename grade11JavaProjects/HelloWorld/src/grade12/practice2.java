package grade12;

import TextIO;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vectorCount;
		
		System.out.println("Welcome Master.");
		System.out.println("I am VICTOR and welcome to VecotorCracker©");
		System.out.println("");
		System.out.println("");
		System.out.println("Please enter the amount of vectors that I will have to add. ");
		
		vectorCount=TextIO.getlnInt();
		System.out.println("OK!");
		
		String[] entry= arrayMaker(vectorCount);
		String addwork=components(entry);
		System.out.println("OK! Were done your work!");
		System.out.println(addwork);
	}
	
	public static String[] arrayMaker(int vectorCount){
		
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
			System.out.println("Error 9. There is no space int the input.");// Error 9.
			numOfErrors++;
		}
	
		else if(out.contains(" ")){// if there is any space char...
			parts= out.split(" ");// When there is a space, it will break the string into an array of strings.
			
			d1=parts[1].charAt(1);// first direction is d1.
			d2=parts[1].charAt(parts[1].length()-2);//second direction.
			br1=parts[1].charAt(0);// first bracket
			br2=parts[1].charAt(parts[1].length()-1);// last bracket.
			
			if(parts.length>2){
				// If there is more than one space.
				// If there is only 2 strings... nothing happens because systemError is still 0.
				System.out.println("Error 1. User has entered more than one space."); // This is Error 1. 
				numOfErrors++;// counts number of errors.
			}
			if(parts[0].matches("[0.0-9.0]+")==false){
				// .matches checks if a string only contains the range within the square brackets.
				// We need to make sure it is a double value. This is because the magnitude can be a decimal.
				// if the string does not contain just numbers...
				// It must have any other symbol besides numbers.
			
				System.out.println("Error 2. The magnitude was entered incorrectly. Use only real numbers."); // This is error 2. 
				numOfErrors++;
			}
			if(br1!='[' || br2!=']'){//%%%%%%%%%%%%%%%
				// The second string contains the direction.
				// if instead of else if because more than 2 errors can be found. Same reasoning for some bellow.
				// If the first char and the last char is not '[' and  ']' square brackets...
				// Note: If user has only one direction. 130 [N]. first and last char meet the situation.
				System.out.println("Error 3.  Invalid '[' or ']' bracket input .");// error 3. 
				numOfErrors++;
			}
			if(d1!='N'&&d1!='E'&&d1!='S'&&d1!='W'&&d2!='N'&&d2!='E'&&d2!='S'&&d2!='W'){//%%%%%%%%%%%%%%%
				// When the second char and second last char is not a direction.
				// Note: If user has only one direction. 130 [N]. Second char is N and second last char is also N. It meets the situation. 
				// To prevent a really long if statement we broke it down into 2 statements.
				System.out.println("Error 4. Directions are not valid directions.");// error 4. 
				numOfErrors++;
			}
			
			if (d1=='N'&&d2=='S'||d1=='S'&&d2=='N'){{//%%%%%%%%%%%%%%%
				// It is incorrect input if the 2 directions are the same. 
				// it is incorrect if they both are vertical or horizontal directions.
				System.out.println("Error 5.Both directions are vertical.");// error 5
				numOfErrors++;
			}
			if(d1=='E'&& d2=='W'||d1=='W'&&d2=='E'){//%%%%%%%%%%%%%%%
				// horizontal 
				System.out.println("Error 6. Both directions are horizontal.");// error 6
				numOfErrors++;
			}
			
			// NOTE: So Far we know that the direction 
			//contains the right brackets
			//has valid directions. 
			// Now we need to make sure the 1<degree<90. ( 90 degree just means one direction)
			
			String splitD=""+d1;// convert d1 into a string to split the string into the bracket and the rest of the direction.
			
			String[] dParts= out.split(splitD);// not only [  and  23N] remains.
			
			String remain=dParts[1];// the 23N] is remaining.
			
			String splitD2=""+d2;// Convert d2 into string.
			
			String[] checker= remain.split(splitD2);
			// this will convert 23N] into 23 and ] will be ignored;
			
			if (checker[0].matches("[0.0-9.0]+")==false){
				// If the numerical section contains anything except numbers...
				System.out.println("Error 7. Invalid degree. Degree cannot contain anything except numbers.");// error 7.
				numOfErrors++;
				
			}
			if(checker[0].matches("[0.0-9.0]+")){
				// if the string is only numbers...
				degree = Double.parseDouble(checker[0]);// convert the string into degree.
				
				if(degree<=0||degree>=90){
					//if the degree quantity is too high or too low...
				System.out.println(" Error 8. Degree cannot contain a number higher than 89 and must be greater than 0.");// error 8.
				numOfErrors++;
				}
			}
			
				
		}
		
		
		
		
	}
		return numOfErrors;// This will return the number of errors that were found. If none, then it will remain zero.
	
	}
	
	public static String addem(double[] x, double [] y) {
		// TODO Auto-generated method stub

		double xtot=0;
		double ytot=0;
		char dx = 'E';// default east if the value of xtot is not found to be negative.
		char dy = 'N';// default North if the value of ytot is not found to be negative.
		String out;
		double result;
		double newDegree;
		
		for(int i=0;i<x.length;i++){
			xtot=xtot+x[i];
			ytot=ytot+y[i];
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
		if (xtot==0){
			// if the x components add up to 0, that means there is only a y direction.
			result=ytot;
			out=(result+" ["+dy+"]");
		}
		else if (ytot==0){
			// same as the if statement above, but this time there is only an x direction.
			result=xtot;
			out=(result+" ["+dx+"]");
		}
		else if (xtot==0&&ytot==0){
			// if the resultant vector does not have any magnitude, the vector is 0;
			out=("No displacement. 0");
		}
		else{
			result=Math.sqrt((Math.pow(xtot, 2))+(Math.pow(ytot, 2)));
			result=Math.round(result*100.0)/100.0;// rounds to the nearest hundredth. 
			// using Pythagorean theorem, we find the resultant vector.
			// for the angle, we use tan law.
			// to get 130 [N35E] format, we must do tan degree=x/y.
			
			newDegree=Math.toDegrees(Math.atan((xtot)/(ytot)));// we have the degree
			newDegree=Math.round(newDegree*100.0)/100.0;// round this degree by two decimal places. 
			
			out=(result+" ["+dy+newDegree+dx+"]");
		}
		return out;
	}
	
	public static String components(String[] arrayMaker){
	// This method takes the inputed array, breaks it into tow arrays.
			// Each array stores either N or south components, or E and W components.
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
			String out;
		
		for(int i=0;i<input.length;i++){
			
			parts= input[i].split(" ");

			char d1=parts[1].charAt(1);// first direction is d1.
			char d2=parts[1].charAt(parts[1].length()-2);//second direction.
			magnitude = Double.parseDouble(parts[0]);
			
			String splitD=""+d1;// convert d1 into a string to split the string into the bracket and the rest of the direction.
			String[] dParts= parts[1].split(splitD);// not only [  and  23N] remains.
			String remain=dParts[1];// the 23N] is remaining.
			String splitD2=""+d2;// Convert d2 into string.
			String[] checker= remain.split(splitD2);// only 23 is left.
			
			degree = Double.parseDouble(checker[0]);// convert string into double.
			double degreeToRadian=Math.toRadians(degree);
			
			sideL=(magnitude*(Math.cos(degreeToRadian)));
			System.out.println(sideL);
			sideR=(magnitude*(Math.sin(degreeToRadian)));
			System.out.println(sideR);
			if(parts[1].length()==3)	{
				// if the direction is simply a direction without degree value. i.e [N]
				if(d1=='N'){
					y[i]=magnitude;
					x[i]=0;
					
				}
				else if(d1=='S'){
					y[i]=-magnitude;
					x[i]=0;
				}
				else if(d1=='E'){
					x[i]=magnitude;
					y[i]=0;
				}
				else if(d1=='W'){
					x[i]=-magnitude;
					y[i]=0;
				}	
			}
			else{
				if(d1=='N'){
					y[i]=sideL;
				}
				else if(d1=='S'){
					y[i]=-sideL;
				}
				else if(d1=='E'){
					x[i]=sideL;
				}
				else if(d1=='W'){
					x[i]=-sideL;
				}
				if(d2=='N'){
					y[i]=sideR;
				}
				else if(d2=='S'){
					y[i]=-sideR;
				}
				else if(d2=='E'){
					x[i]=sideR;
				}
				else if(d2=='W'){
					x[i]=-sideR;
				}
			}
			
		}
		out=addem( x,  y);
		return out;
		
}

}