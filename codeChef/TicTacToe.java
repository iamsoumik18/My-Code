package codeChef;

import java.io.*;

public class TicTacToe {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try{
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				char a[][] = new char[3][3];
				int xCount = 0;
				int oCount = 0;
				int _Count = 0;
				String s1 = br.readLine();
				for(int i=0; i<3; i++) {
					a[0][i] = s1.charAt(i);
					if(s1.charAt(i)=='X') {
						xCount++;
					}else if(s1.charAt(i)=='O') {
						oCount++;
					}else {
						_Count++;
					}
				}
				String s2 = br.readLine();
				for(int i=0; i<3; i++) {
					a[1][i] = s2.charAt(i);
					if(s2.charAt(i)=='X') {
						xCount++;
					}else if(s2.charAt(i)=='O') {
						oCount++;
					}else {
						_Count++;
					}
				}
				String s3 = br.readLine();
				for(int i=0; i<3; i++) {
					a[2][i] = s3.charAt(i);
					if(s3.charAt(i)=='X') {
						xCount++;
					}else if(s3.charAt(i)=='O') {
						oCount++;
					}else {
						_Count++;
					}
				}
				int ans = sol(a,xCount,oCount,_Count);
				bw.write(ans+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static int sol(char a[][], int xCount, int oCount, int _Count) {
		
		if(oCount>xCount) {
			return 3;
		}
		
		if((xCount - oCount) > 1) {
			return 3;
		}
		
		int xWins = 0;
		int oWins = 0;
		
		if(a[0][0]==a[0][1] && a[0][1]==a[0][2]) {
			if(a[0][0]=='X') {
				xWins++;
			}
			if(a[0][0]=='O') {
				oWins++;			
			}
		}
		
		if(a[1][0]==a[1][1] && a[1][1]==a[1][2]) {
			if(a[1][0]=='X') {
				xWins++;
			}
			if(a[1][0]=='O') {
				oWins++;			
			}
			
		}
		
		if(a[2][0]==a[2][1] && a[2][1]==a[2][2]) {
			if(a[2][0]=='X') {
				xWins++;
			}
			if(a[2][0]=='O') {
				oWins++;			
			}
			
		}
		
		if(a[0][0]==a[1][0] && a[1][0]==a[2][0]) {
			if(a[0][0]=='X') {
				xWins++;
			}
			if(a[0][0]=='0') {
				oWins++;
			}
			
		}
		
		if(a[0][1]==a[1][1] && a[1][1]==a[2][1]) {
			
			if(a[0][1]=='X') {
				xWins++;
			}
			if(a[0][1]=='0') {
				oWins++;
			}
			
		}
		
		if(a[0][2]==a[1][2] && a[1][2]==a[2][2]) {
			
			if(a[0][2]=='X') {
				xWins++;
			}
			if(a[0][2]=='0') {
				oWins++;
			}
			
		}
		
		if(a[0][0]==a[1][1] && a[1][1]==a[2][2]) {
			if(a[0][0]=='X') {
				xWins++;
			}
			if(a[0][0]=='O') {
				oWins++;
			}
		}
		
		if(a[0][2]==a[1][1] && a[1][1]==a[2][0]) {
			if(a[0][2]=='X') {
				xWins++;
			}
			if(a[0][2]=='O') {
				oWins++;
			}
		}
		
		
		if(xWins>0 || oWins>0) {
			if(xWins>=1 && oWins>=1) {
				return 3;
			}else {
				if(xWins>=1 && xCount>oCount) {
					return 1;
				}else if(oWins>=1 && oCount==xCount) {
					return 1;
				}else {
					return 3;
				}
			}
		}
		
		if(_Count==0 && xCount==oCount) {
			return 1;
		}
		
		return 2;
	}
	

}
