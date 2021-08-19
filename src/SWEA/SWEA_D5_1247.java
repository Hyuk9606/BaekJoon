package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D5_1247 {
	static int T, N;
	static StringTokenizer st;
	static List<XY> list = new LinkedList<>();

	static class XY {
		int r;
		int c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}

	}

	static boolean np(int[] num) {
		int a = num.length;
		int i = a - 1;
		while (i > 0 && num[i - 1] >= num[i])
			--i;
		if (i == 0)
			return false;
		int j = a - 1;
		while (num[i - 1] >= num[j])
			--j;
		swap(i - 1, j, num);
		int k = a - 1;
		while (k > i) {
			swap(k--, i++, num);
		}
		return true;
	}

	static void swap(int i, int j, int[] num) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list.clear();
			int min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			XY company = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			XY home = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; i++) {
				list.add(new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = i;
			}
			do {
				int sum = 0;
				sum += Math.abs(company.r - list.get(num[0]).r) + Math.abs(company.c - list.get(num[0]).c);
				sum += Math.abs(home.r - list.get(num[N - 1]).r) + Math.abs(home.c - list.get(num[N - 1]).c);
				for (int i = 0; i < N - 1; i++) {
					sum += Math.abs(list.get(num[i]).r - list.get(num[i + 1]).r)
							+ Math.abs(list.get(num[i]).c - list.get(num[i + 1]).c);
				}
				min = sum < min ? sum : min;

			} while (np(num));
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
