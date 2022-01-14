package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_12865 {
	static int N, K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] items = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] DP = new int[K + 1];
		for (int n = 0; n < N; n++) {
			for (int k = K; k >= items[n][0]; k--) 
				DP[k] = Math.max(DP[k], items[n][1]+DP[k - items[n][0]]);
			
		}
		System.out.println(DP[K]);
	}
}
