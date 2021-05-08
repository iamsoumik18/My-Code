package codeChef;

import java.util.*;
import java.io.*;

public class BooleanGame2 {

	@SuppressWarnings("unchecked")
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
				long g[] = new long[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					g[i] = Long.parseLong(s2[i]);
				}
				ArrayList<Pair>[] a = new ArrayList[n+1];
				for(int i=0; i<m; i++) {
					String s3[] = br.readLine().split(" ");
					int u = Integer.parseInt(s3[0]);
					int v = Integer.parseInt(s3[1]);
					int d = Integer.parseInt(s3[2]);
					
					if(a[u].isEmpty()) {
						a[u] = new ArrayList<>();
						Pair p = new Pair(i,d);
						a[u].add(p);
					}else {
						Pair p = new Pair(i,d);
						a[u].add(p);
					}
					
					if(a[v].isEmpty()) {
						a[v] = new ArrayList<>();
						Pair p = new Pair(i,d);
						a[v].add(p);
					}else {
						Pair p = new Pair(i,d);
						a[v].add(p);
					}
					
				}
				ArrayList<Pair>[] dp = new ArrayList[n+1];
				for(int i=0; i<n+1; i++) {
					dp[i] = new ArrayList<>();
				}
				dp[0].add(new Pair(0,0));
				for(int i=1; i<=n; i++) {
					ArrayList<Pair> temp = new ArrayList<>();
					for(Pair p: dp[i-1]) {
						temp.add(p);
					}
					int cur = 0;
					int mask = 0;
					Set<Long> open = new HashSet<>();
					for(int j=i; j>=1; j--) {
						cur += g[j];
						mask^=1<<j;
						for(Pair x: a[j]) {
							if(open.contains(x.first)) {
								cur += x.second;
							}else {
								open.add(x.first);
							}
						}
						if(j>1) {
							for(Pair y:dp[j-2]) {
								temp.add(new Pair(y.first+cur,mask^y.second));
							}
						}else {
							temp.add(new Pair(cur,mask));
						}
					}
					Collections.sort(temp, Collections.reverseOrder());
					Set<Long> sel = new HashSet<>();
					long filled = 0;
					for(int j=0; j<temp.size() && filled<k; j++){
		                if(sel.contains(temp.get(j).second))
		                    continue;
		                dp[i].add(temp.get(j));
		                filled++;
		                sel.add(temp.get(j).second);
		            }
				}
				for(int i=0; i<k; i++) {
					bw.write(dp[n].get(i).first+" ");
					bw.flush();
					
				}
				bw.write("\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}

class Pair{
	long first;
	long second;
	
	public Pair(long first, long second) {
		this.first = first;
		this.second = second;
	}
}
