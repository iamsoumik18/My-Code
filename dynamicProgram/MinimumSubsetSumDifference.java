package dynamicProgram;

import java.io.*;
import java.util.*;

public class MinimumSubsetSumDifference {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int a[] = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(s[i]);
				sum += a[i];
			}
			int dp[][] = new int[n+1][sum + 1];
			for(int rows[]: dp) {
				Arrays.fill(rows, -1);
			}
			System.out.println(minimumSubsetSumDifference(a, n, 0, sum, dp));
		}

	}
	
	static int minimumSubsetSumDifference(int a[], int n, int c, int s, int dp[][]) {
		if(n==0) {
			return dp[n][c] = Math.abs((s-c)-c);
		}
		if(dp[n][c]!=-1) {
			return dp[n][c];
		}
		return dp[n][c] = Math.min(minimumSubsetSumDifference(a, n-1, c+a[n-1], s, dp), minimumSubsetSumDifference(a, n-1, c, s, dp));
	}

}
