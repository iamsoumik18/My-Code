package codeChef;

import java.util.*;
import java.io.*;

public class ReplaceForX {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t>0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int x = Integer.parseInt(s1[1]);
				int p = Integer.parseInt(s1[2]);
				int k = Integer.parseInt(s1[3]);
				int a[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
				}
				solution(a,n,x,p-1,k-1);
				t--;
			}
		}catch(Exception e) {
			return;
		}
		br.close();
	}
	
	static void solution(int a[], int n, int x, int p, int k) {
		Arrays.sort(a);
		if(a[p]==x) {
			System.out.println(0);
		}
		else if(k>=p && a[p]>=x) {
			int i = p;
			int count = 0;
			while(i>=0) {
				if(a[i]<=x)break;
				i--;
				count++;
			}
			System.out.println(count);
		}
		else if(p>=k && a[p]<=x) {
			int i = p;
			int count = 0;
			while(i<n) {
				if(a[i]>=x)break;
				i++;
				count++;
			}
			System.out.println(count);
		}
		else {
			System.out.println(-1);
		}
	}

}
