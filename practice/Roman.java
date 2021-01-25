package practice;

import java.io.*;

public class Roman {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Rm sl = new Rm();
		
		int ans = sl.romanToInt(s);
		
		System.out.println(ans);

	}
}

class Rm{
	public int romanToInt(String s) {
		int ans = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='M') {
				ans = ans + 1000;
				continue;
			}
			if(c=='D') {
				ans = ans + 500;
				continue;
			}
			if(c=='C') {
				if(i<=s.length()-2) { 
					if(s.charAt(i+1)=='D') {
						ans = ans + 400;
						i = i + 1;
						continue;
					}
					else if(s.charAt(i+1)=='M') {
						ans = ans + 900;
						i = i + 1;
						continue;
					}
					else {
						ans = ans + 100;
						continue;
					}
				}
				else {
					ans = ans + 100;
					continue;
				}
			}
			if(c=='L') {
				ans = ans + 50;
				continue;
			}
			if(c=='X') {
				if(i<=s.length()-2) { 
					if(s.charAt(i+1)=='L') {
						ans = ans + 40;
						i = i+1; 
						continue;
					}
					else if(s.charAt(i+1)=='C') {
						ans = ans + 90;
						i = i+1;
						continue;
					}
					else {
						ans = ans + 10;
						continue;
					}
				}
				else {
					ans = ans + 10;
					continue;
				}
			}
			if(c=='V') {
				ans = ans + 5;
				continue;
			}
			if(c=='I') {
				if(s.length()-i==2) {
					if(s.charAt(i+1)=='V') {
						ans = ans + 4;
						i = i+1;
						continue;
					}
					else if(s.charAt(
							i+1)=='X') {
						ans = ans + 9;
						i = i+1;
						continue;
					}
					else {
						ans = ans + 2;
						i = i+1;
						continue;
					}
				}
				else if(s.length()-i==3) {
					ans = ans + 3;
					i = i + 2;
					continue;
				}
				else if(s.length()-i==1) {
					ans = ans + 1;
					continue;
				}
			}
		}
		return ans;
	}
}


