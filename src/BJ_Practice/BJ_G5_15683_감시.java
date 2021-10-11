package BJ_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15683_감시 {
	static int N, M;
	static int answer = 0;
	static int map[][];
	static int[][] deltas = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int[][] direction = { { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };
	static List<CCTV> list = new ArrayList<>();
	static StringTokenizer st;

	static class CCTV {
		int r, c, dir;

		public CCTV(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					list.add(new CCTV(i, j, map[i][j]));
			}
		}

	}

	static void observe(int cctv, int dir, int[][] map) {
		if (cctv == list.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1)
						count++;
				}
			}
			answer = Math.max(count, answer);
			return;
		}

		int nr = list.get(cctv).r;
		int nc = list.get(cctv).c;
		for (int j = 0; j < direction[list.get(cctv).dir].length; j++) {
			while (isIn(nr, nc) && map[nr][nc] < 6) {
				nr += deltas[(j + dir) % 4][0];
				nc += deltas[(j + dir) % 4][1];
				if (map[nr][nc] == 0) {
					map[nr][nc] = -1;
				}
			}
			observe(cctv + 1, dir, map);
		}
		observe(cctv, dir + 1, map);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
