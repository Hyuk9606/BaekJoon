package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G1_1194 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;
	static Status curr;

	static class Status {
		int r, c;
		int count, key;

		public Status(int r, int c, int count, int key) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				if (map[r][c] == '0') {
					curr = new Status(r, c, 0, 0);
				}

			}
		}
		bfs();
	}

	static void bfs() {
		Queue<Status> queue = new LinkedList<>();
		queue.offer(curr);
		visited[curr.key][curr.r][curr.c] = true;

		while (!queue.isEmpty()) {
			Status temp = queue.poll();
			int count = temp.count;
			int key = temp.key;

			if (map[temp.r][temp.c] == '1') {
				System.out.println(count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (canGo(nr, nc) && !visited[key][nr][nc]) {

					if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
						int tempKey = (1 << (map[nr][nc] - 'a')) | key;
//						System.out.println(tempKey);
						queue.offer(new Status(nr, nc, count + 1, tempKey));
						visited[tempKey][nr][nc] = true;
						visited[key][nr][nc] = true;
					}

					else if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
						int door = (1 << (map[nr][nc] - 'A')) & key;

						if (door > 0) {
							queue.offer(new Status(nr, nc, count + 1, key));
							visited[key][nr][nc] = true;
						}
					} else {
						visited[key][nr][nc] = true;
						queue.offer(new Status(nr, nc, count + 1, key));
					}

				}

			}

		}

		System.out.println(-1);

	}

	static boolean canGo(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] != '#';
	}
}
