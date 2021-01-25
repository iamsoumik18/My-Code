package practice;

import java.util.*;

public class PermutationOfString {
	
	static Set<String> ts = new TreeSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		permuteString(s, 0, s.length()-1);
		for(String str: ts) {
			System.out.println(str);
		}
		ts.clear();
	}
	
	static void permuteString(String s, int l, int r) {
		if(l==r) {
			ts.add(s);
			return;
		}
		
		for(int i=l; i<=r; i++) {
			s = swap(s,l,i);
			permuteString(s, l+1, r);
			s = swap(s,l,i);
		}
	}
	static String swap(String s, int a, int b) {
		char arr[] = s.toCharArray();
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return String.valueOf(arr);
	}
	

}
