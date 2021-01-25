package practice;

import java.util.*;

public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int queries[][] = new int[m][3];
		for(int i=0; i<m; i++) {
			queries[i][0] = sc.nextInt();
			queries[i][1] = sc.nextInt();
			queries[i][2] = sc.nextInt();
		}
		System.out.print("Max: "+maxEle(n,queries));

	}
	
	static long maxEle(int n, int queries[][]) {
		long ans[] = new long[n];
		for(int i=0; i<queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			ans[a]+=k;
			if(b<n-1)
				ans[b+1]-=k;
		}
		long temp = 0;
		long max = Long.MIN_VALUE;
		for(int i=0; i<n; i++) {
			temp+=ans[i];
			max = temp>max?temp:max;
		}
		return max;
	}

}
