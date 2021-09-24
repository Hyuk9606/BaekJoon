package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_17144 {
	static int R, C, T;
	static int[][] home;
	static int[][] deltas1 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] deltas2 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int airCleaner;
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		home = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				home[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			if (home[r][0] == -1) {
				airCleaner = r;
				break;
			}
		}
		for (int t = 0; t < T ; t++) {
			home = spread();
			topWind();
			bottomWind();
		}
		int answer = 0;
		for (int r = 0; r < R ; r++) {
			for (int c = 0; c < C ; c++) {
				if(home[r][c] > 0)
					answer += home[r][c];
			}
		}
		System.out.println(answer);
	}

	static int[][] spread() {
		Queue<RC> queue = new LinkedList<>();
		int[][] nextSecHome = new int[R][C];
		for (int i = 0; i < R; i++) {
			nextSecHome[i] = Arrays.copyOf(home[i], home[i].length);
		}

		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				if (home[r][c] > 0)
					queue.offer(new RC(r, c));

		while (!queue.isEmpty()) {
			RC temp = queue.poll();
			int r = temp.r;
			int c = temp.c;
			int part = home[r][c] / 5;
//			System.out.println(home[r][c] + " : " + part);
			for (int i = 0; i < 4; i++) {
				int nr = r + deltas1[i][0];
				int nc = c + deltas1[i][1];
				if (isIn(nr, nc) && home[nr][nc] != -1) {
					nextSecHome[nr][nc] += part;
					nextSecHome[r][c] -= part;
				}
			}

		}
		return nextSecHome;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static void topWind() {
		int r = airCleaner - 1;
		int c = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += deltas1[i][0];
				nc += deltas1[i][1];
				if (!isIn(nr, nc) || home[nr][nc] == -1 || (nr > airCleaner && c == C-1))
					break;
				home[r][c] = home[nr][nc];
				r = nr;
				c = nc;
			}
		}
		home[r][1] = 0;
	}
	static void bottomWind() {
		int r = airCleaner+2;
		int c = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += deltas2[i][0];
				nc += deltas2[i][1];
				if (!isIn(nr, nc) || home[nr][nc] == -1 || (nr < airCleaner+1 && c == C-1))
					break;
				home[r][c] = home[nr][nc];
				r = nr;
				c = nc;
			}
		}
		home[r][1] = 0;
	}

}
