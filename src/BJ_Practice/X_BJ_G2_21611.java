package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_G2_21611 {
	static int N, M;
	static int countZero = 0;
	static int[] bomb = new int[4];
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] deltas2 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Integer> queue = new LinkedList<>();
	static StringTokenizer st;

	static class Biz {
		int r, c;
		int num;

		public Biz(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Biz other = (Biz) obj;
			if (c != other.c)
				return false;
			return r == other.r;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					countZero++;
			}
		}
		countZero -= 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int r = N / 2, c = N / 2;
			for (int j = 0; j < s; j++) {
				r += deltas2[d][0];
				c += deltas2[d][1];
				map[r][c] = 0;
				countZero++;
			}
			insertQueue();
			explosionBiz();
			insertMap();
		}
		System.out.println(Arrays.toString(bomb));

	}

	static void explosionBiz() {
		int boomCnt = 0;
		int qsize = queue.size();
		while (true) {
			int num;
			int count = 0;
			int currsize = queue.size();
			
			for (int j = 0; j < currsize; j++) {
				if(queue.isEmpty()) {
					System.out.println("ㄹㅇ?");
					break;
				}
				
				num = queue.poll();
				count++;
				
				while (!queue.isEmpty() && j<currsize-1&& num == queue.peek()) {
					count++;
					queue.poll();
					j++;
					
				}

				if (count < 4) {
					for (int i = 0; i < count; i++) {
						queue.offer(num);
					}
				} else {
					boomCnt++;
					bomb[num] += count;
				}
				count = 0;
			}
			if (boomCnt == 0)
				break;
			boomCnt = 0;
		}
		qsize -= queue.size();
		countZero += qsize;

	}

	static void insertQueue() {
		boolean[][] visited = new boolean[N][N];
		int r = 0, c = 0;
		if (map[r][c] != 0)
			queue.offer(map[0][0]);
		visited[0][0] = true;
		int step = 0;
		while (!(r == N / 2 && c == N / 2)) {
			r += deltas[step % 4][0];
			c += deltas[step % 4][1];
			if (isIn(r, c) && !visited[r][c]) {
				if (map[r][c] != 0)
					queue.offer(map[r][c]);
				visited[r][c] = true;

			} else {
				r -= deltas[step % 4][0];
				c -= deltas[step % 4][1];
				step++;
			}
		}
	}
	
	static void insertMap() {
		boolean[][] visited = new boolean[N][N];
		int r = 0,c=0;
		visited[0][0] = true;
		if(countZero == 0) map[r][c] = queue.poll();
		
		int step = 0;
		int cnt = countZero-1;
		while (!(r == N / 2 && c == N / 2)) {
			r += deltas[step % 4][0];
			c += deltas[step % 4][1];
			if(c == N/2 && r == N/2) break;
			if (isIn(r, c) && !visited[r][c]) {
				if (cnt > 0) {
					map[r][c] = 0;
					cnt--;
				}
				else map[r][c] = queue.poll();
				visited[r][c] = true;

			} else {
				r -= deltas[step % 4][0];
				c -= deltas[step % 4][1];
				step++;
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N ;
	}
}
