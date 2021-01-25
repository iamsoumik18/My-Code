package dynamicProgram;

import java.io.*;

public class AllPathFromTopLToBottomR {
	
	static int div = 1000000007;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			System.out.println(path(n,m));
		}

	}
	
	static int path(int n, int m) {
		
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<m+1; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(i==1 || j==1) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = (dp[i][j-1]%div + dp[i-1][j]%div)%div;
				}
			}
		}
		
		return dp[n][m];
		
		
	}

}
