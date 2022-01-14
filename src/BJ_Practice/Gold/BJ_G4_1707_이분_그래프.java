package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1707_이분_그래프 {
	static int T;
	static int V,E;
	static Node[] adjList;
	static int[] visited;
	static StringTokenizer st;
	
	static class Node{
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new Node[V+1];
			visited = new int[V+1];
			for (int i = 0; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start] = new Node(end,adjList[start]);
				adjList[end] = new Node(start,adjList[end]);
			}
			
			int ans = 1;
			for (int i = 1; i <= V ; i++) {
				if(visited[i] == 0) {
					bfs(i);
			
				}
			}
			 outer : for (int i = 1; i <= V ; i++) {
				int cur = visited[i];
				for(Node temp = adjList[i] ; temp != null; temp = temp.link) {
					if(visited[temp.vertex] == cur) {
						ans = 0;
						break outer;
					}
				}
			}
			
			if(ans==1) sb.append("YES").append("\n");
			else if(ans == 0) sb.append("NO").append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		visited[num] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if(visited[temp.vertex] == 0) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = visited[cur] == 1? 2:1;
				}
			}
		}
	}
}
