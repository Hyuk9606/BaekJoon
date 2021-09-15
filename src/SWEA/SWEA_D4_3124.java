package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_3124 {
	static int T, V, E;
	static Edge[] edgeList;
	static StringTokenizer st;

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start, end, weight);
			}

			Arrays.sort(edgeList);

			make();

			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					if (++cnt == V - 1)
						break;
				}
			}

//			System.out.println(cnt);
//			System.out.println(result);
			sb.append("#").append(t).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}

	static int[] p;

	private static void make() {
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	private static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if (xRoot == yRoot)
			return false;

		p[yRoot] = xRoot;
		return true;
	}
}
