package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MyArrayList {

	public static void main(String[] args) {
		
//		List<Integer> a = new ArrayList<Integer>();
//		Queue<Integer> q = new LinkedList<>();
//		
//		Map<String, Integer> mp = new HashMap<>();
//		
//		mp.put("Dog", 1);
//		mp.put("Cat", 2);
//		mp.put("Mouse", 1);
//		mp.put("Bird", 4);
//		
//		System.out.println(mp);
		
		Set<Integer> main = new TreeSet<>();
		Set<Integer> demo = new TreeSet<>();
		main.add(1);
		main.add(4);
		main.add(5);
		main.add(7);
		demo.add(4);
		main.retainAll(demo);
		System.out.println(main);
		
	
		
		
		
				
		
		

	}
	
	public static List<Integer> gradingStudents(List<Integer> grades){
		List<Integer> a = new ArrayList<Integer>();
		
		int n = grades.size();
		
		for(int i=0; i<n; i++) {
			int num = grades.get(i);
			if(num >= 38) {
				int q = num/5 + 1;
				int x = q*5;
				if( x - num < 3)
					a.add(x);
				else
					a.add(num);
			}
			else {
				a.add(num);
			}
			
		}
		
		return a;
	}

}
