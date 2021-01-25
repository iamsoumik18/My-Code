package codeChef;

import java.io.*;

public class PositiveAND {
	
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				solution(n);
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int n) {
		if(n==1) {
			System.out.println("1");
		}
		else if(n==3) {
			System.out.println("1 3 2");
		}
		else if(powerOfTwo(n)) {
			System.out.println(-1);
		}
		else {
			System.out.print("2 3 1 ");
			int i = 4;
			while(i<=n) {
				if(powerOfTwo(i)) {
					System.out.print((i+1)+" "+i+" ");
					i += 2;
				}
				else {
					System.out.print(i+" ");
					i++;
				}
			}
			System.out.println();
		}
	}
	
	static boolean powerOfTwo(int n) {
		return n!=0 && ((n&(n-1))==0);
	}

}
