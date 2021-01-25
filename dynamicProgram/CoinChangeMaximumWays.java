package dynamicProgram;

import java.io.*;

public class CoinChangeMaximumWays {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(s[i]);
			int m = Integer.parseInt(br.readLine());
			System.out.println(maxCoinChange(a, n, m));
		}

	}
	
	static int maxCoinChange(int a[], int n, int m) {
		int dp[][] = new int[n+1][m+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<m+1; j++) {
				if(j==0) {
					dp[i][j] = 1;
				}
				else if(j!=0 && i==0){
				    dp[i][j] = 0;
				}
				else if(a[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i][j-a[i-1]] + dp[i-1][j];
				}
			}
		}
		return dp[n][m];
	}

}
