package practice;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int n=sc.nextInt();
		int rev=0;
		int temp=n;
		int lastDigit=0;
		while(temp>0) {
			lastDigit=temp%10;
			rev=rev*10 + lastDigit;
			temp/=10;
		}
		if(rev==n) {
			System.out.println(n+" is a PALINDROME number.");
		}
		else {
			System.out.println(n+" is not a PALINDROME number.");
		}

	}

}
