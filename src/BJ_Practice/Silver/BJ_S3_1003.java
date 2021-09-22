package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_1003 {
	static int T, N;
	static int[][] DP;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		DP = new int[41][2];
		
		DP[0][0] = 1;
		DP[1][1] = 1;
		for (int i = 2; i <= 40 ; i++) {
			DP[i][0] = DP[i-1][0] + DP[i-2][0];
			DP[i][1] = DP[i-1][1] + DP[i-2][1];
		}
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(DP[N][0]).append(" ").append(DP[N][1]).append("\n");
		}
		System.out.println(sb);
	}


}
