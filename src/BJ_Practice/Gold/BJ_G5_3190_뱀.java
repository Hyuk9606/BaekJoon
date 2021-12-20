package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_3190_뱀 {

	static int N, K, L;
	static int time = 0;
	static int currentDir = 0;
	static int answer = 0;
	static int r = 0, c = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static ArrayDeque<Position> deque = new ArrayDeque<>();
	static StringTokenizer st;

	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		K = Integer.parseInt(input.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}

		boolean flag = false;
		deque.offer(new Position(r, c));
		visited[r][c] = true;

		L = Integer.parseInt(input.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(input.readLine());
			time = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			
			if(flag = move(time)) {
				break;
			}
			
			switch (direction) {
			case 'D':
				currentDir += 1;
				currentDir %= 4;
				break;
			case 'L':
				currentDir += 3;
				currentDir %= 4;
				break;
			}

		}
		
		if(!flag) move(10000);
		
		System.out.println(answer + 1);
		input.close();

	}

	static boolean move(int time) {
		while (answer < time) {
			r += deltas[currentDir][0];
			c += deltas[currentDir][1];
			if (isIn(r, c) && !visited[r][c]) {
				answer++;
				if (map[r][c] == 0) {
					deque.offer(new Position(r, c));
					visited[r][c] = true;
					Position temp = deque.pollFirst();
					visited[temp.r][temp.c] = false;
				} else {
					deque.offer(new Position(r, c));
					visited[r][c] = true;
					map[r][c] = 0;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
