package practice;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int arr[] = new int[n];
//		for(int i=0; i<n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		int m = sc.nextInt();
//		int brr[] = new int[m];
//		for(int i=0; i<m; i++) {
//			brr[i] = sc.nextInt();
//		}
//		missingNumbers(arr, brr);
		int n = sc.nextInt();
		int s[] = new int[n];
		for(int i=0; i<n; i++) {
			s[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int a[] = new int [m];
		for(int i=0; i<m; i++) {
			a[i] = sc.nextInt();
		}
		int ans[] = climbingLeaderboard(s, a);
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static List<String> mostActive(List<String> customers) {
			int n = customers.size();
			Map<String,List<String>> mp = new HashMap<>();
			for(String s: customers) {
				if(!mp.containsKey(s)) {
					mp.put(s, new LinkedList<>());
				}
				mp.get(s).add(s);
			}
			Map<String,Integer> co = new TreeMap<>();
			Set<String> set = new TreeSet<>(customers);
			for(String s: set) {
				List<String> temp = new LinkedList<>(mp.get(s));
				co.put(s, temp.size());
			}
			List<String> ans = new ArrayList<>();
			for(String s: set) {
				int x = co.get(s);
				double p = ((double)x/(double)n) * 100;
				if(p>=5) {
					ans.add(s);
				}
			}
			return ans;
			
			
	    

	    }
	
	static long repeatedString(String s, long n) {
        if(s.length()==1){
            if(s.charAt(0)=='a'){
                return n;
            }else{
                return 0;
            }
        }
        long q = n/(long)s.length();
        int r = (int) (n%s.length());
        
        int ca = 0;
        int rest = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)=='a') {
        		ca++;
        	}else {
        		rest++;
        	}
        }
        
        long sum = 0;
        sum = q*ca;
        for(int i=0; i<r; i++) {
        	if(s.charAt(i)=='a')
        		sum++;
        }

        return sum;
    }
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		Set<Integer> ls	= new LinkedHashSet<>();
		for(int i = 0; i<scores.length; i++) {
			ls.add(scores[i]);
		}
		int rank[] = new int[ls.size()];
		int x=0;
		for(int num: ls) {
			rank[x++] = num;
		}
		int ans[] = new int[alice.length];
		x = 0;
		int i = 0;
		int j = rank.length-1;
		while(i<alice.length) {
			if(alice[i]>rank[0]) {
				ans[x++] = 1;
				i++;
			}else if(alice[i]==rank[j]) {
				ans[x++] = j+1;
				i++;
			}else if(alice[i]<rank[j]) {
				ans[x++] = j+2;
				i++;
			}
			else if(alice[i]>rank[j] && alice[i]<rank[j-1]) {
				ans[x++] = j-1+2;
				i++;
			}else {
				j--;
			}
		}
		return ans;
	}
	
	static void missingNumbers(int arr[], int brr[]) {
		Set<Integer> ts = new TreeSet<>();		
		int freq[] = new int[10001];
		for(int i=0; i<brr.length; i++) {
			freq[brr[i]]++;
		}
		for(int i=0; i<arr.length; i++) {
			freq[arr[i]]--;
		}
		for(int i=1; i<freq.length; i++) {
			if(freq[i]!=0) {
				ts.add(i);
			}
		}
		for(int num: ts) {
			System.out.print(num+" ");
		}
		
		
		
	}
	
	

}
