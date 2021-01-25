package introduction;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n = sc.nextInt();
		System.out.println();
		int a[]= new int[n];
		System.out.print("Enter array elements: ");
		for(int i=0; i<n; i++) {
			a[i]= sc.nextInt();
		}
		System.out.println();
		for(int i=0; i<n-1; i++) {
			int index=i;
			for(int j=i+1; j<n; j++) {
				if(a[j]<a[index]) {
					index=j;
				}
			}
			int temp= a[i];
			a[i]=a[index];
			a[index]=temp;
		}
		System.out.print("Array after sorting: ");
		for(int i=0; i<n; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
