package codeChef;

import java.io.*;

public class AnInterestingSequence {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				long k = Long.parseLong(br.readLine());
				long ans = 0;
				for(long i=1; i<=2*k; i++) {
					ans+=gcd(k+i*i,k+(i+1)*(i+1));
				}
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

}
