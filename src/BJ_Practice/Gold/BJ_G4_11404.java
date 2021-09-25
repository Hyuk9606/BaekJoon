package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_11404 {
	static int N,M;
	static int[][] route;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		route = new int[N][N];
		for (int i = 0; i < N ; i++) {
			Arrays.fill(route[i], 99999999);
		}
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			route[start][end] = Math.min(route[start][end], cost);
		}
		for (int k = 0; k < N ; k++) {
			for (int i = 0; i < N ; i++) {
				if(i!=k)
					for (int j = 0; j < N ; j++) {
						if(j!=i && j!=k) {
							route[i][j] = Math.min(route[i][k]+route[k][j], route[i][j]);
						}
					}
			}
		}
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N ; j++) {
				if(route[i][j] == 99999999)
					route[i][j]= 0;
				sb.append(route[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}	
