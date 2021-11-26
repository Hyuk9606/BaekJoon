package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_7562_나이트의_이동 {

	static int T, N;
	static int[][] map;
	static RC start,end;
	static boolean[][] visited;
	static int[][] deltas = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
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

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			start = new RC(r, c);
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			end = new RC(r, c);
//			if(start.r == end.r && start.c == end.c) System.out.println(1);
			System.out.println(bfs(start));
		}
	}

	static int bfs(RC rc) {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(rc);
		visited[rc.r][rc.c] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for (int step = 0; step < size; step++) {

				RC temp = queue.poll();
				
				if(temp.r == end.r && temp.c == end.c) {
					return cnt-1;
				}

				for (int i = 0; i < 8; i++) {
					int nr = temp.r + deltas[i][0];
					int nc = temp.c + deltas[i][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						queue.offer(new RC(nr,nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		return 0;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

