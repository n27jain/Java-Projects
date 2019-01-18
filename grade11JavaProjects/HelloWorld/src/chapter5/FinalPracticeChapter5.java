package chapter5;

import TextIO;

public class FinalPracticeChapter5 {

	public static void main(String[] args) {
		
			String in=TextIO.getln();
		int out=convert(in);
		System.out.println(out);
	}
public static int convert(String in){
		
		char[] exam=new char[in.length()];
	
		
			for(int i=0;i<=in.length();i++){
				exam[i]=in.charAt(i);
				System.out.println(exam[i]);
			}
			//working
		int[]correct=new int[in.length()];
		
			for(int i=0;i<=(in.length())-1;i++){
				
				if(exam[i]=='I'){
					correct[i]=1;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='V'){
					correct[i]=5;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='X'){
					correct[i]=10;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='L'){
					correct[i]=50;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='C'){
					correct[i]=100;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='D'){
					correct[i]=500;
					System.out.println(correct[i]);
				}
				else if (exam[i]=='M'){
					correct[i]=1000;
					System.out.println(correct[i]);
				}
			
			}
		int figure=correct[correct.length];
		
		for(int i=correct.length;i>=0;i--){
			if(correct[i]<=correct[i-1]){
				figure=figure+correct[i-1];
			}
			else if(correct[i]>correct[i-1]){
				figure=figure-correct[i-1];
			}
		}
		return figure;
	}
}
