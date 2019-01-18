package competetion;
import java.util.Scanner;
import java.io.IOException;

public class hidden {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
	
		int e=sc.nextInt();
		int f=sc.nextInt();
		int g=sc.nextInt();
		int h=sc.nextInt();
		
		int i=sc.nextInt();
		int j=sc.nextInt();
		int k=sc.nextInt();
		int l=sc.nextInt();
		
		int m=sc.nextInt();
		int n=sc.nextInt();
		int o=sc.nextInt();
		int p=sc.nextInt();
		
		int aa=a+b+c+d;
		int aaa=a+e+i+m;
		
		int bb=e+f+g+h;
		int bbb=b+f+j+n;
		
		int cc=i+j+k+l;
		int ccc=c+g+k+o;
		
		int dd=m+n+o+p;
		int ddd=d+h+l+p;
		if(aa==bb&&bb==cc&&cc==dd&&dd==aa&&aaa==aa&&bbb==bb&&cc==ccc&&dd==ddd){
		System.out.print("magic");
		}
		else if(aa!=bb||bb!=cc||cc!=dd||dd!=aa||aaa!=aa||bbb!=bb||cc!=ccc||dd!=ddd){
			System.out.print("not magic");
		}
	}

}
