package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D3_7236 {
	static int T, N;
	static int answer;
	static char[][] map;
	static StringTokenizer st;

	static int count(int r, int c) {
		int cnt = 0;
		if (isIn(r, c) && map[r][c] == 'W')
			cnt++;
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			answer = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int depth = 0;
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if (!(i == 0 && j == 0))
								depth += count(r + i, c + j);
						}
					}
					answer = Math.max(answer, depth);
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}
}
