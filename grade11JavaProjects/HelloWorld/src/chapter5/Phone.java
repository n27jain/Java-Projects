package chapter5;

public class Phone {

	

		public static void main(String[] args) {
			  // Declare a set of dice
		    Contact person1;

		     // Construct the object using set values
		    person1 = new Contact(6, 6);

		    System.out.println("You started with " + person1.die1 +  " and " + person1.die2);
		    
		     // But I should roll them to be fair
		    person1.roll();

		    System.out.println("After rolling we got " + person1.die1 + " and " + person1.die2);

		    // Or we can declare and construct at the same time
		    Contact person2 = new Contact();

		    System.out.println("The second pair started with " + person2.die1 + " and " + person2.die2);
		  }
		    
		} // end class PlayingWithDice



	class Contact {

		   // Number showing on the first die.
		  public int die1;
		   // Number showing on the second die.
		  public int die2;    

		  public Contact() {
		     // Constructor.  Rolls the dice, so that they initially
		     //   show some random values.
		    roll();  // Call the roll() method to roll the dice.
		  }
		 
		  public Contact(int val1, int val2) {
		     // Constructor.  Creates a pair of dice that
		     //   are initially showing the values val1 and val2.
		    die1 = val1;  // Assign specified values 
		    die2 = val2;  //   to the instance variables.
		  }

		  public void roll() {
		     // Roll the dice by setting each of the dice to be
		     //   a random number between 1 and 6.
		    die1 = (int)(Math.random()*6) + 1;
		    die2 = (int)(Math.random()*6) + 1;
		  }
	}

}
