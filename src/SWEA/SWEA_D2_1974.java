package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D2_1974 {
	static int T;
	static int[][] map;
	static StringTokenizer st;

	static boolean check1(int r) {
		int sum = 45;
		for (int i = 0; i < 9; i++) {
			sum -= map[r][i];
		}
		if (sum == 0)
			return true;
		else
			return false;
	}

	static boolean check2(int c) {
		int sum = 45;
		for (int i = 0; i < 9; i++) {
			sum -= map[i][c];
		}
		if (sum == 0)
			return true;
		else
			return false;
	}

	static boolean check3(int r, int c) {
		int sum = 45;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				sum -= map[i][j];
			}
		}
		if (sum == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int Answer = 1;

			outer: for (int i = 0; i < 9; i++) {
				if (!check1(i)) {
					Answer = 0;
					break outer;
				}
				if (!check2(i)) {
					Answer = 0;
					break outer;
				}

				for (int j = 0; j < 9; j++)
					if (i % 3 == 0 && j % 3 == 0)
						if (!check3(i, j)) {
							Answer = 0;
							break outer;
						}
			}
			sb.append("#").append(t).append(" ").append(Answer).append("\n");
		}
		System.out.println(sb);
	}
}
