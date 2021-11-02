package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1600_말이_되고픈_원숭이 {
	static int K, W, H;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] holse = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][][] visited;
	static StringTokenizer st;

	static class RC {
		int r, c, cnt;

		public RC(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new int[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(-1);
	}

	static void bfs() {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(new RC(0, 0, 0));
		for (int i = 0; i <= K; i++) {
			visited[0][0][i] = 1;
		}

		while (!queue.isEmpty()) {
			RC temp = queue.poll();
			
			if(temp.r == H-1 && temp.c == W-1) {
				System.out.println(visited[temp.r][temp.c][temp.cnt]-1);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && map[nr][nc] == 0 && visited[nr][nc][temp.cnt] == 0) {
					queue.offer(new RC(nr, nc, temp.cnt));
					visited[nr][nc][temp.cnt] = visited[temp.r][temp.c][temp.cnt] + 1;
				}
			}
			if (temp.cnt < K) {
				for (int i = 0; i < 8; i++) {
					int nr = temp.r + holse[i][0];
					int nc = temp.c + holse[i][1];
					if (isIn(nr, nc) && map[nr][nc] == 0 && visited[nr][nc][temp.cnt + 1] == 0) {
						queue.offer(new RC(nr,nc,temp.cnt+1));
						visited[nr][nc][temp.cnt+1] = visited[temp.r][temp.c][temp.cnt] +1;
					}
				}
			}

		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}
}
