package selectionSort;

import java.util.ArrayList;

import submits.TextIO;

public class SelectionRoster {

	/**
	 * Baller class creates a roster for an coach to add his team members.
	 * it is a fairly basic app that incorporates the objects added to an arrayList.
	 * No error checks required. 
	 * User should be able to input the players name -height in inches - weight in kgs - and country of origin
	 * User must be able to remove a player. 
	 * Lastly, user should be able to print the list of the roster formatted in a table.
	 * This time we have added a method that sorts each entry alphabetically by the name of the players.
	 * This time the method used is Selection Sort. 
	 * We assume entries are valid.
	 *  NOTE: When author says string with lowest value he means 
	 * that the string that is alphabetically earlier than the string it is being compared to.
	 * @author Naman Jain 11/18/2016
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int decide=99;// This is starting value for the menu. As long as the user does not enter 0, loop will run.
		
		
		ArrayList <list> roster = new ArrayList <list>();// we make the arrayList. This list consists of the objects called list.	
		while(decide!=0){// While loop that runs the menu
				
				// Menu
			System.out.println("");//space
			System.out.println(" Welcome to Baller!");
			System.out.println(" What do you wanna do? Enter the number before the command:");
			System.out.println("");//space
			System.out.println(" 1. Add a new baller.");
			System.out.println(" 2. Count the amount of ballers added.");
			System.out.println(" 3. Take someone off the team.");
			System.out.println(" 4. Print the list of the ballers.");
			System.out.println(" 0. Terminate program.");
			
			decide= TextIO.getlnInt();// Take input command.
			
				while (decide>4||decide<0){
				// If the user enters something that is not an option...
				System.out.println("Oops! Thats not an option. Try again!");//error message.
				decide= TextIO.getlnInt();// Take input command again.
				}
				if (decide==1 ){// If option 1
					addEm(roster);// use addEm method
				}
				else if (decide==2){// if 2
					countEm(roster);// use the countEm method and so on...
				}
				else if (decide==3){// if 3
					takeEmOff(roster);// takeEmoff method.
				}
				else if (decide==4){// if 4
					arrangeTable(roster);// Arrange the ArrayList before it can be printed.
					printItTable(roster);// print stream.
				}	
			}
			System.out.println(" Ok! Until next time coach!");// When the loops been broken, give the exit statement.
	}
	
	public static void addEm(ArrayList <list> roster){
		// Method that puts new information into the roster.
		
		list newList;// The new object that will be put into the array. 
		
		System.out.println(" Ok, add a new ballers name.");// ask for input
		String getName= TextIO.getln();// Get input
		
		System.out.println(" Ok, what is their height.");// ask for input
		int getHeight= TextIO.getlnInt();// Get the height.
		
		System.out.println(" Ok, what is their weight.");// ask for input
		int getWeight= TextIO.getlnInt();// Get the weight.
		
		System.out.println(" Ok, which country are they from?");// ask for input
		String getCountry= TextIO.getln();// Get country
		
		newList= new list (getName, getCountry, getHeight, getWeight);// Construct the object
		
		roster.add(newList);// Add the object to arraylist. 
	}
	
	public static void countEm(ArrayList<list> roster){
		// Method counts the amounts of data in the ArrayList.
		int size= roster.size();// Its calculates the size. 
		System.out.println(" There are "+size+ " players");// Return the request.
		System.out.println("");//space
		System.out.println("");//space
	}
	
	public static void takeEmOff( ArrayList<list> roster){
		// This method removes a player of chosen index or exits to the menu if an invalid index is entered.
		printItTable(roster);// use the printable method.
		System.out.println(" Whom do you wish to remove?");// Ask
		
		int indexRemoval= TextIO.getlnInt();// This will be the getInt to determine which player index to remove.
		
		if (indexRemoval>roster.size()|| indexRemoval<=0){
			// If the indexNumber is less than zero or exceeds the possible index value.
			System.out.println("OOPS! That player does not exist!!! Try again later!");// message. Return to menu.
		}
		else{
			// Otherwise that index exists.
			roster.remove(indexRemoval-1);// We remove the index. Because 0=1 we need to reduce the desired index by 1.
			System.out.println("Ok!");
			System.out.println("");
			System.out.println("Player "+ indexRemoval+" Has been removed!!!");// Let them know the number of the player removed. 
		}
		
	}
	
	public static void printItTable (ArrayList<list> roster){
		// Method prints the names in a list.
		
		System.out.printf("%-20s %-20s %-20s %-20s", "Name", "Height(Inches)","Weight(Kgs)","Country");// The table heading
		System.out.println("");// space
		
		for (int i=0; i< roster.size();i++){
			// For loop that checks every object in the arrayList. We use int i for each index.
			
			System.out.print(i+1+ " . ");// Lets user know the number of the index. 
			
			roster.get(i).showEntry();// prints out the inputed string. 
			
			System.out.println("");// Space
		}
	}
	public static void arrangeTable (ArrayList<list> roster){
		// This method arranges the entries alphabetically. 
		// The entries are then permanently saved into the object in the correct order.
		
		for(int x=0; x< roster.size(); x++){
			// set each of the index in the array.
			
			list checkObject= roster.get(x);// get the object that corresponds to the x index.
			int index= x;// We use this String to know which String to point to. 
			//It will point to the String in the array that is the lowest value. 
			
			for(int i=x+1; i<roster.size();i++){
				// Check the String in the array after current index being checked.
				
				list newObject= roster.get(i);// We get the object that we are checking.
				String compare= newObject.getName();// We get the string value that we are comparing too. 
				
				list currentLowest= roster.get(index);// We need to compare each object in the array with the current lowest String. 
				String current= currentLowest.getName();// This is the current lowest String.
					
					if (compare.compareToIgnoreCase(current)<0){// if our checked String is less value then the current checked and the value that the pointer is pointing to. 
						index=i;// Our pointer points to the current index unless a number in another index is lesser.	
					}	
		
			}
			list tempo = roster.get(index); // temp is the temporary object that is the value of the lowest String in the remaining array unchecked.
			roster.set(index, checkObject);// Replace the index in the array that contains the lower string value, with the object that contains a higher value string.
			roster.set(x, tempo);// The initially checked index is replaced with the lowest string value in the array.
		}
		
	}
}

class list{
		// Object that stores the inputs and outputs a formatted string. 
		private int height=0, weight=0; // Int variables 

		private String name="", country="";// String variables
		
		public list(String getName, String getCountry, int  getHeight, int getWeight ){
			// constructor
			name = getName;
			
			height = getHeight;

			weight= getWeight;

			country = getCountry;
		}
		public String getName(){
			return name;
		}
		public void showEntry(){
			// This is the return method of the object.
			System.out.printf("%-20s %-20s %-20s %-20s", name, height,weight, country);// formated in chart form using printf	
		}		
}







