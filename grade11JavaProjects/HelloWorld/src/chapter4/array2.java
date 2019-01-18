package chapter4;

import TextIO;

public class array2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int abc;
		System.out.println("Chose the number:");
		abc= TextIO.getlnInt();
		int one[]=new int [abc];
		
		
		
		one=array(one);
		print(one);
	}
	
	
	public static int[]array(int[] one){
		int[] twe=new int[one.length];
		
		for(int i=0;i<one.length;i++){
			
		twe[i]=i+1;
		}
	return twe;
	}

	
	public static void print(int[] array){
		for(int num:array){
		
			System.out.print(" "+num+" ");
			
		}
		System.out.println();
	}
}
