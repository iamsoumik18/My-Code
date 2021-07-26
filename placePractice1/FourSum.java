package placePractice1;

import java.io.*;
import java.util.*;

public class FourSum {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int target = Integer.parseInt(s1[1]);
				int nums[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					nums[i] = Integer.parseInt(s2[i]);
				}
				
				List<List<Integer>> ans = solution(nums,target);
				for(List<Integer> lst: ans) {
					for(int num: lst) {
						bw.write(num+" ");
					}
					bw.write("\n");
				}
				bw.write("\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static List<List<Integer>> solution(int[] nums, int target){
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		int n = nums.length;
		
		Arrays.sort(nums);
		
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				int target2 = target - nums[i] - nums[j];
				
				int left = j+1;
				int right = n-1;
				
				while(left<right) {
					
					int twoSum = nums[left] + nums[right];
					
					if(twoSum<target2) {
						left++;
					}else if(twoSum>target2) {
						right--;
					}else {
						List<Integer> quad = new ArrayList<>();
						quad.add(nums[i]);
						quad.add(nums[j]);
						quad.add(nums[left]);
						quad.add(nums[right]);
						ans.add(quad);
						
						while(left<right && nums[left]==quad.get(2))
							left++;
						
						while(left<right && nums[right]==quad.get(3))
							right--;
					}
				}
				
				while(j+1<n && nums[j+1]==nums[j])
					j++;
				
			}
			
			while(i+1<n && nums[i+1]==nums[i])
				i++;
			
		}
		
		return ans;
		
	}

}
