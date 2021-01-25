package dynamicProgram;

import java.io.*;

public class ShortestCommonSupersequence {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int n = s1[0].length();
			int m = s1[1].length();
			char a[] = new char[n];
			char b[] = new char[m];
			for(int i=0; i<n; i++)
				a[i] = s1[0].charAt(i);
			for(int i=0; i<m; i++)
				b[i] = s1[1].charAt(i);
			System.out.println(shortestCommonSupersequence(n, a, m, b));
		}

	}
	
	static int shortestCommonSupersequence(int n, char a[], int m, char b[]) {
		int dp[][] = new int[n+1][m+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<m+1; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(a[i-1]==b[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return n + m - dp[n][m];
	}

}
