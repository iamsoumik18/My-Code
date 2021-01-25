package codeChef;

import java.io.*;

public class MagicalCandyStore {
	
	static int mod = 1000000007;
	
	static boolean isEven(long n) {
		return (n & 1) == 0;
	}
	
	static boolean isOdd(long n) {
		return (n & 1) == 1;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				
		        long a[] = new long[n];
		        
		        String s1[] = br.readLine().split(" ");
		        
		        int flag = 0;
		        int p = -1;
		        
		        for(int i=0; i<n; i++){
		            a[i] = Long.parseLong(s1[i]);
		            if(a[i]==1 && i==0){
		                    flag = 1;
		            }else if(a[i]==1 && i!=n-1){
		                    flag = 2;
		                    p = i;
		            }
		        }
		        
		        if(flag==1){
		        	
		            int q = Integer.parseInt(br.readLine());
		            
		            while(q-->0){
		                int r = Integer.parseInt(br.readLine());
		                
		                long ans = 0;
		                
		                if(r%n==0) ans = (r/n) % mod;
		                else if(r%n==1 && r>n) ans = (r/n) % mod;
		                else ans = (r/n+1) % mod;
		             
		                System.out.println(ans);
		            }
		        }else if(flag==2){
		            long sum = 0; 
		            long arr[] = new long[100000];
		            
		            for(int i=0; i<n-1; i++){
		                if(i==p-1){
		                    if((a[i]&1)==0){
		                        sum += a[i] - 1;
		                        arr[i] = sum;
		                    }else{
		                        sum += a[i];
		                        arr[i] = sum; 
		                    }
		                }else{
		                    if((a[i]&1)==0){
		                        sum += a[i];
		                        arr[i] = sum;
		                    }
		                    else{
		                        sum += a[i] - 1;
		                        arr[i] = sum;
		                    }
		                }
		            }
		            
		            if((a[n-1]&1)==0) sum += a[n-1] - 1;
		            else sum += a[n-1];
		            
		            int q = Integer.parseInt(br.readLine());
		            
		            while(q-->0){
		                int r = Integer.parseInt(br.readLine());
		                
		                if(r%n==0){
		                    if((a[n-1]&1)==0) System.out.println(((r/n)*sum+1) % mod);
		                    else System.out.println(((r/n)*sum) % mod);
		            	}else{
		                	if(p==r%n-1){
		                    	if((a[p-1]&1)==0) System.out.println(((r/n)*sum+2+arr[r%n-1]) % mod);
		                    	else System.out.println(((r/n)*sum+arr[r%n-1]) % mod);
		                	}else if(p-1==r%n-1){
		                    	if((a[p-1]&1)==0) System.out.println(((r/n)*sum+arr[r%n-1]+1) % mod);
		                    	else System.out.println(((r/n)*sum+arr[r%n-1]) % mod);
		                    	
		                	}else{
		                    	if((a[r%n-1]&1)==1) System.out.println(((r/n)*sum+arr[r%n-1]+1) % mod);
		                    	else System.out.println(((r/n)*sum+arr[r%n-1]) % mod);
		                	}
		            	}
		        	}
		    	}else{
		        	long sum=0;
		        	long arr[] = new long[100000];
		        	
		            for(int i=0;i<n-1;i++){
		            	
		                if((a[i]&1)==0){
		                	sum += a[i];
		                	arr[i] = sum;
		                }else{
		                   	sum += a[i]-1;
		                   	arr[i] = sum;
		               	}
		           	}
		            
		            if((a[n-1]&1)==0) sum += a[n-1]-1;
		           	else sum += a[n-1];
		            
		           	int q = Integer.parseInt(br.readLine());
		           	
		           	while(q-->0){
		               	int r = Integer.parseInt(br.readLine());
		               	
						if(r%n==0){
		                   	if((a[n-1]&1)==0) System.out.println(((r/n)*sum+1) % mod);
		                   	else System.out.println(((r/n)*sum) % mod);
		               	}else{
		                   	if((a[r%n-1]&1)==1) System.out.println(((r/n)*sum+arr[r%n-1]+1) % mod);
		                   	else System.out.println((((r/n)*sum+arr[r%n-1]) % mod));
		               	}      	
					}
		    	}
			}
		}catch(Exception e) {
			return;
		}
	}
}
