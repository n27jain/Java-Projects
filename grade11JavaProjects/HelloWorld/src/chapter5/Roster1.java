package chapter5;



import java.util.ArrayList;

import TextIO;



class Baller {
	String Name;
	int Height;
	int Weight;
	String Country;
}

public class Roster1 {
	
	private static void Info(ArrayList<Baller> BallerInfo,Baller PlayerInfo) {
		
		
		System.out.println("You have "+BallerInfo.size()+" players on yout team.");
		
		for(int i =0; i<BallerInfo.size();i++){
			System.out.println(BallerInfo.get(i).Name);
			System.out.println(BallerInfo.get(i).Weight);
			System.out.println(BallerInfo.get(i).Height);
			System.out.println(BallerInfo.get(i).Country);
		}
		
		return;
	}

	private static void Remove(ArrayList<Baller> BallerInfo,Baller PlayerInfo) {
		int userChoose;
		if(BallerInfo.size()==0){
			System.out.println("You have 0 player on your team!");
		}
		for(int i=0; i<BallerInfo.size();i++){
			int a = i+1;
			System.out.println(a+". "+PlayerInfo.Name);
		}
		do{
			System.out.println("Which one do you want to remove?");
			userChoose = TextIO.getlnInt();
		}while(userChoose-1>BallerInfo.size());
		BallerInfo.remove(userChoose-1);
		return;
	}

	private static void add(ArrayList<Baller> BallerInfo) {
		Baller PlayerInfo=new Baller();
		
		if(BallerInfo.size()>0){
			System.out.println(BallerInfo.get(0).Name);
		}
		
		
		System.out.println("Please input Player's name:");
		PlayerInfo.Name=TextIO.getln();
		
		System.out.println("Please input Player's Height:");
		PlayerInfo.Height=TextIO.getlnInt();
		
		System.out.println("Please input your Player's Weight:");
		PlayerInfo.Weight=TextIO.getlnInt();
		
		System.out.println("Please input yout Player's country:");
		PlayerInfo.Country=TextIO.getln();
		
		BallerInfo.add(PlayerInfo);
		
		return;
	}	
	
	public static void main(String[] args){
		
		Baller PlayerInfo=new Baller();
		ArrayList <Baller>BallerInfo= new ArrayList<Baller>();
		
		int choose;
		do{
			do{
			System.out.println("Please choose one opinion"); // print out the opinions 
			System.out.println("1. Add player info");
			System.out.println("2. Remove player info");
			System.out.println("3. Check player info");
			System.out.println("4. Exit");
			choose = TextIO.getlnInt(); // get a choose from user
			}while(choose<1||choose>4); // when the number user type in is wrong
			
			if(choose==1){ // when user wants to add one player	
				add(BallerInfo);
			}
			else if(choose==2){ // when user wants to remove one player
				Remove(BallerInfo,PlayerInfo);
			}
			else if (choose == 3){ // when player wants to check players info
				Info(BallerInfo,PlayerInfo);
			}
			else{ // when user wants to exit the app
				System.exit(0);
			}
		}while(true);	
		
	}
}
