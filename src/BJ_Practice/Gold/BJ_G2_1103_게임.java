package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_1103_게임 {

	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int answer = 0;
	static boolean[][] visited;
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
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	static int count = 0;

	static void dfs(int r, int c) {
		visited[r][c] = true;
		count++;

		answer = Math.max(answer, count);

		dp[r][c] = count;

		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0] * map[r][c];
			int nc = c + deltas[i][1] * map[r][c];

			if (isIn(nr, nc)) {
				if (visited[nr][nc]) {
					System.out.println(-1);
					System.exit(0);
				}
				if (dp[nr][nc] <= count)
					dfs(nr, nc);
			}
		}
		visited[r][c] = false;
		count--;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] != 'H' - '0';
	}
}
