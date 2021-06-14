package codeChef;

import java.io.*;
import java.util.Arrays;

public class ChefAndParty {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				int a[] = new int[n];
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s1[i]);
				}
				Arrays.sort(a);
				int cP = 0;
				int ans = 0;
				for(int i=0; i<n; i++) {
					if(a[i]<=cP) {
						cP++;
						ans++;
					}
				}
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}