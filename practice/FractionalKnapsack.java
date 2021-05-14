package practice;

import java.util.*;
import java.io.*;

public class FractionalKnapsack {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s[] = br.readLine().split(" ");
			
			int n = Integer.parseInt(s[0]);
			int W = Integer.parseInt(s[1]);
			
			String st1[] = br.readLine().split(" ");
			
			int v[] = new int[n];
			int wt[] = new int[n];
			
			for(int i = 0; i<n; i++) {
				v[i] = Integer.parseInt(st1[i]);
			}
			
			String st2[] = br.readLine().split(" ");
			
			for(int i=0; i<n; i++) {
				wt[i] = Integer.parseInt(st2[i]);
			}
			
			float result = solution(n, W, v, wt);
			
			System.out.printf("%.2f\n", result);

		}

	}
	
	static float solution(int n, int W, int v[], int w[]) {
		
		Map<Float, Integer> mp = new TreeMap<>();
		
		for(int i=0; i<n; i++) {
			float x = (float)v[i]/(float)w[i];
			if(mp.containsKey(x)) {
				mp.put(x, mp.get(x)+w[i]);
			}
			else {
				mp.put(x, w[i]);
			}
		}
		
		List<Float> ll = new LinkedList<>(mp.keySet());
		int m = ll.size();
		int cur = 0;
		float ans = 0;
		
		for(int i=m-1; i>=0; i--) {
			
			if(W-cur==0) {
				break;
			}
			
			float val = ll.get(i);
			int wei = mp.get(ll.get(i));
			
			if(wei<(W-cur)) {
				ans = ans + ((float)wei)*val;
				cur = cur + wei;
			}else {
				ans = ans + ((float)(W-cur))*val;
				cur = cur + (W-cur);
			}
			
		}
		
		return ans;
		
	}	

}
