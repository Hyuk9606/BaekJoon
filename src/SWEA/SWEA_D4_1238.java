package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_1238 {
	static int T;
	static int[][] emergency;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T=10;
		for (int t = 1; t <= T; t++) {
			emergency = new int[101][101];
			int[] visited = new int[101];
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				emergency[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
			}

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			visited[start] = 1;
			int a = 0;
			int max = Integer.MIN_VALUE;
			while (!queue.isEmpty()) {
				int step = queue.poll();
					for (int i = 1; i < 101; i++) {
						if (emergency[step][i] == 1 && visited[i] == 0) {
							queue.offer(i);
							visited[i] = visited[step]+1;
							a = visited[i];
						}
					}
			}
			for(int i=1; i<101; i++) {
				if(visited[i] == a) {
					max = Math.max(max, i);
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
