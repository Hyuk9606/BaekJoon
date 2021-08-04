package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D2_2001 {

	static int T;
	static int N;
	static int M;
	static int[][] map;

	static int sum;
	static int max;

	static int search(int r, int c) {
		sum = 0;
		for (int i = r; i < r + M; i++) {
			for (int j = c; j < c + M; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static void kill() {
		max = Integer.MIN_VALUE;
		for (int r = 0; r <= N - M; r++) {
			for (int c = 0; c <= N - M; c++) {
				int killPoint = search(r, c);
				if (max < killPoint)
					max = killPoint;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			kill();
			System.out.println("#"+t+" " + max);

		}
	}
}
