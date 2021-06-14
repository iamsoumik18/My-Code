package practice;

import java.io.*;
import java.util.*;

public class RemoveDuplicateLettersSmallestLexicographicalOrder {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s = br.readLine();
				String ans = solution(s);
				bw.write(ans+"\n");
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}
	
	static String solution(String s) {
		int[] res = new int[26]; 
	    boolean[] visited = new boolean[26];
	    
	    for(int i=0; i<s.length();i++)
	        res[s.charAt(i)-'a']++;
	    
	    Deque<Character> st = new ArrayDeque<>();
	    for(int i=0; i<s.length(); i++){
	    	
	        res[s.charAt(i)-'a']--;
	        
	        if(visited[s.charAt(i)-'a'])
	            continue;
	        
	        while(!st.isEmpty() && s.charAt(i)<st.peek() && res[st.peek()-'a']!=0) 
	            visited[st.pop()-'a']=false;
	        
	        st.push(s.charAt(i));
	        visited[s.charAt(i)-'a']=true;
	        
	    }

	    StringBuilder sb = new StringBuilder();
	    while(!st.isEmpty()){
	        sb.append(st.pop());
	    }
	    return sb.reverse().toString();
		
	}

}
