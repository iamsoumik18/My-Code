package codeChef;

import java.io.*;

public class EvenMatrix {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int a[][] = new int[n][n];
				spiralFill(n, n, a);
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						bw.write(a[i][j]+" ");
					}
					bw.write("\n");
				}
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static void spiralFill(int m, int n, int a[][]) {
        int val = 1;
        int k = 0, l = 0;
        while (k < m && l < n) {
            for (int i = l; i < n; ++i) {
                a[k][i] = val++;
            }
            k++;
            for (int i = k; i < m; ++i) {
                a[i][n - 1] = val++;
            }
            n--;
            if (k < m) {
                for (int i = n - 1; i >= l; --i) {
                    a[m - 1][i] = val++;
                }
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= k; --i) {
                    a[i][l] = val++;
                }
                l++;
            }
        }
    }

}