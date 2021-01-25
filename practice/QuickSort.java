package practice;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MyQuickSort qs = new MyQuickSort();
		
		System.out.print("Enter array size: ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		System.out.print("\nEnter array elements: ");
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		qs.sort(a, 0, n-1);
		
		System.out.print("\nArray after sorting: ");
		for(int num: a) {
			System.out.print(num+" ");
		}
		

	}

}
class MyQuickSort{
	int partition(int a[],int start,int end) {
		int pivot = a[end];
		int pIndex = start;
		for(int i=start; i<end; i++) {
			if(a[i]<=pivot) {
				int temp = a[pIndex];
				a[pIndex] = a[i];
				a[i] = temp;
				pIndex++;
			}
		}
		int temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
		
	}
	public void sort(int a[], int start, int end) {
		if(start<end) {
			int pIndex = partition(a, start, end);
			
			sort(a, start, pIndex-1);
			sort(a, pIndex+1, end);
		}
	}
}
