package codeChef;

import java.util.*;
import java.io.*;

public class AdaAndDishes {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int a[] = new int[n];
				String s1[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s1[i]);
				}
				Arrays.sort(a);
				System.out.println(solution(n,a));
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(int n, int a[]) {
		if(n==1) {
			return a[0];
		}
		if(n==2){
			return a[0]>a[1]?a[0]:a[1];
		}
		int x = a[n-1];
		int y = 0;
		for(int i = n - 2; i>=0; i--) {
			if(y<=x) {
				y += a[i];
			}
			else {
				x += a[i];
			}
		}
		return x>y?x:y;
	}

}
