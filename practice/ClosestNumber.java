package practice;

import java.util.*;

public class ClosestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		close(a);

	}
	
	public static void close(int a[]) {
		Deque<Integer> dq = new LinkedList<>();
		Arrays.sort(a);
		int cur = Math.abs(a[1]-a[0]);
		dq.addLast(a[0]);
		dq.addLast(a[1]);
		for(int i=2; i<a.length; i++) {
			if(Math.abs(a[i]-a[i-1])<cur) {
				dq.clear();
				cur = Math.abs(a[i]-a[i-1]);
				dq.addLast(a[i-1]);
				dq.addLast(a[i]);
			}
			else if(Math.abs(a[i]-a[i-1])==cur) {
				dq.addLast(a[i-1]);
				dq.addLast(a[i]);
			}
		}
		Object[] ans = dq.toArray();
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
	}

}
