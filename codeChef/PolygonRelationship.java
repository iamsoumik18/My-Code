package codeChef;

import java.io.*;

public class PolygonRelationship {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine().trim());
			while(t>0) {
				int n = Integer.parseInt(br.readLine().trim());
				String temp;
				for(int i=0; i<n; i++)
					temp = br.readLine();
				solution(n);
				t--;
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static void solution(int num) {
		long sum = num;
		int n = num;
		while(n>5) {
			sum += n/2;
			n = n/2;
		}
		System.out.println(sum);
	}

}
