package practice;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first string: ");
		String s1 = sc.nextLine();
		System.out.print("\nEnter second string: ");
		String s2 = sc.nextLine();
		
		boolean isAnagram = true;
		
		int al[] = new int[256];
		
		if(s1.length()==s2.length()) {
			for(int i=0; i<s1.length(); i++) {
				char c = s1.charAt(i);
				int ascii = (int)c;
				al[ascii]++;
				char d = s2.charAt(i);
				int ascii2 = (int)d;
				al[ascii2]--;
			}
			
			for(int i=0; i<256; i++) {
				if(al[i]!=0) {
					isAnagram=false;
					break;
				}
			}
		}
		else {
			isAnagram=false;
		}
		
		if(isAnagram) {
			System.out.println("\nIt is ANAGRAM.");
		}
		else {
			System.out.println("\nIt is not ANAGRAM.");
		}
		
	}

}
