package Useful;
import submits.TextIO;

public class rPG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int race;
		race=0;
		
		String one = null;
		String two=null;
		String three=null;
		String name=null;
		
		
		
		
		System.out.println("What is your Name?");
		name = TextIO.getln();
	do{
		System.out.println("Time to create a character!");
		System.out.println("Pick a race");
		System.out.println("1. Human");
		System.out.println("2. Dwarf");
		System.out.println("3. Elf");
		System.out.println("4. Orge");
			race = TextIO.getlnInt();
	
		switch (race){
		

		case 1:
			one=("Human");
			break;
		case 2:
			one=("Dwarf");
			break;
		case 3:
			one=("Elf");
			break;
		case 4:
			one=("Orge");
			break;
		}	
	}while((race<1)||(race>4));
			
			
		
		
		
		
		do{	
		System.out.println("Pick a gender");
		System.out.println("1. Male");
		System.out.println("2. Female");
		System.out.println("3. Unknown");
		race = TextIO.getlnInt();
		
		switch (race){
		case 1:
			two=("Male");
			break;
		case 2:
			two=("Female");
			break;
		case 3:
			two=("Unknown");
			break;
		}
			}while((race<1)||(race>3));
				
				
		
		
		
		
	
			do{
			System.out.println("Pick a class");
			System.out.println("1. Fighter");
			System.out.println("2. Ranger");
			System.out.println("3. Wizard");
				race = TextIO.getlnInt();
		
			switch (race){
			case 1:
				three=("Fighter");
				break;
			case 2:
				three=("Ranger");
				break;
			case 3:
				three=("Wizard");
				break;
			}
			}while((race<1)||(race>3));
			
				
			
		
		System.out.println("Name:"+name);
		System.out.println("Race:"+one);
		System.out.println("Gender:"+two);
		System.out.println("Class:"+three);
			
		
	}
}
		
