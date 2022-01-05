package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1967_트리의_지름 {

	static int N;
	static int max = 0;
	static int maxValueVertex = 1;
	static Node[] adjList;
	static boolean[] visited;
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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		adjList = new Node[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[start] = new Node(end, weight, adjList[start]);
			adjList[end] = new Node(start, weight, adjList[end]);
		}

		dfs(1, 0);

		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}

		dfs(maxValueVertex, 0);
		System.out.println(max);
	}

	static void dfs(int vertex, int dist) {
		visited[vertex] = true;

		for (Node temp = adjList[vertex]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex, dist + temp.weight);
			}
		}

		if (max < dist) {
			max = dist;
			maxValueVertex = vertex;
		}
	}
}
