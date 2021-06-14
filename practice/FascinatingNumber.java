package practice;
import java.util.Scanner;

public class FascinatingNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		
		int flag =fascinatingNumber(num);
		
		if( flag == 1 ) {
			System.out.println("It is a Fascinating Number");
		}
		else {
			System.out.println("It is not a fascinating number.");
		}

	}
	
	static int fascinatingNumber(int num) {
		int digit = count(num);
		int flag = 1;
		if(digit>=3) {
			int first = num*2;
			int second = num*3;
			String a = Integer.toString(num) + Integer.toString(first) + Integer.toString(second);
			int s[] = new int[256];
			for(int i=0; i<a.length(); i++) {
				char c = a.charAt(i);
				int ascii = (int)c;
				s[ascii]++;
			}
			
			for(int i=0; i<256; i++) {
				if(s[i]>1) {
					flag = 0;
					break;
				}
			}
			
		}
		else {
			flag = 0;
		}
		return flag;
	}
	
	static int count(int num) {
		int c=0;
		while(num>0) {
			num=num/10;
			c++;
		}
		return c;
	}

}
