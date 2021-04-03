package dsaOne;

import java.util.Scanner;

public class CountSetBitsOfNumber {
	
	static long countSetBits(long n) {
		long count = 0;
		while(n>0) {
			n &= (n-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		long n = sc.nextLong();
		System.out.println(countSetBits(n));

	}

}
