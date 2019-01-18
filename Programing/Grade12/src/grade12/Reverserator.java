package grade12;

public class Reverserator {

	public static void main(String[] args) {
		/**
		*Create an app asks the user for a string, then prints the reverse of the string recursively.
		*The only string operations you can use are + concatenation, charAt and subString. 
		*The recursive method should return the reversed string to the main method.
		* Save to a text file separated by commas.
		* * @author Naman Jain 04/13/2017
		*/
		
    
		System.out.println("Enter a string:");// Take in the input
		String in= TextIO.getln();// this is the inputed string.
		
		String out =flipin(in);// using the recursion method that flips the line, string out it the output. 
		System.out.println(out);// print the flipped string.
	}
	
	  public static String flipin(String in){// flipping method
		  
	        char locate = in.charAt(in.length()-1);// since charAt index 0 is char number 1, 
	        //we need to subtract one from the length of the string in order to get the correct index char.  
	        
	        if(in.length() == 1) { // When the length of the the string is 1, index is 0.
	        						//in this case this is the first char in the string that will be printed last.
	        	
	        	return Character.toString(locate);// so we return this value to be printed last.
	        }
	        

	        
	        return locate + flipin( in.substring(0,in.length()-1) );// We keep doing this and adding a new char to the string 
	       													//until we hit the first char of the original string.
	        // The substring method allows to shrink out input by one char each, this way the last letter is removed each time.
	        //(0, means that no change in the front of the string.    in.length()-1) means that we remove one char from the right.
	        // This way, each time the flipin method is called, string in is replaced with a substring version. 
	        
	        
	        
	        // i.e Jassy Babe
	        //return e + flipin(Jassy Bab) --- return  e+ b +flipin (Jassy Ba) and so long. 
	    
	  }

}

