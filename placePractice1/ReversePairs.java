package placePractice1;

import java.io.*;
import java.util.*;

public class ReversePairs {

	public static void main(String[] args) {
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
				int ans = solution(a);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(int[] a) {
		return mergeSort(a,0,a.length-1);
	}
	
	static int mergeSort(int a[], int low, int high) {
		int cnt = 0;
		if(low<high) {
			int mid = (low+high)/2;
			cnt += mergeSort(a,low,mid);
			cnt += mergeSort(a,mid+1,high);
			cnt += merge(a,low,mid,high);
		}
		return cnt;
	}
	
	static int merge(int a[], int low, int mid, int high) {
		int cnt = 0;
		int j = mid+1;
		for(int i=low; i<=mid; i++) {
			while(j<=high && a[i]>2*(long)a[j]) {
				j++;
			}
			cnt += (j - (mid+1));
		}
		
		List<Integer> temp = new ArrayList<>();
		int i = low;
		j = mid + 1;
		
		while(i<=mid && j<=high) {
			if(a[i]<a[j]) {
				temp.add(a[i++]);
			}else {
				temp.add(a[j++]);
			}
		}
		
		while(i<=mid) {
			temp.add(a[i++]);
		}
		
		while(j<=high) {
			temp.add(a[j++]);
		}
		
		for(i=0; i<temp.size(); i++) {
			a[low+i] = temp.get(i);
		}
		
		return cnt;
	}

}
