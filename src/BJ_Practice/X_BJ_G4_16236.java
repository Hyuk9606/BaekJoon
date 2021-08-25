package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_G4_16236 {
	static int N;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static StringTokenizer st;

	static class Fish {
		int x, y;

		public Fish(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Shark extends Fish {

		int size, eat;

		public Shark(int x, int y, int size, int eat) {
			super(x, y);
			this.size = size;
			this.eat = eat;
		}

		@Override
		public String toString() {
			return "[r=" + super.x + ", c=" + super.y + ", size=" + size + ", eat=" + eat + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Fish> queue = new LinkedList<>();
		Shark shark = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
				}
			}
		}
		int ans = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (shark.size > map[i][j] && map[i][j] > 0) {
					queue.offer(new Fish(shark.x, shark.y));
					int[][] route = new int[N][N];
					while (!queue.isEmpty()) {
						Fish f = queue.poll();
						int r = f.x;
						int c = f.y;

						for (int k = 0; k < 4; k++) {
							int nr = r + deltas[k][0];
							int nc = c + deltas[k][1];
							if (isIn(nr, nc) && map[nr][nc] <= shark.size) {
								queue.offer(new Fish(nr, nc));
								route[nr][nc] = route[r][c] + 1;
								if (shark.size > map[nr][nc] && map[nr][nc] > 0) {
									ans += route[nr][nc];
									map[shark.x][shark.y] = 0;
									map[nr][nc] = 9;

									shark = new Shark(nr, nc, shark.size, shark.eat + 1);
									if (shark.eat == shark.size) {
										shark.size++;
										shark.eat = 0;
									}

									queue.clear();
									i = -1;
									continue outer;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

