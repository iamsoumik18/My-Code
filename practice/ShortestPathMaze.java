package practice;

import java.util.*;

public class ShortestPathMaze {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a[][] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                     {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                     {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                     {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                     {1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
                     {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                     {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                     {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		
		int result = shortestPath(a, 0, 0, 8, 9);
		
		if(result>100000) {
			System.out.println("There is no path.");
		}else {
			System.out.println("The shortest path is "+result);
		}
		

	}
	
	static int shortestPath(int a[][], int i, int j, int x, int y) {
		int row = a.length;
		int col = a[0].length;
		
		boolean vis[][] = new boolean[row][col];
		
		return shortestPath(a, i, j, x, y, vis);
	}
	
	static boolean isValid(int a[][], int i, int j, boolean vis[][]) {
		int row = a.length;
		int col = a[0].length;
		
		return i>=0 && j>=0 && i<row && j<col && a[i][j]==1 && !vis[i][j];
		
	}
	
	static int shortestPath(int a[][], int i, int j, int x, int y, boolean vis[][]) {
		
		if(!isValid(a, i, j, vis))
			return 100000;
		
		if(i==x && j==y)
			return 0;
		
		vis[i][j] = true;
		
		int left = shortestPath(a, i, j-1, x, y, vis)+1;
		int right = shortestPath(a, i, j+1, x, y, vis)+1;
		int up = shortestPath(a, i-1, j, x, y, vis)+1;
		int down = shortestPath(a, i+1, j, x, y, vis)+1;
		
		vis[i][j] = false;
		
		return Math.min(Math.min(left, right), Math.min(up, down));
		
	}

}
