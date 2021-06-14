package codeChef;

import java.io.*;

public class SummerHeat {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int x = Integer.parseInt(s1[0]);
				int y = Integer.parseInt(s1[1]);
				int X = Integer.parseInt(s1[2]);
				int Y = Integer.parseInt(s1[3]);
				int ans = (int)Math.ceil(X/x) + (int)Math.ceil(Y/y);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}

}