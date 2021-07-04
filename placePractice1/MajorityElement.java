package placePractice1;

import java.io.*;

//Find element whose occurrence is greater than n/2 times.

public class MajorityElement {

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
				int ans = solution(nums);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	//Moore's Voting Algorithm
	
	static int solution(int nums[]) {
		int n = nums.length;
		int cnt = 0;
		int ele = 0;
		for(int i=0; i<n; i++) {
			if(cnt==0)
				ele = nums[i];
			if(ele==nums[i])
				cnt++;
			else
				cnt--;
		}	
		return ele;
	}

}
