package practice;

import java.util.*;

public class Subset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		subSet(a);
		

	}
	
	static void subSet(int a[]) {
		int sub[] = new int[a.length];
		helper(a,sub,0);
	}
	
	static void helper(int a[], int sub[], int i) {
		if(i==a.length) {
			printArray(sub);
		}else {
			sub[i] = 0;
			helper(a,sub,i+1);
			sub[i] = a[i];
			helper(a,sub,i+1);
		}
	}
	
	static void printArray(int sub[]) {
		System.out.print("{");
		for(int i=0; i<sub.length; i++) {
			if(sub[i]!=0) {
				System.out.print(sub[i]+" ");
				
			}
		}
		System.out.println("}");
	}

}
