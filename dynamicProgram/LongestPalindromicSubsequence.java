package dynamicProgram;

import java.io.*;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			System.out.println(solution(n,s));
		}

	}
	
	static int solution(int n, String s1) {
		StringBuilder st = new StringBuilder();
		st.append(s1);
		String s2 = st.reverse().toString();
		int dp[][] = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}

}
