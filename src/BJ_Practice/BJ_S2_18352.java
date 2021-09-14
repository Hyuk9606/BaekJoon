package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S2_18352 {
	static int N, M,K,step;
	static StringTokenizer st;
	static final long INFINITY = Long.MAX_VALUE;
	static int[] visited;
	
	static class Node {
		int vertex;
		int weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link + "]\n";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		step = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		Node[] adjArray = new Node[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjArray[s] = new Node(e, 1, adjArray[s]);
//			adjArray[e] = new Node(s, 1, adjArray[e]);
		}
		bfs(adjArray);
	}
	
	static void bfs(Node[] adjArray) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(step);
		visited[step] = 1;
		int count = 0;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			if(visited[a] > K+1)
				break;
			for(Node temp = adjArray[a]; temp != null; temp = temp.link) {
				if(visited[temp.vertex]==0) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = visited[a] +1;
				}
			}					
		}
		int cnt = 0;
		for (int i = 1; i <= N ; i++) {
			if(visited[i] == K+1) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt == 0)
			System.out.println(-1);
		
	}

}