package competetion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prac {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[]x=new int[7];
		int i;
		String xx=br.readLine();
		for( i=0;i<xx.length();i++){
			char a=xx.charAt(i);
			
			int b=Character.getNumericValue(a);
			if(a!=' '){
				x[i]=b;
			}
			else if(a==' '){
				
			}
			
		}
		System.out.print(x.length);
}
}
