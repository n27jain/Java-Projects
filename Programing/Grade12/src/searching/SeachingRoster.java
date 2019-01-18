 package searching;

import java.util.ArrayList;


public class SeachingRoster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Baller class creates a roster for an coach to add his team members.
		 * it is a fairly basic app that incorporates the objects added to an arrayList.
		 * No error checks required. 
		 * User should be able to input the players name -height in inches - weight in kgs - and country of origin
		 * User must be able to remove a player. 
		 * Lastly, user should be able to print the list of the roster formatted in a table.
		 * This time the ability to search and find a person is introduced.
		 * User can also print all users with a certain nationality.
		 * @author Naman Jain 12/06/2016
		 */
	
		ArrayList <list> roster = new ArrayList <list>();// we make the arrayList. This list consists of the objects called list.	
		
		int decide; // we will use this int to decide what is asked and to exit the while loop
		do{	
				// Menu
			
			System.out.println("");//space
			System.out.println(" Welcome to Baller!");
			System.out.println(" What do you wanna do? Enter the number before the command:");
			System.out.println("");//space
			
			System.out.println(" 1. Add a new baller.");
			System.out.println(" 2. Count the amount of ballers added.");
			System.out.println(" 3. Take someone off the team.");
			System.out.println(" 4. Print the list of the ballers.");
			System.out.println(" 5. Read text file.");
			System.out.println(" 6. Save Roster. ");
			System.out.println(" 7. Search ");
			System.out.println(" 8. Find By Country Name");
			System.out.println(" 0. Terminate program.");
			
			
			decide= TextIO.getlnInt();// Take input command.
			
				while (decide>8||decide<0){
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
				else if (decide==5){// if 5
					readEm(roster);// Read the last saved .txt file. 
				}
				else if (decide==6){// if 6
					saveEm(roster);// Save the roster by overwriting. 
				}
				else if (decide==7){// if 7
					
					int index=searchEm(roster);// Save the roster by overwriting. 
					
					if(index==-1){// if we don't get a match...
						System.out.println(" We couldn't find that!!! Try again later.");
					}
					else{
						
					System.out.println("");
					System.out.println("");
					System.out.println("We found your man!!!");
					
					list out= roster.get(index);// Because we have found the index, we print the index
					out.showEntry();// showEntry method prints out data from object.
					
					System.out.println("");
					}
				}
				else if (decide==8){// if 8
					nationalizeEm(roster);// This method will handle it.
				}
				
			}while(decide!=0);// Keep running until user presses 0 to indicate the exiting of the app
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
	public static void readEm(ArrayList <list> roster){
		// readEm reads the . txt file and splits at commas to construct the object. 
		TextIO.readFile("RosterNames.txt");// Read our input
		
		while(!TextIO.eof()){// While loop that runs until the last line is read.
			list newList;// The new object that will be put into the array. 
			String process= TextIO.getln();// Get the first set of data. 
			String[]pieces= process.split(",");
			String name= pieces[0];// First part is name
			String country = pieces[3];// last part is country name
			int height= Integer.parseInt(pieces[1]);//we convert string into int .
			int weight= Integer.parseInt(pieces[2]);//we convert string into int .
			newList= new list ( name,country, height, weight);// The new array found.
			roster.add(newList);// Add the object to arraylist. 
		}	
		TextIO.readStandardInput();// Return the app to start reading inputs back to the normal way.
	}
	
	public static void saveEm(ArrayList <list> roster){
		// This saveEm method saves all of our objects. 
		
		TextIO.writeFile("RosterNames.txt");// We write on top of the old doc. 
		for(int i=0; i<roster.size(); i++){// We keep doing this for every object in the array.
			list newlist= roster.get(i);// We get each object from the array.
			String out=(newlist.getName()+","+newlist.getHeight()+","+newlist.getWeight()+","+newlist.getCountry()); // output in proper format with decimals
			
			System.out.println("Saving-----"+out);
			TextIO.putln(out);// put this object in the array.
		}
		
	}
	
	public static int searchEm(ArrayList<list> roster){
		// The searching method to find a certain player.
		// We return -1 if we do not find an index. 
		
		arrangeTable(roster);// Arrange the table before you search.
		
		System.out.println("Who do you want to search?");// The table heading
		
		String query= TextIO.getln();// Take what you want to find. 
	
		
		int low=0;//First index
		int high=roster.size()-1;// last index.
	
		while (high >=low) {// As long as the higher valuer is greater than equal to the lowest value.
		    int middle = (low+high) / 2;// This is the middle index
		    
		    	list inspectMiddle= roster.get(middle);// We get the middle object.
		    	String inspected= inspectMiddle.getName();// We get the name.
		    			     
		    	if (query.equals(inspected)){// If the middle string is the one we are looking for.
		    	
		        return middle;// return this index
		        
		    	}
		    
		      else if (inspected.compareToIgnoreCase(query)>0){// If the middle string comes after the query.
		        high = middle - 1;// We make the high equal to the middle -1. This is to eliminate the unessary indexes to check.
		      }
		      // eliminate locations <= middle
		      else{
		        low = middle + 1;   // Otherwise the middle string comes before the the query and we need to change the new low.
		      }
		}
		  return -1;// If we don't find it we return -1.

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
	
	public static void nationalizeEm(ArrayList<list> roster){
		// This method searches the array for every object that has a certain country name 
		// It then prints them out.
		
		System.out.println("What country members shall I search?");
		String query=TextIO.getln();// Take the users input to find.
		int found=0;// If this int does not change that means we don't find any players with that country name.
		for(int i=0; i<roster.size(); i++){// Check every country string in the array.
			
			list check= roster.get(i);// We get the object that we check.
			String country= check.getCountry(); // Get the country name
			
			if(query.equals(country)){
				System.out.println("We found:");	
				check.showEntry();// Print method.
				found++;// We have found one so we don't need to tell the user that the roster does not exist. 
				System.out.println("");//space
				System.out.println("");
			}
		}
		if (found==0){
			// If we didnt find anything.
			System.out.println("We could not find that country. Try again!!!");
		}
		
	}
	
	public static void arrangeTable (ArrayList<list> roster){
		// This method arranges the entries alphabetically. 
		// The entries are then permanently saved into the object in the correct order.
		
		boolean sorted = true;// a true/ false motion. 
		
		// Traverse the list until no more swaps made
		for (int i = 1; i < roster.size() ; i++) {
			// We will not check the first index (0) because the second index will be compared to the first.
			sorted= true;// Each time the for loop s run we initially start of with a true statement. When a switch must be made it will become false.
			list checkObject= roster.get(i); // object 2 that will be checked.
			list indexObject= roster.get(i-1); // The object that is in a previous index that will be compared to. changes with the while loop bellow.
			String view = checkObject.getName();// we get the string from the object.
			String indexOfObject = indexObject.getName();// We get the string for the object of the index. 
		
			int x= i-1;// This int will be the index that is being checked. 
				
				while(x>=0 && view.compareToIgnoreCase(indexOfObject)<0){
				  // We are using comapareToIgnoreCase method.
				  // When one string has a letter that is a higher value,
				  // it means it is closer to z in the alphabet. 
				  // If our string is supposed to be earlier than the compared string, .compareTo will out put a negative number.
				  // A switch is then required.
				  // If 0 it means strings are same. 
				  
				  sorted=false; // Because the while loop has been run, a switch is required and detected.
				  
				  roster.set(x+1, indexObject);// Because we know the past string is suppose to come after the tested string, we will shift the string to the next index.
				 
				  x--;// The x counts down each time to test a previous string.   
					
				  if(x>-1){// x-- reduces the index that we will check. If the index is a negative number then our app will crash.
				  		// To prevent this, we will make sure x is not a negative number before we check the next index object.
					  
					  indexObject= roster.get(x);// The object checked is changed. We don't need to worry about it crashing because x will always be greater than or equal too 0.
					  
					  indexOfObject= indexObject.getName();// The new string to be checked is taken from the new object checked.
				  	} 
				 // When the condition is not true, it means that any previous index is alphabetically correct and the checked string is in the right place.
				 }
				
				if (sorted==false){// If we had to sort even once.
			
				  roster.set(x+1, checkObject);// If we did some sorting, the last index where we left of in the sorting need to be replaced with the string that was being compared.
				}
		}
	}
	
}

public class list{
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
		public String getName(){// Get name
			return name;
		}
		public int getHeight(){//get height
			return height;
		}
		public int getWeight(){// get weight
			return weight;
		}
		public String getCountry(){// get country
			return country;
		}
		public void showEntry(){
			// This is the return method of the object.
			System.out.printf("%-20s %-20s %-20s %-20s", name, height,weight, country);// formated in chart form using printf	
		}		
}

	


