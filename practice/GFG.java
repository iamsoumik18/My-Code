package practice;

import java.io.*;

public class GFG {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine();
			String a[] = s.split(" "); 
			int n = Integer.parseInt(a[0]);
			int m = Integer.parseInt(a[1]);
			System.out.println(path(0,0,n,m));
		}

	}
	
	static boolean isValid(int i, int j, int n, int m) {
		return i<n && j<m;
	}
	
	static int path(int i, int j, int n, int m) {
		
		if(!isValid(i,j,n,m)) {
			return 0;
		}
		
		if(i==n-1 || j==m-1) {
			return 1;
		}
		
		return path(i+1, j, n, m) + path(i,j+1,n,m);
	}

}
