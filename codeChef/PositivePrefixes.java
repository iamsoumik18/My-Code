package codeChef;

import java.io.*;

public class PositivePrefixes {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				int a[] = new int[n+1];
				int sum = 0;
				int cnt = 0;
				if((n&1)==0) {
					for(int i=1; i<=n; i++) {
						if((i&1)==0)
							a[i] = i;
						else
							a[i] = -i;
						sum += a[i];
						cnt = sum>0?cnt+1:cnt;
					}
				}else {
					for(int i=1; i<=n; i++) {
						if((i&1)==0)
							a[i] = -i;
						else 
							a[i] = i;
						sum += a[i];
						cnt = sum>0?cnt+1:cnt;
					}
				}
				
				if(cnt>k) {
					for(int i=n; i>0 && cnt!=k; i--) {
						if(a[i]>0) {
							a[i] = -1*a[i];
							cnt--;
						}
					}
				}
				
				if(cnt<k) {
					for(int i=n; i>0 && cnt!=k; i--) {
						if(a[i]<0) {
							a[i] = -1*a[i];
							cnt++;
						}
					}
				}
				
				for(int i=1; i<=n; i++)
					bw.write(a[i]+" ");
				bw.write("\n");
				bw.flush();
				
			}
		}catch(Exception e) {
			return;
		}
	}
	
}
