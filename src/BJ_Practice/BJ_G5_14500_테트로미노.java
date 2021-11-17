package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_14500_테트로미노 {
	static int N, M;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static StringTokenizer st;

	static class RC implements Comparable<RC> {
		int r, c, num;

		public RC(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(RC o) {
			return Integer.compare(o.num, this.num);
		}

		@Override
		public String toString() {
			return "RC [r=" + r + ", c=" + c + ", num=" + num + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				answer = Math.max(answer, bfs(new RC(i,j,map[i][j])));
			}
		}
		
		System.out.println(answer);
	}

	static int bfs(RC rc) {
		PriorityQueue<RC> queue = new PriorityQueue<>();
		queue.offer(rc);
		
		visited[rc.r][rc.c] = true;
		
		RC [] store = new RC[4];
		
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			RC temp = queue.poll();
			store[i] = temp;
			sum += temp.num;
			if(i == 3) {
				for (int j = 0; j < 4 ; j++) {
					RC temp2 = store[j];
					visited[temp2.r][temp2.c] = false;
				}
				return sum;
			}
			for (int j = 0; j < 3; j++) {
				int nr = temp.r + deltas[j][0];
				int nc = temp.c + deltas[j][1];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					queue.offer(new RC(nr,nc,map[nr][nc]));
					visited[nr][nc] = true;
				}
			}
		}
		return sum;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
