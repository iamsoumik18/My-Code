package introduction;

import java.io.*;

public class FastPower {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("Enter a, b and n(a^b % n): ");
		
		String s[] = br.readLine().split(" ");
		
		long a = Long.parseLong(s[0]);
		long b = Long.parseLong(s[1]);
		long n = Long.parseLong(s[2]);
		
		System.out.println(fastPower(a, b, n));

	}
	
	static long fastPower(long a, long b, long n) {
		
		long result = 1;
		
		while(b>0) {
			if((b&1)!=0) {
				result = (result * (a % n)) % n;
			}
			
			a = ((a % n) * (a % n)) % n;
			b = b >> 1;
		}
		
		return result;
	}

}
