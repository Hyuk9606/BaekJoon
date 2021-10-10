package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_17471_게리맨더링 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] pops;
	static boolean[][] graph;

	static int findCnt;
	static int MIN;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		pops = new int[N + 1];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 1; n <= N; n++) {
			pops[n] = Integer.parseInt(tokens.nextToken());
		}
		graph = new boolean[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int cnt = Integer.parseInt(tokens.nextToken());
			for (int c = 0; c < cnt; c++) {
				int to = Integer.parseInt(tokens.nextToken());
				graph[n][to] = true;
			}
		}

		MIN = Integer.MAX_VALUE;

		for (int i = 1; i <= (N + 1) / 2; i++) {
			combination(i, new boolean[N + 1], 1, i);
		}
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);

	}

	static void combination(int toChoose, boolean[] choosed, int start, int size) {
		if (toChoose == 0) {
			findCnt = 0;
			int pop1 = dfs(getStart(choosed, true), choosed, new boolean[N + 1], true);
			if (findCnt != size) {
				return;
			}
			findCnt = 0;
			int pop2 = dfs(getStart(choosed, false), choosed, new boolean[N + 1], false);
			if (findCnt != N - size) {
				return;
			}
			MIN = Math.min(MIN, Math.abs(pop1 - pop2));
			return;
		}

		for (int i = start; i <= N; i++) {
			choosed[i] = true;
			combination(toChoose - 1, choosed, i + 1, size);
			choosed[i] = false;
		}
	}

	static int dfs(int i, boolean[] choosed, boolean[] visited, boolean check) {
		visited[i] = true;
		findCnt++;
		int pop = pops[i];

		for (int c = 1; c <= N; c++) {
			if (!visited[c] && graph[i][c] && choosed[c] == check) {
				pop += dfs(c, choosed, visited, check);
			}
		}
		return pop;
	}

	static int getStart(boolean[] choosed, boolean check) {
		for (int i = 1; i < choosed.length; i++) {
			if (choosed[i] == check) {
				return i;
			}
		}
		return -1;
	}
}
