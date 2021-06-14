package practice;

import java.io.*;

public class MultiplyTwoPolynomial {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s1[] = br.readLine().split(" ");
			
			int m = Integer.parseInt(s1[0]);
			
			int n = Integer.parseInt(s1[1]);
			
			String s2[] = br.readLine().split(" ");
			
			int a[] = new int[m];
			
			for(int i=0; i<m; i++)
				a[i] = Integer.parseInt(s2[i]);
			
			String s3[] = br.readLine().split(" ");
			
			int b[] = new int[n];
			
			for(int i=0; i<n; i++)
				b[i] = Integer.parseInt(s3[i]);
			
			int ans[] = solution(a, b, m, n);
			
			for(int i=0; i<ans.length; i++)
				System.out.print(ans[i]);
			
			System.out.println();
			
		}

	}
	
	static int[] solution(int a[], int b[], int m, int n) {
		
		int ans[] = new int[n+m-1];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				ans[i+j] += a[i]*b[j];
			}
		}
		
		return ans;
		
	}

}
