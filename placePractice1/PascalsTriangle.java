package placePractice1;

import java.io.*;
import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				List<List<Integer>> ans = solution(n);
				for(int i=0; i<ans.size(); i++) {
					for(int j=0; j<ans.get(i).size(); j++) {
						bw.write(ans.get(i).get(j)+" ");
					}
					bw.write("\n");
				}
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}
	
	static List<List<Integer>> solution(int numRows){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, prev = null;
		
		for(int i=0; i<numRows; i++) {
			row = new ArrayList<>();
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					row.add(1);
				}else {
					row.add(prev.get(j-1)+prev.get(j));
				}
			}
			prev = row;
			res.add(row);
		}
		
		return res;
	}

}
