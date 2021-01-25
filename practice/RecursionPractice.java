package practice;

import java.math.*;

public class RecursionPractice {
	
	public static void main(String[] args) {
		
		System.out.println(pow(new BigInteger("2"),40));
		
		
	}
	
	
	
	
	static BigInteger pow(BigInteger a, int b) {
		if(b==0) {
			return new BigInteger("1");
		}else if(b%2==0) {
			return pow( a.multiply(a),b/2);
		}else {
			return   a.multiply(pow(a,b-1));
		}
	}

}
