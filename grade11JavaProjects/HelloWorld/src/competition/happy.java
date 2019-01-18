package competition;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class happy {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String in=br.readLine();
	int smile=0;
	int frown=0;
	for(int i=2;i<in.length();i++){
		char a=in.charAt(i-2);
		char b=in.charAt(i-1);
		char c=in.charAt(i);
		if(a==':'&&b=='-'&&c==')'){
			smile++;
		}
		else if(a==':'&&b=='-'&&c=='('){
			frown++;
		}
	}
	
	if(smile==0&&frown==0){
		System.out.print("none");
	}
	else if(smile>frown){
		System.out.print("happy");
	}
	else if(smile<frown){
		System.out.print("sad");
	}
	else if(smile==frown){
		System.out.print("unsure");
	}
	}
	

}
