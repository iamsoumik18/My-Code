package codeChef;

import java.io.*;

public class AnInterestingSequence {
	
	static int arraySize = 4000002;
	
	static int c[] = new int[arraySize];
	static int ans[] = new int[arraySize];
	
	static void preProcess() {	
		for(int i=0; i<arraySize; i++) {
			c[i] = i;
			ans[i] = 0;
		}
		for(int j=2;j<arraySize;j++) {
			if(c[j]==j) {
				c[j]=j-1;
				for(int i=2*j;i<arraySize;i+=j)
					c[i]=(c[i]/j)*(j-1);
			}
		}
		for(int i=1; i<arraySize; i++) {
			ans[i]+=i-1;
			for(int j=2*i;j<arraySize;j+=i) 
				ans[j]+=i*((1+c[j/i])/2);
		}
		
	}
	
	static long gcd(long a, long b){
	      if (b == 0)
	        return a;
	      return gcd(b, a % b);
	    }

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		preProcess();
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int k = Integer.parseInt(br.readLine());
				bw.write(ans[4*k+1]+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}
