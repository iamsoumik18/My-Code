package introduction;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		System.out.println();
		int a[] = new int[n];
		System.out.print("Enter array elements: ");
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		System.out.println();
		for(int i=0; i<n-1; i++) {
			boolean sorted=true;
			for(int j=0; j<n-1-i; j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
					sorted=false;
				}
			}
			if(sorted)
				break;
		}
		System.out.print("Array after sorting: ");
		for(int item : a) {                  
			System.out.print(item+" ");
		}

	}

}
