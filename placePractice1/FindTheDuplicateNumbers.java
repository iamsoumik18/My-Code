package placePractice1;

import java.io.*;

//Floyd's Tortoise and Hare (Cycle Detection)

public class FindTheDuplicateNumbers {

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
				int ans = findDuplicate(nums);
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static int findDuplicate(int nums[]) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow!=fast);
		
		slow = nums[0];
		while(slow!=fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return fast;
	}

}
