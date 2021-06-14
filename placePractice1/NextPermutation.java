package placePractice1;

import java.io.*;

public class NextPermutation {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String n = br.readLine();
				int nums[] = new int[n.length()];
				for(int i=0; i<n.length(); i++) {
					nums[i] = n.charAt(i) - '0';
				}
				solution(nums);
				for(int i=0; i<nums.length; i++) {
					bw.write(nums[i]+"");
				}
				bw.write("\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int[] nums) {
		if(nums.length==1)
			return;
		int i = nums.length-2;
		while(i>=0 && nums[i]>=nums[i+1])
			i--;
		if(i>=0) {
			int j = nums.length-1;
			while(nums[j]<=nums[i])
				j--;
			swap(nums,i,j);
		}
		reverse(nums,i+1,nums.length-1);
	}
	
	static void swap(int[] nums, int i, int j) {
		nums[i] = nums[i]+nums[j];
		nums[j] = nums[i]-nums[j];
		nums[i] = nums[i]-nums[j];
	}
	
	static void reverse(int[] nums, int i, int j) {
		while(i<j)
			swap(nums, i++, j--);
	}

}
