package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_1005_ACM_Craft {

	static int T;
	static int N, M;
	static int time[];
	static int[] indegree;
	static Node adjList[];
	static int endPoint;
	static StringTokenizer st;

	static class Node {
		int v;
		Node link;

		public Node(int v, Node link) {
			super();
			this.v = v;
			this.link = link;
		}
	}

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			time = new int[N + 1];
			adjList = new Node[N + 1];

			indegree = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start] = new Node(end, adjList[start]);
				indegree[end]++;
			}
			endPoint = Integer.parseInt(br.readLine());
			
			bfs();
		}
		System.out.println(sb.toString());

	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int result[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			result[i] = time[i];

			if (indegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (Node temp = adjList[curr]; temp != null; temp = temp.link) {
				result[temp.v] = Math.max(result[temp.v], time[temp.v] + result[curr]);
				indegree[temp.v]--;
				
				if(indegree[temp.v] == 0) {
					queue.offer(temp.v);
				}
			}
			
		}
		sb.append(result[endPoint]).append("\n");
	}
}
