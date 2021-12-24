package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S5_11651_좌표_정렬하기2 {

	static int N;
	static StringTokenizer st;

	static class Position implements Comparable<Position> {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Position o) {
			if (this.c == o.c)
				return this.r - o.r;
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		List<Position> list = new ArrayList<>();
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Position(r,c));
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size() ; i++) {
			Position temp = list.get(i);
			sb.append(temp.r).append(" ").append(temp.c).append("\n");
		}
		System.out.println(sb.toString());
	}
}
