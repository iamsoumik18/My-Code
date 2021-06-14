package practice;
import java.util.Scanner;

public class BarfiPattern{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size: ");
		int n = sc.nextInt();
		System.out.println();
		
		
		for(int i=1;i<=n;i++) {
			if(i<=n/2) {
				for(int j=i; j<n/2; j++) {
					System.out.print("  ");
				}
				for(int j=1; j<=i; j++) {
					System.out.print("*   ");
				}
			}
			else {
				for(int j=n/2; j<i; j++) {
					System.out.print("  ");
				}
				for(int j=i; j<n-1; j++) {
					System.out.print("*   ");
				}
			}
			System.out.println();
		}
	}
	
}

