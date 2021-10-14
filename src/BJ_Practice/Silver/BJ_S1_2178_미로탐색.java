package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2178_미로탐색 {
	static int N,M;
	static int[][] map;
	static int[][] visited;

	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
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
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs(new RC(0,0)));
		

	}

	static int bfs(RC rc) {
		Queue<RC> queue = new LinkedList<>();
		queue.offer(rc);
		visited[rc.r][rc.c] = 1;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				if (isIn(nr, nc) && visited[nr][nc]==0 && map[nr][nc] == 1) {
					queue.offer(new RC(nr, nc));
					visited[nr][nc] = visited[temp.r][temp.c]+1;
				}
			}
		}
		return visited[N-1][M-1];

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
