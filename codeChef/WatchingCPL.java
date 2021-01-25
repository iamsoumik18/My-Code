package codeChef;

import java.io.*;
import java.util.*;

public class WatchingCPL {
	
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0){
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				String s2[] = br.readLine().split(" ");
				int h[]=new int[n];
				int arraySum = 0;
				for(int i=0; i<n; i++) {
					h[i] = Integer.parseInt(s2[i]);
					arraySum += h[i];
				}
				
				Arrays.sort(h);
				
				if(arraySum<2*k) {
					bw.write("-1\n");
					bw.flush();
				}else {
					int ans = solution(h,n,k);
					bw.write(ans+"\n");
					bw.flush();
					
				}
				
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void desc(long a[]) {
		Arrays.sort(a);
		int n = a.length;
		for(int i=0; i<n/2; i++) {
			long temp = a[i];
			a[i] = a[n-i-1];
			a[n-i-1] = temp;
		}
	}
	
	static int solution(int h[], int n, int k) {
		Set<Integer> ht1 = new LinkedHashSet<Integer>();
		int sum=0;
		ht1.add(h[n-1]);
		sum = h[n-1];
		int ans = -1;
		for(int i=n-2;i>=0;i--){
			Set<Integer> ht2 = new LinkedHashSet<Integer>();
			sum += h[i];
			Iterator it = ht1.iterator();
			while(it.hasNext()){
				int p=(int)(it.next());
				ht2.add(p);
				ht2.add(h[i]);
				ht2.add(p+h[i]);
				if(((p+h[i])>=k)&&((sum-p-h[i])>=k)){
					ans=n-i;
					break;
				}
				if(((h[i])>=k)&&((sum-h[i])>=k)){
					ans=n-i;
					break;
				}
			}
			if(ans!=-1){
				break;
			}
			ht1 = ht2;
		}
		return ans;
	}
	
	static int recur(int a[], int i, int k, int sumA, int sumB) {
		
		if(sumA>=k && sumB>=k) {
			return 0;
		}
		if((sumA<k || sumB<k) && i<0) {
			return 5000;
		}
		if(sumA>=k && sumB<k) {
			return 1+recur(a,i-1,k,sumA,sumB+a[i]);
		}
		if(sumB>=k && sumA<k ) {
			return 1+recur(a,i-1,k,sumA+a[i],sumB);
		}
		
		
		return Math.min(1+recur(a,i-1,k,sumA+a[i],sumB), 1+recur(a,i-1,k,sumA,sumB+a[i]));
	}
	
}