package Useful;
import submits.TextIO;

public class wordenator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Create an app in which you type any text
		 * then it outputs only the letters and numbers
		 * excludes all other characters
		 * Each time a new word is typed
		 * print the next word on the next line
		 * @author Naman Jain 01/07/2016
	     */
		
		// Declare the useful variables
		String a;// The string that you type.
		int i;// COunter that is used to inspect each letter on string.
		
		
		

		
		System.out.println("What'd You Say?");// Asks for you to type some text.
	
		a=TextIO.getlnString();  // Lets you type some input text.
	
		
	for(i=0;i<a.length();i++)// Loop that inspects each character in the string.
	{
		char y=a.charAt(i);// This is the character that the program 
							//gets each time the loop is used.
	
		if ((y<='Z'&&y>='A')||(y<='z'&&y>='a')||(y<='9'&&y>='0'))// Filters any numbers and letter.
		{
			System.out.print(y);// Prints that character. 
			//Now the next letter will just add on to the previous untill space bar is pressed.
			}
		
		else if (y==' ') // When space is pressed...
		{
			System.out.println();// New line is created.
			// Note: Since other symbols were not declared, 
			// they wont be used. :)
			}
		

			
		}
			
		
		
	
	}

	}
	


		 
		
		


