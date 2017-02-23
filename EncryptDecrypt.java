/*
 * Encrypt/Decrypt
 * 
 * Write a program that can encrypted and decrypt a message using
 * simple columnar transposition encryption algorithm.
 */

import java.io.*;
import java.util.*;

public class EncryptDecrypt{
	
	public static void main (String []args){
		
		/*
		 * This is used so that an input such as a file can be opened
		 */
		File text = new File("Cryptography Text File.txt");
		
		/*
		 * This block of code will open the file, read the file
		 * and it will do either Encryption or Decryption depending on
		 * whether an E or D is read from the file
		 */
		try{
			Scanner sc = new Scanner(text);
			PrintWriter out = new PrintWriter("output.txt");
			
			while(sc.hasNextLine()){
				
				String line = sc.nextLine();
				char reader = line.charAt(0);
				
				if(reader == 'E'){
					Encryption E = new Encryption(line);
					String finalMessage = E.Encrypt();
					System.out.println(finalMessage);
					out.println(finalMessage);
					
				}//if Encryption will be used
				else if(reader == 'D'){	
					Decryption D = new Decryption(line);
					String newMessage = D.Decrypt();
					System.out.println(newMessage);
					out.println(newMessage);
				}//if Decryption will be used
				
			}//while
			sc.close();
			out.close();
		}//try block
		
		/*
		 * This is placed in case the file is not Found
		 * and will throw a FileNotFoundException
		 */
		catch (FileNotFoundException FnFe){
			System.out.println(FnFe.getMessage());
		}//catch block

		
	}//main body 
}//class Project1