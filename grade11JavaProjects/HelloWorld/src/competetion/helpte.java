package competetion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class helpte {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[]x=new int[4];
		String xx=br.readLine();
		for(int i=0;i<xx.length();i++){
			char a=xx.charAt(i);
		
			int b=Character.getNumericValue(a);
			
			if(a!=' '){
			x[i]=(b);
			}
			if (a==' '){
				a=xx.charAt(i+1);
				b=Character.getNumericValue(a);
				x[i]=(b);
			}
		System.out.println(x[i]);	
		}
	}

}
