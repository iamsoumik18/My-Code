package codeChef;

import java.io.*;

public class CovidRun {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t>0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				int x = Integer.parseInt(s1[2]);
				int y = Integer.parseInt(s1[3]);
				solution(n,k,x,y);
				t--;
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int n, int k, int x, int y) {
		int cur = (x+k)%n;
		while(true) {
			if(cur==y) {
				System.out.println("YES");
				return;
			}
			if(cur==x) {
				System.out.println("NO");
				return;
			}
			cur = (cur+k)%n;
		}
	}
}
