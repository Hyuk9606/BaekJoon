package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_4386_별자리_만들기 {

	static int N;
	static float[][] data;
	static int[] parent;
	static StringTokenizer st;

	static class Edge implements Comparable<Edge> {
		int start, end;
		double cost;

		public Edge(int start, int end, double cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 1; i <= N ; i++) {
			parent[i] = i;
		}
		data = new float[N][2];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Float.parseFloat(st.nextToken());
			data[i][1] = Float.parseFloat(st.nextToken());
			for (int j = 0; j < i; j++) {
				double x = Math.abs(Math.pow(data[i][0] - data[j][0], 2));
				double y = Math.abs(Math.pow(data[i][1] - data[j][1], 2));
				double dist = Math.sqrt(x + y);
				pq.offer(new Edge(i, j, dist));
			}
		}
		int count = 0;
		double answer = 0.0;
		while (count < N-1) {
			Edge temp = pq.poll();
			if(!isSame(temp.start,temp.end)) {
				union(temp.start,temp.end);
				answer += temp.cost;
				count++;
			}
		}
		System.out.printf("%.2f",answer);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return;
		if (x > y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	static boolean isSame(int x, int y) {
		if (find(x) == find(y)) {
			return true;
		}
		return false;
	}
}
