package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_15681 {

	static int N, R, Q;
	static StringTokenizer st;
	static Stack<Integer> stack = new Stack<>();
	static List<Integer>[] arr;
	static int count[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			arr[U].add(V);
			arr[V].add(U);
		}

		count = new int[N + 1];
		dfs(R);
		System.out.println(Arrays.toString(count));
	}

	static void dfs(int node) {
		stack.push(node);
		count[node] = 1;
		int cnt = 0;
		for (int i = 0; i < arr[node].size(); i++) {
			if (count[node] == 0) {
				dfs(arr[node].get(i));
				cnt++;
			}
		}
		count[node] = cnt;
	}

}
