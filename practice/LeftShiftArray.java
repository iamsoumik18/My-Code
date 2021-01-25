package practice;
import java.util.*;

public class LeftShiftArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		    int d = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n; i++){
		        a[i] = sc.nextInt();
		    }
		    rotate(a, n, d);
		    printArray(a, n);
		    System.out.println();
		
	}
	
	static int gcd(int a, int b){
	    if(b==0)
	        return a;
	    else
	        return gcd(b, a%b);
	}
	
	static void rotate(int a[], int n, int d){
	    d=d%n;
	    int i,j,k,temp;
	    int g = gcd(n,d);
	    for(i=0; i<g; i++){
	        temp=a[i];
	        j=i;
	        while(true){
	            k=j+d;
	            if(k>=n)
	                k=k-n;
	            if(k==i)
	                break;
	            a[j]=a[k];
	            j=k;
	        }
	        a[j]=temp;
	    }
	}
	
	static void printArray(int a[], int n){
	    for(int i=0; i<n; i++)
	        System.out.print(a[i]+" ");
	}

}
	
