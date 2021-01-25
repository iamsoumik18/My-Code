package codeChef;

import java.io.*;
import java.util.*;

public class StringOperations {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int test = Integer.parseInt(br.readLine());
			String temp;
			while(test-->0) {
				String s = br.readLine();
				bw.write(solution(s)+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int solution(String s) {
		
		int n = s.length();
		
		Map<Integer,ArrayList<String>> mp = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				String st = s.substring(i, j+1);
				if(mp.get(st.length())==null)
					mp.put(st.length(), new ArrayList<>());
				mp.get(st.length()).add(st);
			}
		}
		
		
		int ans=0;
		
		for(int q=1; q<=n; q++) {
			
			ArrayList<String> ll = mp.get(q);
			boolean vis[] = new boolean[ll.size()];
			Arrays.fill(vis, false);
			
			for(int i=0; i<ll.size(); i++) {
				int cnt=0;
			
				for(int j=0; j<ll.size() ; j++) {			
					if(j==i)
						continue;
	
					if(!vis[j]) {
						if(check2(ll.get(i),0,ll.get(i).length()-1) && check2(ll.get(j),0,ll.get(j).length()-1) && reverseString(ll.get(i), 0, ll.get(i).length()-1).equals(ll.get(j))) {
							vis[j]=true;
						}else if( check(ll.get(i),ll.get(j), 0, ll.get(i).length()-1) ) {
							vis[j]=true;
						}else if( ll.get(i).equals(ll.get(j))){
							vis[j]=true;
						}
					}
				}
				
				if(!vis[i])
					cnt++;		
				
				ans += cnt;
			}
			
		}
		
		return ans;
		
	}
	
	static boolean check(String s1, String s2, int i, int j) {
		if(s1.equals(s2))
			return true;
		
		boolean flag = false;
		for(int k=i; k<j; k++) {
			String str1 = s1;
			String str2 = s2;
			if(check2(str1,i,k))
				str1 = reverseString(str1, i, k);
			if(check2(str2,k+1,j))
				str2 = reverseString(str2, k+1, j);
			flag = ( check(str1, s2, i, k) || check(str2, s2, k+1, j ) || check(s1, s2, i+1, j) || check(s1, s2, i, j-1) );
			if(flag)
				break;
		}
		return flag;
	}
	
	static boolean check2(String s, int i, int j) {
		int cnt=0;
		for(int k=i; k<=j; k++) {
			if(s.charAt(k)=='1')
				cnt++;
		}
		return (cnt%2==0);
	}
	
	static String reverseString(String s, int i, int j) {
		char str[] = s.toCharArray();
		while (i < j) 
        {
            char c = str[i]; 
            str[i] = str[j]; 
            str[j] = c; 
  
            i++; 
            j--; 
        } 
        String string = new String(str); 
        return string;
	}
}
