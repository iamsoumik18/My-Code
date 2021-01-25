package codeChef;

import java.io.*;

public class IronMagnetAndWall {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int k = Integer.parseInt(s1[1]);
				String s = br.readLine();
				solution(n,k,s);
			}
		}catch(Exception e) {
			return;
		}
	}
	static void solution(int n, int k, String s) {
		int ir = 0;
		int mg = 0;
		int ans = 0;
		while(ir<n && mg<n) {
			while(ir<n) {
				if(s.charAt(ir)=='I' || s.charAt(ir)=='X') {
					break;
				}
				ir++;
			}
			while(mg<n) {
				if(s.charAt(mg)=='M' || s.charAt(mg)=='X'){
					break;
				}
				mg++;
			}
			if(ir>=n || mg>=n) {
				break;
			}
			if(s.charAt(ir)=='X' || s.charAt(mg)=='X') {
				ir = Math.max(ir,mg) + 1;
				mg = ir;
				continue;
			}
			int cs = 0;
			for(int i = Math.min(ir,mg); i<Math.max(ir, mg); i++) {
				if(s.charAt(i)==':') {
					cs++;
				}
			}
			int p = k + 1 - Math.abs(ir-mg) - cs;
			if(p>0) {
				ans += 1;
				ir++;
				mg++;
			}else{
				if(ir<mg) {
					ir++;
				}else{
					mg++;
				}
			}	
		}
		System.out.println(ans);
	}
}
