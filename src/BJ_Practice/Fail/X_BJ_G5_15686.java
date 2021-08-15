package BJ_Practice.Fail;

import java.io.*;
import java.util.*;

public class X_BJ_G5_15686 {
	static int N, M;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;

	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}

	static List<XY> home = new ArrayList<>();
	static List<XY> store = new ArrayList<>();

	static void combination(int cnt, int start, int[] selected) {
		if (cnt == M) {
			int dist = 0;
			XY temp;
			for (int i = 0; i < home.size(); i++) {
				temp = home.get(i);
				dist += calcDistance(temp.x, temp.y,selected);
			}
			min = min > dist ? dist : min;
			
			return;

		}
		for (int i = start; i < store.size(); i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1, selected);
		}
	}

	static int calcDistance(int r, int c,int[] selected) {
		int dist = 0;
		XY temp;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <selected.length; i++) {
			temp = store.get(selected[i]);
			dist = Math.abs(r - temp.x) + Math.abs(c - temp.y);
			min = min > dist ? dist : min;
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int num;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 1)
					home.add(new XY(r, c));
				else if (num == 2)
					store.add(new XY(r, c));
			}
		}
		int[] selected = new int[M];
		combination(0, 0, selected);
		System.out.println(min);
	}

}
