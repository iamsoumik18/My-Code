package practice;

import java.util.*;;

public class PowerSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(powSum(x,n,1));
	}
		
	static int powSum(int x, int n, int num) {
		if((int)Math.pow((double)num,(double)n)==x) {
			return 1;
		}
		if((int)Math.pow((double)num,(double)n)<x) {
			return powSum(x,n,num+1)+powSum(x-(int)Math.pow((double)num,(double)n),n,num+1);
		}
		return 0;
	}

}

