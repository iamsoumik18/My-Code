package codeChef;

import java.io.*;

public class ChefandDice {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				long n = Long.parseLong(br.readLine());
				long q = n/4;
				long r = n%4;
				long ans = 0;
				if(q!=0) {
					if(r==0) {
						ans = (q*44) + 16; 
					}else if(r==1) {
						ans = (q*44) + 12 + 20;
					}else if(r==2) {
						ans = (q*44) + 8 + 36; // (q*36) + 12 + 40
					}else if(r==3) {
						ans = (q*44) + 4 + 51;
					}
				}else if(q==0) {
					if(r==1) {
						ans = 20;
					}else if(r==2) {
						ans = 36; // 40
					}else if(r==3) {
						ans = 51;
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
