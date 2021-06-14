package placePractice1;

import java.io.*;

//Kadane's Algorithm

public class MaximumSubarraySum {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				int a[] = new int[n];
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s1[i]);
				}
				int ans = kadaneAlgo(n,a);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static int kadaneAlgo(int n, int a[]) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for(int i=0; i<n; i++) {
			curSum += a[i];
			maxSum = curSum>maxSum?curSum:maxSum;
			curSum = curSum<0?0:curSum;
		}
		return maxSum;
	}

}
