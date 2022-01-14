package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_11724_연결_요소의_개수 {
	static int N, M;
	static StringTokenizer st;

	static class Node {
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

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(N);
			System.exit(0);
		}
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}

		boolean[] visited = new boolean[N + 1];
		Node[] adjList = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adjList[start] = new Node(end, adjList[start]);
			adjList[end] = new Node(start, adjList[end]);
		}

		int count = 1;
		int Answer = 0;

		Queue<Integer> queue = new LinkedList<>();

		while (count < N) {
			for (int i = 1; i <= N ; i++) {
				if(!visited[i] && adjList[i] != null) {
					queue.offer(i);
					visited[i] = true;
					count++;
					Answer++;
					break;
				}else if(!visited[i] &&adjList[i] == null) {
					Answer++;
					count++;
					visited[i] = true;
				}
			}
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				for (Node temp = adjList[curr]; temp != null; temp = temp.link) {
					if (!visited[temp.vertex]) {
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
						count++;
					}
				}
			}
		}
		System.out.println(Answer);
	}
}
