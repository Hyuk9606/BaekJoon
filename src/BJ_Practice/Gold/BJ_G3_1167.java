package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_1167 {
	static int V;
	static StringTokenizer st;
	static Node[] adjArray;
	static int answer = 0, second = 0;

	static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		int totalCost;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		public Node(int vertex, int totalCost) {
			super();
			this.vertex = vertex;
			this.totalCost = totalCost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		};

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		V = Integer.parseInt(br.readLine());
		adjArray = new Node[V + 1];
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while (true) {
				int end = Integer.parseInt(st.nextToken());
				if (end == -1)
					break;
				int weight = Integer.parseInt(st.nextToken());
				adjArray[start] = new Node(end, weight, adjArray[start]);
			}
		}

		dijkstra(1);
		if (second != 1)
			dijkstra(second);

		System.out.println(answer);

	}

	static void dijkstra(int start) {
		int[] dist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.offer(new Node(start, 0));
		visited[start] = true;

		while (!pq.isEmpty()) {
			Node maxDistNode = pq.poll();

			for (Node temp = adjArray[maxDistNode.vertex]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && dist[temp.vertex] < dist[maxDistNode.vertex] + temp.weight) {
					dist[temp.vertex] = dist[maxDistNode.vertex] + temp.weight;
					pq.offer(new Node(temp.vertex, dist[temp.vertex]));
					visited[temp.vertex] = true;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (answer < dist[i]) {
				answer = dist[i];
				second = i;
			}

		}
	}

}
