package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G1_2268_수들의_합7 {
	static int N, M, K;
	static long[] BIT;
	static long[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N + 1];
		BIT = new long[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(b, c - data[b]);
				data[b] = c;
			} else {
				sb.append(IntervalSum(Math.min(b, c),Math.max(b, c))).append("\n");
			}
		}
		System.out.println(sb);

	}

	static void update(int i, long num) {
		while (i <= N) {
			BIT[i] += num;
			i += (i & -i);
		}
	}

	static long prefixSum(int i) {
		long result = 0;
		while (i > 0) {
			result += BIT[i];
			i -= (i & -i);
		}
		return result;
	}

	static long IntervalSum(int start, int end) {
		return prefixSum(end) - prefixSum(start - 1);
	}
}
