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
				
				for(int i=0; i<3; i++) {
					String s= br.readLine();
					a[i][0] = s.charAt(0);
					a[i][1] = s.charAt(1);
					a[i][2] = s.charAt(2);
				}
				
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(a[i][j]=='X') {
							xCount++;
						}else if(a[i][j]=='O') {
							oCount++;
						}else {
							_Count++;
						}
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
		
		if(xCount > (1+oCount)) {
			return 3;
		}
		
		boolean xWins = check(a,'X');
		boolean oWins = check(a,'O');
		
		
		if(xWins && oWins) {
			return 3;
		}
		if(xWins && xCount==oCount) {
			return 3;
		}
		if(oWins && xCount>oCount) {
			return 3;
		}
		if(xWins || oWins) {
			return 1;
		}
		if(_Count==0) {
			return 1;
		}
		
		return 2;
	}
	
	static boolean check(char a[][], char ch) {
		for (int i=0; i<3; i++) {
			if (a[i][0]==ch && a[i][0]==a[i][1] && a[i][1]==a[i][2])
				return true;
			if (a[0][i]==ch && a[0][i]==a[1][i] && a[1][i]==a[2][i])
				return true;
		}
		if (a[0][0]==ch && a[0][0]==a[1][1] && a[1][1]==a[2][2])
			return true;
		if (a[0][2]==ch && a[0][2]==a[1][1] && a[1][1]==a[2][0])
			return true;
		
		return false;
	}
	

}