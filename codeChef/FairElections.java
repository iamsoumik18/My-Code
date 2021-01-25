package codeChef;

import java.io.*;
import java.util.*;

public class FairElections {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				String s2[] = br.readLine().split(" ");
				String s3[] = br.readLine().split(" ");
				int a[] = new int[n];
				int b[] = new int[m];
				int johnSum = 0;
				int jackSum = 0;
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
					johnSum += a[i];
				}
				for(int i=0; i<m; i++) {
					b[i] = Integer.parseInt(s3[i]);
					jackSum += b[i];
				}
				Arrays.sort(a);
				Arrays.sort(b);
				int swapCount = 0;
				int i=0;
				int j=m-1;
				while(johnSum<=jackSum && i<n && j>=0) {
					johnSum -= a[i];
					jackSum -=b[j];
					johnSum += b[j];
					jackSum += a[i];
					i++;
					j--;
					swapCount++;
				}
				if(johnSum<=jackSum)
					swapCount = -1;
				bw.write(swapCount+"\n");
				bw.flush();
			}
		}catch(Exception e){
			return;
		}
	}
	
}
