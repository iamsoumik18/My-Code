package codeChef;

import java.util.*;
import java.io.*;

public class MaximiseFunction {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				long a[] = new long[n];
				for(int i=0; i<n; i++) {
					a[i] = Long.parseLong(s1[i]);
				}
				Arrays.sort(a);
				long n1 = a[0];
				long n2 = a[1];
				long n3 = a[n-1];
				long ans = Math.abs(n1-n2) + Math.abs(n2-n3) + Math.abs(n3-n1);
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}
