package dynamicProgram;

import java.io.*;

public class UglyNumber {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(uglyNumber(n));
		}

	}
	
	static long uglyNumber(int n) {
		long ugly[] = new long[n];
		ugly[0] = 1;
		
		long uglyNo = 1;     
		
		int i2 = 0, i3 = 0, i5 = 0;
		
		long nxt_mul_2 = ugly[0]*2;
		long nxt_mul_3 = ugly[0]*3;
		long nxt_mul_5 = ugly[0]*5;
		
		for(int i=1; i<n; i++) {
			
			uglyNo = Math.min(nxt_mul_2, Math.min(nxt_mul_3, nxt_mul_5));
			
			ugly[i] = uglyNo;
			
			if(uglyNo == nxt_mul_2) {
				i2 += 1;
				nxt_mul_2 = ugly[i2]*2;
			}
			if(uglyNo == nxt_mul_3) {
				i3 += 1;
				nxt_mul_3 = ugly[i3]*3;
			}
			if(uglyNo == nxt_mul_5) {
				i5 += 1;
				nxt_mul_5 = ugly[i5]*5;
			}
		}
		return uglyNo;
	}

}
