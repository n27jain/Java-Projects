package selectionSort.copy;

import selectionSort.TextIO;

public class Practice {

	
	
		
		for(int x=0; x<list.length; x++){
			// set each of the index in the array.
			list checkObject= roster.get(x);// get the object that corresponds to the x index.
			String check= checkObject.getName();// We get the name from the object.
			int index= x;// We use this int to know which int to point to. It will point to the int in the array that is the lowest value. 
			
			for(int i=x+1; i<list.length;i++){
				// Check the first number in the array after current index being checked.
				list newObject= roster.get(i);// We get the object that we are checking.
				String compare= roster.getName(newObject);// We get the string value that we are comparing too. 
				
				list currentLowest= roster.get(index);// We need to compare each object in the array with the current earliest string alphabetically. 
				String current= roster.getName(currentLowest);
				if (compare.compareToIgnoreCase(current)<0){// if our checked String is less value then the current checked and the value that the pointer is pointing to. 
					index=i;// Our pointer points to the current index unless a number in another index is lesser.	
				}	
			}
			List tempo = list.get(index); // temp is the temporary value that is the value of the lowest integer in the remaining array unchecked.
			roster.set(index, check);
			roster.set(x, tempo)
			list[x]=tempo;// The initially checked value is replaced with the lowest unchecked array value.
			
			
		}
		
		
		
	}

}
