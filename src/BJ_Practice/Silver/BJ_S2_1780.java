package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_1780 {
	static int N;
	static int[] ans = { 0, 0, 0 };
	static int[][] data;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		devide(0, 0, N);
		for(int i : ans) {
			System.out.println(i);
		}

	}

	static void devide(int r, int c, int size) {

		int init = data[r][c];

		if (size == 1) {
			ans[init+1]++;
			return ;
		}

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {

				if (data[i][j] != init) {
					size /= 3;
					for (int k = 0; k < 3; k++)
						for (int z = 0; z < 3; z++)
							devide(r + (k * size), c + (z * size), size);
					return;
				}

			}
		}
		ans[init+1]++;
		return;
	}
}
