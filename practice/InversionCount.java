package practice;

import java.util.*;
import java.io.*;

public class InversionCount {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			int n = Integer.parseInt(br.readLine());
			
			int a[] = new int[n];
			
			String s[] = br.readLine().split(" ");
			
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(s[i]);
			
			System.out.println(mergeSortAndCount(a, 0, n-1));
			
		}

	}
	
	static long mergeAndCount(int a[], int l, int m, int r) {
		int left[] = Arrays.copyOfRange(a, l, m+1);
		
		int right[] = Arrays.copyOfRange(a, m+1, r+1);
		
		int i = 0, j = 0, k = l;
		long swap = 0;
		
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				a[k++] = left[i++];
			}else {
				a[k++] = right[j++];
				swap += left.length - i;
			}
		}
		
		while(i<left.length) {
			a[k++] = left[i++];
		}
		
		while(j<right.length) {
			a[k++] = right[j++];
		}
		
		return swap;
		
	}
	
	static long mergeSortAndCount(int a[], int l, int r) {
		long count = 0;
		
		if(l<r) {
			
			int m = (l+r)/2;
			
			count += mergeSortAndCount(a, l, m);
			
			count += mergeSortAndCount(a, m+1, r);
			
			count += mergeAndCount(a, l, m, r);
		
		}
		
		return count;
		
	}

}
