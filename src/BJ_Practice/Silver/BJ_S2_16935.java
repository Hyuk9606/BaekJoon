package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_16935 {
	static int N, M, R;
	static int[][] map;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] newMap= map;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			newMap = rotate(Integer.parseInt(st.nextToken()),newMap);
			
		}
		for(int[] x : newMap) {
			for(int xx : x)
				sb.append(xx).append(" ");
			sb.append("\n");
				
		}
		System.out.println(sb);
			
	}

	public static int[][] rotate(int step,int[][]map) {
		int[][] newMap;
		int N = map.length;
		int M = map[0].length;
		switch (step) {
		case 1:
			newMap = new int[N][M];

			for (int r = 0; r < N; r++) {
				newMap[N - r - 1] = map[r];
			}
			return newMap;
		case 2:

			newMap = new int[N][M];
			for (int c = 0; c < M; c++) {
				for (int r = 0; r < N; r++) {
					newMap[r][M - c - 1] = map[r][c];
				}
			}
			return newMap;

		case 3:
			newMap = new int[M][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					newMap[c][N - r - 1] = map[r][c];
				}
			}
			return newMap;

		case 4:
			newMap = new int[M][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					newMap[M-c-1][r] = map[r][c];
				}
			}
			return newMap;
		case 5:
			newMap = new int[N][M];
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i][j+M/2] = map[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i+N/2][j+M/2] = map[i][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i+N/2][j] = map[i+N/2][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i][j] = map[i+N/2][j];
				}
			}
			return newMap;
		case 6:
			newMap = new int[N][M];
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i+N/2][j] = map[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i+N/2][j+M/2] = map[i+N/2][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i][j+M/2] = map[i+N/2][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j = 0; j<M/2;j++) {
					newMap[i][j] = map[i][j+M/2];
				}
			}
			return newMap;

			
		}
		return map;
	}

}
