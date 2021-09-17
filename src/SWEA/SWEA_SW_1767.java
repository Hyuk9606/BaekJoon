package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_1767 {
	static int deltas[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] map;
	static int N, T;
	static int max, minLength;
	static List<RC> list;
	
	static class RC {
		int r, c;

		public RC(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;
					if (map[i][j] == 1)
						list.add(new RC(i, j));
				}
			}
			max = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + minLength);
		}
	}

	private static void dfs(int idx, int coreCnt, int len) {
		if (idx == list.size()) {
			if (max < coreCnt) {
				max = coreCnt;
				minLength = len;
			} else if (max == coreCnt) {
				if (minLength > len)
					minLength = len;
			}
			return;
		}
		int row = list.get(idx).r;
		int col = list.get(idx).c;
		for (int dir = 0; dir < 4; dir++) {
			int count = 0;
			int nx = row;
			int ny = col;
			int Srow = row;
			int Scol = col;
			while (true) {
				nx += deltas[dir][0];
				ny += deltas[dir][1];
				if (check(nx, ny))
					break;
				if (map[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			for (int i = 0; i < count; i++) {
				Srow += deltas[dir][0];
				Scol += deltas[dir][1];
				map[Srow][Scol] = 1;
			}
			if (count == 0)
				dfs(idx + 1, coreCnt, len);
			else {
				dfs(idx + 1, coreCnt + 1, len + count);
				Srow = row;
				Scol = col;
				for (int i = 0; i < count; i++) {
					Srow += deltas[dir][0];
					Scol += deltas[dir][1];
					map[Srow][Scol] = 0;
				}
			}
		}
	}
	

	private static boolean check(int nx, int ny) {
		return nx < 0 || nx >= N || ny < 0 || ny >= N;
	}
	
	
}
