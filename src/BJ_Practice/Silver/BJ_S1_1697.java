package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_1697 {
	static int N, K, length;
	static int[] data, answer;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		length = Math.max(N, K) + 1;
		data = new int[length*2];
		Arrays.fill(data, -1);
		bfs();
		System.out.println(data[K]);
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		data[N] = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next = calcNext(temp, i);
				if (isIn(next) && data[next] == -1) {
					queue.offer(next);
					if (data[next] != -1)
						data[next] = Math.min(data[next], data[temp] + 1);
					else data[next] = data[temp]+1;
				}
			}
		}
//		System.out.println(Arrays.toString(data));
	}

	static int calcNext(int num, int i) {
		switch (i) {
		case 0:
			num *= 2;
			break;
		case 1:
			num -= 1;
			break;
		case 2:
			num += 1;
			break;
		}
		return num;
	}

	static boolean isIn(int num) {
		return num >= 0 && num < data.length;
	}

}
