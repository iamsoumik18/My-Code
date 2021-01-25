package codeChef;

import java.io.*;

public class ChefandWork {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t>0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				int a[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++)
					a[i] = Integer.parseInt(s2[i]);
				solution(n,k,a);
				t--;
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static void solution(int n, int k, int a[]) {
		int sum = 0;
		int c = 0;
		int i = 0;
		while(i<n){
			if(sum==0 && a[i]>k) {
				System.out.println(-1);
				return;
			}else if(sum+a[i]<=k) {
				sum += a[i];
				i++;
			}else {
				c++;
				sum = 0;
			}
		}
		c++;
		System.out.println(c);
	}

}
