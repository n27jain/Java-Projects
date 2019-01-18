package competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class doubledice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int a=100;
		int b=100;
		int start=1;
	int round=Integer.parseInt(br.readLine());
	
	
	do{
		
		start++;
		String roll=br.readLine();
		char ant=roll.charAt(0);
		char dav=roll.charAt(2);
		int an=Character.getNumericValue(ant);
		int da=Character.getNumericValue(dav);
		
		
		if(an>da){
			b=b-an;
			}
		else if (an<da){
			a=a-da;
		}
		else if(an==da){
			
		}


	
		
		
	}while(start<=round);
	System.out.println(a);
	System.out.println(b);
	}
}
