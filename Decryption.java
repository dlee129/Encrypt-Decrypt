/*
 * This Decryption class was created so that the Decrypt method from this class
 * can be called from the Project1 class for shorter and cleaner code
 * and to avoid a long block of code in one java file
 */

public class Decryption{
	
	String input;	
	
	/*
	 * This Decryption method is put here so that it can be called from project1
	 * so that Project1 has access to the Encryption class' methods and objects 
	 */
	
	public Decryption(String DecryptedMessage){
		
		input = DecryptedMessage;
		
	}//Decryption method close
	
	public String Decrypt(){
		
		String DecryptedMessage = "";
		
		String []DecryptedString = input.split("");
		
		int column = Integer.parseInt(DecryptedString[1]);
		int NumOfRows = (DecryptedString.length)/column;
		String [][]Table = new String[NumOfRows][column];
		int index = 2;
		
		
		/*
		 * This block of code reads the original input encrypted message
		 * and writes each character into a 2D array representing a table
		 * to read each character from
		 *  
		 */
		
		for(int j=0; j < column; j++){
			for(int k=0; k < NumOfRows; k++){
				if(DecryptedString[index].equals("Z") || DecryptedString[index].equals("Q") || DecryptedString[index].equals("X") || DecryptedString[index].equals("*")){
					Table[k][j] = "";
				}//if any of these characters show up, they will be removed
				else{
				Table[k][j] = DecryptedString[index];
				index++;
				}//else
			}//inner for loop
		}//outer for loop
		
		/*
		 * This block of code reads each character from the Table
		 * row by row and concatenates a string that will represent
		 * the Decrypted message
		 */
		
		for(int i=0; i < NumOfRows; i++){
			for(int j=0; j < column; j++){
				DecryptedMessage = DecryptedMessage + Table[i][j];
			}
		}
		
		return DecryptedMessage;
	}
}