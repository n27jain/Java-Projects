package Useful;
import Useful.TextIO;

public class Casnioproper {
	/**
	 * This app is a Casino game app.
	 * Try your luck and win the cash
	 * User gets 10 credits and can play any of the three games provided. 
	 * Slots generates 3 numbers out of 4 
	 * 	If you get 3 match, you get 10:1
	 * 	If math you get 2:1
	 * Guessing game 
	 * you pick a number from 1-3 
	 * User tries to guess the number – a correct guess pays out 3:1
	 * •	(Bonus T/A) Roulette: Generate a random number between 0-36. 
	 * User chooses to bet on Even, Odd, Low (1-18),
	 *  High (19-36) 
	 *  or a specific number (0-36) 
	 *  -- even/odd (not 0) pay out 2:1
	 * low/high pay out 2:1
	 *  specific numbers pay out 30:1
	 *  At then end you can quit and leave with you credits!
	 * @author Naman Jain 02/02/2016
     */
	private static int mainMenu() // This is the main menu method. We perform the game startup here. 
	{
		int pot;// This is the choice you make.

		
		String slots=("  1. Slots");// Simplify strings ask for game 1 (this is in case you wish to add more to the strings later.)
		String gess= ("  2. Guessing Game");// Simplify strings ask for game 2
		String role=("  3. Roulette");// Simplify strings ask for game 3
		String endgame=("Or would you like to (4) leave the casino?"); // Simplify strings ask to leave
		
		
		System.out.println(slots);//output simplified string
		System.out.println(gess);//output simplified string
		System.out.println(role);//output simplified string
		System.out.println(endgame);//output simplified string
		
		
		pot= TextIO.getlnInt(); // Ask for the choice
		return pot;// return the choice.
	}



	private static int bet() // This method analyzes the amount of credits you want to bet.
	{
		int pot;// What you put into the game.
		System.out.println("How many credits would you like to play (up to 5)?");// Ask for credits
		pot= TextIO.getlnInt();// takes credit amount
		
		while (pot<=0&&pot>5)// While pot does not meet requirements for the bet.
		{
			System.out.println("Thats not a valid amount! Lets try this again or we will have to call securtiy !");// Tell them its not proper
			System.out.println("How many credits would you like to play (up to 5!!!!!!)?");// Ask them again
			pot= TextIO.getlnInt(); // take the new pot value.
		}
		
		
		return pot;// return the bet value.
	}

	private static int bank(int all, int choice, int joy)
	// This is our bank.
	// Here we store the credits, 
	// complete the math for increases and decreases
	// and give our main method the final remainder.
	{
		int cash =all; // the stored cash is the last remaining cash.
		
		int incoming=choice; // this is the amount that is incoming from the specific games.
		
		cash=cash-joy; // We need to subtract the bet(joy) from our original bank statement to get remaining.
		
		cash=cash+incoming; // now we add the new winnings ( this includes the original bet value).
		
		return cash;// Let our final statement be used by our main method. return this value. 
		
	}
	
	
	private static int slots (int bet)// This is the slots game method. We use the bet value to output our winnings.
	{
		int out=0;// This will output. Initial amount is given.
		
		int x=(int) Math.floor (Math.random()*4+1);// First slot number randomly generated from 1-4.
		int y=(int) Math.floor (Math.random()*4+1);// Second number generated.
		int z=(int) Math.floor (Math.random()*4+1);// Third number is generated. 
		
		System.out.println("Betting "+bet+" credits on the slots . . .");// Tells user what is at stake.
		System.out.println("    Slots came up to be "+x+" "+y+" "+z+" ");// Tells user the slot values.
		
		if(x==y&&y==z)// When x equal the other 2, they all equal one another...
		{
			out= bet*10;// Out bet is multiplied by 10 when we match 3 numbers.
			
			System.out.println("You matched 3 numbers! You gain "+out+" credits!"); //Tells you the result
		}
		else if (x==y&&y!=z||x==z&&z!=y||x!=y&&x!=z&&z==y)// When 2 numbers match ...
		{
			out=bet*2;// Out bet is multiplied by 2.
			
			System.out.println("You matched 2 numbers! You gain "+out+" credits!");//Tells you the result
		}
		else if(x!=y&&y!=z&&z!=x){
			out=0;
			System.out.println(" Sorry there bud. You matched nothing! You lost your "+bet+" credits!");//Tells you that you lost.
		}
		return out;// Give out the final outcome of the credits.
	}


	private static int guessingGame (int bet)// This is the method for the guessing game. We use the bet to find the outcome.
	{
		int out=0;// initial starting of out output
		int guess; // this is to get our guessing value.
		
		System.out.println("What is your guess?");// Ask for the guess.
		
		guess= TextIO.getlnInt();// take the value.
		
		int pot=(int) Math.floor (Math.random()*3+1);// this is the int that the casino generates from 1-3, randomly.
		
		if(pot==guess)// If your guess is same as computers number...
		{
			out=bet*3;// Your bet is multiplied by 3. 
		}
		else if(pot!=guess) //If your guess is wrong ...
		{
			System.out.println("Sorry! The number was actually "+pot+" You lose "+bet+" credits.");
			out=0;
		}
		return out;// you get back 0 credits. 
	}


	private static int rou(int bet)// Method for roulette game.
	{
		int out=0;// initial return value. 
		int guess=(int) Math.floor (Math.random()*36+1);// Computer picks the number between 0-36.
		int oddEve=guess%2; // This is to find out if the number is odd or even. No remainder means even and remainder of 1 means odd.
		int pick; // You pick an option.
		
		System.out.println("");// Leave some space
		System.out.println("");// Leave some space
		
		System.out.println("Would you like to bet on:");// Ask what to bet on.
		System.out.println("1. Odd numbers (1, 3, 5....)");// odd numbers excluding 0
		System.out.println("2. Even numbers (2, 4, 6...)");// even numbers excluding 0
		System.out.println("3. Low numbers (1 to 18)");// low numbers excluding 0
		System.out.println("4. High numbers (19 to 36)");// high numbers excluding 0.
		System.out.println("5. Specific number (0 to 36)");// specific numbers.
		
		pick= TextIO.getlnInt();// Get the choice
		
		if (pick==1)// If option 1 is chosen...
		{	
			if(oddEve==1)// and the generated number is odd...
			{
			out=bet*2;// Bet is doubled!
			
			System.out.println("Betting "+bet+"credits on odds...");// Tell the stakes.
			System.out.println("   Roulette came up "+guess);		// Tell what happened.
			System.out.println("You won! You gain "+out+" credits!");// Tell the outcome.
			}
			else if(oddEve!=1)// If the number is not odd...
			{
			out=0; // You have lost your bet.
			
			System.out.println("   Roulette came up "+guess); // Tell have happened.
			System.out.println("You lost! You lost "+bet+" credits!"); // Tell that they lost.
				
			}
		}
		else if (pick==2)//If option 2 is chosen...
		{
			if(oddEve==0&&guess!=0)// and the generated number is even and not zero...
			{
			out=bet*2;// Bet is doubled!
				
			System.out.println("Betting "+bet+"credits on eves...");// Tell the stakes.
			System.out.println("   Roulette came up "+guess);		// Tell what happened.
			System.out.println("You won! You gain "+out+" credits!");// Tell the outcome.
			}
			
			else if(oddEve!=0)// If the number is not odd...
			{
			out=0; // You have lost your bet.
				
			System.out.println("   Roulette came up "+guess); // Tell have happened.
			System.out.println("You lost! You lost "+bet+" credits!"); // Tell that they lost.	
			}
			
		
		}
		else if (pick==3&&guess>=1&&guess<=18)// If you chose option 3 and you were right..
		{
		out=bet*2;// Bet is doubled!
		
		System.out.println("Betting "+bet+"credits on low #'s...");// Tell the stakes.
		System.out.println("   Roulette came up "+guess);		// Tell what happened.
		System.out.println("You won! You gain "+out+" credits!");// Tell the outcome.
		}
		
		else if (pick==4&&guess>=19&&guess<=36)// If you chose option 4 and you were right...
		{
		out=bet*2;// Bet is doubled!
		
		System.out.println("Betting "+bet+"credits on high #'s...");// Tell the stakes.
		System.out.println("   Roulette came up "+guess);			// Tell what happened.
		System.out.println("You won! You gain "+out+" credits!");	// Tell the outcome.
		}
		
		else if (pick==3&&guess>18||pick==4&&guess<19)// If you chose low when there was a high number...
			// or if you chose high when there was a low number...
			// or if you chose the wrong number...
		{
		out=0; // You have lost your bet.
		
		System.out.println("   Roulette came up "+guess); // Tell have happened.
		System.out.println("You lost! You lost "+bet+" credits!"); // Tell that they lost.
		}
		
		else if (pick==5)// Special case
		{
		System.out.println("What number would you like to bet on?");// Asks you for the number u wan to bet on.
		
		int gamble= TextIO.getlnInt(); // Takes the value.
		
		System.out.println("Betting "+bet+"credits on number "+gamble); // Tell the stakes.
		
			if(gamble==guess)// If you choose correctly..
			{
			out=bet*30;// Your bet if multiplied by 30@
			System.out.println("   Roulette came up "+guess);// Tell what happened.
			System.out.println("You won! You gain "+out+" credits!");// Tell the outcome.
			}
			
			if(gamble!=guess)// If you choose incorrectly..
			{	out=0; // You have lost your bet.
			
			System.out.println("   Roulette came up "+guess); // Tell have happened.
			System.out.println("You lost! You lost "+bet+" credits!"); // Tell that they lost.
			}
			
		}
		
	
	return out;// Give out the new credit amount.
	}


	public static void main(String[] args) // The main method. This is where we put it all together. 
	{
		// TODO Auto-generated method stub
		
	int joy; // The bet that you make.
	
	int choice; // The game the you choice gives its output as this int.
	
	int remains=10;// This is the remains of the credits that is used for the strings. We start of will 10.
	
	int gameChoice;// This is the int we get from our main menu to see the choice of the game.
	
	
	System.out.println("Welcome to the Casinoator Royaleator!");// Welcome the user.
	System.out.println("Take you luck and leave your cash!");   // Wish them luck (they are not gonna need it)
	
	System.out.println(""); // leave gap
	System.out.println(""); // leave gap
	
	
	
	
	
	
	
	
	do // This is the core of our program.
	{
	System.out.println("");// leave gap
	System.out.println("");// leave gap
	
	String result=("You have "+remains+" credits left. Do you wish to play:"); // Tells you the amount of credits left.
	
	System.out.println(result);// Print the generated string.
	
	gameChoice=	mainMenu();// Take us to the main menu and continue the app from there.
	
	
	if (gameChoice==1)// When the gamechoice is game 1...
	{
		joy=bet();// Take the bet from the user. (use bet method)
		
		choice=slots(joy); // Play the slots game. Use the joy bet value, and get the decision of the game.
		
		remains=bank( remains, choice, joy);// Use bank method to do the math.
										// all is used for the last remainder of credits
										// Choice is the games result.
										// Joy is out bet. 
		
		
	
		}
	
	else if (gameChoice==2)// When the gamechoice is game 2...
	{
		joy=bet();// Take the bet from the user. (use bet method)
		
		choice=guessingGame(joy);// Play the guessing game. Use the joy bet value, and get the decision of the game.
		
		remains=bank(remains, choice, joy);// Use bank method to do the math.
										// all is used for the last remainder of credits
										// Choice is the games result.
										// Joy is out bet. 
		
		}
	
	else if (gameChoice==3)// When the gamechoice is game 3...
	{
		joy=bet();	// Take the bet from the user. (use bet method)
		
		choice=rou(joy);	// Play roulette. Use the joy bet value, and get the decision of the game.
		
		remains=bank(remains, choice, joy);// Use bank method to do the math.
										// all is used for the last remainder of credits
										// Choice is the games result.
										// Joy is out bet. 
		
		
		}
	else if (gameChoice==4)// When you want to quit.
	{
		
		System.out.println("You left with "+remains+" credits. See you next time!");// Tell them what they leave with.
	}
	if (remains<=0) // When there are no credits left.
	{
		System.out.println("You left bankrupt you loser! We should have never given you our 10 credits!");
		// Make fun of them for losing the easy game.
	
	}
	
		}while(gameChoice!=4&&remains>0);// Keep the game rolling until those conditions have been met. 
		
	}

}



