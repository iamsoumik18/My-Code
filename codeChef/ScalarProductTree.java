package codeChef;

import java.util.*;
import java.io.*;

public class ScalarProductTree {
	
	private List<Integer> adj[];
	
	static long mod = 4294967296L;
	
	@SuppressWarnings("unchecked")
	public ScalarProductTree(int v) {
		adj = new ArrayList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	private boolean dfsUtil(int source, int destination, boolean vis[], Deque<Integer> stack) {
		stack.push(source);
		if(source==destination)return true;
		
		for(int neighbour: adj[source]) {
			if(!vis[neighbour]) {
				vis[neighbour] = true;
				boolean isConnected = dfsUtil(neighbour,destination,vis,stack);
				if(isConnected)return true;
			}
		}
		stack.pop();
		return false;
	}
	
	public Deque<Integer> dfs(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		Deque<Integer> stack = new ArrayDeque<>();
		dfsUtil(source,destination,vis,stack);
		return stack;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
		
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int q = Integer.parseInt(s1[1]);
			String s2[] = br.readLine().split(" ");
			long w[] = new long[n];
			for(int i=0; i<n; i++) {
				w[i] = Long.parseLong(s2[i]);
			}
		
			ScalarProductTree graph = new ScalarProductTree(n);
		
			for(int i=0; i<n-1; i++) {
				String s3[] = br.readLine().split(" ");
			
				int u = Integer.parseInt(s3[0])-1;
				int v = Integer.parseInt(s3[1])-1;
			
				graph.addEdge(u, v);
			
			}
		
			for(int i=0; i<q; i++) {
				String s4[] = br.readLine().split(" ");
				int u = Integer.parseInt(s4[0])-1;
				int v = Integer.parseInt(s4[1])-1;
			
				List<Integer> f1 = new ArrayList<>(graph.dfs(u, 0));
				List<Integer> f2 = new ArrayList<>(graph.dfs(v, 0));
			
			
				long f = 0;
				for(int j=0; j<f1.size(); j++) {
					f = ((f % mod) +  ((((w[f1.get(j)]%mod) * (w[f2.get(j)]%mod)) % mod) % mod)) % mod;
				}
				bw.write(f+"\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}

}
