package codeChef;

import java.io.*;

public class EvenSum {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				long a[] = new long[n];
				int oddCount = 0;
				for(int i=0; i<n; i++) {
					a[i] = Long.parseLong(s1[i]);
					if((a[i]&1)==1) {
						oddCount++;
					}
				}
				if((oddCount&1)==1) {
					bw.write("2\n");
					bw.flush();
				}else {
					bw.write("1\n");
					bw.flush();
				}
			}
		}catch(Exception e) {
			return;
		}

	}

}
