package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G1_1981_배열에서_이동 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int min = 1000, max = 0;
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

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}

		int start = 0;
		int end = max - min;
		int answer = 987654321;
		while (start <= end) {
			int mid = (start + end) / 2;
			boolean flag = false;
			for (int i = min; i <= max-mid; i++) {
				if (i <= map[0][0] && map[0][0] <= i + mid)
					if (flag = bfs(i, i + mid))
						break;
			}
			if (flag) {
				end = mid - 1;
				answer = Math.min(answer, mid);
			} else
				start = mid + 1;
		}
		System.out.println(answer);
	}

	static boolean bfs(int min, int max) {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(new RC(0, 0));

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		visited[0][0] = true;

		while (!queue.isEmpty()) {
			RC curr = queue.poll();

			if (curr.r == N - 1 && curr.c == N - 1) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + deltas[i][0];
				int nc = curr.c + deltas[i][1];

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= min && map[nr][nc] <= max) {
					queue.offer(new RC(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
