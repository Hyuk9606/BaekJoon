package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_14940_쉬운_최단거리 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		RC start = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
				else if (map[i][j] == 2) {
					start = new RC(i, j);
					map[i][j] = 0;
				}
			}
		}
		Queue<RC> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.r][start.c] = true;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == -1) {
					queue.offer(new RC(nr, nc));
					visited[nr][nc] = true;
					map[nr][nc] = map[temp.r][temp.c] + 1;
				}
			}
		}
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
