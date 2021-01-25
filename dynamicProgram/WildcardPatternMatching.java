package dynamicProgram;

import java.io.*;

public class WildcardPatternMatching {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t-->0) {
				String str = br.readLine();
				String pattern = br.readLine();
				System.out.println(solution(str,pattern));
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static boolean solution(String str, String pattern) {
		int n = str.length();
		int m = pattern.length();
		boolean dp[][] = new boolean[n+1][m+1];
		dp[0][0] = true;
		for(int j=1; j<=m; j++) {
			if(pattern.charAt(j-1)=='*') {
				dp[0][j] = dp[0][j-1];
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(pattern.charAt(j-1)=='*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
				else if(pattern.charAt(j-1) == '?' || str.charAt(i-1)==pattern.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}

}
