package practice;

import java.util.*;

public class DutchNFAlgo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			func(a);
			
			for(int i=0; i<n; i++) {
				System.out.print(a[i]+" ");
			}
			
			System.out.println();
		}

	}
	
	static void func(int a[]) {
		int low = 0;
		int mid = 0;
		int high = a.length -1;
		
		while(mid<=high) {
			switch(a[mid]){
				case 0:{
					int temp = a[mid];
					a[mid] = a[low];
					a[low] = temp;
					low++;
					mid++;
					break;
				}
				case 1:{
					mid++;
					break;
				}
				case 2:{
					int temp = a[mid];
					a[mid] = a[high];
					a[high] = temp;
					high--;
				}
			}
		}
	}

}
