package dynamicProgram;

import java.io.*;

public class LCSubstring {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int m = Integer.parseInt(s1[1]);
			char a[] = new char[n];
			char b[] = new char[m];
			String s2 = br.readLine();
			for(int i=0; i<n; i++)
				a[i] = s2.charAt(i);
			String s3 = br.readLine();
			for(int i=0; i<m; i++)
				b[i] = s3.charAt(i);
			System.out.println(longestCommonSubstring(n, a, m, b));
		}

	}
	
	static int longestCommonSubstring(int n, char a[], int m, char b[]) {
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
					dp[i][j] = 0;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<m+1; j++) {
				if(dp[i][j]>max) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

}
