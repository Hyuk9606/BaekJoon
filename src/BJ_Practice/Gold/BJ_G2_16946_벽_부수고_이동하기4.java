package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_16946_벽_부수고_이동하기4 {
	static int N, M;
	static int step = 1;
	static List<Integer> data = new ArrayList<>();
	static int[][] map;
	static int[][] answer;
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
		answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					bfs(new RC(i, j));
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					answer[i][j]++;
					for (int k = 0; k < 4; k++) {
						int nr = i + deltas[k][0];
						int nc = j + deltas[k][1];
						if(isIn(nr,nc) && map[nr][nc] != 1) {
							set.add(map[nr][nc] -2);
						}
					}
					for(int itr : set) {
						answer[i][j] += data.get(itr);
					}
					answer[i][j] %= 10;
					set.clear();
				} 
			}
		}
		for(int[] r : answer) {
			for(int c : r) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void bfs(RC rc) {
		Queue<RC> queue = new LinkedList<>();
		step++;
		queue.offer(rc);
		map[rc.r][rc.c] = step;
		int count = 1;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + deltas[i][0];
				int nc = temp.c + deltas[i][1];

				if (isIn(nr, nc) && map[nr][nc] == 0) {
					queue.offer(new RC(nr, nc));
					map[nr][nc] = step;
					count++;
				}
			}
		}
		data.add(count);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
