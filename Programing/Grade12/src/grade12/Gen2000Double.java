import submits.TextIO;

public class Gen2000Double {

	/**
	 * Generates a text file with 200 doubles within a given range
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int length;
		double low, high;
		
		// Get extrema
		System.out.print("Lower extreme? ");
		low = TextIO.getlnDouble();
		System.out.print("Upper extreme? ");
		high = TextIO.getlnDouble();
		
		// Put extrema in correct order
		if (high < low) {
			double temp = low;
			low = high;
			high = temp;
		}

		// Get length of file
		System.out.print("How many numbers? ");
		length = TextIO.getlnInt();
		
		// Open file
		TextIO.writeUserSelectedFile();
		
		// Write numbers
		for (int i = 0; i < length; i++)
			TextIO.putln( (Math.random() * (high - low)) + low );
	
		System.out.println("Done!");
	}

}
