package practice;
import java.util.Scanner;

public class MaxString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test>0){
		    int n = sc.nextInt();
		    sc.nextLine();
		    String a[] = new String[n];
		    for(int i=0; i<n; i++){
		        a[i] = sc.nextLine();
		    }
		    int size[] = new int[n];
		    for(int i=0; i<n; i++){
		        size[i]=a[i].length();
		    }
		    int index = 0;
		    int max = size[0];
		    for(int i=1; i<n; i++){
		        if(size[i] > max){
		            max = size[i];
		            index = i;
		        }
		    }
		    System.out.println(a[index]);
		    test--;
		}

	}

}
