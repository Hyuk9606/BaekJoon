package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_4014_활주로_건설 {
	static int T, N, X;
	static int[][] map;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;

			for (int i = 0; i < N; i++) {
				boolean flag = true;

				for (int j = 1; j < N; j++) {
					if (Math.abs(map[i][j] - map[i][j - 1]) >= 2)
						flag = false;
				}
				if (!flag)
					continue;

				int prev = map[i][0];
				int cnt = 1;
				for (int j = 1; j < N; j++) {
					if (prev == map[i][j])
						cnt++;
					else if (prev < map[i][j]) {
						if (cnt >= X) {
						} else {
							flag = false;
						}
						prev = map[i][j];
						cnt = 1;
					} else {
						prev = map[i][j];
						cnt = 1;
						for (int j2 = 1; j2 < X; j2++) {
							if (j + j2 >= N)
								break;
							if (prev == map[i][j + j2])
								cnt++;
						}
						if (cnt != X)
							flag = false;
						j = j + X - 1;
						cnt = 0;
					}
				}
				if (flag)
					answer++;
			}

			for (int i = 0; i < N; i++) {
				boolean flag = true;

				for (int j = 1; j < N; j++) {
					if (Math.abs(map[j][i] - map[j - 1][i]) >= 2)
						flag = false;
				}
				if (!flag)
					continue;

				int prev = map[0][i];
				int cnt = 1;
				for (int j = 1; j < N; j++) {
					if (prev == map[j][i])
						cnt++;
					else if (prev < map[j][i]) {
						if (cnt >= X) {
						} else {
							flag = false;
						}
						prev = map[j][i];
						cnt = 1;
					} else {
						prev = map[j][i];
						cnt = 1;
						for (int j2 = 1; j2 < X; j2++) {
							if (j + j2 >= N)
								break;
							if (prev == map[j + j2][i])
								cnt++;
						}
						if (cnt != X)
							flag = false;
						j = j + X - 1;
						cnt = 0;
					}

				}
				if (flag)
					answer++;
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}
}
