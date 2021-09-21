package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_2579 {
	static int N;
	static int[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i >= 3) {
				dp[i] = Math.max(data[i - 1] + dp[i - 3] + data[i], data[i] + dp[i - 2]);
			}else if(i == 2) {
				dp[i] = Math.max(data[i-1] + data[i], data[i-2] + data[i]);
			}else {
				dp[i] = data[i];
			}
		}
		System.out.println(dp[N]);

	}
}
