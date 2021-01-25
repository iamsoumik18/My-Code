package practice;

import java.util.*;

public class CoinGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println(maxAmt(a,0,n-1));
		}

	}
	
	static int maxAmt(int a[], int l, int r) {
		if(l+1==r) {
			return Math.max(a[l], a[r]);
		}
		
		return Math.max(a[l]+Math.min(maxAmt(a,l+2,r), maxAmt(a,l+1,r-1)), a[r]+Math.min(maxAmt(a,l+1,r-1), maxAmt(a,l,r-2)));
	}

}
