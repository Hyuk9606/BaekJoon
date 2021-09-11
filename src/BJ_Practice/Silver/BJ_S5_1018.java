package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_1018 {
	static int N, M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		char ch1 = 'W';
		char ch2 = 'B';
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int count1 = 0;
				int count2 = 0;
				for (int r = i; r < i + 8; r++) {
					ch1 = ch1 == 'B' ? 'W' : 'B';
					ch2 = ch2 == 'B' ? 'W' : 'B';
					for (int c = j; c < j + 8; c++) {
						if (map[r][c] != ch1)
							count1++;
						ch1 = ch1 == 'B' ? 'W' : 'B';
						if (map[r][c] != ch2)
							count2++;
						ch2 = ch2 == 'B' ? 'W' : 'B';

					}
				}
				min = Integer.min(min, count1);
				min = Integer.min(min, count2);
			}
		}
		System.out.println(min);
	}
}
