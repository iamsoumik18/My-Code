package practice;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int n = sc.nextInt();
		boolean isPrime= true;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				isPrime=false;
				break;
			}
		}
		if(n<2) {
			isPrime=false;
		}	
		
		if(isPrime) {
			System.out.println(n+" is a PRIME number.");
		}
		else {
			System.out.println(n+" is not a PRIME number.");
		}

	}

}
