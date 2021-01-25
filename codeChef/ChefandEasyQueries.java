package codeChef;

import java.util.*;
import java.io.*;

public class ChefandEasyQueries {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t>0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				long k = Long.parseLong(s1[1]);
				long a[] = new long[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++)
					a[i] = Long.parseLong(s2[i]);
				System.out.println(solution(a,n,k));
				t--;
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static long solution(long a[], int n, long k) {
		Deque<Long> stack = new ArrayDeque<>();
		boolean flag = true;
		long day = 0;
		int i = 0;
		while(flag) {
			if(i<n) {
				long temp = !stack.isEmpty()?stack.pollLast():0;
				stack.push(temp+a[i]);
				i++;
			}
			if(i>=n) {
				long temp = stack.pollLast();
				long temp1 = temp/k;
				day = day + temp1 + 1;
				break;
			}
			long val = stack.pollLast();
			if(val<k || val==0) {
				day++;
				flag = false;
				break;
			}
			val = val - k;
			stack.push(val);
			day++;
		}
		return day;
	}
	
}
