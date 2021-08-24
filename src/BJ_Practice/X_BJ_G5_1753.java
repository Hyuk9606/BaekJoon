package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_G5_1753 {
	static int V, E, K;
	static StringTokenizer st;

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
			return "[vertex=" + vertex + ", weight=" + weight + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Node> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		Node[] adjArray = new Node[V + 1];

		int start = K;
		int end = V;
		final int INFINITY = Integer.MAX_VALUE;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjArray[r] = new Node(c, weight, adjArray[r]);
			adjArray[c] = new Node(r, weight, adjArray[c]);
		}

		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, INFINITY);

		distance[start] = 0;
		int min = 0, current = K;
		for (int i = 1; i <= V; i++) {
			min = INFINITY;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			System.out.print(current + " ");
			if (current == end)
				break;

			for (Node temp = adjArray[current]; temp.link != null; temp = temp.link)
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
		}
		System.out.println();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INFINITY)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
}
