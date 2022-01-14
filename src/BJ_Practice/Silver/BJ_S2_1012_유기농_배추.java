package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농_배추 {
	static int T;
	static int N, M, K;
	static int[][] map;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int Answer;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						bfs(r,c);
						Answer++;
					}
				}
			}
			sb.append(Answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		map[r][c] = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + deltas[i][0];
				int nc = temp[1] + deltas[i][1];
				
				if(isIn(nr,nc)&& map[nr][nc] == 1) {
					queue.offer(new int[] {nr,nc});
					map[nr][nc] = 0;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
