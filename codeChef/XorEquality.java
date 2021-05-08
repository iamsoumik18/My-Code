package codeChef;

import java.io.*;

public class XorEquality {
	
	static long MOD = 1000000007;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				long n = Long.parseLong(br.readLine());
				long ans = power(2,n-1);
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static long power(long x, long y)
	  {
	    long res = 1;
	    
	    x = x % MOD;
	    
	    if (x == 0)
	      return 0; 
	    
	    while (y > 0)
	    {
	 
	      if ((y & 1) != 0)
	        res = (res * x) % MOD;
	 
	      y = y >> 1; 
	      x = (x * x) % MOD;
	    }
	    
	    return res;
	    
	  }

}
