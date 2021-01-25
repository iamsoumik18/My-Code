package dynamicProgram;

import java.io.*;
import java.util.*;

public class CoinChangeMinimumNo {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int v = Integer.parseInt(s1[0]);
			int n = Integer.parseInt(s1[1]);
			int c[] = new int[n];
			String s2[] = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				c[i] = Integer.parseInt(s2[i]);
			}
			int dp[] = new int[v+1];
			Arrays.fill(dp, -1);
			int ans = min(c, n, v, dp);
			if (ans==Integer.MAX_VALUE) {
				System.out.println("-1");
			}else {
				System.out.println(ans);
			}
		}

	}
	
	static int min(int c[], int n, int v, int dp[]) {
		
		if(v == 0) {
			return 0;
		}
		
		if(dp[v] != -1)
			return dp[v];
		
		int res = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			if(c[i]<=v) {
				int val = min(c, n, v-c[i], dp);
				if(val!=Integer.MAX_VALUE && val +1 < res) {
					res = val + 1;
				}
			}
		}
		return dp[v] = res;
	}

}

