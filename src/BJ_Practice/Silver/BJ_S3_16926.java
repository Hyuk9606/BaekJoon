package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_16926 {
	static int N, M, R;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			int r = 0, c = 0;
			int nc, nr;
			visited = new boolean[N][M];
			while (true) {

				int temp = map[r][c];
				for (int x = 0; x < 4; x++) {
					nr = r + deltas[x][0];
					nc = c + deltas[x][1];
					while (isIn(nr, nc) && visited[nr][nc] == false) {
						map[r][c] = map[nr][nc];
						visited[r][c] = true;
						r = nr;
						c = nc;
						nr += deltas[x][0];
						nc += deltas[x][1];
					}
				}
				map[r][c] = temp;
				c = c + 1;
				if (visited[r][c] == true)
					break;
			}

		}
		for (int[] x : map) {
			for (int xx : x)
				sb.append(xx).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
