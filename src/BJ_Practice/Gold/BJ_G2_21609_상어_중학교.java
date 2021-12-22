package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_21609_상어_중학교 {

	static int N, M;
	static int score = 0;
	static int map[][];
	static boolean visited[][];
	static int deltas[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static PriorityQueue<Standard> standardBlockList = new PriorityQueue<>();
	static Queue<Position> queue = new LinkedList<>();
	static StringTokenizer st;
	
	static class Position{
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static class Standard implements Comparable<Standard> {
		int r, c;
		int blockCnt;
		int rainbow;

		public Standard(int r, int c, int blockCnt, int rainbow) {
			super();
			this.r = r;
			this.c = c;
			this.blockCnt = blockCnt;
			this.rainbow = rainbow;
		}

		@Override
		public int compareTo(Standard o) {
			if (this.blockCnt == o.blockCnt)
				if (this.rainbow == o.rainbow)
					if (this.r == o.r)
						return o.c - this.c;
					else
						return o.r - this.r;
				else
					return o.rainbow - this.rainbow;
			else
				return o.blockCnt - this.blockCnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c] && 0 < map[r][c] && map[r][c] <= M) {
						bfs(r, c);
					}
				}
			}
			if (standardBlockList.isEmpty()) {
				break;
			}
			destroy();
			standardBlockList.clear();
			gravity();
			map = rotate();
			gravity();
		}
		System.out.println(score);
	}

	static void bfs(int r, int c) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					visited[i][j] = false;
			}
		}

		queue.offer(new Position(r, c));
		visited[r][c] = true;
		int blockCnt = 1;
		int rainbowCnt = 0;
		int color = map[r][c];

		while (!queue.isEmpty()) {
			Position temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && map[nr][nc] != -1 && (map[nr][nc] == color || map[nr][nc] == 0)
						&& !visited[nr][nc]) {
					queue.offer(new Position(nr, nc));
					visited[nr][nc] = true;
					blockCnt++;
					if (map[nr][nc] == 0)
						rainbowCnt++;
				}
			}
		}

		if (blockCnt >= 2) {
			standardBlockList.offer(new Standard(r, c, blockCnt, rainbowCnt));
		}

	}

	static void destroy() {
		Standard target = standardBlockList.poll();
		score += Math.pow(target.blockCnt, 2);
		
		int color = map[target.r][target.c];
		queue.offer(new Position(target.r, target.c));

		while (!queue.isEmpty()) {
			Position temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == color)) {
					queue.offer(new Position(nr, nc));
					map[nr][nc] = -2;
				}
			}
		}
	}

	static void gravity() {
		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] >= 0) {
					int nr = r + 1;
					while (isIn(nr, c) && map[nr][c] == -2) {
						nr++;
					}
					nr--;
					if (nr == r)
						continue;
					else {
						map[nr][c] = map[r][c];
						map[r][c] = -2;
					}
				}
			}
		}
	}

	static int[][] rotate() {
		int[][] newMap = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				newMap[N - c - 1][r] = map[r][c];
			}
		}

		return newMap;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
