package dsaOne;

import java.util.*;

public class SetKthBitOfNumber {
	
	static long setKthBit(long n, long k) {
		return ((1<<(k-1))|n);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		long n = sc.nextLong();
		System.out.print("\nEnter kth bit: ");
		long k = sc.nextLong();
		System.out.println(setKthBit(n, k));

	}

}
