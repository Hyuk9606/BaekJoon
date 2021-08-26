package BJ_Practice.Fail;

import java.io.*;
import java.util.*;

public class X_BJ_G3_2571 {
	static int N;
	static char[][] map = new char[101][101];
	static StringTokenizer st;
	static int[][][] check = new int[101][101][2];



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {

						map[j][k] = 'x';
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j] == 'x') {
					check[i][j][0] = check[i][j - 1][0] + 1;
				}
				if (map[j][i] == 'x') {
					check[j][i][1] = check[j - 1][i][1] + 1;
				}
			}
		}
		int mul = 0;
		int cnt = 1;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (check[i][j][1] != 0 && check[i][j - 1][1] == check[i][j][1]) {
					cnt++;

				} else {
					mul = check[i][j - 1][1] * cnt;
					max = max < mul ? mul : max;
					cnt = 1;
				}
			}
		}

		int cnt2 = 1;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (check[j][i][0] != 0 && check[j - 1][i][0] == check[j][i][0]) {
					cnt2++;
				} else {
					mul = check[j - 1][i][0] * cnt2;
					max = max < mul ? mul : max;
					cnt2 = 1;
				}
			}
		}

		System.out.println(max);
	}
}
