package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_G1_9328_열쇠 {

	static int T;
	static int N, M; 
	static char[][] map;
	static boolean[][][] visited;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 0, -1 } };
	static String key = "";
	static List<RC> entrance = new ArrayList<>();
	static StringTokenizer st;

	static class RC {
		int r, c, dim;

		public RC(int r, int c, int dim) {
			super();
			this.r = r;
			this.c = c;
			this.dim = dim;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M][26];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			key = br.readLine().toUpperCase();

		}
	}

	static void bfs() {
		Queue<RC> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isEnterable(i, j) && map[i][j] != '*') {
					if (map[i][j] == '.' || key.contains(String.valueOf(map[i][j]))) {
						queue.offer(new RC(i, j, 0));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			RC temp = queue.poll();
			visited[temp.r][temp.c][temp.dim] = true;

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				if (isIn(nr, nc) && map[nr][nc] != '*' && !visited[nr][nc][temp.dim]) {
					if(map[nr][nc] == '.') {
					}
				}
			}
		}

	}

	static boolean isEnterable(int i, int j) {
		return i == 0 || j == 0 || i == N - 1 || j == M - 1;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
