package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_4963_섬의개수 {
	static int H, W;
	static int[][] map;
	static int[][] deltas = { {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1} };
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

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (H == 0 && W == 0)
				break;

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 1) {
						bfs(new RC(i,j));
						cnt++;
					}
				}
				System.out.println(Arrays.toString(map[i]));
			}
			sb.append(cnt).append("\n");

		}
		System.out.println(sb.toString());
	}

	static void bfs(RC rc) {
		Queue<RC> queue = new LinkedList<>();

		queue.offer(rc);
		map[rc.r][rc.c] = -1;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				
				if(isIn(nr,nc) && map[nr][nc] == 1) {
					queue.offer(new RC(nr,nc));
					map[nr][nc] = -1;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}

}
