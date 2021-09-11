package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_1260 {
	static int N, M, V;
	static StringTokenizer st;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			graph[end].add(start);
		}
		for (int i = 1; i <= N; i++) {
			if (graph[i].size() != 0)
				Collections.sort(graph[i]);
		}

		boolean[] visited = new boolean[N + 1];

		dfs(V, visited);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(visited);
		System.out.println(sb.toString());
	}

	private static void bfs(boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited[V] = true;
		sb.append(V).append(" ");
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			for (int i = 0; i < graph[vertex].size(); i++) {
				int current = graph[vertex].get(i);
				if (!visited[current]) {
					queue.offer(current);
					visited[current] = true;
					sb.append(current).append(" ");
				}
			}
		}
	}

	private static void dfs(int vertex, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();

		stack.push(vertex);
		visited[vertex] = true;
		sb.append(vertex).append(" ");

		while (!stack.isEmpty()) {
			vertex = stack.pop();
			for (int i = 0; i < graph[vertex].size(); i++) {
				int current = graph[vertex].get(i);
				if(!visited[current]) {
					dfs(current, visited);
				}
			}

		}
	}

}
