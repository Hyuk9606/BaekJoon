package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2636 {
	static int N, M;
	static boolean[][] data;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
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

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new boolean[N][M];
//		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					data[i][j] = true;

			}
		}

		int answer = 0;

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(data[i][j] == true) {
					answer = bfs();
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(answer);
	}

	static int bfs() {
		visited = new boolean[N][M];
		int count = 0;
		Queue<RC> queue = new LinkedList<>();
		queue.offer(new RC(0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			RC curr = queue.poll();
			int r = curr.r;
			int c = curr.c;
			for (int i = 0; i < deltas.length; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					if (data[nr][nc] == true) {
						data[nr][nc] = false;
						count++;
					} else {
						queue.offer(new RC(nr, nc));
					}
					visited[nr][nc] = true;
				}
			}
		}
		return count;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
