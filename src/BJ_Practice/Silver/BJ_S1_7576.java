package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_7576 {
	static int N, M, cnt, Answer;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;
	static ArrayList<RC> list = new ArrayList<>();

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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		cnt = 0;
		Answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					cnt++;
				else if (map[i][j] == 1) {
					list.add(new RC(i, j));
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}

		bfs();

		if (cnt != 0) {
			System.out.println(-1);
		} else
			System.out.println(Answer);

	}

	static void bfs() {
		Queue<RC> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			queue.offer(list.get(i));
		}

		while (!queue.isEmpty()) {
			RC temp = queue.poll();
			int r = temp.r;
			int c = temp.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				if (isIn(nr, nc) && map[nr][nc] == 0) {
					queue.offer(new RC(nr, nc));
					map[nr][nc] = map[r][c] + 1;
					cnt--;
					Answer = Math.max(Answer, map[r][c]);
				}
			}
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
