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

public class BJ_S1_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;

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

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					list.add(bfs(new RC(i,j)));
				}
			}
		}
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int a : list) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());

	}

	static int bfs(RC rc) {
		Queue<RC> queue = new LinkedList<>();
		int count = 1;
		queue.offer(rc);
		visited[rc.r][rc.c] = true;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];
				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					queue.offer(new RC(nr, nc));
					visited[nr][nc] = true;
					count++;
				}
			}
		}
		return count;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
