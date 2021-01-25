package codeChef;

import java.io.*;
import java.util.*;

public class AProblemOnSticks {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
		
			while(t>0) {
				int n = Integer.parseInt(br.readLine().trim());
				long a[] = new long[n];
				String s1[] = br.readLine().split(" ");
				for(int i=0; i<n; i++)
					a[i] = Long.parseLong(s1[i]);
				System.out.println(solution(n,a));
				t--;
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(int n, long a[]) {
		int c = 0;
		Arrays.sort(a);
		long num = a[0];
		if(num==0)
			c = 0;
		else
			c = 1;
		for(int i=1; i<n; i++) {
			if(a[i]!=num) {
				c++;
				num = a[i];
			}
		}
		return c;
	}

}
