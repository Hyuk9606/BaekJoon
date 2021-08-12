package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S1_2468 {
	static int N, cnt;
	static int[][] map;
	static int[][] isSafe;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isSafe = new int[N][N];
		int max = Integer.MIN_VALUE;
		int max_safe = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = max < map[i][j] ? map[i][j] : max;
			}
		}
		for (int i = 0; i < max; i++) {
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > i) {
						isSafe[r][c] = map[r][c];
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (isSafe[r][c] > 0) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			max_safe = cnt > max_safe ? cnt : max_safe;
		}

		System.out.println(max_safe);
	}

	static void dfs(int r, int c) {

		if (!isIn(r, c) || isSafe[r][c] == 0)
			return;

		isSafe[r][c] = 0;
		int nr = r;
		int nc = c;
		for (int i = 0; i < 4; i++) {
			nr = r + deltas[i][0];
			nc = c + deltas[i][1];
			dfs(nr, nc);
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
