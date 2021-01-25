package codeChef;

import java.io.*;

public class AdaMatrix {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t>0) {
				int n = Integer.parseInt(br.readLine().trim());
				int a[][] = new int[n][n];
				for(int i=0; i<n; i++) {
					String s1[] = br.readLine().split(" ");
					for(int j=0; j<n; j++) {
						a[i][j] = Integer.parseInt(s1[j]);
					}
				}
				solution(n, a);
				t--;
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int n, int a[][]) {
		int c = 0;
		for(int i = n-1; i>=0; i--) {
			if(a[0][i]!=i+1) {
				for(int j=0; j<=i; j++) {
					for(int k = j; k<=i; k++) {
						int temp = a[j][k];
						a[j][k] = a[k][j];
						a[k][j] = temp;
					}
				}
				c++;
			}
		}
		System.out.println(c);
	}

}
