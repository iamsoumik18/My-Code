package dynamicProgram;

import java.io.*;

public class Knapsack01 {

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
			System.out.println(knapsack(W, n, v, w, dp));
		

		}
	}
	
	static int knapsack(int W, int n, int v[], int w[], int dp[][]) {
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if(w[i-1]>j) {
					dp[i][j]= dp[i-1][j];
				}else {
					dp[i][j] = Math.max(v[i-1] + dp[i-1][j-w[i - 1]], dp[i-1][j]);
				}
			}
		}
		return dp[n][W];
		
	}

}
