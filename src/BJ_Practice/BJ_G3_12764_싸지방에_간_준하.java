package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G3_12764_싸지방에_간_준하 {

	static int N;
	static StringTokenizer st;

	static class Seat {
		int no;
		int start, end;

		public Seat(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Seat [no=" + no + ", start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Seat> startQ = new PriorityQueue<>(new Comparator<Seat>() {

			@Override
			public int compare(Seat o1, Seat o2) {
				return o1.start - o2.start;
			}

		});
		PriorityQueue<Seat> endQ = new PriorityQueue<>(new Comparator<Seat>() {

			@Override
			public int compare(Seat o1, Seat o2) {
				return o2.end - o1.end;
			}

		});

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			startQ.offer(new Seat(-1, start, end));
		}
		int seat = 1;
		while (!startQ.isEmpty()) {
			Seat temp = startQ.poll();

			if (endQ.isEmpty()) {
				temp.no = seat++;
				endQ.offer(temp);
			} else {
				while(temp.start < endQ.peek().end) {
					temp.no = seat++;
					endQ.offer(temp);
				} 
				if (temp.start >= endQ.peek().end) {
					temp.no = endQ.poll().no;
					endQ.offer(temp);
				}
			}
			System.out.println(temp);
		}
		System.out.println(seat);
	}
}
