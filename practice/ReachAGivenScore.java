package practice;

import java.util.*;

public class ReachAGivenScore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int sum = sc.nextInt();
			int a[] = {3,5,10};
			int n = 3;
			System.out.println(check(sum,n,a));
		}

	}
	
	static int check(int sum, int n, int a[]) {
		if(sum==0) {
			return 1;
		}
		if(sum<=0 || n<=0) {
			return 0;
		}
		
		return check(sum, n-1, a)+check(sum-a[n-1], n, a);
		
	}

}
