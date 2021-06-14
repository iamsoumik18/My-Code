package placePractice1;

import java.io.*;
import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[][] solution(int[][] intervals){
		
		List<int[]> res = new ArrayList<>();
		
		Arrays.sort(intervals, (a,b)->a[0]-b[0]);
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for(int[] set: intervals) {
			if(set[0]<=end) {
				end = Math.max(set[1], end);
			}else {
				res.add(new int[] {start,end});
				start = set[0];
				end = set[1];
			}
		}
		
		res.add(new int[] {start,end});
		
		return res.toArray(new int[res.size()][]);
		
	}

}
