package introduction;

import java.io.*;

public class CarFueling {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int d = Integer.parseInt(br.readLine());
		
		int l = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		int a[] = new int[n+2];
		
		a[0] = 0;
		a[n+1] = d;
		
		String s[] = br.readLine().split(" ");
		
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(s[i-1]);
		}
		
		int ans = solution(d, l, n, a);
		
		System.out.println(ans);

	}
	
	static int solution(int d, int l, int n, int a[]) {
		int lastFill = 0;
		int curFill = 0;
		int fill = 0;
		while(curFill<=n) {
			lastFill = curFill;
			while(curFill<=n && a[curFill+1]-a[lastFill]<=l) {
				curFill++;
			}
			if (curFill==lastFill) {
				return -1;
			}
			if(curFill<=n) {
				fill +=1;
			}
		}
		return fill;
	}

}
