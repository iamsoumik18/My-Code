package practice;

import java.io.*;

public class Knapsack01Recur {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int W = Integer.parseInt(br.readLine());
			String s1[] = br.readLine().split(" ");
			int v[] = new int[n];
			for(int i=0; i<n; i++) {
				v[i] = Integer.parseInt(s1[i]);
			}
			String s2[] = br.readLine().split(" ");
			int w[] = new int[n];
			for(int i=0; i<n; i++) {
				w[i] = Integer.parseInt(s2[i]);
			}
			System.out.println(knapsack(W, n, v, w));
		}

	}
	
	static int knapsack(int W, int n, int v[], int w[]) {
		
		if(n==0 || W==0) {
			return 0;
		}
		
		if(w[n-1]>W) {
			return knapsack(W, n-1, v, w);
		}
		
		return Math.max(v[n-1]+knapsack(W-w[n-1], n-1, v, w), knapsack(W, n-1, v, w));
	}

}
