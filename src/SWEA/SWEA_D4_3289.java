package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D4_3289 {
	static int T, N, M;
	static StringTokenizer st;

	static int[] parent;

	static void make() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);	
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		
		parent[yRoot] = xRoot;
		
		return true;	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				switch(operation) {
				case 0:
					union(x,y);
					break;
				case 1:
					if(find(x) == find(y))
						sb.append(1);
					else sb.append(0);
					break;
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
