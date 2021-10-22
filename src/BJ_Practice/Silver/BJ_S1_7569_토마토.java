package BJ_Practice.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_7569_토마토 {
	static int N, M, H;
	static int[][][] tomato;
	static int[][] deltas = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static StringTokenizer st;

	static class Tomato {
		int r, c, h;

		public Tomato(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[N][M][H];
		int zeroCnt=0;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					tomato[r][c][h] = Integer.parseInt(st.nextToken());
					if (tomato[r][c][h] == 1)
						queue.offer(new Tomato(r, c, h));
					else if(tomato[r][c][h] == 0) zeroCnt++;
				}
			}
		}
		if(zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		
		int day = bfs()-1;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (tomato[r][c][h] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);
		
		
	}

	public static Queue<Tomato> queue = new LinkedList<>();

	static int bfs() {
		int day = 0;
		while (!queue.isEmpty()) {
			day++;
			int size = queue.size();
			for (int step = 0; step < size; step++) {
				Tomato temp = queue.poll();

				for (int i = 0; i < 6; i++) {
					int nr = temp.r + deltas[i][0];
					int nc = temp.c + deltas[i][1];
					int nh = temp.h + deltas[i][2];
					if (isIn(nr, nc, nh) && tomato[nr][nc][nh] == 0) {
						queue.offer(new Tomato(nr, nc, nh));
						tomato[nr][nc][nh] = 1;
					}
				}
			}
		}
		return day;
	}

	static boolean isIn(int r, int c, int h) {
		return r >= 0 && c >= 0 && h >= 0 && r < N && c < M && h < H;
	}
}
