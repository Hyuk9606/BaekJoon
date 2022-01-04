package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_15684_사다리_조작 {

	static int N, M, H;
	static int[][] ladder;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ladder[r][c] = 1;
		}

		if (check()) {
			System.out.println(0);
			return;
		}
		
		for (int r = 1; r <= H; r++) {
			for (int c = 1; c < N; c++) {
				if (ladder[r][c] == 1)
					continue;
				if (c > 1 && ladder[r][c - 1] == 1) {
					continue;
				}
				if (c < N - 1 && ladder[r][c + 1] == 1) {
					continue;
				}
				ladder[r][c] = 1;
				if (!check()) {
					ladder[r][c] = 0;
				} else {
					System.out.println(1);
					return;
				}
			}
		}

		for (int r1 = 1; r1 <= H; r1++) {
			for (int c1 = 1; c1 < N; c1++) {
				if (ladder[r1][c1] == 1)
					continue;
				if (c1 > 1 && ladder[r1][c1 - 1] == 1) {
					continue;
				}
				if (c1 < N - 1 && ladder[r1][c1 + 1] == 1) {
					continue;
				}
				ladder[r1][c1] = 1;
				for (int r2 = r1; r2 <= H; r2++) {
					for (int c2 = 1; c2 < N; c2++) {
						if (ladder[r2][c2] == 1) {
							continue;
						}
						if (c2 > 1 && ladder[r2][c2 - 1] == 1) {
							continue;
						}
						if (c2 < N - 1 && ladder[r2][c2 + 1] == 1) {
							continue;
						}
						ladder[r2][c2] = 1;
						if (!check()) {
							ladder[r2][c2] = 0;
						} else {
							System.out.println(2);
							return;
						}
					}
				}
				ladder[r1][c1] = 0;
			}
		}

		for (int r1 = 1; r1 <= H; r1++) {
			for (int c1 = 1; c1 < N; c1++) {
				if (ladder[r1][c1] == 1)
					continue;
				if (ladder[r1][c1 - 1] == 1) {
					continue;
				}
				if (ladder[r1][c1 + 1] == 1) {
					continue;
				}
				ladder[r1][c1] = 1;
				for (int r2 = r1; r2 <= H; r2++) {
					for (int c2 = 1; c2 < N; c2++) {
						if (ladder[r2][c2] == 1) {
							continue;
						}
						if (ladder[r2][c2 - 1] == 1) {
							continue;
						}
						if (ladder[r2][c2 + 1] == 1) {
							continue;
						}
						ladder[r2][c2] = 1;
						for (int r3 = r2; r3 <= H; r3++) {
							for (int c3 = 1; c3 < N; c3++) {
								if (ladder[r3][c3] == 1)
									continue;
								if (ladder[r3][c3 - 1] == 1) {
									continue;
								}
								if (ladder[r3][c3 + 1] == 1) {
									continue;
								}
								ladder[r3][c3] = 1;
								if (!check()) {
									ladder[r3][c3] = 0;
								} else {
									System.out.println(3);
									return;
								}
							}
						}
						ladder[r2][c2] = 0;
					}
				}
				ladder[r1][c1] = 0;
			}
		}
		System.out.println(-1);

	}

	static void comb(int cnt) {

	}

	static boolean check() {
		for (int i = 1; i <= N; i++) {
			int currPosition = i;
			int start = 1;
			while (start <= H) {
				if (ladder[start][currPosition] == 1) {
					currPosition++;
					start++;
				} else if (ladder[start][currPosition - 1] == 1) {
					currPosition--;
					start++;
				} else {
					start++;
				}
			}
			if (i != currPosition)
				return false;
		}
	
		return true;
	}
}
