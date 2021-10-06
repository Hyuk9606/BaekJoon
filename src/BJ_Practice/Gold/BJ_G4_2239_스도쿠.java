package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_2239_스도쿠 {
	static int[][] sdoku = new int[9][9];
	static StringTokenizer st;
	static List<RC> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = null;
		for (int i = 0; i < 9; i++) {
			str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = str.charAt(j) - '0';
				if (sdoku[i][j] == 0)
					list.add(new RC(i, j));
			}
		}
		solve(0);
	}

	static void solve(int idx) {
		if (idx == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sdoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);

		}
		RC temp = list.get(idx);

		for (int i = 1; i <= 9; i++) {
			if (check(temp.r, temp.c, i)) {
				sdoku[temp.r][temp.c] = i;
				solve(idx + 1);
				sdoku[temp.r][temp.c] = 0;
			}
		}

	}

	static boolean check(int tr, int tc, int v) {

		for (int c = 0; c < 9; c++) {
			if (sdoku[tr][c] == v)
				return false;
		}
		for (int r = 0; r < 9; r++) {
			if (sdoku[r][tc] == v)
				return false;
		}

		int rr = tr / 3 * 3;
		int cc = tc / 3 * 3;

		for (int r = rr; r < rr + 3; r++) {
			for (int c = cc; c < cc + 3; c++) {
				if (sdoku[r][c] == v)
					return false;
			}
		}

		return true;
	}
}
