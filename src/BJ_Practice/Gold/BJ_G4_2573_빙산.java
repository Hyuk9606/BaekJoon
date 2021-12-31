package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_2573_빙산 {
	static int N, M;
	static int answer = 0;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visited;
	static StringTokenizer st;

	static class Position {
		int r, c;

		public Position(int r, int c) {
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
		int melt[][] = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
				Arrays.fill(melt[i], 0);
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			if (count > 1)
				break;
			else if (count == 0) {
				answer = 0;
				break;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						for (int step = 0; step < 4; step++) {
							int nr = i + deltas[step][0];
							int nc = j + deltas[step][1];
							if (isIn(nr, nc) && map[nr][nc] < 1) {
								melt[i][j]++;
							}
						}
					}

				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= melt[i][j];
				}
			}
			answer++;
		}

		System.out.println(answer);

	}

	static void bfs(int r, int c) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(r, c));
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Position temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
					queue.offer(new Position(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

