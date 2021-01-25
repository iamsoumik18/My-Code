package dynamicProgram;

import java.util.*;
import java.io.*;

public class Knapsack01Memo {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int W = Integer.parseInt(br.readLine());
			String s1[] = br.readLine().split(" ");
			int v[] = new int[n];
			for(int i=0; i<n; i++) {
				v[i] = Integer.parseInt(s1[i]);
			}
			String s2[] = br.readLine().split(" ");
			int w[] = new int[n];
			for(int i=0; i<n; i++) {
				w[i] = Integer.parseInt(s2[i]);
			}
			int dp[][] = new int[n+1][W+1];
			for(int[] rows: dp) {
				Arrays.fill(rows, -1);
			}
			System.out.println(knapsack(W, n, v, w, dp));
		}

	}
	
	static int knapsack(int W, int n, int v[], int w[], int dp[][]) {
		
		if(n==0 || W==0) {
			return 0;
		}
		
		if(dp[n][W]!=-1) {
			return dp[n][W];
		}
		
		if(w[n-1]>W) {
			return dp[n][W] = knapsack(W, n-1, v, w, dp);
		}
		
		return dp[n][W] = Math.max(v[n-1]+knapsack(W-w[n-1], n-1, v, w, dp), knapsack(W, n-1, v, w, dp));
	}
}