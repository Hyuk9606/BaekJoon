package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_1992 {
	static int N;
	static char[][] map;
	static String str = "";
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		if (N == 1) {
			sb.append("1");
		} else {
			str = str.concat("(");
			visit(0, 0, N);
			str = str.concat(")");
			for (int i = 0; i < 16; i++) {
				str = str.replace("0000", "0");
				str = str.replace("1111", "1");
				str = str.replace("(0)", "0");
				str = str.replace("(1)", "1");
			}
			str = str.replace(" ", "");

			sb.append(str);
		}
		System.out.println(sb);
	}

	static void visit(int r, int c, int size) {

		if (size == 2) {
			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 2; j++) {
					str = str.concat(String.valueOf(map[i][j]));
				}

			}
			return;
		}
		size /= 2;
		str = str.concat("(");
		visit(r, c, size);
		str = str.concat(")");

		str = str.concat("(");
		visit(r, c + size, size);
		str = str.concat(")");

		str = str.concat("(");
		visit(r + size, c, size);
		str = str.concat(")");

		str = str.concat("(");
		visit(r + size, c + size, size);
		str = str.concat(")");

	}

}
