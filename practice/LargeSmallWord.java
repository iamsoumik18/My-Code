package practice;

import java.util.*;

public class LargeSmallWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		sol(s);
		

	}
	
	public static void sol(String s) {
		int i = 0;
		String small = "";
		String large = "";
		while(i<s.length()) {
			while(i<s.length() && s.charAt(i)==' ')
				i++;
		
		int j = i;
		while(i<s.length() && s.charAt(i)!=' ')
			i++;
		
		if(small.length()==0 || large.length()==0) {
			small = s.substring(j, i);
			large = s.substring(j, i);		
		}else {
			if(s.substring(j, i).length()<small.length()) {
				small = s.substring(j, i);
			}
			if(s.substring(j, i).length()>large.length()) {
				large = s.substring(j, i);
			}
		}
		}
		System.out.print("\nThe smallest word is: "+small);
		System.out.print("\nThe largest word is: "+large);
		
		
	}

}
