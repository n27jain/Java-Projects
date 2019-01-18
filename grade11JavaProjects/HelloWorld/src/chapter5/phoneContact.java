package chapter5;

import TextIO;

public class phoneContact {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int pick=0;
		ContactIn name;	
		name= new ContactIn();
		
		
		while(pick!=3){
			System.out.println("Welcome to myPhoneBook!");
			System.out.println("Press (1) to edit contact.");
			System.out.println("Press (2) to print info.");
			System.out.println("Press (3) to quit.");
			 pick=TextIO.getlnInt();
		
			if(pick==1){

					System.out.println("What is the surname?");
					
					name.last=TextIO.getln();
					
					System.out.println("What is the first name?");
					
					String tempName=TextIO.getln();
					
					name.setName(tempName);
					
					System.out.println("What is the phone number? You Must use 10 numbers!");
					
					name.number=TextIO.getln();
					
				
					
						while(name.number.length()>10||name.number.length()<10){
							System.out.println("You need to use 10 numbers! Try Again!");
							System.out.println("What is the phone number? You Must use 10 numbers!");
							name.number=TextIO.getln();
					}
					
					System.out.println("Lastly, what is the email adress? Please use the @ symbol.");
					 
					name.adress=TextIO.getln();
					
						
			}
	
			if (pick==2){
				
			
			System.out.println("Your last name is  " + name.getLast());
			System.out.println("Your first name is  " + name.getName());
			System.out.println("Your phone number is  " + name.getNumber());
			System.out.println("Your email adress is  " + name.getAdress());
		}
			
		}
	}
	}

	class ContactIn{
		private String name;
		
		private String last;
		
		private String number;
		
		private String adress;
		
		private ContactIn(String fname, ){// figure this out.
			
		}
		public void setName(String newname){
			name=newname;
		}
		
		public String getName(){
			return name;
			
		}
		public String getAdress(){
			
			return adress;
			
		}
		public String getLast(){
			return last;
			
		}
		public String getNumber(){
			
			return number;
			
		}
	}

