package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_15486_퇴사2 {
	static int N;
	static int[] T;
	static int[] P;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];

		for (int i = N; i >= 0; i--) {
			System.out.println(Arrays.toString(dp));
			if (i + T[i]-1 > N) {
				dp[i] = dp[i+1];
			}else
				dp[i] = Math.max(dp[i+1], P[i]+dp[i+T[i]]);
		}
		
		System.out.println(dp[1]);
	}
}
