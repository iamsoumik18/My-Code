package practice;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the nth term of Fibonacci series: ");
		int n = sc.nextInt();
		int a=0 , b=1,c=0;
		System.out.print(a+" "+b+" ");
		for(int i=2;i<n;i++) {
			c=a+b;
			System.out.print(c+" ");
			a=b;
			b=c;
		}

	}

}
