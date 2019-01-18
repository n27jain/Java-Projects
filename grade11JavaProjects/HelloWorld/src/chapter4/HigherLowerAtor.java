package chapter4;

import TextIO;

public class HigherLowerAtor {
	// TODO Auto-generated method stub
			/**
			 * Create an app that allows the user to guess a (single) card 
			 * by guessing a suit and face value. 
			 * The computer should keep track of the user’s guesses in an array, 
			 * to a maximum of 10 guesses. 
			 * the computer should tell the user whether the face value of the chosen card is higher or lower than the user’s guess. 
			 * After the game is won or lost... 
			 * the app should list each of the player’s guesses (from the array).
			 * @author Naman Jain 03/19/2016
		     */
	public static void main(String[] args) {
		//The main method.
		// Here all of the other methods are ultimately used.
		
		
		
		int rar=secretCard(); // Starts with a random card that the computer generates.
		
		int compare=0; // initialize the compare number.(later used to exit the game.)
		
		int[]air=new int[10]; // initialize the array.
		
		
		System.out.println("I bet you can't guess my card! I'll give you 10 tries."); // Start with the opening statement.
		
		System.out.println(""); // Leave space.
		
		
		
		for (int x=0;x<10&&compare!=1;x++){ // For loop that operates the app until 10 guessed are up, 
											// or until the user guesses the right card and compare = 1;
			
			int y=x+1;// this is counter used to determine the number of guesses because x is one number less than the number of guess made.
			
			int left=10; // used to determine the number of turns left.
			
			left=left-y; // subtract 10 from the number of turns taken to get total turns left. 
			
			int pick=userCard(); // use the userCard method in order to get the users guess each time.
			
			
			air[x]=pick; // each time the user enters a guess it is stored in the array.
			
			compare=compareCards(rar,pick); // Use the compareCards method to find out what is the result of the guess. 
											// rar id the computers card. 
			
			
			if (compare==0){  						// when user is wrong...
				
				System.out.print("You chose the "); // tell then their choice,
				
				printCard(pick);					// use the printCard method to use the card number and print it out.					
				
				System.out.println(", but that's not my card!"); // finish the sentence.
				
				int decide=compareFace(rar,pick);	// Now user the compareFace method to determine if the card is a high number or low.
				
				
					if(decide==-1){ // if card is a lower value...
						
						System.out.print("My card has a higher face value than the "); // finish the previous statement explaining
																						// that the computers card has a higher face value.
						printCard(pick); // print users guess
						
						System.out.println(".");// end sentence.
						
					System.out.println("You have "+left+ " guesses left.");// let user know how many guess are left.
					
					}
					
					else if (decide==1){ // when the guess is higher...
						
						System.out.print("My card has a lower face value than the "); // finish previous statement
						
						printCard(pick); // print users card.
						
						System.out.println("."); // end sentence.
						
					System.out.println("You have "+left+ " guesses left."); // let user know how many guess are left. 
					
					}
					
					else if (decide==0){ // when the face value is the same but card suit is different.
						
						System.out.print("My card has the same face value as the ");// finish previous statement.
						
						printCard(pick); // print users card.
						
						System.out.println("."); // end sentence.
						
					System.out.println("You have "+left+ " guesses left."); // let them know how many guesses left. 
					
					}
				}
				
			else if (compare==1){ // otherwise you have guessed the right card!
				
				System.out.print("You chose the ");// start congratulations
									
				printCard(pick); // print users card.
									
				System.out.println(" - that's my card!");// end statement.
					
				System.out.println("You guessed my card in "+y+ " guesses !"); // tell user the number of guesses made.
				
				printGuess(air,x); // using the printGuess method... the computer prints out each card that the user guessed. 
			}
			
			
		}
		
		
	}
	
	private static int secretCard() {
		
		// Method for the secret card to be generated that needs to be guessed. 
		
		double random;// For math.random to work, you need to declare a double.
		
		random=Math.floor (Math.random()*52);// Math method that generates number from 0-51.
		
		int cardValue = (int) random;// To make other calculations easier, the double value is converted to int.
		
		return cardValue; // return the secret card.
	}
	
	private static int userCard(){
		
		// Method that asks for and takes users guess.
		// Returns the users guess in computer language from 0-51;
		
		int out;// declare the int that will be returned.
		
		System.out.println("");// leave a space.
		
		System.out.println("Guess a suit by chosing the number corresponding (1)Clubs, (2)Diamonds, (3)Hearts, (4)Spades: ");// give options that accept ints only
		
		int suit= TextIO.getInt();// take choice.
		
		
			while(suit>4||suit<1){ // while you chose invalid int...
				
				System.out.println("Try again! There is no such suit!");// give error message.
				
				System.out.println("Guess a suit by chosing the number corresponding (1)Clubs, (2)Diamonds, (3)Hearts, (4)Spades: ");// ask again.
				
				suit= TextIO.getInt();// take choice.
			}
		
		System.out.println("Guess a face value by entering the corresponding number  (1)Ace, (2-10), (11)Jack, (12)Queen, (13)King: ");// ask for face value accepting only ints.
		
		int face= TextIO.getInt();// take choice.
		
		
		while(face>13||suit<0){// while you chose an invalid int...
					
					System.out.println("Try again! Thats an invalid number!");// give error message
					
					System.out.println("Guess a face value by entering the corresponding number  (1)Ace, (2-10), (11)Jack, (12)Queen, (13)King: ");// and ask agian.
					
					face= TextIO.getInt();// take choice.
				}
		
		
		out= (face*4)-suit; // calculates the value of the chosen card.
		
		return out;// returns that card.
	
		}
	
	
	private static int compareCards(int secretCard, int userCard){
		// Method decides if the computers card matches the guess.
		
		int out = 0;// Outs starts off as 0 indicating that the card is not a match...
		
		if(secretCard==userCard){// However, if the cards match...
			
			out=1;// the computer returns 1;
		}
		
		return out;// return the decision.
	}
	
	
	private static int compareFace(int secretCard, int userCard){
		// Method that compares the cards face value in order to determine is the card is high or low.
		
		int comp;	// this is the computers face value
		int play;	// players face value
		int out = 0;// out is the return value. Starts off as 0 assuming that the face values match.
		
		comp=(int) Math.floor(secretCard/4);// Calculate the face value of the card. Math.floor helps achieve the accurate value.
		
		play=(int) Math.floor(userCard/4); // Calculate the face value of the card. Math.floor helps achieve the accurate value.
		
		
		
		if(play<comp){// If player's card is lower in value...
			out=-1;// Return -1.
			
		}
		
		else if(play>comp){// If player's card is lower in value...
			out=1;// Return 1.
			
		}
		
		return out;// Return the chosen number.
	}
	
	
	public static void printCard(int cardy){
		
		//printCard method looks at any given int form 0-51 and converts it to the usual card values.
		//(i.e 0= Ace of Spades).
		
		
		int ana=cardy%4;// int ana is the suit determiner.
		int in = 0;		// int in  is the face determiner.
		
		String suit=null;// String that contains the suit name.
		String face=null;// String that contains the face value or name (i.e Kings)
		
	
		
		if(ana==1){
			// When remainder is 1...
			// Suit is Hearts
			suit=("Hearts");
		}
		
		else if(ana==2){
			// When remainder is 2...
			// Suit is Diamonds.
			suit=("Diamonds");
		}
		
		else if(ana==3){
			// When remainder is 3...
			// Suit is Clubs.
			suit=("Clubs");
		}
		if(ana==0){
			// When remainder is 0...
			// Suit is Spades
			suit=("Spades");
			
		}
		
			
		in=(int) Math.ceil(cardy/4);// to find the face value we divided the card number by 4 and round the card value down.
		
		in++;// since 0 will a a certain value, we make all face values go up one number to make coding easier. 
		
		
		if(in>1&&in<11){// when the face value lies in 2-10, output it as itself.
			face=(""+in);
		}
		
		else if(in==1){// if the value is 1 then write Ace.
			face=("Ace");
		}
		
		else if(in==11){// if the value is 11 then write Jack.
			face=("Jack");
		}
		
		else if(in==12){// if the value is 12 then write Queen.
			face=("Queen");
		}
		
		else if(in==13){// if the value is 13 write King.
			face=("King");
		}
		
		System.out.print(face+" of "+suit);// Add up the strings to print card. 
	}
	
	
	
	public static void printGuess(int air[], int x){
		
		// Method that shows user the guesses made.
		
		System.out.println("Your guesses :");// Statement.
		System.out.println("");// Space.
		
		
		for(int i=0;i<=x;i++){// For loop that inspects each array value.
			
				
			printCard(air[i]);// convert each array value into the appropriate card value.
			
			System.out.println("");// leave space.
			
			
		}
	}
	
	
	
	
}
