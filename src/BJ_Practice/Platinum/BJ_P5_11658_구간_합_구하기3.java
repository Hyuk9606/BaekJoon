package BJ_Practice.Platinum;

import java.io.*;
import java.util.*;

public class BJ_P5_11658_구간_합_구하기3 {
	static int N, M;
	static int data[][];
	static int BIT[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		BIT = new int[N + 1][N + 1];
		data = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				update(i, j, data[i][j]);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if (w == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update(x,y,c-data[x][y]);
				data[x][y] = c;
			}else {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				sb.append(intervalSum(x1, y1, x2, y2)).append("\n");
			}
		}
		System.out.println(sb);
		for (int i = 0; i <= N ; i++) {
//			System.out.println(Arrays.toString(BIT[i]));
		}

	}

	static void update(int x, int y, int number) {
		while (x <= N) {
			int tempY = y;
			while (tempY <= N) {
				BIT[x][tempY] += number;
				tempY += (tempY & -tempY);
			}
			x += (x & -x);
		}
	}

	static int prefixSum(int x, int y) {
		int result = 0;
		while (x > 0) {
			int tempY = y;
			while (tempY > 0) {
				result += BIT[x][tempY];
				tempY -= (tempY & -tempY);
			}
			x -= (x & -x);
		}
		return result;
	}

	static int intervalSum(int x1, int y1, int x2, int y2) {
		return prefixSum(x2, y2) + prefixSum(x1 - 1, y1 - 1) - prefixSum(x2, y1 - 1) - prefixSum(x1 - 1, y2);
	}

}
