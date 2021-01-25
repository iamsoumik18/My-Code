package practice;
import java.util.*;

public class Encryption {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		encryption(s);
	}
	
	static void encryption(String st) {
		String s = removeSpace(st);
		int l = s.length();	
		int row = (int)Math.sqrt((double)l);
		int col = (int)Math.ceil(Math.sqrt((double)l));
		
		if(row*col < l) {
			int max = Math.max(row, col);
			row = max;
			col = max;
		}
		
		char a[][] = new char[row][col];
		int k = 0;
		for(int i=0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				a[i][j] = s.charAt(k);
				k++;
				if(k==l) {
					break;
				}
			}
		}
		
		String ans = "";
		for(int i = 0; i<col; i++) {
			for(int j = 0; j<row; j++) {
				if(a[j][i] != '\u0000') {
					ans = ans + a[j][i];
				}
			}
			ans = ans + ' ';
		}
		
		ans.trim();		
		System.out.println(ans);
		
	
	}
	
	
	static String removeSpace(String st) {
		
		st.trim();		
		String ans = st.replaceAll("\\s+", "");
		return ans;
	}

}
