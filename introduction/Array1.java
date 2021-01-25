package introduction;
import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter strength of the class: ");
		int n = sc.nextInt();
		int total=0;
		int[] marks;
		marks = new int[n];
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print("Enter marks of student "+ (i+1) +": ");
			marks[i] = sc.nextInt();
			total+=marks[i];
		}
		System.out.println();
		int average;
		average=total/n;
		System.out.println("Average marks of the class is "+ average);
	}

}
