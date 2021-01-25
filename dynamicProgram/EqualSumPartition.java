package dynamicProgram;

import java.io.*;

public class EqualSumPartition {

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
			if((sum & 1) != 0) {
				System.out.println("NO");
			}
			else {
				if(equalSumPartition(a, n, sum/2))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}
	
	static boolean equalSumPartition(int a[], int n, int s) {
		boolean dp[][] = new boolean[n+1][s+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<s+1; j++) {
				if(j==0) {
					dp[i][j] = true;
				}
				else if(j!=0 && i == 0) {
					dp[i][j] = false;
				}
				else if(a[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
				}
			}
		}
		return dp[n][s];
		
	}

}
