package practice;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of lines: ");
		int line = sc.nextInt();
		System.out.println();
		
		pascalTriangle(line);

	}
	
	static void pascalTriangle(int line) {
		for(int row=0; row<line; row++) {
			int n=1;
			for(int space = 0; space<(line - row - 1); space++) {
				System.out.print(" ");
			}
			for(int col=0; col<=row; col++) {
				System.out.print(n+" ");
				n = n * ( row - col ) / ( col + 1 );
			}
			System.out.println();
		}
	}

}
