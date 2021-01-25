package practice;

import java.io.*;
import java.util.*;

public class SlidingWindowMax {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		SlidingSolution ss = new SlidingSolution();
		ss.neg(a, k);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		SlidingSolution ss = new SlidingSolution();
//		
//		System.out.print("Enter array size: ");
//		int n = Integer.parseInt(br.readLine());
//		
//		int a[] = new int[n];
//		
//		System.out.print("\nEnter array elements: \n");
//		for(int i=0; i<n; i++) {
//			a[i] = Integer.parseInt(br.readLine());
//		}
//		
//		System.out.println("\nEnter window size: ");
//		int k = Integer.parseInt(br.readLine());
//		
//		int ans[] = ss.slidingWindow(a, k);
//		
//		System.out.print("\nResult: ");
//		for(int num: ans) {
//			System.out.print(num+" ");
//		}
		

	}

}

class SlidingSolution{
	public int[] slidingWindow(int a[], int k) {
		int n = a.length;
		
		if(n<=1) {
			return a;
		}
		
		int ans[] = new int[n-k+1];
		
		Deque<Integer> dq = new ArrayDeque<>();
		int i=0;
		for(; i<k ; i++) {
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
	
	public void neg(int a[], int k) {
		int n = a.length;
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<k; i++) {
			if(a[i]<0) {
				dq.addLast(i);
			}
		}
		
		if(dq.isEmpty()) {
			System.out.print("0 ");
		}
		else {
			System.out.print(a[dq.peekFirst()]+" ");
		}
		
		for(int i=k; i<n; i++) {
			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.removeFirst();
			}
			if(a[i]<0) {
				dq.addLast(i);
			}
			if(dq.isEmpty()) {
				System.out.print("0 ");
			}
			else {
				System.out.print(a[dq.peekFirst()]);
			}
		}
	}
}
















