package dynamicProgram;

import java.io.*;

public class CountNoSubWithGivenDiff {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(s[i]);
			int d = Integer.parseInt(br.readLine());
			System.out.println(solution(a, n, d));
		}

	}
	
	static int solution(int a[], int n, int d) {
		int s = 0;
		for(int i: a) {
			s += i;
		}
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
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
				}
			}
		}
		int count = 0;
		for(int i=0; i<=s/2; i++) {
			if(dp[n][i]) {
				count = (s-(2*i))==d?count+1:count;
			}
		}
		
		return count;
	}

}
