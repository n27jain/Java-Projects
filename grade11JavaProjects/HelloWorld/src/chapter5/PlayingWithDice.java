package chapter5;

public class PlayingWithDice {
	  public static void main(String[] args) {
	     // Declare and construct a random set of dice
	    PrivatePairOfDice dice1 = new PrivatePairOfDice();

	    System.out.println("The private pair started with " + dice1.getDie1() + " and " + dice1.getDie2());


	     // Roll the dice using the same method as before
	    dice1.roll();

	    System.out.println("The private pair started with " + dice1.getDie1() + " and " + dice1.getDie2());

	  }
	    
	} // end class PlayingWithDice2


	 


	class PrivatePairOfDice {

		   // Number showing on the first die.
		  private int die1;
		   // Number showing on the second die.
		  private int die2;    

		  public PrivatePairOfDice() {
		     // Constructor.  Rolls the dice, so that they initially
		     //   show some random values.
		    roll();  // Call the roll() method to roll the dice.
		  }
		 
		  public void roll() {
		     // Roll the dice by setting each of the dice to be
		     //   a random number between 1 and 6.
		    die1 = (int)(Math.random()*6) + 1;
		    die2 = (int)(Math.random()*6) + 1;
		  }

		  public int getDie1() {
			  
		    return die1;
		  }

		  public int getDie2() {
		    return die2;
		  }

		} // end class PrivatePairOfDice
