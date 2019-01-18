package grade12;

import java.util.ArrayList;

import javax.swing.RowSorter;

import TextIO;

public class Bball {
	/**
	 * Create an app that can manage a basketball team roster. 
	 *  The user should be able to add, remove and count the players on the team 
	 *  as well as print a roster list.  
	 *  Only store the name of the player.
 	 * @author Naman Jain 04/10/2016
	 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList roster = new ArrayList<String>();// We create a new arrayList. It will store only ints.
		
		int decide=99;// This is starting value for the menu. As long as the user does not enter 0, loop will run.
		
			while(decide!=0){// While loop that runs the menu
				
				// Menu
			System.out.println(" Welcome to B-Ball roster!");
			System.out.println(" What do you wanna do? Enter the number before the command to do as you please.");
			System.out.println("");//space
			System.out.println(" 1. Add a new ballers name.");
			System.out.println(" 2. Count the amount of ballers added.");
			System.out.println(" 3. Take someone off the team.");
			System.out.println(" 4. Print the list of the ballers.");
			System.out.println(" 0. Terminate program.");
			
			
			decide= TextIO.getlnInt();// Take input command.
			
				while (decide>4||decide<0){
				// If the user enters something that is not an option...
				System.out.println("Oops! Thats not an option. Try again!");
				decide= TextIO.getlnInt();// Take input command again.
				}
				
				if (decide==1 ){// If option 1
					addEm(roster);// use addEm method
				}
				
				else if (decide==2){// if 2
					countEm(roster);// use the countEm method and so on...
				}
				
				else if (decide==3){
					takeEmOff(roster);
				}
				
				else if (decide==4){
					printIt(roster);
				}	
			}
			System.out.println(" Ok! Until next time coach!");// When the loops been broken, give the exit statement.
	}
	
	public static void addEm(ArrayList<String> roster ){
		// Method that puts new information into the roster.
		System.out.println(" Ok, add a new ballers name.");// ask for input
		String name= TextIO.getln();// Get input
		roster.add(name);// store it.
		System.out.println(" Ok, "+ name+ " was added.");// let the user know what was added.
		
	}
	
	public static void countEm(ArrayList<String> roster){
		// Method counts the amounts of data in the ArrayList.
		int size=roster.size();// Its calculates the size. 
		System.out.println(" There are "+size+ " players");// Return the request.
		System.out.println("");//space
		System.out.println("");//space
	}
	
	public static void takeEmOff( ArrayList<String> roster){
		// This method removes players.
		System.out.println(" Whom do you wish to remove?");// Ask
		String name= TextIO.getln();// get
		
		while (roster.contains(name)==false){
			// If the arraylist does not contain the entered name, 
			//it needs to be asked again.
			System.out.println(" That player is not on the team. Enter again.");// Ask again.
			 name= TextIO.getln();// get
		}
		
		if (roster.contains(name)){// If we find a match...
			
		System.out.println("Ok, we got rid of "+ name);//Message.
		roster.remove(name);// remove.	
		}
		
	}
	public static void printIt (ArrayList<String> roster){
		// Method prints the names in a list.
		for (String out: roster){
			// For loop that makes string out equal to every value in each index of the ArrayList.
			System.out.println(out);// We just print it out each time. 
		}
	}

}

