package dynamicProgram;

import java.io.*;
import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s = br.readLine();
				int dp[][] = new int[s.length()][s.length()];
				for(int row[]: dp)
					Arrays.fill(row, -1);
				System.out.println(solution(s,0,s.length()-1,dp));
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(String s, int i, int j, int dp[][]) {
		if(i>=j)return 0;
		if((new StringBuffer(s.substring(i, j+1)).reverse().toString()).equals(s.substring(i, j+1)))return 0;
		if(dp[i][j]!=-1)return dp[i][j];
		int min = Integer.MAX_VALUE;
		for(int k = i; k<j; k++) {
			int temp = 1 + solution(s,i,k,dp) + solution(s,k+1,j,dp);
			min = temp<min?temp:min;
		}
		return dp[i][j] = min;
	}

}
