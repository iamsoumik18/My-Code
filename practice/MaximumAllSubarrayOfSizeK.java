package practice;

import java.io.*;
import java.util.*;

public class MaximumAllSubarrayOfSizeK {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int k = Integer.parseInt(s1[1]);
			String s2[] = br.readLine().split(" ");
			int a[] = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(s2[i]);
			}
			int ans[] = solution(a, n, k);
			for(int i=0; i<ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}

	}
	
	static int[] solution(int a[], int n, int k) {
		
		Deque<Integer> dq = new ArrayDeque<>();
		int ans[] = new int[n-k+1];
		int i = 0;
		for(; i<k; i++) {
			while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for(; i<n; i++) {
			ans[i-k] = a[dq.peekFirst()];
			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		ans[i-k] = a[dq.peekFirst()];
		
		return ans;
		
	}

}
