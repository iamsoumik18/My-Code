package practice;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("\nEnter array elements in ascending order: ");
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print("\nEnter the element to search: ");
		int item = sc.nextInt();
		
		if(binarySearch(a,0,(n-1),item)) {
			System.out.println("\nElement found!");
		}
		else {
			System.out.println("\nElement not found!");
		}
		

	}
	
	static boolean binarySearch(int a[], int beg, int end, int item) {
		boolean result = false;
		while(beg<=end) {
			int mid = (beg + end) / 2;
			if(item == a[mid]) {
				return result = true;
			}
			else if(item > a[mid]) {
				return binarySearch(a,(mid+1),end,item);
			}
			else if(item < a[mid]) {
				return binarySearch(a,beg,(mid-1),item);
			}
		}
		return result;
	}

}
