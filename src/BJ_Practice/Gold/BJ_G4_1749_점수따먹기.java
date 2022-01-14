package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1749_점수따먹기 {

	static int N, M;
	static int[][] data;
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int num = Integer.parseInt(st.nextToken());
				data[i][j] = num + data[i][j-1] + data[i-1][j] - data[i-1][j-1];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= M ; j++) {
				for (int k = N; k >= i ; k--) {
					for (int s = M; s >= j ; s--) {
						int num = data[k][s] - data[i-1][s] - data[k][j-1] + data[i-1][j-1];
						max = Math.max(max, num);
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
}
