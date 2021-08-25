package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_10026 {

	static int N;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs(map,1)+" "+bfs(map,2));
		

	}

	static int bfs(char[][] data,int version) {
		char [][] map = new char[N][N];
		
		for(int i=0; i<N;i++) {
			for (int j = 0; j < N ; j++) {
				if(version==2 && data[i][j] == 'G') {
					map[i][j] = 'R';
				}else
				map[i][j] = data[i][j];
			}
		}
		
		Queue<RC> queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 65) {
					++cnt;
					queue.offer(new RC(i, j));
					char ch = map[i][j];
					map[i][j] -= 65;
					while (!queue.isEmpty()) {
						RC axis = queue.poll();
						int r = axis.r;
						int c = axis.c;

						for (int k = 0; k < 4; k++) {
							int nr = r + deltas[k][0];
							int nc = c + deltas[k][1];

							if (isIn(nr, nc) && ch == map[nr][nc]) {
								queue.offer(new RC(nr, nc));
								map[nr][nc] -= 65;
							}
						}

					}

				}
			}
		}
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
