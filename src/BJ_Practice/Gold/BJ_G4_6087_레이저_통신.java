package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_6087_레이저_통신 {

	static int N, M;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] visited;
	static StringTokenizer st;
	static RC start = null;
	static RC end = null;

	static class RC implements Comparable<RC> {
		int r, c;
		int cnt;
		int dir;

		public RC(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(RC o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "RC [r=" + r + ", c=" + c + ", cnt=" + cnt + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N ; i++) {
			Arrays.fill(visited[i],Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C') {
					if (start == null)
						start = new RC(i, j, 0, -1);
					else
						end = new RC(i, j, 0, -1);
				}
			}
		}
		int answer = bfs();
		System.out.println(answer);
	}

	static int bfs() {
		PriorityQueue<RC> queue = new PriorityQueue<>();
		queue.offer(start);
		visited[start.r][start.c] = 0;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			if (temp.r == end.r && temp.c == end.c) {
				return temp.cnt;
			}

			for (int i = 0; i < 4; i++) {

				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc)) {
					if (i == temp.dir || temp.dir == -1) {
						if (visited[nr][nc] >= temp.cnt) {
							queue.offer(new RC(nr, nc, temp.cnt, i));
							visited[nr][nc] = temp.cnt;
						}
					} else {
						if (visited[nr][nc] >= temp.cnt + 1) {
							queue.offer(new RC(nr, nc, temp.cnt + 1, i));
							visited[nr][nc] = temp.cnt + 1;
						}
					}
				}
			}
		}
		return -1;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] != '*';
	}
}
