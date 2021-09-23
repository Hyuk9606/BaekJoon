package Jungol;

import java.io.*;
import java.util.*;

public class JG_1681 {
	static int N, answer = 999999;
	static int[][] map;
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N];
		visited[0] = true;

		comb(1, 0, 0);
		System.out.println(answer);
	}

	private static void comb(int cnt, int cur, int sum) {
		if (sum > answer)
			return;
		if (cnt == N) {
			if (map[cur][0] != 0 && answer > sum + map[cur][0]) {
				answer = sum + map[cur][0];
			}
			return;
		}
		for (int i = 1; i < N; i++) {
			if (map[cur][i] == 0 || visited[i])
				continue;
			visited[i] = true;
			comb(cnt + 1, i, sum + map[cur][i]);
			visited[i] = false;
		}
	}

}
