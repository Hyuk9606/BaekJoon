package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_20002_사과나무 {
	static int N;
	static int[][] orchard;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		orchard = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				orchard[r][c] = Integer.parseInt(st.nextToken()) + orchard[r - 1][c] + orchard[r][c - 1] - orchard[r-1][c-1];
			}
		}

		int ans= -2000;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int x = i, y = j;
				while(isIn(x,y)){
					ans = Math.max(ans, sum(i,j,x++,y++));
				}
			}
		}
		System.out.println(ans);
	}

	static int sum(int x1, int y1, int x2, int y2) {
		return orchard[x2][y2] + orchard[x1 - 1][y1 - 1] - orchard[x2][y1 - 1] - orchard[x1-1][y2];
	}

	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= N && c <= N;
	}
}
