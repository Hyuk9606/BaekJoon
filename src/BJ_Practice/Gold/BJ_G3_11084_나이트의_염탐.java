package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_11084_나이트의_염탐 {

	static int N, M;
	static int count = 0;
	static int distance = 0;
	static int[][] deltas = { { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 } };
	static long[][] map;
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
		if (N == 1 && M == 1) {
			System.out.println(0 + " " + 1);
			return;
		}

		map = new long[N][M];
		
		bfs();
		
		if (map[N - 1][M - 1] == 0)
			System.out.println("None");
		else {
			System.out.println(distance + " " + map[N - 1][M - 1]);
		}

	}

	static void bfs() {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(new RC(0, 0));
		map[0][0] = 1;

		while (!queue.isEmpty()) {
			if (map[N - 1][M - 1] != 0)
				break;
			int size = queue.size();
			distance++;
			for (int step = 0; step < size; step++) {
				RC temp = queue.poll();

				for (int i = 0; i < 8; i++) {
					int nr = temp.r + deltas[i][0];
					int nc = temp.c + deltas[i][1];
					if (isIn(nr, nc)) {
						if (map[nr][nc] == 0)
							queue.offer(new RC(nr, nc));
						map[nr][nc] = (map[nr][nc] + map[temp.r][temp.c]) %(long)(1e9 + 9);
						
					}
				}
			}
		}
	}
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
