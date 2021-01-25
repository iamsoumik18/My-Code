package practice;
import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		
		MyMergeSort ob = new MyMergeSort();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter array size: ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		System.out.print("\nEnter array elements: ");
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		ob.sort(a, 0, n-1);
		
		System.out.print("\nArray after sorting:");
		printArray(a);
		

	}
	
	static void printArray(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}

class MyMergeSort{
	void merge(int a[], int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i=0; i<n1; i++) {
			L[i] = a[l + i];
		}
		
		for(int i=0; i<n2; i++) {
			R[i] = a[m+1+i];
		}
		
		int i=0, j=0;
		int k=l;
		
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				a[k++] = L[i++];
			}else {
				a[k++] = R[j++];
			}
		}
		
		while(i<n1) {
			a[k++] = L[i++];
		}
		
		while(j<n2) {
			a[k++] = R[j++];
		}
		
	}
	
	void sort(int a[], int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(a, l, m);
			sort(a, m+1, r);
			
			merge(a, l, m, r);
		}
	}
}
