package placePractice1;

import java.io.*;

public class Power {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				double x = Double.parseDouble(s1[0]);
				int n = Integer.parseInt(s1[1]);
				double ans = pow(x,n);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}
	}
	
	static double pow(double x, int n) {
		double ans = 1.0;
		long N = n;
		if(N<0)
			N = -1 * N;
		while(N>0) {
			if(N%2==1) {
				ans = ans * x;
				N = N - 1;
			}else {
				x = x * x;
				N = N / 2;
			}
		}
		if(n<0)
			ans = (double)(1)/(double)(ans);
		return ans;
	}

}
