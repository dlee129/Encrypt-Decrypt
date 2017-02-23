/*
 * This Encryption class was created so that the Encrypt method from this class
 * can be called from the Project1 class for shorter and cleaner code
 * and to avoid a long block of code in one java file
 */

public class Encryption{
	
	String input; 
	
	/*
	 * This Encryption method is put here so that it can be called from project1
	 * so that Project1 has access to the Encryption class' methods and objects 
	 */
	public Encryption(String originalMessage){
		
		input = originalMessage;
		
	}//Encryption method close
	
	/*
	 * This Encrypt Method will contain all the algorithm 
	 * that will goes towards encrypting the original method
	 */
	
	public String Encrypt(){
		
		/*
		 * This method will return a string that will print out 
		 * the new encrypted message
		 * The inputed string which would be from the text file
		 * would be split into a String array using the split method
		 * from Java's library of methods.
		 */
		String EncryptedMessage = "";
		
		String []EncryptedString = input.split("");
		
		int column = Integer.parseInt(EncryptedString[1]);
		int NumOfRows = EncryptedString.length/column;
		String [][]Table = new String[NumOfRows][column+1];
		int index = 2;
		
		
		/*
		 * This nested for loop code is the part of the encryption
		 * in which the original string is read and then
		 * a 2D array is set up to be a table for which the code
		 * is encrypted reading one column at a time
		 */
			
		for(int j=0; j < NumOfRows; j++){
			for(int k=0; k < column; k++){
				if(EncryptedString[index].equals(null)){
					Table[j][k] = "Z";
				}
				else if(EncryptedString[index].equals("*")){
					Table[j][k] = "";
				}
				else{
				Table[j][k] = EncryptedString[index];			
				index++;
				}
			}//inner for loop close
		}//outer for loop close
		
		/*
		 * This block of code reads from the Table, the encrypted message
		 * and then begins to concatenate a string that is the encrypted message
		 */
		for(int i = 0; i < column; i++){
			for(int j = 0; j < Table[column].length; j++){
					EncryptedMessage = EncryptedMessage + Table[j][i];
			}//inner for loop close
		}//outer for loop close
		
		return EncryptedMessage;
	}//Encrypting Method
}//class Encryption