package codeChef;

import java.io.*;

public class WorthyMatrix {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				int k = Integer.parseInt(s1[2]);
				int a[][] = new int[n][m];
				for(int i=0; i<n; i++) {
					String s2[] = br.readLine().split(" ");
					for(int j=0; j<m; j++) {
						a[i][j] = Integer.parseInt(s2[j]);
					}
				}
				long ans = solution2(n,m,k,a);
				bw.write(ans+"\n");
				bw.flush();
				
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static long solution(int n, int m, int k, int a[][]) {
		
		int pSum[][] = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] + a[i-1][j-1] - pSum[i-1][j-1];
			}
		}

		
		long ans = 0;
		for(int r1 = 1; r1<=n; r1++) {
			for(int c1=1; c1<=m; c1++) {
				for(int r2 = r1, c2 = c1; r2<=n && c2<=m; r2++, c2++) {
					long cur = pSum[r2][c2] - pSum[r1-1][c2] - pSum[r2][c1-1] + pSum[r1-1][c1-1];
					long e = (r2-r1+1)*(r2-r1+1);
					if(cur>=k*e)
						ans++;
				}
			}
		}
		
		return ans;
		
	}
	static long solution2(int n, int m, int k, int a[][]) {
		
		int pSum[][] = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] + a[i-1][j-1] - pSum[i-1][j-1];
			}
		}

		
		long ans = 0;
		for(int r1 = 1; r1<=n; r1++) {
			for(int c1=1; c1<=m; c1++) {
				int l = 1;
				int r = Math.min(n-r1+1,m-c1+1);
				int res = -1; 
				int nb = r;
				while(l<=r) {
					int mid = (l+r)/2;
					int r2 = r1+mid-1; 
					int c2 = c1+mid-1;
					long cur = pSum[r2][c2] - pSum[r1-1][c2] - pSum[r2][c1-1] + pSum[r1-1][c1-1];
					long e = (mid)*(mid);
					if(cur>=k*e) {
						r = mid-1;
						res = mid;
					}else {
						l = mid+1;
					}	
				}
				if(res!=-1) {
					ans += nb-res+1;
				}
			}
		}
		
		return ans;
		
	}
}
