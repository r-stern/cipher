/**
 * Author: Rachel Stern
 * Version: 1.0
 * Description: Cipher personal project
 */

/* package cipher; */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Cipher {
	
	/**
	 * Removes duplicate characters from your key.
	 * @param keyunf: String, the key
	 * @return: String, the key with duplicates removed
	 */
	public static String removedups(String keyunf) {
		char[] keyarr = keyunf.toCharArray();
		Set<Character> keyset = new LinkedHashSet<Character>();
		for (char ch : keyarr) {
			keyset.add(ch);
		}
		StringBuilder keystring = new StringBuilder();
		for (Character cha : keyset) {
			keystring.append(cha);
		}
		return keystring.toString();
	}
	
	/**
	 * Ciphers message.
	 * @param key String, the key for the cipher
	 * @param m_unfilter String, the unfiltered message
	 * @return String: the ciphered message
	 */
	public static String makeComp(String key, String m_unfilter) {
		String alphabeta = "abcdefghijklmnopqrstuvwxyz";
		
		String alps = ""; 
		String message = m_unfilter.toLowerCase();
		String keystring = removedups(key).toLowerCase();

		alps = removedups(keystring + alphabeta); //creates the new alphabet starting with the dupless key and unique alphabet.

		String m_filter = "";
		
		for(int z = 0; z < message.length(); z++) {
			if (Character.isLetter(message.charAt(z)) == false) {
				m_filter += Character.toString(message.charAt(z));
			}
			else {
				int indexina = alphabeta.indexOf(Character.toString(message.charAt(z)));
				m_filter += Character.toString(alps.charAt(indexina));
			}
		}
		return m_filter;
	}
	
	/**
	 * Deciphers a ciphered message.
	 * @param key String, key for the cipher.
	 * @param m_filter your filtered message. A string.
	 * @return String, the deciphered message
	 */
	public static String reduceComp(String key, String m_filter) {
		String alphabeta = "abcdefghijklmnopqrstuvwxyz";
		
		String message = m_filter.toLowerCase();
		String keyunlock = removedups(key).toLowerCase();
		String himalayas = removedups(keyunlock + alphabeta);
		
		
		String m_unfilter = "";
		for(int y = 0; y < message.length(); y++) {
			if (Character.isLetter(message.charAt(y)) == false) {
				m_unfilter += Character.toString(message.charAt(y));
			}
			else {
				int indexina = himalayas.indexOf(Character.toString(message.charAt(y)));
				m_unfilter += Character.toString(alphabeta.charAt(indexina));
			}
		}
		return m_unfilter;
	}
	
	/**
	 * Checks if your key contains only letters.
	 * @param abc, String key
	 * @return true if it contains only letters, false if not.
	 */
	public static boolean checkLetter(String abc) {
		for (int z = 0; z < abc.length(); z++) {
			if (Character.isLetter(abc.charAt(z)) == false) {
				return false;
			}
		}
		return true;
	}


	/**
	 * instructions to the user, and printing out, happens here
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Do you want to encode a message (1) , or decipher (2) it?");
		Scanner scan0 = new Scanner(System.in);
		String ans = scan0.nextLine();

		if (ans.equals("1")) {
			System.out.println("Please input your unciphered message.");
			Scanner scan1 = new Scanner(System.in);
			String m_unfilter = scan1.nextLine(); // unfiltered message

			System.out.println("Please input your key.");
			Scanner scan2 = new Scanner(System.in);
			String key = scan2.nextLine(); // key
			if (checkLetter(key) == false) {
				throw new IllegalArgumentException("Key can only contain letters, not any other characters.");
			}

			System.out.println("Your message is: " + m_unfilter + "\n" + "Your key is: " + key);

			// begin ciphering.
			// remove duplicate letters from your key.
			System.out.println("Your fixed key is: " + removedups(key));

			System.out.println("Your filtered message is: " + makeComp(key, m_unfilter));
		}
		else if(ans.equals("2")) {
			System.out.println("Please input your ciphered message.");
			Scanner scan3 = new Scanner(System.in);
			String m_ciph = scan3.nextLine();
			
			System.out.println("Please input your key.");
			Scanner scan4 = new Scanner(System.in);
			String keyc = scan4.nextLine();
			if (checkLetter(keyc) == false) {
				throw new IllegalArgumentException("Key can only contain letters, not any other characters.");
			}
			
			System.out.println("Your message is: " + m_ciph + "\n" + "Your key is: " + keyc);
			
			System.out.println("Your fixed key is: " + removedups(keyc));
			
			System.out.println("Your deciphered message is: " + reduceComp(keyc, m_ciph));
			
		}
		else {
			throw new IllegalArgumentException("Your choices are only 1 or 2! You must pick one of those." + "\n" + "Try again.");
		}
	}
	
}
