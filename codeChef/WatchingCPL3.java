package codeChef;

import java.io.*;
import java.util.*;

public class WatchingCPL3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				String s2[] = br.readLine().split(" ");
				int h[] = new int[n];
				for(int i=0; i<n; i++) {
					h[i] = Integer.parseInt(s2[i]);
				}
				
				Arrays.sort(h);
				
				for(int x=0; x<n/2; x++) {
					int temp = h[x];
					h[x] = h[n-x-1];
					h[n-x-1] = temp;
				}
				
				int i = 0;
				int mh = 0;
				int th = 0;
				int count = 0;
				
				while(i<n) {
					int minD = Integer.MAX_VALUE;
					int idx = i;
					for(int j=i; j<n; j++) {
						if(Math.abs(k-(mh+h[j]))<minD) {
							minD = Math.abs(k-(mh+h[j]));
							idx = j;
						}
					}
					int temp = h[i];
					h[i] = h[idx];
					h[idx] = temp;
					mh += h[i];
					count++;
					i++;
					if(mh>=k)
						break;
				}
				
				while(i<n) {
					int minD = Integer.MAX_VALUE;
					int idx = i;
					for(int j=i; j<n; j++) {
						if(Math.abs(k-(th+h[j]))<minD) {
							minD = Math.abs(k-(th+h[j]));
							idx = j;
						}
					}
					int temp = h[i];
					h[i] = h[idx];
					h[idx] = temp;
					th += h[i];
					count++;
					i++;
					if(th>=k)
						break;
				}
				
				if(mh>=k && th>=k) {
					bw.write(count+"\n");
					bw.flush();
				}else {
					bw.write("-1\n");
					bw.flush();
				}
				
			}
		}catch(Exception e) {
			return;
		}

	}

}
