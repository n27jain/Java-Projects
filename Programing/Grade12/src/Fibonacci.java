import java.io.IOException;
import java.util.InputMismatchException;

import submits.TextIO;


public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int n= TextIO.getlnInt();
		
			
	try {	
	for(int i=1;i<=n ;i++) {
		
		int yolo=fibonacci(i);
		System.out.println(yolo);
	}
	}catch(NumberFormatException e){
		System.out.println("Too Big");
	}
	
}
	
	public static int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	   
	}


	
}
