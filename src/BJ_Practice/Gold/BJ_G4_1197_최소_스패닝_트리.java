package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1197_최소_스패닝_트리 {

	static int V,E;
	static int[] parent;
	static StringTokenizer st;
	static class Edge implements Comparable<Edge>{
		int start,end,cost;

		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		for (int i = 1; i <= V ; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(start,end,cost));
		}
		int answer = 0;
		int count = 0;
		while(count<V-1) {
			Edge temp = pq.poll();
			if(!isSame(temp.start, temp.end)) {
				union(temp.start, temp.end);
				answer += temp.cost;
				count++;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return;
		}
		if(x > y) {
			parent[y] = x;
		}else{
			parent[x] = y;
		}
	}
}
