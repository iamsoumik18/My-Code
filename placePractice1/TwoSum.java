package placePractice1;

import java.io.*;
import java.util.*;

public class TwoSum {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int target = Integer.parseInt(s1[1]);
				int a[] = new int[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
				}
				int ans[] = solution(a,target);
				for(int i=0; i<2; i++) {
					bw.write(ans[i]+" ");
				}
				bw.write("\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static int[] solution(int[] nums, int target) {
		int ans[] = new int[2];
		Map<Integer, Integer> mp = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(mp.containsKey(target-nums[i])) {
				ans[0] = mp.get(target-nums[i]);
				ans[1] = i;
				break;
			}
			mp.put(nums[i], i);
		}
		return ans;
	}

}
