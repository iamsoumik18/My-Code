package codeChef;

import java.util.*;
import java.io.*;

public class FrogSort {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				String s2[] = br.readLine().split(" ");
				int w[] = new int[n];
				int l[] = new int[n];
				for(int i=0; i<n; i++) {
					w[i] = Integer.parseInt(s1[i]);
					l[i] = Integer.parseInt(s2[i]);
				}
				
				if(n==2) {
					if(w[0]<w[1]) {
						bw.write(0+"\n");
						bw.flush();
					}else {
						if(l[0]==1) {
							bw.write(2+"\n");
							bw.flush();
						}else {
							bw.write(1+"\n");
							bw.flush();
						}
					}
				}else if(n==3) {
					int a = 0, a1 = 0, b = 0, b1 = 0, c = 0, c1 = 0;
					for(int i=0; i<n; i++) {
						if(w[i]==1) {
							a = i;
							a1 = i;
						}
						if(w[i]==2) {
							b = i;
							b1 = i;
						}
						if(w[i]==3) {
							c = i;
							c1 = i;
						}
					}
					int ans = 0;
					while(b<=a) {
						b += l[b1];
						ans++;
					}
					while(c<=a || c<=b) {
						c += l[c1];
						ans++;
					}
					bw.write(ans+"\n");
					bw.flush();
					
				}else if(n==4) {
					int a = 0, a1 = 0, b = 0, b1 = 0, c = 0, c1 = 0, d = 0, d1 = 0;
					for(int i=0; i<n; i++) {
						if(w[i]==1) {
							a = i;
							a1 = i;
						}
						if(w[i]==2) {
							b = i;
							b1 = i;
						}
						if(w[i]==3) {
							c = i;
							c1 = i;
						}
						if(w[i]==4) {
							d = i;
							d1 = i;
						}
					}
					int ans = 0;
					while(b<=a) {
						b += l[b1];
						ans++;
					}
					while(c<=a || c<=b) {
						c += l[c1];
						ans++;
					}
					while(d<=a || d<=b || d<=c) {
						d += l[d1];
						ans++;
					}
					bw.write(ans+"\n");
					bw.flush();
				}
				
			}
		}catch(Exception e) {
			return;
		}

	}

}
