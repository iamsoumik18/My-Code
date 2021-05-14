package codeChef;

import java.io.*;
import java.util.*;

public class ModularEquation {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				List<Long> l = new ArrayList<>();
				for(int i=0; i<=n; i++) {
					l.add((long)1);
				}
				long ans = 0;
//				for(int i=1; i<=n; i++) {
//					for(int j=i+1; j<=n; j++) {
//						if(((m%i)%j)==((m%j)%i)) {
//							ans++;
//						}
//					}
//				}
				for(int i=2; i<=n; i++) {
					int x = m%i;
					ans+=l.get(x);
					for(int j=x; j<=n; j=j+i) {
						l.set(j, l.get(j)+1);
					}
				}
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}
