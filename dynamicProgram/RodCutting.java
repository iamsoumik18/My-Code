package dynamicProgram;

import java.io.*;

public class RodCutting {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			System.out.println(rodCutting(a, n));
		}

	}
	
	static int rodCutting(int a[], int n) {
		int dp[][] = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(i>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(a[i-1]+dp[i][j-i], dp[i-1][j]);
				}
			}
		}
		return dp[n][n];
	}

}
