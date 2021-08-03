package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_1210 {
	static int[][] ladder = new int[100][100];

	static boolean isIn(int c) {
		return c >= 0 && c < 100;
	}

	static int[][] deltas = { { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SWEA1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t < 11; t++) {
			br.readLine();
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++)
					ladder[r][c] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;

			for (int c = 0; c < 100; c++) {
				if (ladder[99][c] == 2) {
					ans = c;
					break;
				}
			}
			int r = ladder.length - 1;
			int c = ans;
			outer: while (r > 0) {
				for (int i = 0; i < 2; i++) {
					int nc = c + deltas[i][1];
					while (isIn(nc) && ladder[r][nc] == 1) {
						c = nc;
						nc = c + deltas[i][1];
						if (isIn(nc)&&ladder[r][nc] == 0) {
							r--;
							continue outer;
						}
					}
				}
				r--;

			}
			sb.append("#").append(t).append(" ").append(c).append("\n");
		}
		System.out.println(sb.toString());
	}
}
