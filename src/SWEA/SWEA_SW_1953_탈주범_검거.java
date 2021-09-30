package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_1953_탈주범_검거 {
	static int T;
	static int N, M, R, C, Hour;
	static int[][] map;
	static int[][][] deltas = { { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }, { { 1, 0 }, { -1, 0 } },
			{ { 0, 1 }, { 0, -1 } }, { { 0, 1 }, { -1, 0 } }, { { 1, 0 }, { 0, 1 } }, { { 0, -1 }, { 1, 0 } },
			{ { -1, 0 }, { 0, -1 } } };
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

		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			Hour = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			int[][] visited = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<RC> queue = new LinkedList<>();
			
			queue.add(new RC(R, C));
			visited[R][C]++;
			while (!queue.isEmpty()) {
				RC temp = queue.poll();
				int r = temp.r;
				int c = temp.c;
				int step = map[r][c]-1;
				for (int i = 0; i < deltas[step].length; i++) {
					int nr = r + deltas[step][i][0];
					int nc = c + deltas[step][i][1];
					if(isIn(nr,nc) && map[nr][nc] != 0 && visited[nr][nc] == 0) {
						
						int step2 = map[nr][nc]-1;
						for (int j = 0; j < deltas[step2].length ; j++) {
							int nnr = nr + deltas[step2][j][0];
							int nnc = nc + deltas[step2][j][1];
							if(nnr == r && nnc == c) {
								visited[nr][nc] = visited[r][c] + 1;
								queue.offer(new RC(nr,nc));
								break;
							}
						}
					}
					
				}
			}
			
//			for (int i = 0; i < N ; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			
			int answer = 0;
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M ; j++) {
					if(visited[i][j] > 0 && visited[i][j] <= Hour) answer++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
