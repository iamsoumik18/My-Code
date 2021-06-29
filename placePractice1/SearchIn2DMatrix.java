package placePractice1;

import java.io.*;

public class SearchIn2DMatrix {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				int matrix[][] = new int [n][m];
				for(int i=0; i<n; i++) {
					String s2[] = br.readLine().split(" ");
					for(int j=0; j<m; j++) {
						matrix[i][j] = Integer.parseInt(s2[j]);
					}
				}
				int target = Integer.parseInt(br.readLine());
				boolean ans = solution1(matrix, target);
				if(ans) {
					bw.write(target+" is present\n");
				}else {
					bw.write(target+" is not present\n");
				}
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}
	
	/*
	 
	Matrix having properties:
		- Integers in each row are sorted from left to right.
		- The first integer of each row is greater than the last integer of the previous row.
		
	Matrix having properties:
		- Integers in each row are sorted in ascending from left to right.
		- Integers in each column are sorted in ascending from top to bottom.
		
	solution1 works on both of the above cases.
	 
	*/
	
	static boolean solution1(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int i = 0;
		int j = m-1;
		while(i<n && j>=0) {
			if(matrix[i][j]==target) {
				return true;
			}
			if(matrix[i][j]<target) {
				i++;
			}else {
				j--;
			}
		}
		return false;
	}
	
	/*
	 
	For the matrix having properties:
		- Integers in each row are sorted from left to right.
		- The first integer of each row is greater than the last integer of the previous row.
		
	solution2 works for the above condition only.
	 
	Intuition is Binary Search for solution2.
	
	*/
	static boolean solution2(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int low = 0;
		int high = (n*m)-1;
		while(low<=high) {
			int mid = low + (high - low) / 2;
			if(matrix[mid/m][mid%m]==target) {
				return true;
			}
			if(matrix[mid/m][mid%m]<target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return false;
	}
	

}