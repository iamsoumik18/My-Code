package practice;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Practice1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger b1 = new BigInteger("0");
		
		String a[] = {"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
		Set<BigInteger> al = new TreeSet<BigInteger>();
		for(int i=0; i<a.length; i++) {
			al.add(new BigInteger(a[i]));
		}
		
		Iterator<BigInteger> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());
		  }
		  
		  String s1 = "12345";
		  String s2 = "20";
		  BigInteger b = new BigInteger(s1);
		  System.out.println(b.add(new BigInteger(s2)));
		  System.out.println(b.multiply(new BigInteger(s2)));
	}
}
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		
//	
//	  	StringBuilder sbf = new StringBuilder();
//	  	sbf.append(br.readLine());
//	  	System.out.println(sbf);
//	  	sbf.append(br.readLine());
//	  	System.out.println(sbf);
		
		
	  	
	  	
	  	
	
	
		
		
//		String s = sc.nextLine();
//		int x = 0;
//		int y = 0;
//		for(int i=0; i<s.length(); i++) {
//			if(s.charAt(i) == 'L') {
//				x--;
//			}
//			else if(s.charAt(i) == 'R' ) {
//				x++;
//			}
//			else if(s.charAt(i) == 'U') {
//				y++;
//			}
//			else if(s.charAt(i) == 'D') {
//				y--;
//			}
//		
//		}
//		System.out.println(x+" "+y);
//		
//		int max=Integer.MIN_VALUE;
//		int min= Integer.MAX_VALUE;
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("The program ended now!!!!!");
		
		//generateSquare(3);
//	}
//	
//	public static String f(String str) {
//		String r = "";
//		
//		int h1 = (int)str.charAt(1) - '0'; 
//	    int h2 = (int)str.charAt(0) - '0'; 
//	    int hh = (h2 * 10 + h1 % 10);
//	    
//	    if (str.charAt(8) == 'A') {
//	    	if (hh == 12) {
//	    		r = "0" + "0";
//	    		for(int i = 2; i<=7; i++)
//	    			r = r + str.charAt(i);
//	    	}
//	    	else {
//	    		for(int i=0; i<=7; i++)
//	    			r = r + str.charAt(i);
//	    	}
//	    	
//	    }
//	    else {
//	    	if( hh == 12 ) {
//	    		for(int i=0; i<=7; i++)
//	    			r = r + str.charAt(i);
//	    	}
//	    	else {
//	    		hh = hh +12;
//	    		r = Integer.toString(hh);
//	    		for(int i=2; i<=7; i++)
//	    			r = r + str.charAt(i);
//	    	}
//	    }		
//	    return r;
//	}
//	public static void generateSquare(int n) 
//    { 
//        int[][] magicSquare = new int[n][n]; 
//        int i = n/2; 
//        int j = n-1; 
//    
//        for (int num=1; num <= n*n; ) 
//        { 
//            if (i==-1 && j==n) 
//            { 
//                j = n-2; 
//                i = 0; 
//            } 
//            else
//            { 
//                if (j == n) 
//                    j = 0; 
//                       
//                if (i < 0) 
//                    i=n-1; 
//            } 
//              
//            if (magicSquare[i][j] != 0)  
//            { 
//                j -= 2; 
//                i++; 
//                continue; 
//            } 
//            else 
//                magicSquare[i][j] = num++;  
//                  
//            j++;  
//            i--;  
//        }
//        
//        for(i=0; i<n; i++) 
//        { 
//            for(j=0; j<n; j++) 
//                System.out.print(magicSquare[i][j]+" "); 
//            System.out.println(); 
//        } 
//    } 
   


