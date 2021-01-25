package codeChef;

import java.io.*;

public class EvenPairSum {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				long a = Long.parseLong(s1[0]);
				long b = Long.parseLong(s1[1]);
				long e1 = a/2;
				long e2 = b/2;
				long o1 = a - e1;
				long o2 = b - e2;
				long ans = (e1*e2) + (o1*o2);
				System.out.println(ans);
			}
		}catch(Exception e) {
			return;
		}
	}

}
