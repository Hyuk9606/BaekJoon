package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G1_1275_커피숍2 {

	static int N, Q;
	static long[] arr, tree;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		arr = new long[N+1];
		tree = new long[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			update(i, arr[i]);
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());


			sb.append(intervalSum(Math.min(x, y),Math.max(x,y))).append("\n");
			update(a, b-arr[a]);
			arr[a] = b;
		}
		System.out.println(sb.toString());

	}

	static long prefixSum(int i) {
		long result = 0;
		while (i > 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}

	static void update(int i, long dif) {
		while (i <= N) {
			tree[i] += dif;
			i += (i & -i);
		}
	}

	static long intervalSum(int start, int end) {
		return prefixSum(end) - prefixSum(start - 1);
	}

}
