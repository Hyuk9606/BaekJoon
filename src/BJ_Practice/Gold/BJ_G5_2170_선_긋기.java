package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2170_선_긋기 {

	static int N;
	static StringTokenizer st;

	static class Line implements Comparable<Line> {
		int start, end;

		public Line(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Line o) {
			if (this.start == o.start)
				return this.end - o.end;
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Line [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Line> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Line(start, end));
		}
		int ans = 0;
		int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			Line temp = pq.poll();
			if (end >= temp.start) {
				end = Math.max(temp.end, end);

			} else {
				ans += Math.abs(end - start);
				start = temp.start;
				end = temp.end;
			}
			if (pq.isEmpty()) {
				ans += Math.abs(end - start);

			}
		}
		System.out.println(ans);
	}
}
