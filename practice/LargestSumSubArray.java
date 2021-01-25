package practice;
import java.util.*;

public class LargestSumSubArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("\nEnter array elements: ");
		for(int i=0; i<n; i++) {
			a[i]= sc.nextInt();
		}
		
//		int lowIndex = 0;
//		int highIndex = 0;
//		int max = Integer.MIN_VALUE;
//		for(int i=0; i<n; i++) {
//			for(int j = i; j<n; j++) {
//				int sum = 0;
//				for(int k = i; k<=j; k++) {
//					sum = sum + a[k];
//				}
//				if( sum > max ) {
//					max = sum;
//					lowIndex = i;
//					highIndex = j;
//				}
//			}
//		}
//		
//		System.out.print("\nLargest sum of subarray {");
//		for(int i = lowIndex; i<highIndex; i++) {
//			System.out.print(a[i]+", ");
//		}
//		System.out.print(a[highIndex]+"} is "+max);
		
		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			curSum = curSum + a[i];
			maxSum = Math.max(curSum, maxSum);
			curSum = curSum<0?0:curSum;
		}
		System.out.println("\nThe maximum sum in the subarray is "+maxSum);

	}

}
