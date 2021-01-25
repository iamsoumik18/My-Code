package codeChef;

import java.io.*;

public class VaccineDistribution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int d = Integer.parseInt(s1[1]);
				int a[] = new int[n];
				String s2[] = br.readLine().split(" ");
				int risk = 0;
				int rem = 0;
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
					if(a[i]>=80 || a[i]<=9) {
						risk++;
					}
					else {
						rem++;
					}
				}
				int day = ( (risk + d -1)/d ) + ( (rem + d -1)/d);
				System.out.println(day);
			}
		}catch(Exception e) {
			return;
		}
	}

}
