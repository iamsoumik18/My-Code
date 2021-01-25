package practice;

import java.io.*;

public class MergeWithoutExtraSpace {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int m = Integer.parseInt(s1[1]);
			String s2[] = br.readLine().split(" ");
			String s3[] = br.readLine().split(" ");
			int a[] = new int[n];
			int b[] = new int[m];
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(s2[i]);
			for(int i=0; i<m; i++)
				b[i] = Integer.parseInt(s3[i]);
			solution(n,a,m,b);
			for(int i=0; i<n; i++)
				System.out.print(a[i]+" ");
			for(int i=0; i<m; i++)
				System.out.print(b[i]+" ");
			System.out.println();
		}
	}
	
	static int gapValue(int g) {
		if(g<=1) {
			return 0;
		}
		return (g/2)+(g%2);
	}
	
	static void solution(int n, int a[], int m, int b[]) {
		int i, j, gap = n+m;
		for(gap = gapValue(gap); gap>=1; gap = gapValue(gap)) {
			for(i=0; i+gap<n; i++) {
				if(a[i]>a[i+gap]) {
					int temp = a[i];
					a[i] = a[i+gap];
					a[i+gap] = temp;
				}
			}
			for(j = gap>n?gap-n:0; i<n && j<m; i++,j++) {
				if(a[i]>b[j]) {
					int temp = a[i];
					a[i] = b[j];
					b[j] = temp;
				}
			}
			if(j<m) {
				for(j=0; j+gap<m; j++) {
					if(b[j]>b[j+gap]) {
						int temp = b[j];
						b[j] = b[j+gap];
						b[j+gap] = temp;
					}
				}
			}
		}
	}
}
