package codeChef;

import java.io.*;

public class Bellaciao {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				long D = Long.parseLong(s1[0]);
				long d = Long.parseLong(s1[1]);
				long P = Long.parseLong(s1[2]);
				long Q = Long.parseLong(s1[3]);
				long n = D/d;
				long sum = 0;
				if(D%d==0) {
					sum = (P*n + (Q*(n-1)*n)/2)*d;
				}else {
					sum = ((P*n + (Q*(n-1)*n)/2)*d) + ( (D%d) * (P + n*Q) );
				}
				bw.write(sum+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}

}