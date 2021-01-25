package practice;

import java.util.*;

public class ZeroSumSubArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		if(isTrue(a))
			System.out.println("\nFound");
		else {
			System.out.println("\nNot Found");
		}
		
	}
	
	static boolean isTrue(int a[]) {
		int n = a.length;
		Set<Integer> hs = new HashSet<>();
		int sum = 0;
		for(int i=0; i<n; i++) {
			hs.add(sum);
			sum+=a[i];
			if(hs.contains(sum)) {
				return true;
			}
		}
		return false;
	}

}
