package dynamicProgram;

import java.io.*;

public class SubsetSum {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(s[i]);
			int sum = Integer.parseInt(br.readLine());
			System.out.println(subsetSum(a, n, sum));
		}

	}
	
	static boolean subsetSum(int a[], int n, int s) {
		boolean dp[][] = new boolean[n+1][s+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<s+1; j++) {
				if(j==0) {
					dp[i][j] = true;
				}
				else if(j!=0 && i==0) {
					dp[i][j] = false;
				}
				else if(a[i-1]>j) {
					dp[i][j] = false;
				}
				else {
					dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
				}
			}
		}
		return dp[n][s];
	}

}
