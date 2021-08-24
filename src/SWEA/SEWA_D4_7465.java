package SWEA;

import java.io.*;
import java.util.*;

public class SEWA_D4_7465 {
	static int N;
	static int M;
	static int[] p;

	private static void make() {
		p = new int[N + 1];
		for (int i = 0; i <= N; i++) // input
			p[i] = i;
	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	private static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if (xRoot == yRoot)
			return false;

		p[yRoot] = xRoot; // y의 대표자를 x의 대표자로 만듦
		return true;
	}

	static int T;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			make();
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for (int i = 1; i <= N; i++) {
				if(i == p[i]) cnt++;
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
