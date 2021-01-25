package codeChef;

import java.util.*;
import java.io.*;

public class RestoreSequence {
	
	static List<Integer> prime = new ArrayList<>();
	
	static void setPrime() {
		boolean isPrime[] = sieveOfEratosthenes(4000000);
		for(int i = 2; i<=4000000; i++) {
			if(isPrime[i]) {
				prime.add(i);
			}
		}
	}
	
	static boolean[] sieveOfEratosthenes(int n) {
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2; i*i<=n; i++) {
			if(isPrime[i])
				for(int j=2*i; j<=n; j+=i)
					isPrime[j] = false;
		}
		return isPrime;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			setPrime();
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int a[] = new int[n];
				String s1[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s1[i]);
				}
				solution(n,a);
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int n, int b[]) {
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = prime.get(i);
		}
		for(int i=0; i<n; i++) {
			if(i!=(b[i]-1)) {
				a[i] = a[b[i]-1];
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
