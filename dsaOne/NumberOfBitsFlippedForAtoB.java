package dsaOne;

import java.util.*;

public class NumberOfBitsFlippedForAtoB {
	
	static long sol(long a, long b) {
		long n = a^b;
		long count = 0;
		while(n>0) {
			n &= (n-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number A: ");
		long a = sc.nextLong();
		System.out.print("Enter number B: ");
		long b = sc.nextLong();
		System.out.println(sol(a,b));
	}

}
