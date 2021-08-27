package BJ_Practice.Fail;

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
				int ansR = Integer.MAX_VALUE, ansC = Integer.MAX_VALUE;
				int[][] route = new int[N][N];
				if (shark.size > map[i][j] && map[i][j] > 0) {
					queue.offer(new Fish(shark.x, shark.y));
					route[shark.x][shark.y] = 0;
					int cnt = 1;
					while (!queue.isEmpty()) {
						int size = queue.size();
						Fish f = queue.poll();
						
						while(size-- >= 0) {
							int r = f.x;
							int c = f.y;

							for (int k = 0; k < 4; k++) {
								int nr = r + deltas[k][0];
								int nc = c + deltas[k][1];
								if (isIn(nr, nc) && map[nr][nc] <= shark.size && route[nr][nc]==0) {
									queue.offer(new Fish(nr, nc));
									route[nr][nc]= route[r][c]+1;
									if (shark.size > map[nr][nc] && map[nr][nc] > 0) {
										if (ansR > nr) {
											ansR = nr;
											ansC = nc;
										}
										else if(ansR == nr) {
											if(ansC>nc) {
												ansR = nr;
												ansC = nc;
											}
										}
									}
								}
							}
						}
						cnt++;
						if (ansR == Integer.MAX_VALUE)
							continue;

						if (shark.size > map[ansR][ansC] && map[ansR][ansC] > 0) {
							ans += route[ansR][ansC];
							map[shark.x][shark.y] = 0;
							map[ansR][ansC] = 9;

							shark = new Shark(ansR, ansC, shark.size, shark.eat + 1);
							if (shark.eat == shark.size) {
								shark.size++;
								shark.eat = 0;
							}
							i = -1;
							queue.clear();
							continue outer;
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
