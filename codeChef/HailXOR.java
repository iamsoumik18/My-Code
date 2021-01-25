package codeChef;

import java.io.*;

public class HailXOR {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int x = Integer.parseInt(s1[1]);
				int a[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
				}
				int i=0;
				int cnt = 0;
				while(i<n-1 && cnt<x) {
					if(a[i]==0) {
						i++;
						continue;
					}
					int p = (int)(Math.log(a[i]) / Math.log(2));
					int index = n-1;
					int j = i+1;
					while(j<n) {
						if( (a[j]^(1<<p))<a[j] ) {
							index = j;
							break;
						}
						j++;
					}
					a[i] = a[i]^(1<<p);
					a[index] = a[index]^(1<<p);
					if( (a[i]^(1<<( (int)(Math.log(a[i]) / Math.log(2))) )) < a[i]) {
						cnt++;
						continue;
					}
					i++;
					cnt++;
				}
				if(cnt!=x && (x-cnt)%2!=0 && n==2) {
					a[n-2] = a[n-2]^1;
					a[n-1] = a[n-1]^1;
				}
				for(int num: a) {
					bw.write(num+" ");
				}
				bw.write("\n");
				bw.flush();
				
			}
		}catch(Exception e) {
			return;
		}
	}
}
