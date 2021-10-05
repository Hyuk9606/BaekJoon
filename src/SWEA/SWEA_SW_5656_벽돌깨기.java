package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_SW_5656_벽돌깨기 {
	static int T;
	static int N, W, H;
	static int count;
	static int map[][];
	static int deltas[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static StringTokenizer st;

	static class Block {
		int r, c;
		int num;

		public Block() {
			super();
		}

		public Block(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			count = 0;
			int total = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			numbers = new int[N];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] != 0) {
						total++;
					}
				}
			}

			permu(0);

			total -= count;

			sb.append("#").append(t).append(" ").append(total).append("\n");

		}
		System.out.println(sb);
	}

	static int destroy(int col, int[][] map) {
		Queue<Block> queue = new LinkedList<>();
		int count = 0;
		for (int r = 0; r < H; r++) {
			if (map[r][col] != 0) {
				queue.offer(new Block(r, col, map[r][col]));
				count++;
				map[r][col] = 0;
				break;
			}
		}

		while (!queue.isEmpty()) {
			Block temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = temp.r;
				int nc = temp.c;
				for (int j = 0; j < temp.num - 1; j++) {
					nr += deltas[i][0];
					nc += deltas[i][1];
					if (isIn(nr, nc) && map[nr][nc] != 0) {
						queue.offer(new Block(nr, nc, map[nr][nc]));
						count++;
						map[nr][nc] = 0;
					}
				}

			}

		}
		return count;

	}

	static void restore(int[][] map) {
		Stack<Integer> stack = new Stack<>();
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] != 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			int r = H - 1;
			while (!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	static int[] numbers;

	static void permu(int cnt) {
		if (cnt == N) {
			int[][] tempMap = new int[H][W];
			tempMap = copy(map, tempMap);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += destroy(numbers[i], tempMap);
				restore(tempMap);
			}
				count = Math.max(count, sum);
			return;
		}

		for (int i = 0; i < W; i++) {
			numbers[cnt] = i;
			permu(cnt + 1);
		}

	}

	static int[][] copy(int[][] map, int[][] temp) {
		for (int i = 0; i < H; i++) {
			temp[i] = Arrays.copyOf(map[i], W);
		}
		return temp;
	}
}


