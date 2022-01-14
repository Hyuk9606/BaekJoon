package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_1525_퍼즐 {

	static int answer = -1;
	static int[][] data = new int[3][3];
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 0) {
					data[i][j] = 9;
				}
			}
		}
		int trans = trans(data);
		if(trans == 123456789) {
			System.out.println(0);
			System.exit(0);
		}
		
		map.put(trans(data), 0);
		bfs();
		System.out.println(answer);
	}

	static int trans(int[][] data) {
		long result = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result += data[i][j];
				result *= 10;
			}
		}
		return (int) (result / 10);
	}

	static void bfs() {
		Queue<int[][]> queue = new LinkedList<>();
		queue.offer(data);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int step = 0; step < size; step++) {
				int[][] temp = queue.poll();
				int[] zero = new int[2];
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (temp[j][k] == 9) {
							zero[0] = j;
							zero[1] = k;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					int[][] temptemp = new int[3][3];
					for (int j = 0; j < 3; j++) {
						temptemp[j] = Arrays.copyOf(temp[j], 3);
					}
					int nr = zero[0] + deltas[i][0];
					int nc = zero[1] + deltas[i][1];
					if (isIn(nr, nc)) {
						int swaptemp = temptemp[zero[0]][zero[1]];
						temptemp[zero[0]][zero[1]] = temptemp[nr][nc];
						temptemp[nr][nc] = swaptemp;
						int res = trans(temptemp);
						if (!map.containsKey(res)) {
							map.put(res, count);
							if (res == 123456789) {
								answer = count;
								break;
							}
							queue.offer(temptemp);
						}
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < 3 && c >= 0 && c < 3;
	}
}
