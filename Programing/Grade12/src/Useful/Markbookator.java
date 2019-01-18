package Useful;

import submits.TextIO;

public class Markbookator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ast;
		int ma;
		int to;
		int we;
		
		System.out.println("Welcome to the MarkBook!");
		System.out.println("");
		System.out.println("");
		System.out.println("1. Calculate the current overall weighted average");
		System.out.println("2. List all entries and overall weighted average");
		System.out.println("3. New mark entry");
		System.out.println("4. Delete a mark entry");
		System.out.println("5. Update an existing mark");
		System.out.println("	What would you like to do?");
		
		Mark one=new Mark();
		
			System.out.println("Enter the assignment name:");
			ast=TextIO.getln();
			
			
			System.out.println("Enter the total mark:");
			to=TextIO.getlnInt();
			
	
			System.out.println("Enter the student’s mark:");
			ma=TextIO.getlnInt();
		
	
		
			System.out.println("Enter the weight (Default 1):");
			we=TextIO.getlnInt();
	 
		Mark one=Mark(ast,to,ma,we)	;
		
		
		
		
	}

}

	class Mark{
		
		private String assignment;// assignment name
		
		private double mark;// mark number 
		
		private double total;
		
		private int weight;

		
		
			 Mark(){
				mark=0;
				assignment="";
				total=1;
				weight=1;
				
				
			}
			
			public Mark(name, total, mark, weight){
				
				mark=mark;
				total=total;
				weight=weight;
				name=assignment;
				
			}
			public Mark(name, total, mark){
				weight=1;
				
			}
			public String getName(){
				return assignment;
			}
			public double getTotal(){
				return total;
			}
			public int getWeight(){
				return weight;
			}
			public double getMark(){
				return mark;
			}
			 public void setMark(int newMark){
				 mark=newMark;
			 }
			
			
			
			public double calcAverage(){
				
			double ret=(mark/total*100);
			
			return ret;
			}
			
			
			
			
			
	}