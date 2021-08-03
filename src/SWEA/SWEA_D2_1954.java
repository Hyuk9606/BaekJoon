package SWEA;

import java.util.*;

public class SWEA_D2_1954 {
	static int T;
	static int N;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] snale;

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			snale = new int[N][N];
			int cnt = 1;
			int r = 0;
			int c = 0;
			int i = 0;
			while (cnt <= N * N) {
				snale[r][c] = cnt++;
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				if (!isIn(nr, nc) || snale[nr][nc] != 0) {
					i = (i + 1) % 4;

					r = r + deltas[i][0];
					c = c + deltas[i][1];
				} else {
					r = r + deltas[i][0];
					c = c + deltas[i][1];
				}

			}
			System.out.println("#"+t);
			for (int[] x : snale) {
				for(int x2 : x) {
					System.out.print(x2+" ");
				}
				System.out.println();
			}
				
		}
	}
}
