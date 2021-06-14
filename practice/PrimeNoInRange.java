package practice;

import java.util.*;
import java.io.*;

public class PrimeNoInRange {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the range(2-n): ");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println();
		
		boolean isPrime[] = sieveOfEratosthenes(n);
		
		System.out.print("The list of prime numbers between (2-"+n+") is: ");
		for(int i = 2; i<=n; i++) {
			if(isPrime[i]) {
				System.out.print(i+" ");
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

}
