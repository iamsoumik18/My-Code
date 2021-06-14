package practice;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println();
		System.out.print("Enter array elements: ");
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		insertionSort(a, n);
		System.out.println();
		System.out.print("Array after sorting: ");
		for(int c: a)
			System.out.print(c+" ");
	}
	
	static void insertionSort(int a[], int n) {
		int i,j,key;
		for(i=1; i<n; i++) {
			key = a[i];
			j = (i-1);
			while( j>=0 && a[j]>key ) {
				a[j+1] = a[j];
				j = j-1;
			}
			a[j + 1] = key;
		}
	}

}
