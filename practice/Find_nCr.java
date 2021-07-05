package practice;

import java.io.*;

public class Find_nCr {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int r = Integer.parseInt(s1[1]);
				int ans = nCr(n,r);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static int nCr(int n, int r) {
		double res = 1;
		for(int i=1; i<=r; i++) {
			res = res * (n-r+i)/i;
		}
		return (int)res;
	}

}
