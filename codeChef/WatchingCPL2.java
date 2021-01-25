package codeChef;

import java.io.*;
import java.util.*;

public class WatchingCPL2 {

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
				int arraySum = 0;
				for(int i=0; i<n; i++) {
					h[i] = Integer.parseInt(s2[i]);
					arraySum += h[i];
				}
				
				Arrays.sort(h);
				
				if(arraySum<2*k) {
					bw.write("-1\n");
					bw.flush();
				}else {
					Arrays.sort(h);
					int ans = recur(h, n-1, k, 0, 0);
					ans = ans>=5000?-1:ans;
					bw.write(ans+"\n");
					bw.flush();
					
				}
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static int recur(int a[], int i, int k, int sumA, int sumB) {
		
		if(sumA>=k && sumB>=k) {
			return 0;
		}
		if((sumA<k || sumB<k) && i<0) {
			return 5000;
		}
		if(sumA>=k && sumB<k) {
			return 1+recur(a,i-1,k,sumA,sumB+a[i]);
		}
		if(sumB>=k && sumA<k ) {
			return 1+recur(a,i-1,k,sumA+a[i],sumB);
		}
		
		
		return Math.min(1+recur(a,i-1,k,sumA+a[i],sumB), 1+recur(a,i-1,k,sumA,sumB+a[i]));
	}

}