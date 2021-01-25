package practice;

import java.util.*;

public class ConnectedCell {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int temp = path(matrix, i, j);
				if(temp>max)
					max = temp;
				
			}
		}
		
		System.out.println(max);

	}
	
	static int path(int matrix[][], int i, int j) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		boolean vis[][] = new boolean[row][col];
		
		return path(matrix, i, j, vis);
	}
	
	static boolean isValid(int a[][], int i, int j, boolean vis[][]) {
		int row = a.length;
		int col = a[0].length;
		
		return i>=0 && j>=0 && i<row && j<col && a[i][j]==1 && !vis[i][j];
		
	}
	
	static int path(int matrix[][], int i, int j, boolean vis[][]) {
		if(!isValid(matrix, i, j, vis))
			return 0;
		
		vis[i][j] = true;
		
		int left = path(matrix, i, j-1, vis)+1;
		int right = path(matrix, i, j+1, vis)+1;
		int up = path(matrix, i-1, j, vis)+1;
		int down = path(matrix, i+1, j, vis)+1;
		int tl = path(matrix, i-1, j-1, vis)+1;
		int tr = path(matrix, i-1, j+1, vis)+1;
		int bl = path(matrix, i+1, j-1, vis)+1;
		int br = path(matrix, i+1, j+1, vis)+1;
		
		vis[i][j]=false;
		
		return Math.max(Math.max(Math.max(left, right), Math.max(up, down)) , Math.max(Math.max(tl, tr), Math.max(bl, br)));
	}

}
