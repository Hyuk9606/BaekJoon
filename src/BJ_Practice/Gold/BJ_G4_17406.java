package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_17406 {
	static int N, M, R;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static StringTokenizer st;
	static List<int[]> list = new LinkedList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] map_origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map_origin[i][j] = map[i][j];
			}
		}

		numbers = new int[R];
		isSelected = new boolean[R + 1];
		permunitaion(0);
		int[][] arr = new int[R][3];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int j = 0; j < list.size(); j++) {
			for (int ii = 0; ii < N; ii++) {
				for (int jj = 0; jj < M; jj++) {
					map[ii][jj] = map_origin[ii][jj];
				}
			}
			int[] step = list.get(j);
			for (int k = 0; k < step.length; k++) {
				int rr = arr[step[k]][0];
				int cc = arr[step[k]][1];
				int s = arr[step[k]][2];
				visited = new boolean[N][M];
				for (int r1 = rr - s - 1; r1 < rr + s; r1++) {
					for (int c1 = cc - s - 1; c1 < cc + s; c1++) {
						visited[r1][c1] = true;
					}
				}

				int r = rr - s - 1;
				int c = cc - s - 1;
				int nc, nr;
				while (true) {
					int temp = map[r][c];
					for (int x = 0; x < 4; x++) {
						nr = r + deltas[x][0];
						nc = c + deltas[x][1];
						while (isIn(nr, nc) && visited[nr][nc] == true) {
							map[r][c] = map[nr][nc];
							visited[r][c] = false;
							r = nr;
							c = nc;
							nr += deltas[x][0];
							nc += deltas[x][1];
						}
					}
					map[r][c] = temp;
					visited[r][c] = false;
					r = r + 1;
					if (visited[r][c] == false)
						break;
				}
			}
			for (int[] x : map) {
				int sum = 0;
				for (int xx : x)
					sum += xx;
				min = Math.min(min, sum);
			}

		}
		System.out.println(min);

	}

	static int[] numbers;
	static boolean[] isSelected;

	public static void permunitaion(int cnt) {
		if (cnt == R) {
			int[] num = Arrays.copyOf(numbers, numbers.length);
			list.add(num);
			return;
		}

		for (int i = 0; i < R; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;

			permunitaion(cnt + 1);
			isSelected[i] = false;
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
