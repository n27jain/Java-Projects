
package submits;

import java.util.ArrayList;

public class Pivotator {

	/**
	 * Create an app that reads a user-selected space-delimited text
	 *  file of integers and “pivot”s the table 
	 *  – rows become columns and columns become rows. 
	 *  The pivoted table should be output to another user-selected file. 
	 * No output to the screen is necessary, but is optional.
	 * @author Naman Jain 02/16/2017
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Taking file...");
		int[][]takefile= readFile();// lets read the file
		
		int[][]pivot= pivot(takefile);// we will pivot the file
		
		outfile(pivot);// now we export the file
		System.out.println("Saved file");
	}
	
	
	
	
public static int[][] readFile(){
		
		// readFile reads the . txt file and splits at commas to construct the object. 
		// assume file has vaild data. 
		
		TextIO.readUserSelectedFile();// Read file of choice 
		
		ArrayList <String []> listOfArrays = new ArrayList <String []>();// arrayList of arrays
		
		int c=0;// will be the number of columns
	
		while(!TextIO.eof()){// While loop that runs until the last line is read.
			
			String read= TextIO.getln();// Get the first set of data. 
			
			String[]pieces= read.split(" ");// Splits the string between every space. 
			
			listOfArrays.add(pieces);// we keep adding the broken array to the arraylist. 
			
			c= pieces.length;// This will the the number of columns in the data.	
		}
		
		int a= listOfArrays.size();// The size of the arraylist helps us count the number of rows.
		
		
		int[][]out= new int[a][c];// we have learned the size of the new array and so we construct it.
		
		for(int q=0;q<out.length;q++){// this for loop constructs it. 
			
					String [] review =listOfArrays.get(q);// create a new String array from our arraylist 
					
					for(int i=0; i<out[0].length;i++){//for loop helps populate the array. 
						
						int insert = Integer.parseInt(review[i]);//we convert the string into int. 
						out[q][i]=insert;// we populate
						}
				}
		
		TextIO.readStandardInput();// Return the app to start reading inputs back to the normal way.
		return out;// return the populated array
	}

public static void outfile(int [][]pivot){
	// we output our new file. 

	TextIO.writeUserSelectedFile();// Select the location or the file to overwrite.
	
	for(int i=0; i<pivot.length;i++){// for loop convert the array into proper format with spaces. 
		String out="";// out out string.
		for(int q=0; q<pivot[0].length;q++){// this for loop finds the parts of the first line
			out=(out+pivot[i][q]+" ");// add each element into the string
		}
		
		TextIO.putln(out);// put this string into the textfile.// put this string line into the doc
	}

	
}

public static int[][] pivot(int[][]takefile){
	// this method does all the pivoting. 
	
	int[][]out= new int [takefile[0].length][takefile.length];// this will be the output array.
	
	for(int q=0;q<takefile.length;q++){// we use this loop to find each value.
		
		for(int i=0; i<takefile[0].length;i++){
			
			out[i][q]= takefile[q][i];// this is the  value that we pivot.
		}
	}
	return out;// return the array. 
	
}



}
