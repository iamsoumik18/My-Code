package codeChef;

import java.io.*;

public class ChefInHeaven {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int l = Integer.parseInt(br.readLine());
				String s = br.readLine();
				boolean ans = solution(s);
				if(ans) {
					bw.write("YES\n");
					bw.flush();
				}else {
					bw.write("NO\n");
					bw.flush();
				}
			}
			
		}catch(Exception e) {
			return;
		}

	}
	
	static boolean solution(String s) {
		int cOne = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='1') {
				cOne++;
				if( ((cOne*100)/(i+1)) >= 50 ) {
					return true;
				}
			}
		}
		return false;
	}

}
