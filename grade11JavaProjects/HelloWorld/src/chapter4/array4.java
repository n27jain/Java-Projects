package chapter4;

import TextIO;

public class array4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]x=pin();
		int chosen=max(x);
		System.out.print(chosen);
		
	}
	public static int max(int[]x){
		int max=0;
		int chosen=0;
		for(int i=0;i<x.length;i++){
			chosen=x[i];
			if(chosen>max){
			max=chosen;
			}
			
		}
		return max;
	}
	public static int [] pin(){
		int[] pin= new int [10];
		System.out.println("Chose the integer 1");
		pin[0]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 2");
		pin[1]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 3");
		pin[2]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 4");
		pin[3]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 5");
		pin[4]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 6");
		pin[5]= TextIO.getlnInt();
	
		System.out.println("Chose the integer 7");
		pin[6]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 8");
		pin[7]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 9");
		pin[8]= TextIO.getlnInt();
		
		System.out.println("Chose the integer 10");
		pin[9]= TextIO.getlnInt();
	
		return pin;
		
		
	}
}
