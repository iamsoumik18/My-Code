package placePractice1;

import java.io.*;
import java.util.*;

//Find list of elements whose occurrence is greater than n/3 times.

public class MajorityElement2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				int nums[] = new int[n];
				for(int i=0; i<n; i++) {
					nums[i] = Integer.parseInt(s1[i]);
				}
				List<Integer> ans = solution(nums);
				for(int num: ans) {
					bw.write(num+" ");
				}
				bw.write("\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	//Boyer-Moore Voting Algorithm
	static List<Integer> solution(int[] nums){
		int n = nums.length;
		int cnt1 = 0;
		int cnt2 = 0;
		int num1 = -1;
		int num2 = -1;
		for(int i=0; i<n; i++) {
			if(nums[i]==num1) {
				cnt1++;
			}else if(nums[i]==num2) {
				cnt2++;
			}else if(cnt1==0) {
				num1 = nums[i];
				cnt1 = 1;
			}else if(cnt2==0) {
				num2 = nums[i];
				cnt2 = 1;
			}else {
				cnt1--;
				cnt2--;
			}
		}
		
		cnt1 = 0;
		cnt2 = 0;
		for(int i=0; i<n; i++) {
			if(nums[i]==num1)
				cnt1++;
			else if(nums[i]==num2)
				cnt2++;
		}
		List<Integer> list = new ArrayList<>();
		if(cnt1>nums.length/3)
			list.add(num1);
		if(cnt2>nums.length/3)
			list.add(num2);
		return list;
	}

}
