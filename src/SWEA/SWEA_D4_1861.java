package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_1861 {
	static int T;
	static int N;
	static int[][] map;
	static Stack<Integer> stack = new Stack<>();

	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		try {
			T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				N = Integer.parseInt(br.readLine());
				map = new int[N][N];

				for (int r = 0; r < N; r++) {
					st = new StringTokenizer(br.readLine());
					for (int c = 0; c < N; c++) {
						map[r][c] = Integer.parseInt(st.nextToken());
					}
				}
				int curR = 0;
				int curC = 0;
				int Answer = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						int cnt = 1;
						curR = r;
						curC = c;
						while (true) {
							for (int i = 0; i < 4; i++) {
								int nr = curR + deltas[i][0];
								int nc = curC + deltas[i][1];
								if (isIn(nr, nc) && map[curR][curC] == map[nr][nc] - 1) {
									curR = nr;
									curC = nc;
									i = -1;
									cnt++;
								}
							}
							break;
						}
						if (cnt != 1 && max < cnt) {
							max = cnt;
							Answer = map[r][c];
						}
						else if(cnt == max) {
							if (Answer > map[r][c]) {
								Answer = map[r][c];
							}
						}
					}
				}
				sb.append("#").append(t).append(" ").append(Answer).append(" ").append(max).append("\n");
			}
		} catch (Exception e) {
		}
		System.out.println(sb);
	}
}
