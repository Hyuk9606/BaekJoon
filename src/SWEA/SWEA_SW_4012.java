package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_4012 {
	static int T, N;
	static int min;
	static int A, B;
	static int[][] S;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					S[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] selected = new boolean[N];
			min = Integer.MAX_VALUE;
			A = 0;
			B = 0;
			comb(0, 0, selected);

			sb.append("#").append(t).append(" ").append(min).append("\n");

		}
		System.out.print(sb);
	}

	static void comb(int cnt, int start, boolean[] sel) {
		if (cnt == N / 2) {

			int A = 0, B = 0;
			int[] arr1 = new int[N / 2];
			int[] arr2 = new int[N / 2];
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] == true) {
					arr1[A++] = i;
				} else
					arr2[B++] = i;
			}
			A = 0;
			B = 0;

			int[] P = new int[N / 2];
			int cnt2 = 0;
			while (++cnt2 <= 2)
				P[N / 2 - cnt2] = 1;

			do {
				int a = -1, b = -1;
				for (int i = 0; i < N / 2; i++) {
					if (P[i] == 1) {
						if (a == -1)
							a = i;
						b = i;
					}
				}

				A += S[arr1[a]][arr1[b]] + S[arr1[b]][arr1[a]];
				B += S[arr2[a]][arr2[b]] + S[arr2[b]][arr2[a]];

//				np(arr2);
			} while (np(P));

			int a = Math.abs(A - B);
			min = min > a ? a : min;
			return;
		}
		for (int i = start; i < N; i++) {
			if (sel[i] == true)
				continue;

			sel[i] = true;
			comb(cnt + 1, i + 1, sel);
			sel[i] = false;
		}
	}

	private static boolean np(int[] numbers) {
		int N = numbers.length;

		int i = N - 1;

		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		swap(numbers, i - 1, j);

		int k = N - 1;
		while (i <= k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
