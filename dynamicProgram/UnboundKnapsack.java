package dynamicProgram;

import java.io.*;

public class UnboundKnapsack {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int W = Integer.parseInt(s1[1]);
			int v[] = new int[n];
			int wt[] = new int[n];
			String s2[] = br.readLine().split(" ");
			String s3[] = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				v[i] = Integer.parseInt(s2[i]);
				wt[i] = Integer.parseInt(s3[i]);
			}
			System.out.println(unboundKnapsack(n, W, v, wt));
		}

	}
	
	static int unboundKnapsack(int n, int W, int v[], int wt[]) {
		int dp[][] = new int[n+1][W+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(j==0 || i==0) {
					dp[i][j] = 0;
				}
				else if(wt[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(v[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
				}
			}
		}
		return dp[n][W];
	}

}
