package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1520 {
	static int N, M;
	static int[][] map;
	static int[][] route;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static StringTokenizer st;

	static class RC {
		int r;
		int c;

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
		route = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N ; i++) {
			Arrays.fill(route[i], -1);
		}
		System.out.println(dfs(new RC(0, 0)));
//		for (int i = 0; i < N ; i++) {
//			System.out.println(Arrays.toString(route[i]));
//		}

	}

	static int dfs(RC rc) {
		if(rc.r == N-1 && rc.c == M-1) {
			return 1;
		}
		
		int r = rc.r;
		int c = rc.c;

		int res = route[r][c];
		if(res != -1) return route[r][c] = res;
		res = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if (isIn(nr, nc) && map[r][c] > map[nr][nc]) {
				res += dfs(new RC(nr,nc));
			}
		}
		
		return route[r][c] = res;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
*/
