package competetion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hellp {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int[]x=new int[4];
	String xx=br.readLine();
	for(int i=0;i<xx.length();i++){
		char a=xx.charAt(i);
		char q=xx.charAt(i+1);
		int b=Character.getNumericValue(a);
		int c=Character.getNumericValue(q);
		if(a!=' '&&q!=' '){
		x[i]=(b+10+c);
		}
		else if(a!=' '&&b==' '){
			x[i]=(a);
		}
		
	}
	int[]y=new int[4];
	String yy=br.readLine();
	for(int i=0;i<yy.length();i++){
		char a=yy.charAt(i);
		char q=yy.charAt(i+1);
		int b=Character.getNumericValue(a);
		int c=Character.getNumericValue(q);
		if(a!=' '&&q!=' '){
		y[i]=(b+10+c);
		}
		else if(a!=' '&&b==' '){
			y[i]=(a);
		}
	}
	
	int[]w=new int[4];
	String ww=br.readLine();
	for(int i=0;i<ww.length();i++){
		char a=ww.charAt(i);
		char q=ww.charAt(i+1);
		int b=Character.getNumericValue(a);
		int c=Character.getNumericValue(q);
		if(a!=' '&&q!=' '){
		w[i]=(b+10+c);
		}
		else if(a!=' '&&b==' '){
			w[i]=(a);
		}
	}
	
	
	int[]p=new int[4];
	String pp=br.readLine();
	for(int i=0;i<pp.length();i++){
		char a=pp.charAt(i);
		char q=pp.charAt(i+1);
		int b=Character.getNumericValue(a);
		int c=Character.getNumericValue(q);
		if(a!=' '&&q!=' '){
		p[i]=(b+10+c);
		}
		else if(a!=' '&&b==' '){
			p[i]=(a);
		}
	}
	int xxx=(x[0]+x[1]+x[2]+x[3]);
	int ppp=(p[0]+p[1]+p[2]+p[3]);
	int www=(w[0]+w[1]+w[2]+w[3]);
	int yyy=(y[0]+y[1]+y[2]+y[3]);
	
	int rx=(x[0]+p[0]+w[0]+y[0]);
	int rp=(x[1]+p[1]+w[1]+y[1]);
	int rw=(x[2]+p[2]+w[2]+y[2]);
	int ry=(x[3]+p[3]+w[3]+y[3]);
	if(xxx==ppp&&xxx==www&&xxx==yyy&&xxx==rx&&xxx==rp&&xxx==ry&&xxx==rw){
	System.out.print("magic");}
	else if(xxx!=ppp){
		System.out.print("not magic");
	}
	}
			
}
	


