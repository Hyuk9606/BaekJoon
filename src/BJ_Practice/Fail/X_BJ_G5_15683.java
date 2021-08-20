package BJ_Practice.Fail;

import java.io.*;
import java.util.*;

public class X_BJ_G5_15683 {
	static int N, M;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 0 && map[r][c] < 6) {
					switch (map[r][c]) {
					case 5:
						for (int i = 0; i < 4; i++) {

						}
					}
				}

			}
		}
	}

	static void cctv1(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += deltas[i][0];
				nc += deltas[i][1];
				if (!isIn(nr, nc) || map[nr][nc] == 6) {

				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
