package codeChef;

import java.util.*;
import java.io.*;

public class TeamName {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s[] = br.readLine().split(" ");
				Map<String, ArrayList<Character>> m = new HashMap<>();
				
				for(String st: s) {
					String b = st.substring(1);
					if(!m.containsKey(b)) {
						m.put(b, new ArrayList<>());
						m.get(b).add(st.charAt(0));
					}else {
						m.get(b).add(st.charAt(0));
					}
				}
				
				List<String> m1 = new ArrayList<>(m.keySet());
				
				int ans = 0;
				
				for(int i=0; i<m.size(); i++) {
					for(int j=i; j<m.size(); j++) {
						int c = unique(m.get(m1.get(i)),m.get(m1.get(j)));
						ans += ((m.get(m1.get(i)).size() - c)*(m.get(m1.get(j)).size() - c));
					}
				}
				
				ans = 2*ans;
				bw.write(ans+"\n");
				bw.flush();
				
			}
		}catch(Exception e) {
			return;
		}
	}
	
	static int unique(List<Character> l1, List<Character> l2) {
		Set<Character> s1 = new HashSet<>(l1);
		Set<Character> s2 = new HashSet<>(l2);
		s1.retainAll(s2);
		return s1.size();
	}

}
