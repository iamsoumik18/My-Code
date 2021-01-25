package dynamicProgram;

import java.util.*;
import java.io.*;

public class MinimumNumberOfJump {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int a[] = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			int dp[] = new int[n+1];
			Arrays.fill(dp, -1);
			int ans = jump(0, a, n, dp);
			if(ans >= 10000005) {
				System.out.println("-1");
			}else {
				System.out.println(ans);
			}
		}

	}
	
	static int jump(int pos, int a[], int n, int dp[]) {
		
		if(pos>=n-1) {
			return 0;
		}
		
		if(dp[pos] != -1)
			return dp[pos];
		
		if(a[pos] == 0) {
			return 10000005;
		}
		int count = 10000005;
		
		for(int i = 1; i<=a[pos]; i++) {
			int val = jump(pos + i, a, n, dp);
			if(val+1<count) {
				count = val+1;
			}
		}
		
		return dp[pos] = count;
		
	}

}
