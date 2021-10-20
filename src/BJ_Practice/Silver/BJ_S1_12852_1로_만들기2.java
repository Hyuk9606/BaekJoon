package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_12852_1로_만들기2 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		int[] history = new int[N+1];
		int[] dp = new int[N+1];
		history[1] = -99;
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			history[i] = i - 1;
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1)
			{
				dp[i] = dp[i / 2] + 1;
				history[i] = i / 2;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				history[i] = i / 3;
			}
		}
//		System.out.println(Arrays.toString(history));
//		System.out.println(Arrays.toString(dp));
		sb.append(dp[N]).append("\n");
		while(N != -99) {
			sb.append(N+ " ");
			N = history[N];
		}
		System.out.println(sb);
	}
}
