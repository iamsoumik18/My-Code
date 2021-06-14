package practice;
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Principal amount: ");
		int principal = sc.nextInt();
		System.out.print("Enter the rate: ");
		float rate = sc.nextFloat();
		System.out.print("Enter the time in months: ");
		int time = sc.nextInt();
		
		float simpleInterest = (principal * rate * time) / 100;
		
		System.out.println("The Simple Interest is : " + simpleInterest);
		
	}

}



