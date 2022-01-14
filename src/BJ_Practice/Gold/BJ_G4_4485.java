package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_4485 {
	static int N, T = 0;
	static int[][] map;
	static int[][] distance;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class RC implements Comparable<RC> {
		int r, c, cost;

		public RC(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(RC o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
		}
		System.out.println(sb);


	}

	static void dijkstra() {
		PriorityQueue<RC> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], 10000);
		}
		distance[0][0] = map[0][0];
		pq.offer(new RC(0, 0, distance[0][0]));

		while (!pq.isEmpty()) {
			RC temp = pq.poll();
			int r = temp.r;
			int c = temp.c;
			visited[r][c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				if (isIn(nr, nc) && !visited[nr][nc] && distance[nr][nc] > temp.cost + map[nr][nc]) {
					distance[nr][nc] = temp.cost + map[nr][nc];
					pq.offer(new RC(nr, nc, distance[nr][nc]));
				}

			}
		}
		sb.append("Problem").append(" ").append(++T).append(": ").append(distance[N - 1][N - 1]).append("\n");

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
