package practice;

import java.util.*;
import java.io.*;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int [n][n];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(""+s.charAt(j));
			}
		}
		
		cavityMap(a);
			
    }
	static void cavityMap(int a[][]) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				if(i==0 || i==a.length-1 || j==0 || j==a.length-1) {
					System.out.print(a[i][j]);
				}else if(a[i][j]>a[i][j-1] && a[i][j]>a[i][j+1] && a[i][j]>a[i-1][j] && a[i][j]>a[i+1][j]){
					System.out.print("X");	
				}else {
					System.out.print(a[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	static int toys(int[] w) {
		int c = 1;
		Arrays.sort(w);
		int low = w[0];
		int up = low+4;
		for(int i=0; i<w.length; i++) {
			if(w[i]>=low && w[i]<=up) {
				continue;
			}else {
				c++;
				low = w[i];
				up = low+4;
			}
			
		}
		return c;


    }
	
	static String pangrams(String s) {
		s = s.toLowerCase();
		int as[] = new int[26];
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!=' ') {
				as[(int)s.charAt(i) - 97]++;
			}
		}
		boolean flag = true;
		for(int i=0; i<26; i++) {
			if(as[i]==0) {
				flag = false;
				break;
			}
		}
		String ans = "";
		if(flag==true) {
			ans = "pangram";
		}else {
			ans = "not pangram";
		}
		return ans;
		


    }
	
	static int gemstones(String[] arr) {
		Set<Character> main = new TreeSet<>();
		for(int i=0; i<arr[0].length(); i++) {
			main.add(arr[0].charAt(i));
		}
		for(int i=1; i<arr.length; i++) {
			Set<Character> temp = new TreeSet<>();
			for(int j=0; j<arr[i].length(); j++) {
				temp.add(arr[i].charAt(j));
			}
			main.retainAll(temp);
		}
		int ans = main.size();
		return ans;


    }
	static int sherlockAndAnagrams(String s) {
		Map<String,Integer> mp = new HashMap<>();
		int res = 0;
		for(int i = 0; i<s.length(); i++) {
			for(int j=i+1; j<=s.length(); j++) {
				char temp[] = s.substring(i,j).toCharArray();
				Arrays.sort(temp);
				String str = ""+ String.valueOf(temp);
				if(!mp.containsKey(str)) {
					mp.put(str, 1);
				}else {
					mp.put(str, mp.get(str)+1);
				}
				res += mp.get(str)-1;
			}
		}
		return res;
		
    }
	
	 static int makingAnagrams(String s1, String s2) {
		 int a[] = new int[26];
		 for(int i=0; i<s1.length(); i++) {
			 a[s1.charAt(i) - 97]++;
		 }
		 for(int i=0; i<s2.length(); i++) {
			 a[s2.charAt(i) - 97]--;
		 }
		 int c = 0;
		 for(int i=0; i<26; i++) {
			 if(a[i]!=0) {
				 c = c + Math.abs(a[i]);
			 }
		 }
		 return c;


	}
	
	static int theLoveLetterMystery(String s) {
		char t[] = s.toCharArray();
		int ans = 0;
		int e = s.length()-1;
		int f = 0;
		while(f<e) {
			if(t[f]==t[e]) {
				f++;
				e--;
				continue;
			}
			boolean flag = true;
			while(flag) {
				if(t[e]>t[f] && t[e]!='a') {
					char temp = t[e];
					temp--;
					t[e] = temp;
					ans++;
				}else if(t[f]>t[e] && t[f]!='a') {
					char temp = t[f];
					temp--;
					t[f] = temp;
					ans++;
				}else if(t[e]==t[f]) {
					e--;
					f++;
					flag = false;
				}else if(t[e]=='a' || t[f]=='a') {
					flag = false;
				}
			}
		}
		return ans;


    }
	static String gameOfThrones(String s) {
		String ans = "NO";
		List<Character> ll = new LinkedList<>();
		for(int i=0; i<s.length(); i++) {
			if(ll.contains(s.charAt(i))) {
				ll.remove((Character)s.charAt(i));
			}else {
				ll.add(s.charAt(i));
			}
		}
		
		if(s.length()%2==0 && ll.isEmpty() || s.length()%2==1 && ll.size()==1) {
			ans = "YES";
		}
		return ans;
        


    }
	static int beautifulBinaryString(String b) {
		char t[] = b.toCharArray();
		int c = 0;
		for(int i=0; i<t.length-2; i++) {
			if(t[i]=='0' && t[i+1]=='1' && t[i+2]=='0') {
				t[i+2]='1';
				c++;
				i=i+2;
			}
		}
		return c;


    }
}
