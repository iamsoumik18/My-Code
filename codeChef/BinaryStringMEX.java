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
				bw.write(sol2(s)+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static long count(String s1, char ch) {
		int cnt = 0;
		for(int i=0; i<s1.length(); i++)
			if(s1.charAt(i)==ch)
				cnt++;
		return cnt;
	}
	
	static String sol2(String s) {
		
		if(count(s,'0') == 0){ 
            return "0";
        }
		
        if(count(s,'1') == 0){ 
            return "1";
        }

        int n = s.length(), c = 0;
        char bs[][]  = new char[n+1][2];
        bs[n][0] = '0';
        bs[n][1] = '0';

        for(int i = n-1; i >= 0; i--){
            bs[i][0] = bs[i+1][0];
            bs[i][1] = bs[i+1][1];
            if(s.charAt(i) == '0'){
                bs[i][1] = '1';
            }
            else{
                bs[i][0] = '1';
            }
            if(bs[i][0] == '1' && bs[i][1] == '1') {
                c++; 
                bs[i][0] = '0';
                bs[i][1] = '0';
            }
        }
        StringBuffer sb = new StringBuffer("");
        boolean flag = true;
        int cur = 0;
        if(bs[0][1] == '0' && bs[0][0] == '1'){
            sb.append("1");
            flag = false;
        }
        c++;

        while(c-->0){
            if(flag){
                if(bs[0][0] == '0'){
                    sb.append("1");
                    while(cur < n && s.charAt(cur) != '1')
                        cur++;
                    cur++;
                }
                flag = false;
            }
            else{
            	int temp[] = {1,0};
                for(int i : temp){
                    if(bs[cur][i] == '0'){
                        char ch = (char)('0' + 1 - i);
                        sb.append(ch);
                        while(cur < n && s.charAt(cur) != ch)
                            cur++;
                        cur++;
                        break;
                    }
                }
            }
        }
        return sb.toString();
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
