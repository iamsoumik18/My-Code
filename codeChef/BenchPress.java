package codeChef;

import java.io.*;
import java.util.*;

public class BenchPress {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int w = Integer.parseInt(s1[1]);
				int wr = Integer.parseInt(s1[2]);
				int wt[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					wt[i] = Integer.parseInt(s2[i]);
				}
				boolean ans = solution(n,w,wr,wt);
				if(ans) {
					bw.write("YES\n");
					bw.flush();
				}else {
					bw.write("NO\n");
					bw.flush();
				}
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static boolean solution(int n, int w, int wr, int wt[]) {
		if(wr>=w) {
			return true;
		}
		reverseSort(wt);
		long rw = w-wr;
		long cw=0;
		for(int i=0; i<n-1; i++) {
			if(wt[i]==wt[i+1]) {
				cw += 2*wt[i];
				i++;
				if(cw>=rw) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	static void reverseSort(int[] a){
		Arrays.sort(a);
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {         
            int temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }
    }

}
