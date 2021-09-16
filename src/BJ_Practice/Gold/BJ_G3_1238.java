package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_1238 {
	static int N, M, X;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[N+1][N+1];
		for (int i = 1; i <= N ; i++) {
			Arrays.fill(graph[i], 10000000);
			graph[i][i] = 0;
		}
		
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start][end] = cost;
		}
		
		for (int k = 1; k <= N ; k++) {
			for (int i = 1; i <= N ; i++) {
				if(k!=i)
					for (int j = 1; j <= N ; j++) {
						if(i!=j && j!= k)
							graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
					}
			}
		}
		int answer = 0;
		
		for (int i = 1; i <= N ; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		
		for (int i = 1; i <= N ; i++) {
			if(i != X)
				answer = Integer.max(graph[X][i] + graph[i][X],answer);
		}
		System.out.println(answer);
	}
}
