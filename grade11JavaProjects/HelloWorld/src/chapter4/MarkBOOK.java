package chapter4;

import TextIO;

public class MarkBOOK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Naman Jain
		// 29/04/2016
		
		String ast;//String that will be take as assignment name.
		
		double ma;// Decimal number that will be taken for students mark.
		double to;// same as ma but is taken for the total marks that the assignment is out of.
		
		int we;// Int that will be used to take the weight of assignment.
		
		System.out.println("Welcome to the MarkBook!");//Welcome statement.
		
		Mark[] one=new Mark[20];// Creates a new object that is an array of 20 assignments. 
		
		//Named one to indicate there is only one set of array, in case developer wants to make more than one student.
		
		int count=99;// This is the int that determines what actions will be taken. Set at 99 to prevent confusion.
		int number=0;// The number of times a new mark entry is made.
		int counter=0;
		// This is used to determine the number of entries that have been made.(0 cannot be an entry).
		
		
		while(count!=0){
			// While loop that continues to work as long as the user does not press 0 to exit the app.
			
			
		
			//Main Menu
			System.out.println("");// Space
			System.out.println("");// Space
			System.out.println("Main Menu ("+counter+" mark entries)");// Uses counter to let user know how many entries have been made. 
			System.out.println("1. Calculate the current overall weighted average");// Option 1
			System.out.println("2. List all entries and overall weighted average");	// Option 2
			System.out.println("3. New mark entry");								// Option 3
			System.out.println("4. Delete a mark entry");							// Option 4
			System.out.println("5. Update an existing mark");						// Option 5
			System.out.println("0. Exit");											// Exit
			System.out.println("	What would you like to do?");					// Ask
			
			count=TextIO.getlnInt();//Get the command.
			
			if(count==1){
				//When option 1...
				
				double percent=0.0;	// Percent value for OWA is to one decimal point.
				
				percent=weightAv(number,one);	// Using the weightAv() method we get the average OWA.
				
				System.out.print("Student’s current OWA is ");// Return statement.
				
				System.out.printf("%1.1f",percent);// Format the OWA to one decimal place.
				
				System.out.println("%");// Print percent.
			}
				
			else if(count==2){
				//When option 2...
				
				System.out.println("Current Mark Entries");// Title...
				
				listMarks(one,number,count);// Method lists all the assignments.
				
				double percent=0.0;	// Percent value for OWA is to one decimal point.
				
				percent=weightAv(number,one);	// Using the weightAv() method we get the average OWA.
				
				System.out.print("Student’s current OWA is ");// Return statement.
				
				System.out.printf("%1.1f",percent);// Format the OWA to one decimal place.
				
				System.out.println("%");
			}
		
			else if(count==3){
				//When option 3...
				
				char yesno='n';//Determines true/false statement.
				
				int out=number;// This is the last entry number that the app already initialized.
				
				counter++;// Increase the number of entries.
				
				System.out.println("New Mark Entry");// Title...
				
				System.out.println("--------------");// Underline.
				
				System.out.println("Enter the assignment name:(Allows 40 characters!)");// Ask for assignment.
				
				ast=TextIO.getln();// get assignment
				
				System.out.println("Enter the total mark:"); //Ask for total mark
				
				to=TextIO.getlnDouble();// get double total.
				
				System.out.println("Enter the student’s mark:");// Ask for students mark
				ma=TextIO.getlnDouble();// get double mark
		
				System.out.println("Enter the weight (Default 1):");// asks for weight value. only 1-4 allowed.
				we=TextIO.getlnInt();// get int weight.
				
				while(we<=0||we>4){
					// While the weight is less than or equal to 0 and greater than 4.
					
					System.out.println("Invalid entry!!!. only enter 1-4");// error message.
					
					System.out.println("Enter the weight!:"); //Ask for total mark
					
					we=TextIO.getlnInt();// get double total.
				}
				
				one[out]= new Mark(ast,to, ma,we);// Using the retrieved info, make a new one[].
				
				System.out.println(" ");// start a new line.
				
				System.out.println("Please check the mark entry.");//title
				
				checker(number,one);// Use checker method to display entry.
				
				System.out.println("Is this correct?(y/n) ");// Ask to confirm.
				
				yesno=TextIO.getlnChar();// get the response.
				
				if(yesno=='y'){
					System.out.println(" Ok DONE!!! ");// start a new line. Tells action is completed!
					number++;// Increase the value for the next possible entry.
					
				}
				else if (yesno!='y'){
					System.out.println(" Ok! No worries we have deleted the entry. ");// Tells action has not been completed! 
					System.out.println(" Now redirecting to the main menu!");// closing statement.
					one[out]=new Mark();
					counter--;// decrease the number of counters.
					// number stays the same.
				}
			}
		
			else if(count==4){
				//When option 4 to delete...
				
				char x ='n';// This string determines if the user is fine with their choice.
				
				while(x=='n'){
					// While yn is no...
					
					System.out.println("Delete Mark Entries");// title
					
					System.out.println("--------------------");//underline
					
					System.out.println("");//space
					
					listMarks(one,number,count);//Use listMarks method to list all assignments.
					
					System.out.println("");//space
					
					System.out.println("What entry would you like to delete?");// Ask for command.
					
					int picked=TextIO.getlnInt();// get the command.
					
					picked=picked-1;//Subtract one because arrays start with 0; i.e pick 1 = one[0];
					
					System.out.println("");// space
					
					System.out.println("You have requested to delete the following mark entry:");// give warning message.
					
					checker(picked,one);// Use checker method to print out details.
					
					System.out.println("Is this correct? Press(y/n) or (x) to exit!");// ask
					
					x=TextIO.getlnChar();	// take answer
					
					if(x=='y'){
					// if user picks y for yes...
						
					one[picked]=new Mark();// erase that certain one[]; Make it brand new to default again.
					System.out.println("Done!!!");	// Let user know app has done it!
					counter=counter-1;// Reduce the number of entries
					}
					else if (x=='x'){
						// DO nothing the app exits this operation.
					}
					
						
				}
			}
			
			else if(count==5){
				//When option 5...
				
				System.out.println("Update Mark Entry");// title
				
				System.out.println("--------------------");// underline
				
				System.out.println("");// space
				
				listMarks(one,number,count);// list all of the marks.
				
				System.out.println("Which entry wuld you like to update?");// Ask for command
				
				int pickle=TextIO.getlnInt();// pickle is the number of the assignment that is to be deleted.
				
				pickle=pickle-1;// since arrays start with 0... we take one away.
				
				checker(pickle,one);// Display the chosen entry. 
				
				
				System.out.println("Please input new student mark:");// ask for a new mark value. Nothing else can be changed.
				
				double newMark=TextIO.getlnDouble();//take the newMark and use the the newMark to edit the mark value.
				
				one[pickle].setMark(newMark);// use setMark to change the mark value.
				
				System.out.println("");
				System.out.println("");// double space
				
				System.out.println("DONE!");// Let user know it has been done.
				
			}
			
			
			else if(count==0){
				// exit
				//When option 0...
				System.out.println("Thank you for using Markbookator! Bye Bye!!!");// exit statement!!!
				
			}	
		}
	}
	
	private static double weightAv(int number,Mark one[]){
		// method that gets the weighted average. Uses int number to determine the number of entries made.
		// If there is a blank entry in between there is no issue. It will add the 0 percent and use 0 load, and this will not affect the problem.
		
		double average=0;// these variables a doubles because they can be decimal numbers.// This is average number
		double last=0;// This is the last value that was retrieved. it will be compiled to all of the percents in each array.
		double weAverage;//weight * average gives you the weAverage. See bellow to understand.
		
		int weightSum=0;// The sum of every entries weight.
		
		double out=0;// This is the percent that will be returned.
		
		for(int i=0;i<number;i++){
			// For loop that inspects each of the arrays.
			if(one[i].getAssignment()!=""){
				// When the array is empty to the default constructor...(SO that the student's OWA does not drop because of a deleted entry). 
				
				average=one[i].calcAverage();// Use the calcAver to find the average of the assignment.
				
				weAverage=average*one[i].getWeight();// Using the weight determine the weightAverage.
				
				last=last+weAverage;// Compile the previous weAverage with the new one.
			
				weightSum=weightSum+one[i].getWeight();// Compile the sums of all of the weights.
			}
		}
		
		out=last/weightSum;// Divide the last compiled value by the weightSum to get the percent.
		
		return out;// Return the percent.
	}
	
	public static void listMarks(Mark one[],int number,int count){
		// Method that lists all of the entries based on desire.
		
		
		
		System.out.println("");// space
		
		if(count==2){
			// When option 2 is chosen
			
			for(int i=0;i<number;i++){
				// for loop that inspects each array.
					
				if(one[i].getAssignment()!=""){
					// if the array's assignment is not blank...
					
						System.out.print(i+1+".");// Print out the number of the assignment.
						
						one[i].showEntry();// Return those assignments entries.
						
						System.out.println();// Space.
					}
			}	
		}
	
		else if (count>2){
			// When the options 4 and 5 are chosen...
			
			for(int i=0;i<number;i++){
				//Inspect the array.
				
				if(one[i].getAssignment()!=""){
					// if the array's assignment is not blank...
					
					System.out.print(i+1+"."); // Print out assignment number.
					
					one[i].special();// Print only the assignment name.
					
					System.out.println();// Space.
				}
			}
		}
		
	}
	
	public static void checker(int pick,Mark[]one){
		
		System.out.println("Current mark entry:");// Title
		
		System.out.print("	");// indent
		
		one[pick].special();// print out the chosen line.
		
		System.out.println(" ");// start a new line.
		
		System.out.print("	Students Mark : ");//title
		
		System.out.print(one[pick].getMark());// output the students mark
		
		System.out.print(" / ");//leave dash
		
		System.out.print(one[pick].getTotal());// Output the amount that the assignment is out of.
		
		System.out.println(" ");// start a new line.
		
		System.out.print("	Weight : ");//title
		
		System.out.println(one[pick].getWeight());
		
	}
	
}
	class Mark{
		
		// Class that stores values of the assignments and finds assignment average.
		
		private String assignment;// assignment name
		
		private double mark;// mark number 
		
		private double total;// total marks the test is out of.
		
		private int weight;// the influence on the mark. 1 lowest and 4 highest.

		
		
			public Mark(){
				// Default constructor.
				
				mark=0;
				
				assignment="";// Blank value.
				
				total=1;
				
				weight=1;// default weight,
				
				
			}
			
			public Mark(String ast,double to,double ma,int we){
				// Constructor when we are given all 4 values.
				
				mark=ma;//new mark is set.
				
				total=to;// new total is set.
				
				weight=we;// new weight is set.
				
				assignment=ast;// new assignment is set.
				
			}
			public Mark(String ast,double to,double ma){
				// when user only gives name, total, and marks and wants default weight of assignment. 
				
				mark=ma;// new mark is set.
				
				total=to;
				
				assignment=ast;

				weight=1;// weight is kept the same.
				
			}
			public String getAssignment(){
				//getter for assignment.
				return assignment;
			}
			public double getTotal(){
				//getter for total.
				return total;
			}
			public int getWeight(){
				//getter for weight
				return weight;
			}
			public double getMark(){
				//getter for Mark
				return mark;
			}
			public void setMark(double newMark){
				//setter for Mark to edit mark.
				 mark=newMark;
			 }
			public double calcAverage(){
				// method calculates average of assignment.
			double ret=(mark/total*100);// divide mark by the total and multiply by 100 to get percent.
			
			return ret;// return the percent.
			}
			
			public void showEntry(){
				// method that prints out the assignment details.
				String newAssignment = properOut(assignment);
				
				System.out.printf("%-40s",newAssignment);// Makes the string at least 40 chars. Puts spaces otherwise. - makes is align to the left
				
				System.out.print(" -   ");// indicate dash.
				
				System.out.printf("%1.1f",mark);// round the mark value and output.
				
				System.out.print(" / ");// put the out of sign.
				
				System.out.printf("%1.1f",total);// round and output.
				
				System.out.print("   ");// give gap.
				
				System.out.printf("%1.1f",calcAverage());// round and output.
				
				System.out.println("%");// finalize with the percent sign.
						
			}
			public static String properOut(String assignment){
				// String method that trims the string if it is too big.
				
			int maxLength=40;// this the maximum length of the string.
			
			String input=assignment;// The input is the assignment name.
			
			   if(assignment.length() > maxLength){// if the length is to great...
				   
				   
			      return input.substring(0,maxLength);// return only up to the maximum.
			   }
			   return input;// otherwise return the regular string.
			}
	
			public void special(){
				// For special cases when only the assignment name needs to be output.
				
				String newAssignment = properOut(assignment);// Use proper out to format accordingly.
				
				System.out.printf("%-40s",newAssignment);// if a string is less than 40 chars... Then put in spaces to cover it.
			}
			
	}	