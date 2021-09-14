package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_1463 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		} else if (N < 4) {
			System.out.println(1);
			return;
		}

		int[] D = new int[N + 1];
		for (int i = 1; i < 4; i++) {
			D[i] = 1;
		}
		for (int i = 4; i <= N; i++) {
			int cur = i;
			D[i] = i;
			if (i % 3 == 0)
				D[i] = Integer.min(D[i / 3] + 1, D[i]);
			if (i % 2 == 0)
				D[i] = Integer.min(D[i / 2] + 1, D[i]);

			D[i] = Integer.min(D[i - 1] + 1, D[i]);

		}
		System.out.println(D[N]);
	}

}
