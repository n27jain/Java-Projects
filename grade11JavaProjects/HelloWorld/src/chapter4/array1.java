package chapter4;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int one[]=new int [20];
		
		one=array(one);
		print(one);
	}
	
	
	public static int[]array(int[] one){
		int[] twe=new int[20];
		
		for(int i=0;i<one.length;i++){
		twe[i]=i+1;}
	return twe;
	}

	
	public static void print(int[] array){
		for(int num:array){
		
			System.out.print(" "+num+" ");
			
		}
		System.out.println();
	}
		
	

	
	
	
	
}
