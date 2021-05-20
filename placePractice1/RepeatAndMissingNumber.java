package placePractice1;

import java.io.*;
import java.util.*;

public class RepeatAndMissingNumber {

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
				ArrayList<Integer> ans = new ArrayList<>(solution(a));
				int missing = ans.get(0);
				int repeated = ans.get(1);
				bw.write("Missing No: "+missing+"\nRepeated No: "+repeated+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}
	}

	
	static ArrayList<Integer> solution(int a[]) {
		
		int xor = a[0],x=0,y=0,n=a.length,setBitNo=0,miss=0,repeat=0;
		
		for(int i=1; i<n; i++) {
			xor ^= a[i];
		}
		for(int i=1; i<=n; i++) {
			xor ^= i;
		}
		
		// Get the rightmost set bit in setBitNo 
		// (n&~(n-1)) always return the binary number containing rightmost set bit as 1.
		setBitNo = xor & ~(xor-1);
		
		/* Now elements are divided in two sets. One set is where the elements
		   match the rightmost bit with setBitNo and other where the elements don't 
		   match the bits. Then XOR operation is done on those two sets separately 
		   to get the desired results. */
		for(int i=0; i<n; i++) {
			if( (a[i] & setBitNo) != 0)
				x ^= a[i];
			else
				y ^= a[i];
		}
		
		for(int i=1; i<=n; i++) {
			if((i & setBitNo) != 0) 
				x ^= i;
			else
				y ^= i;
				
		}
		
		
		// Now we have to find missing and repeated number
		for(int i=0; i<n; i++) {
			if(a[i]==x || a[i]==y) {
				repeat = a[i];
				break;
			}
		}
		
		miss = x^y^repeat;
		
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(miss);
		ans.add(repeat);
		return ans;
		
	}
	
}
