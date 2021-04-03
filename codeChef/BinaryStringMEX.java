package codeChef;

import java.io.*;
import java.util.*;

public class BinaryStringMEX {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s = br.readLine();
				boolean flag = false;
				for(int i=0; i<s.length(); i++) {
					if(s.charAt(i)=='0')
						flag = true;
				}
				if(!flag) {
					bw.write("0\n");
					bw.flush();
				}else {
					bw.write(sol(s)+"\n");
					bw.flush();
				}
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static String sol(String s) {
		
		Deque<String> q = new LinkedList<String>();
		
        q.add("1");
 
        while (true) {
            String s1 = q.peek();
            q.poll();
            
            if(!isSubSequence(s1,s))
            	return s1;
 
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
       
	}
	
	static boolean isSubSequence(String str1, String str2){
		
		int j = 0;

		for (int i = 0; i < str2.length() && j < str1.length(); i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == str1.length());
	}

}
