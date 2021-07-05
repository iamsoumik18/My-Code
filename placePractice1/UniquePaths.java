package placePractice1;

import java.io.*;
import java.util.*;

public class UniquePaths {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int m = Integer.parseInt(s1[0]);
				int n = Integer.parseInt(s1[1]);
				int ans = solution2(m,n);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	//Optimal Solution
	static int solution2(int m, int n) {
		int N = m + n - 2;
		int R = m-1;
		double res = 1;
		//nCr
		for(int i=1; i<=R; i++) {
			res = res * (N-R+i)/i;
		}
		return (int)res;
	}
	
	static int solution(int m, int n) {
		int dp[][] = new int[m][n];
		for(int[] row: dp) 
			Arrays.fill(row, -1);
		return solution(0,0,m-1,n-1,dp);
	}
	
	static int solution(int i, int j, int m, int n, int[][] dp) {
		if(i==m && j==n) 
			return 1;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(i==m && j!=n) 
			return dp[i][j] = solution(i,j+1,m,n,dp);
		if(i!=m && j==n)
			return dp[i][j] = solution(i+1,j,m,n,dp);
		return dp[i][j] = solution(i+1,j,m,n,dp) + solution(i,j+1,m,n,dp);
	}

}
