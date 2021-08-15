package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_17135 {
	static int N, M, D;
	static List<Enemy> enemies;
	static int max = Integer.MIN_VALUE;

	static StringTokenizer st;

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c > 0 && c < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		enemies = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					enemies.add(new Enemy(r, c));
				}
			}
		}
		combination(3, new int[3], 0);
		System.out.println(max);
	}

	static void combination(int cnt, int[] choosed, int start) {
		if (cnt == 0) {
			check(choosed);
			return;
		}

		for (int i = start; i < M; i++) {
			choosed[cnt - 1] = i;
			combination(cnt - 1, choosed, i + 1);
		}
	}

	static void check(int[] positions) {
		List<Enemy> copied = new ArrayList<>();
		for (Enemy e : enemies) {
			copied.add(new Enemy(e.r, e.c));
			;
		}
		int deadMan = 0;

		while (true) {

			for (int i = 0; i < positions.length; i++) {
				Enemy target = null;
				int archer = positions[i];

				for (Enemy enemy : copied) {
					enemy.setDistance(archer);

					if (enemy.d <= D) {

						if (target == null || target.compareTo(enemy) > 0) {
							target = enemy;
						}
					}
				}
				if (target != null) {
					target.isTargeted = true;
				}
			}

			for (int e = copied.size() - 1; e >= 0; e--) {
				Enemy enemy = copied.get(e);

				if (enemy.isTargeted) {
					copied.remove(enemy);
					deadMan++;
				} else if (enemy.r == N - 1) {
					copied.remove(enemy);
				} else {
					enemy.r++;
				}
			}

			if (copied.size() == 0) {
				break;
			}
		}
		max = Math.max(max, deadMan);
	}

	static class Enemy implements Comparable<Enemy> {
		int r, c, d;
		boolean isTargeted;

		public Enemy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void setDistance(int archorCol) {
			d = Math.abs(archorCol - this.c) + Math.abs(N - this.r);
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", d=" + d + ", inTargeted=" + isTargeted + "]";
		}

		@Override
		public int compareTo(Enemy o) {
			if (this.d == o.d) {
				return Integer.compare(this.c, o.c); 
			} else {
				return Integer.compare(this.d, o.d);
			}
		}

	}
}
