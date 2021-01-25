package introduction;

import java.io.*;

public class StringPalindrome {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the string: ");
		String s = br.readLine();
		
		if(isPalindrome(s)) {
			System.out.println("The string is PALINDROME.");
		}else{
			System.out.println("The string is NOT PALINDROME.");
		}
		System.out.print("The reverse of the String is: ");
		System.out.println(reverseString(s));
		

	}
	
	static boolean isPalindrome(String s) {
		if(s.length()==0 || s.length()==1) {
			return true;
		}
		
		if(s.charAt(0)==s.charAt(s.length()-1)) {
			return isPalindrome(s.substring(1, s.length()-1));
		}
		
		return false;
	}
	
	static String reverseString(String s) {
		if(s.length()==1) {
			return s;
		}
		
		return reverseString(s.substring(1, s.length()))+s.charAt(0);
	}

}
