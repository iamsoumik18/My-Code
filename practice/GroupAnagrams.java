package practice;

import java.util.*;
import java.io.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		

	}
	
	public static List<List<String>> groupAnagrams(String[] str){
		Map<String, List<String>> mp = new HashMap<>();
		for(String s: str) {
			char charArray[] = s.toCharArray();
			Arrays.sort(charArray);
			String s2 = new String(charArray);
			
			if(!mp.containsKey(s2)) {
				mp.put(s2, new LinkedList<>());
			}
			
			mp.get(s2).add(s);
		}
		
		return new LinkedList<>(mp.values());
	}

}
