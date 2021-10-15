package Jungol;

import java.io.*;
import java.util.*;

public class JG_1169_주사위던지기1 {
	static int N, M;
	static int numbers[];
	static boolean selected[] = new boolean[7];

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		if (M == 1)
			dice1(0);
		else if (M == 2)
			dice2(0, 1);
		else
			dice3(0);
	}

	static void dice1(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt + 1);
		}
	}

	static void dice2(int cnt, int start) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= 6; i++) {

			numbers[cnt] = i;
			selected[i] = true;
			dice2(cnt + 1, i);
			selected[i] = false;
		}

	}

	static void dice3(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (selected[i])
				continue;
			numbers[cnt] = i;
			selected[i] = true;
			dice3(cnt + 1);
			selected[i] = false;
		}
	}
}
