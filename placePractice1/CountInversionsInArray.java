package placePractice1;

import java.io.*;

public class CountInversionsInArray {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				long a[] = new long[n];
				for(int i=0; i<n; i++) {
					a[i] = Long.parseLong(s1[i]);
				}
				long temp[] = new long[n];
				long cnt = mergeSort(a,temp,0,n-1);
				bw.write(cnt+" \n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static long mergeSort(long a[], long temp[], int left, int right) {
		long cnt = 0;
		if(left<right) {
			int mid = (left+right)/2;
			cnt += mergeSort(a,temp,left,mid);
			cnt += mergeSort(a,temp,mid+1,right);
			
			cnt += merge(a,temp,left,mid+1,right);
			
		}
		return cnt;
	}
	
	static long merge(long a[], long temp[], int left, int mid, int right) {
		int i = left;
		int j = mid;
		int k = left;
		long cnt = 0;
		
		while(i<mid && j<=right) {
			if(a[i]<=a[j]) {
				temp[k++] = a[i++];
			}else {
				temp[k++] = a[j++];
				cnt += mid-i;
			}
		}
		
		while(i<mid) {
			temp[k++] = a[i++];
		}
		
		while(j<=right) {
			temp[k++] = a[j++];
		}
		
		for(i=left; i<=right; i++) {
			a[i] = temp[i];
		}
		
		return cnt;
	}

}
