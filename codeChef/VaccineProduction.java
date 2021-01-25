package codeChef;

import java.io.*;

public class VaccineProduction {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s1[] = br.readLine().split(" ");
			int d1 = Integer.parseInt(s1[0]);
			int v1 = Integer.parseInt(s1[1]);
			int d2 = Integer.parseInt(s1[2]);
			int v2 = Integer.parseInt(s1[3]);
			int p = Integer.parseInt(s1[4]);
			int count = 0;
			int day=1;
			while(count<p) {
				if(day>=d1)
					count += v1;
				if(day>=d2)
					count += v2;
				day++;
			}
			System.out.println(day-1);
		}catch(Exception e) {
			return;
		}
	}

}
