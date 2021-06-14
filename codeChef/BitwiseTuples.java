package codeChef;

import java.io.*;

public class BitwiseTuples {
	
	static long MOD = 1000000007;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				long temp = power(2,n) - 1;
				long ans = power(temp,m);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}
	
	static long power(long x, long y){
	    long res = 1; 
	    x = x % MOD; 
	    if (x == 0)
	      return 0;
	    while (y > 0){
	      if ((y & 1) != 0)
	        res = (res * x) % MOD;
	      y = y >> 1;
	      x = (x * x) % MOD;
	    }
	    return res;
	}

}