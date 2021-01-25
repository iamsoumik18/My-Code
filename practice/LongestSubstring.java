package practice;

import java.io.*;
import java.util.*;

public class LongestSubstring {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the string: ");
		
		String s = br.readLine();
		
		System.out.println();
		
		int ans = lengthOfLongestSubstring(s);
		
		System.out.println("Length of longest substring is "+ans+".");

	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		Deque<Character> dq = new ArrayDeque<>();
		
		int max = 0;
		
		for(int i=0; i<s.length(); i++) {
			
			if(dq.isEmpty()) {
				dq.add(s.charAt(i));
			}
			else if(dq.contains(s.charAt(i))) {
				max = dq.size()>max?dq.size():max;
				boolean flag = true;
				while(flag) {
					if(dq.peekFirst()!=s.charAt(i)) {
						dq.removeFirst();
					}else {
						dq.removeFirst();
						flag = false;
					}
				}
				dq.add(s.charAt(i));
			}
			else {
				dq.add(s.charAt(i));
			}
		}
		
		max = dq.size()>max?dq.size():max;
		
		return max;
	}		
		
}
