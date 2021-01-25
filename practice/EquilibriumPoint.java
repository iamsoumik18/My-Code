package practice;

import java.util.*;
import java.io.*;
import java.lang.*;

public class EquilibriumPoint {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			
			String s[] = br.readLine().split(" ");
			
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			
			int index = func(a);
			
			System.out.println(index);
			
		}
		
	}
	
	static int func(int a[]) {
		int index = -1;
		int left = 0;
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		
		int i = 0;
		
		while(i<a.length) {
			sum -= a[i];
			
			if(left == sum) {
				return i+1;
			}
			
			left += a[i];
			
			i++;
		}
		
		return index;
	}

}
