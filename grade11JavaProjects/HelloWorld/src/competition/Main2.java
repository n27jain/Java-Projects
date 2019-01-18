
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int x=Integer.parseInt(br.readLine());
	int y=Integer.parseInt(br.readLine());
	int z=Integer.parseInt(br.readLine());
	
	if(x==60&&y==60&&z==60){
		System.out.print("Equilateral");
	}
	else if(x+y+z==180){
		if (x==y||y==z||x==z){
			System.out.print("Isosceles");
		}
		else if(x!=y&&x!=z||y!=z&&y!=x){
			System.out.print("Scalene");
		}
	
	}
	else if(x+y+z!=180){
		System.out.print("Error");
	}
		
	}

}
