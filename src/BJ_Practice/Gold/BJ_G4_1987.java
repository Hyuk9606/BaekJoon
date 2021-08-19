package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1987 {
	static int R, C;
	static char[][] data;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int max = Integer.MIN_VALUE;
	static String s;
	static int cnt;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][C];
//		count = new int[R][C];

		for (int i = 0; i < R; i++) {
			data[i] = br.readLine().toCharArray();
		}
		s = String.valueOf(data[0][0]);
		cnt = 1;
		dfs(0, 0);
//		for (int[] x : count)
//			System.out.println(Arrays.toString(x));
		System.out.println(max);
	}

	static void dfs(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if (isIn(nr, nc) && !s.contains(String.valueOf(data[nr][nc]))) {
				s = s.concat(String.valueOf(data[nr][nc]));
				cnt++;
				dfs(nr, nc);
			}
		}

		max = max < cnt ? cnt : max;
		s = s.substring(0, s.length() - 1);
		cnt--;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
