package dsaOne;

import java.util.*;

public class FindKthBitInBinary {
	
	static long kthBit(long n, long k) {
		return ( (n & ( 1 << (k-1))) >> (k-1) );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		long n = sc.nextLong();
		System.out.print("\nEnter kth bit: ");
		long k = sc.nextLong();
		System.out.println(kthBit(n,k));
	}

}
