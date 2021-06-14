package backtracking;

import java.io.*;
import java.util.*;

public class NQueenProblem {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int board[][] = new int[n][n];
				for(int rows[]:board) {
					Arrays.fill(rows, 0);
				}
				
				if(!NQueen(board,0)) {
					bw.write("No solution possible!\n");
				}else {
					for(int i=0; i<n; i++) {
						for(int j=0; j<n; j++) {
							bw.write(board[i][j]+" ");
						}
						bw.write("\n");
					}
					bw.write("\n");
				}
				
			
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static boolean isSafe(int board[][], int row, int col) {
		
		int i,j;
		
		for(i=0; i<board.length; i++) {
			if(board[i][col]==1)
				return false;
		}
		
		for(i=row, j = col; i>=0 && j>=0; i--, j--) {
			if(board[i][j]==1)
				return false;
		}
		
		for(i=row, j=col; i>=0 && j<board.length; i--, j++) {
			if(board[i][j]==1)
				return false;
		}
		
		return true;
	}
	
	static boolean NQueen(int board[][], int row) {
		if(row==board.length)return true;
		for(int col=0; col<board.length; col++) {
			if(isSafe(board,row,col)) {
				board[row][col] = 1;
				if(NQueen(board,row+1))
					return true;
				board[row][col] = 0;
			}
		}
		return false;
	}

}
