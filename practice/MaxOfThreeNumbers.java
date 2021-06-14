package practice;
import java.util.Scanner;

public class MaxOfThreeNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Enter the values----");
		System.out.print("a: ");
		int a = sc.nextInt();
		System.out.print("b: ");
		int b = sc.nextInt();
		System.out.print("c: ");
		int c = sc.nextInt();
		
		if(a>b) {
			if(a>c) {
				System.out.println("The maximum number is: "+ a);
			}
			else {
				System.out.println("The maximum number is: "+ c);
			}
		}
		else if(b>c) {
			System.out.println("The maximum number is: "+ b);
		}
		else {
			System.out.println("The maximum number is: "+ c);
		}

	}

}
