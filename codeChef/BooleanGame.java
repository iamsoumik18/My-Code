package codeChef;

import java.io.*;
import java.util.*;

public class BooleanGame {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1[] = br.readLine().split(" ");
				int n = Integer.parseInt(s1[0]);
				int m = Integer.parseInt(s1[1]);
				int k = Integer.parseInt(s1[2]);
				long g[] = new long[n];
				String s2[] = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					g[i] = Long.parseLong(s2[i]);
				}
				int ma[][] = new int[m][3];
				for(int i=0; i<m; i++) {
					String s3[] = br.readLine().split(" ");
					ma[i][0] = Integer.parseInt(s3[0]);
					ma[i][1] = Integer.parseInt(s3[1]);
					ma[i][2] = Integer.parseInt(s3[2]);
				}
				ArrayList<Long> ans = solution(n, m, k, g, ma);
				for(int i=0; i<k; i++) {
					bw.write(ans.get(i)+" ");
					bw.flush();
				}
				bw.write("\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static ArrayList<Long> solution(int n, int m, int k, long g[], int ma[][]) {
		
		int temp[] = new int[n];
		ArrayList<String> list = new ArrayList<>();
		generateAllBinaryStrings(n, temp, 0, list);
		
		ArrayList<Long> score = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			
			long sum = 0;
			
			String b = list.get(i);
			
			for(int j=0; j<n; j++) {
				char ch = b.charAt(j);
				if(ch=='1') {
					sum += g[j];
				}
			}
			
			for(int j=0; j<m; j++) {
				boolean flag = true;
				for(int l = ma[j][0] - 1; l< ma[j][1]; l++) {
					char ch = b.charAt(l);
					if(ch=='0') {
						flag = false;
						break;
					}
				}
				if(flag) {
					sum += ma[j][2];
				}
			}
			
			score.add(sum);
			
		}
		
		Collections.sort(score,Collections.reverseOrder());
		
		ArrayList<Long> ans = new ArrayList<>();
		
		for(int i=0; i<k; i++) {
			ans.add(score.get(i));
		}
		
		return ans;
		
	}
	
	static void generateAllBinaryStrings(int n, int arr[], int i, ArrayList<String> list){
		if (i == n){
			printTheArray(arr, n, list);
			return;
		}
		arr[i] = 0;
		generateAllBinaryStrings(n, arr, i + 1, list);
		arr[i] = 1;
		generateAllBinaryStrings(n, arr, i + 1, list);
	}
	
	static void printTheArray(int arr[], int n, ArrayList<String> list){
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < n; i++){
	        st.append(arr[i]);
	    }
	    list.add(st.toString());
	}

}
