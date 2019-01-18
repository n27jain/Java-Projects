package chapter4;

public class prectice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int x=999;// The number that must be converted to Roman numerals.
				int check;// We will use this variable to tackle many problems. 
				String total="";// This is the output. Starts off as a blank string.
				
				if (x>1000){
					total="CONCORDIA CUM VERITATE";
				}	
				// If the number is less than 1000 it its valid.
				// We will first remove the hundreds term.
				
				else if(x>=900){
					// If it is 900 or more...
					
					total=total+"CM";// Our string will start off as CM.
					x=x-900;// We take away 900 from the number to get the 50's and 10's place.
				}
				else if(x>=500){
					// Now the number is between 500-800.
					
					check=(x/100)-5;// We will check how many hundreds are after 500. 600 has one extra hundred.
					x=  x-(x/100)*100;// X will be reduced by the value based on the hundred term.
					total= total+"D";// The string will now have D for the 500...
					
						for(int q=check;q!=0;q--){
							// AND a C for each extra hundred. 
							total=total+"C";// We add this to the end of the string each time.
						}
				}
				else if(x>=400){
					// Another special case. When input is 400, you will write like 500-100...
					
					total=total+"CD";// SO Romans write CD.
					
					x=x-400;// Reduce this term to work on other terms later.
				}
				else if(x<400){
					// From 100-300...
					
					check=x/100;// Divide by 100 to find out how many hundreds terms.
						
					for(int q=check;q!=0;q--){
						
						// Use for loop to add each terms letter.
						total=total+"C";
						
						x=x-100;// And Subtract the terms to let the lower terms.
					}
				}	
			
				
				if(x<100){
					// This tackles the 50s and 10s place.
					
					if(x>90){
						//90-99.Special case
						x=x-90;	// remove 90 to get the one's term.
						total=total+"XC";// Add XC to the string.
					}
					else if(x>50){
						// 50-80. Else if because it only works if the above is not true.
						check=(x/10)-5;// find the 10's, then subtract to find the extras.
						x=x-50;// Reduce by 50.
						total=total+"L";// Add letter L to signify 50.
						
						for(int q=check;q!=0;q--){
							// Remove each extra hundred term.
							total=total+"X";// Add an X for each one.
							x=x-10;// Reduce.
						}
					}
					else if(x>=40){
						// 40-49.Special case
						x=x-40;// reduce by 40.
						total=total+"XL";// This is how 40 is written.
					}
					else if(x>=10){
						// 10-30.
						check=x/10;// Find number of terms.
						
						for(int q=check;q!=0;q--){
							//Add X for each term.
							total=total+"X";
							x=x-10;// And remove it for the one's term.
						}
					}
				}
				
				
				if(x<10){
					// Ones term.
					
					if(x==9){
						// When the number is 9. Special case.
						
						total=total+"IX";// Written as IX.
					}
					else if(x>=5){
						//5,6,7,8.
						check=x-5;// Count number of extras.
						
						total=total+"V";// Add V to signify 5.
						
						for(int q=check;q!=0;q--){
							// Add an I for each extra term.
							total=total+"I";
						}
					}
					else if(x==4){
						// Special case.
						total=total+"IV";// Written as this.
					}
					else if(x<4){
						// 1,2,3
						for(int q=x;q!=0;q--){
							// Add an I for each number.
							total=total+"I";
						}
					}
					
				}
				

				
		System.out.println(x);
		System.out.print(total);
			
		
		
			
	}
}
