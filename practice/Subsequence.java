package practice;

import java.util.*;

public class Subsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string to be checked: ");
		String str1 = sc.next();
		System.out.print("\nEnter the string where to check: ");
		String str2 = sc.next();
		if(isSubsequence(str1,str2,str1.length(),str2.length())) {
			System.out.println(str1+" is a subsequence of "+str2);
		}else {
			System.out.println(str1+" is NOT a subsequence of "+str2);
		}
	}
	static boolean isSubsequence(String str1, String str2, int n, int m) {
		if(n==0) {
			return true;
		}
		
		if(m==0) {
			return false;
		}
		
		if(str1.charAt(n-1)==str2.charAt(m-1))
			return isSubsequence(str1, str2, n-1, m-1);
		
		return isSubsequence(str1, str2, n, m-1);
	}

}
