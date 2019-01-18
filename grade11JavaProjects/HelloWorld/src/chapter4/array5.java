package chapter4;

import TextIO;

public class array5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int choice=random();	
	
	String[]out=find();
	System.out.println("");	
	System.out.println("You chose "+out[choice]);	
		
		
	}

	
	private static String[]find(){
		String[]find=new String[5];
		String pick = null;
		;
			for(int i=0;i<find.length;i++){
				int j=i+1;
				System.out.println("Name "+j);
				pick=TextIO.getln();
				find[i]=pick;
			}
			return find;
		
	}
	private static int random(){
	int	random=(int) (Math.random()*5);
	return random;
	}
}
