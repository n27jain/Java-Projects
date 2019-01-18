package submits;

import java.util.ArrayList;

public class LittleBlackBookEnator {
	/**
	 * LBB is like a phone book. We store unique last names. 
	 * We then store any first names, phone numbers, and addresses. 
	 * Erase any entries with desired last name. 
	 * Add entries.
	 * Read from previously saved text files. 
	 * Save to a text file separated by commas.
	 * * @author Naman Jain 12/20/2016
	 */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <list> adress = new ArrayList <list>();// our arrayList that will be stored. 
			
		
		int decide; // we will use this int to decide what is asked and to exit the while loop
		
		do{	
				// Menu
			
			System.out.println("");//space
			System.out.println(" Welcome Master!");
			System.out.println(" What do you wanna do? Enter the number before the command:");
			System.out.println("");//space
			
			System.out.println(" 1. Add a new entry.");
			System.out.println(" 2. Delete an entery.");
			System.out.println(" 3. Arrange alphabetically by last name.");
			System.out.println(" 4. Search for records.");
			System.out.println(" 5. Read text file.");
			System.out.println(" 6. ---__SAVE__--- ");
			System.out.println(" 7. Print entries. ");
			System.out.println(" 0. Terminate program.");
			
			
			decide= TextIO.getlnInt();// Take input command.
			
				while (decide>7||decide<0){
				// If the user enters something that is not an option...
					
				System.out.println("Oops! Thats not an option. Try again!");//error message.
				decide= TextIO.getlnInt();// Take input command again.
				
				}
				if (decide==1 ){// If option 1
					newEntry(adress);// use newEntry method
				}
				else if (decide==2){// if 2
					remove(adress);// use the remove method and so on...
				}
				else if (decide==3){// if 3
					sort(adress);// sorting method.
				}
				else if (decide==4){// if 4
					System.out.println(" Whats the last name?");// Ask
					
					String last= TextIO.getln();// This will be the string we check for.
					
					int find= searchIt(adress, last);// this integer is the index on the found last name
					
					if (find==-1){
						// If we couldn't find the last name...
						System.out.println(" We couldn't find the selection!");
					}
					else{
						System.out.println("Ok!");
						System.out.println("");
						list out= adress.get(find);// Because we have found the index, we print the index
						out.showEntry();// showEntry method prints out data from object.
						
						System.out.println("");
					}
					
				}
				else if (decide==5){// if 5
					readFile(adress);// Read the last saved .txt file. 
				}
				else if (decide==6){// if 6
					saveEm(adress);// Save the roster by overwriting. 
				}
				else if (decide==7){
					printIt(adress);// Print method. It will use the sort method. 
				}
				
			}while(decide!=0);// Keep running until user presses 0 to indicate the exiting of the app
			
			System.out.println(" Ok! Until next time coach!");// When the loops been broken, give the exit statement.
		
		
	}
	
	public static void readFile(ArrayList <list> adress){
		
		// readFile reads the . txt file and splits at commas to construct the object. 
		
		adress.clear();// erase my old LBB
		TextIO.readUserSelectedFile();// Read input of choice
		
		while(!TextIO.eof()){// While loop that runs until the last line is read.
			list newList;// The new object that will be put into the array. 
			String process= TextIO.getln();// Get the first set of data. 
			
			String[]pieces= process.split(",");// Splits the string between every comma. 
			
			String last= pieces[0];// First part is last name
			String first = pieces[1];// last part is first name
			long number= Long.parseLong(pieces[2]);//Phone number that is a long value.
			
			String local= pieces[3];// The adress
			
			newList= new list ( last,first,number,local);// The new Object.
			
			adress.add(newList);// Add the object to arraylist. 
		}	
		
		TextIO.readStandardInput();// Return the app to start reading inputs back to the normal way.
	}
	
	public static void saveEm(ArrayList <list> adresses){
		// This saveEm method saves all of our objects. 
		
		TextIO.writeUserSelectedFile();// We write on top of the old doc. 
		
		for(int i=0; i<adresses.size(); i++){ // We keep doing this for every object in the array.
			
			list newlist= adresses.get(i);// We get each object from the array.
			String out=(newlist.getLast()+","+newlist.getFirstName()+","+newlist.getNumber()+","+newlist.getAdress()); // output in proper format with commas
			
			System.out.println("Saving-----"+out);// Show what your saving.
			TextIO.putln(out);// put this string into the textfile.
		}
		
	}
	
	public static void newEntry(ArrayList <list> adress){
		// Method that puts new information into the LBB.
		
		list newList;// The new object that will be put into the array. 
		
		System.out.println("Last name: ");// ask for input
		String last= TextIO.getln();// Get input
		int unique= searchIt(adress,last);// We check to see if the last name is unique.
			
			while (unique!=-1){
				
				System.out.println("Sorry. That name already exists. Try again!");// ask for input
				System.out.println("Last name: ");// ask for input
				last= TextIO.getln();// Get input
				unique= searchIt(adress,last);// We check to see if the last name is unique.
			}
		
		System.out.println("First name: ");// ask for input
		String first= TextIO.getln();// Get the height the first name
		System.out.println("Phone number: ");// ask for input
		long number= TextIO.getlnLong();// Get Long
		
		System.out.println("Adress: ");// ask for input
		String local= TextIO.getln();// get adress
		
		newList= new list (last,first,number,local);// Construct the object
		
		adress.add(newList);// Add the object to arraylist. 
		
	}
	public static void remove( ArrayList<list> adress){
		
		// This method removes an entry, or returns you to the menu if you say no the the confirm sequence.
		
		sort(adress);// use the printable method.
		
		System.out.println(" Whom do you wish to remove?");// Ask
		System.out.println(" Whats the last name?");// Ask
		
		String last= TextIO.getln();// This will be the getInt to determine which player index to remove.
		
		int check= searchIt(adress, last);
			// Otherwise that index exists.
		if (check==-1){
			// If we couldn't find the last name...
			System.out.println(" We couldn't find the selection!");// Ask
		}
		
		int decide=0;// This int will be the confirmation procedure. 
		
		System.out.println("Are you sure that you want to remove"+last); 
		System.out.println("Press 1-YES"); 
		System.out.println("Press 2-No"); 
		
		decide=TextIO.getInt();// Get the yes or no option
		
		if (decide==2){
			System.out.println("Ok. Try again later!!!"); // Message and method will be over. 
		}
		
		if (decide==1){
			adress.remove(check);// We remove the index. Because 0=1 we need to reduce the desired index by 1.
			System.out.println("Ok!");
			System.out.println("");
			System.out.println( last+" Has been removed!!!");// Let them know the entry removed.  
		}
		
		
	}
	public static int searchIt(ArrayList<list> adress, String find){
		// The searching method to find a certain entry.
		// We return -1 if we do not find an index. 
		
		sort(adress);// Arrange the table before you search.
		
		int low=0;//First index
		int high=adress.size()-1;// last index.
	
		while (high >=low) {// As long as the higher valuer is greater than equal to the lowest value.
		    int middle = (low+high) / 2;// This is the middle index
		    
		    	list inspectMiddle= adress.get(middle);// We get the middle object.
		    	String inspected= inspectMiddle.getLast();// We get the name.
		    			     
		    	if (find.equals(inspected)){// If the middle string is the one we are looking for.
		    	
		        return middle;// return this index
		        
		    	}
		    
		      else if (inspected.compareToIgnoreCase(find)>0){// If the middle string comes after the string we want to find...
		    	  
		        high = middle - 1;// We make the high equal to the middle -1. This is to eliminate the indexes to check.
		      }
		      // eliminate locations <= middle
		      else{
		        low = middle + 1;   // Otherwise the middle string comes before the the query and we need to change the new low.
		      }
		}
		  return -1;// If we don't find it we return -1.

	}
	public static void sort (ArrayList<list> adress){
		
		
		// This method arranges the entries alphabetically. 
		// The entries are then permanently saved into the object in the correct order.
		
		boolean sorted = true;// a true/ false motion. 
		
		// Traverse the list until no more swaps made
		for (int i = 1; i < adress.size() ; i++) {
			// We will not check the first index (0) because the second index will be compared to the first.
			sorted= true;// Each time the for loop s run we initially start of with a true statement. When a switch must be made it will become false.
			list checkObject= adress.get(i); // object 2 that will be checked.
			list indexObject= adress.get(i-1); // The object that is in a previous index that will be compared to. changes with the while loop bellow.
			String view = checkObject.getLast();// we get the string from the object.
			String indexOfObject = indexObject.getLast();// We get the string for the object of the index. 
		
			int x= i-1;// This int will be the index that is being checked. 
				
				while(x>=0 && view.compareToIgnoreCase(indexOfObject)<0){
				  // We are using comapareToIgnoreCase method.
				  // When one string has a letter that is a higher value,
				  // it means it is closer to z in the alphabet. 
				  // If our string is supposed to be earlier than the compared string, .compareTo will out put a negative number.
				  // A switch is then required.
				  // If 0 it means strings are same. 
				  
				  sorted=false; // Because the while loop has been run, a switch is required and detected.
				  
				  adress.set(x+1, indexObject);// Because we know the past string is suppose to come after the tested string, we will shift the string to the next index.
				 
				  x--;// The x counts down each time to test a previous string.   
					
				  if(x>-1){// x-- reduces the index that we will check. If the index is a negative number then our app will crash.
				  		// To prevent this, we will make sure x is not a negative number before we check the next index object.
					  
					  indexObject= adress.get(x);// The object checked is changed. We don't need to worry about it crashing because x will always be greater than or equal too 0.
					  
					  indexOfObject= indexObject.getLast();// The new string to be checked is taken from the new object checked.
				  	} 
				 // When the condition is not true, it means that any previous index is alphabetically correct and the checked string is in the right place.
				 }
				
				if (sorted==false){// If we had to sort even once.
			
					adress.set(x+1, checkObject);// If we did some sorting, the last index where we left of in the sorting need to be replaced with the string that was being compared.
				}
		}
	}
	
	public static void printIt (ArrayList<list> adress){
		// Method prints the names in a list.
		sort(adress);// Sort our entries before we print. 
		System.out.printf("%-20s %-20s %-20s %-20s", "Last Name", "First Name ","Number","Adress");// The table heading
		System.out.println("");// space
		
		for (int i=0; i< adress.size();i++){
			// For loop that checks every object in the arrayList. We use int i for each index.
			
			adress.get(i).showEntry();// prints out the inputed string. 
			
			System.out.println("");// Space
		}
	}	
}

class list{
	// Object that stores the inputs and outputs a formatted string. 
	private long number; // Int variables 

	private String firstName="", last="", adress="";// String variables
	
	public list(String Last , String FirstName, long  Number, String Adress ){
		// constructor
		last = Last;
		
		firstName = FirstName;
		
		number= Number;

		adress = Adress;
	}
	public String getFirstName(){// Get name
		return firstName ;
	}
	public String getLast(){//get height
		return last;
	}
	public String getAdress(){// get weight
		return adress;
	}
	public long getNumber(){// get country
		return number;
	}
	public void showEntry(){
		// This is the return method of the object.
		System.out.printf("%-20s %-20s %-20s %-20s", last, firstName,number, adress);// formated in chart form using printf	
	}		
}

