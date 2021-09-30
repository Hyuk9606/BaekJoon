package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G4_2458 {
	static int T, N, M;
	static StringTokenizer st;

	static Node[] forward;
	static Node[] reverse;

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
		
		forward = new Node[N + 1];
		reverse = new Node[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			forward[start] = new Node(end, forward[start]);
			reverse[end] = new Node(start, reverse[end]);
		}
		int[] A = bfs(forward);
		int[] B = bfs(reverse);
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (A[i] + B[i] == N - 1)
				cnt++;
		}
		

		System.out.println(cnt);

	}

	static int[] bfs(Node[] tempList) {
		int[] dist = new int[N + 1];
		Queue<Integer> queue;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			boolean visited[] = new boolean[N + 1];
			queue = new LinkedList<>();
			queue.offer(i);
			visited[i] = true;

			while (!queue.isEmpty()) {
				int curr = queue.poll();

				for (Node temp = tempList[curr]; temp != null; temp = temp.link) {
					if (!visited[temp.vertex]) {
						cnt++;
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			dist[i] = cnt;

		}
		return dist;
	}
}
