package codeChef;

import java.io.*;

public class ShortestRoute {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				String s2[] = br.readLine().split(" ");
				String s3[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				int a[] = new int[n];
				for(int i=0; i<n; i++) {
					a[i] = Integer.parseInt(s2[i]);
				}
				int b[] = new int[m];
				for(int i=0; i<m; i++) {
					b[i] = Integer.parseInt(s3[i]);
				}
				int ans[] = solution(n, m, a, b);
				for(int i=0; i<m; i++) {
					bw.write(ans[i]+" ");
				}
				bw.write("\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static int[] solution(int n, int m, int a[], int b[]) {
		int left[] = new int[n];
		int right[] = new int[n];
		int cnt = 0;
		boolean flag = false;
		for(int i=0; i<n; i++) {
			if(a[i]==1) {
				cnt = 0;
				left[i] = cnt;
				cnt++;
				flag = true;
				continue;
			}
			
			if(flag) {
				left[i] = cnt++;
			}else {
				left[i] = cnt;
			}
		}
		cnt = 0;
		flag = false;
		for(int i=n-1; i>=0; i--) {
			if(a[i]==2) {
				cnt = 0;
				right[i] = cnt;
				cnt++;
				flag = true;
				continue;
			}
			
			if(flag) {
				right[i] = cnt++;
			}else {
				right[i] = cnt;
			}
		}
		
		int ans[] = new int[m];
		for(int i=0; i<m; i++) {
			
			if(b[i]==1){
		        ans[i] = 0;
		        continue;
		    }
			
			if(a[b[i]-1]!=0) {
				ans[i] = 0;
				continue;
			}
			
			if(a[b[i]-1]==0 && left[b[i]-1]==0 && right[b[i]-1]==0) {
				ans[i] = -1;
				continue;
			}
			
			int leftTime = left[b[i]-1];
			int rightTime = right[b[i]-1];
			int least = 0;
			if(leftTime==0) {
				least = rightTime;
			}else if(rightTime==0) {
				least = leftTime;
			}else {
				least = leftTime<=rightTime?leftTime:rightTime;
			}
			ans[i] = least;
				
			
		}
		
		return ans;
		
	}

}