package dynamicProgram;

import java.io.*;
import java.util.*;

public class MatrixChainMultiplication {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine().trim());
				String s1[] = br.readLine().split(" ");
				int a[] = new int[n];
				for(int i=0; i<n; i++)
					a[i] = Integer.parseInt(s1[i]);
				int dp[][] = new int[n][n];
				for(int rows[]:dp)
					Arrays.fill(rows, -1);
				System.out.println(solution(a,1,n-1,dp));
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(int a[], int i, int j,int dp[][]) {
		if(i>=j)return 0;
		if(dp[i][j]!=-1)return dp[i][j];
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp = solution(a,i,k,dp) + solution(a,k+1,j,dp) + ( a[i-1] * a[k] * a[j] );
			min = temp<min?temp:min;
		}
		return dp[i][j] = min;
	}

}
