package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_14502 {
	static int N, M, answer = 987654321;
	static int[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] mapVisited;
	static List<RC> zeroList;
	static List<RC> twoList;
	static StringTokenizer st;

	static class RC {
		int r, c;

		public RC(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "RC [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapVisited = new boolean[N][M];
		zeroList = new ArrayList<>();
		twoList = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0) {
					zeroList.add(new RC(r, c));
				} else if (map[r][c] == 2) {
					twoList.add(new RC(r, c));
					mapVisited[r][c] = true;
				}
				else
					mapVisited[r][c] = true;
			}
		}
		
		for (int i = 0; i < N ; i++) {
//			System.out.println(Arrays.toString(mapVisited[i]));
		}
		
		int[] visited = new int[3];

		comb(0, 0, visited);
		System.out.println(zeroList.size()-3-answer);
	}

	private static void comb(int cnt, int start, int[] numbers) {
		if (cnt == 3) {
			boolean[][] tempV = new boolean[N][M];
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M ; j++) {
					tempV[i][j] = mapVisited[i][j];
				}
			}
//			System.out.println(Arrays.toString(numbers));
			answer = Math.min(answer,  spread(map, tempV, numbers));
			return;
		}
		for (int i = start; i < zeroList.size(); i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1, numbers);
		}
	}

	static int spread(int[][] map, boolean[][] visited, int[] numbers) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			RC temp = zeroList.get(numbers[i]);
			visited[temp.r][temp.c] = true;
		}

		Queue<RC> queue = new LinkedList<>();

		for (int i = 0; i < twoList.size(); i++) {
			queue.offer(twoList.get(i));
			RC temp = twoList.get(i);
			visited[temp.r][temp.c] = true;
			
			while (!queue.isEmpty()) {
				temp = queue.poll();
				int r = temp.r;
				int c = temp.c;
				for (int j = 0; j < 4 ; j++) {
					int nr = r + deltas[j][0];
					int nc = c + deltas[j][1];
					if(isIn(nr,nc) && !visited[nr][nc]) {
						queue.offer(new RC(nr,nc));
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}

		}

//		System.out.println(cnt);
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
