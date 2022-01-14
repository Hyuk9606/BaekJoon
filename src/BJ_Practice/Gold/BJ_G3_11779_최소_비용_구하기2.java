package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_11779_최소_비용_구하기2 {

	static int N, M, T;
	static Node[] graph;
	static StringTokenizer st;

	static class Node implements Comparable<Node> {
		int v;
		int h;
		Node link;

		public Node(int v, int h, Node link) {
			super();
			this.v = v;
			this.h = h;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return this.h - o.h;
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			graph[u] = new Node(v, h, graph[u]);
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, end);
//		System.out.println(sb.toString());
	}

	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, graph[start]));
		int[] distance = new int[N + 1];
		int[] route = new int[N+1];
		Arrays.fill(distance, 100000000);
		boolean[] visited = new boolean[N + 1];

		distance[start] = 0;
		route[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
//			System.out.println(curr.v);
//			if(visited[curr.v]) continue;
//			visited[curr.v] = true;

			for (Node temp = graph[curr.v]; temp != null; temp = temp.link) {
				if (distance[temp.v] > distance[curr.v] + temp.h) {
					pq.offer(new Node(temp.v, temp.h, null));
					distance[temp.v] = distance[curr.v] + temp.h;
					route[temp.v] = curr.v;
				}

			}
		}
		System.out.println(distance[end]);
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		while(end != 0) {
			stack.push(end);
			end = route[end];
			count++;
		}
		System.out.println(count);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}
}