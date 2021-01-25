package practice;

import java.util.*;

public class FloodFill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter rows ans cols: ");
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a[][] = new int[r][c];
		System.out.print("\nEnter array elements: ");
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.print("\nEnter target co-ordinates: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.print("\nEnter swap element: ");
		int k = sc.nextInt();
		floodFill(a,x,y,k);
		System.out.print("Arrays elements after fill: ");
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(a[i][j]+" ");
			}
		}
	}
	
	static void floodFill(int a[][], int x, int y, int k) {
		int colr = a[x][y];
		floodFillRecur(a,x,y,colr,k);
	}
	
	static void floodFillRecur(int a[][], int x, int y, int colr, int k) {
		int r = a.length;
		int c = a[0].length;
		
		if(x<0 || x>=r || y<0 || y>=c)
			return;
		
		if(a[x][y]!=colr)
			return;
		
		a[x][y] = k;
		
		floodFillRecur(a,x+1,y,c,k);
		floodFillRecur(a,x-1,y,c,k);
		floodFillRecur(a,x,y+1,c,k);
		floodFillRecur(a,x,y-1,c,k);
		
	}

}
