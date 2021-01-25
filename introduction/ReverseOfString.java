package introduction;
import java.util.*;

public class ReverseOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String st = sc.nextLine();
		
		System.out.println("Reverse of the string is: "+ revString(st));
		
	}
	
	static String revString(String s) {
		String ans = "";
		int i = s.length()-1;
		while(i>=0) {
			while( i >= 0 && s.charAt(i) == ' ')
				i--;
			int j = i;
			
			if(i<0)
				break;
			
			while(i>=0 && s.charAt(i)!=' ')
				i--;
			
			if(ans.isEmpty()) {
				ans = ans.concat(s.substring(i+1, j+1));
			}
			else {
				ans = ans.concat(" "+s.substring(i+1,j+1));
			}
			
		}
		return ans;
	}

}
