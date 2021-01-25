package practice;

import java.util.*;
import java.io.*;

public class MergeIntervals {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int a[][] = new int[n][2];
				for(int i = 0; i<n; i++) {
					String s1[] = br.readLine().split(" ");
					a[i][0] = Integer.parseInt(s1[0]);
					a[i][1] = Integer.parseInt(s1[1]);
				}
				Merge ob = new Merge();
				int ans[][] =  ob.merge(a);
				for(int i=0; i<ans.length; i++) {
					System.out.print(ans[i][0]+" "+ans[i][1]+"\n");
				}
			}
		}catch(Exception e) {
			return ;
		}
	}
}
class Merge {
	
    public int[][] merge(int[][] intervals) {
    	Collections.sort(Arrays.asList(intervals), new Comparator<int []>() {
    		@Override
    		public int compare(int a[], int b[]) {
    			return a[0]<b[0]?-1:a[0]==b[0]?0:1;
    		}
    	});
    	LinkedList<int[]> merged = new LinkedList<>();
    	for(int interval[]: intervals) {
    		if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
    			merged.add(interval);
    		}
    		else {
    			merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
    		}
    	}	
    	return merged.toArray(new int[merged.size()][]);
    }
}
