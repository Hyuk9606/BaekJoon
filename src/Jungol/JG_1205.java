package Jungol;

import java.io.*;
import java.util.*;

public class JG_1205 {
	static int N, ans;
	static StringTokenizer st;

	static class Gap {
		int start;
		int end;
		int cnt;

		public Gap(int start, int end, int cnt) {
			super();
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + ", cnt=" + cnt + "]\n";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Gap> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			if (data[i] == 0)
				cnt++;
		}
		ans = cnt;
		Arrays.sort(data);
	
		for (int i = cnt; i <= N - 1; i++) {
			int s = data[i];
			int x = 1;
			while (i < N - 1 && (data[i] == data[i + 1] || data[i] + 1 == data[i + 1])) {
				if (data[i] != data[i + 1]) {
					x++;
				}
				i++;
				if (i == N - 1) {
					break;
				}
			}
			int e = data[i];
			list.add(new Gap(s, e, x));
		}

		for (int i = 0; i <= list.size() - 1; i++) {
			int gap = cnt;
			int sum = 0;
			sum += list.get(i).cnt;
			if (i == list.size() - 1) {
				ans = Math.max(ans, sum + gap);
				break;
			}
			int k = i;
			while (k < list.size() - 1 && list.get(k + 1).start - list.get(k).end - 1 <= gap && cnt != 0) {
				sum += list.get(k + 1).cnt + list.get(k + 1).start - list.get(k).end - 1;
				gap -= list.get(k + 1).start - list.get(k).end - 1;
				k++;
			}
			ans = Math.max(ans, sum + gap);
		}
		System.out.println(ans);

	}
}
