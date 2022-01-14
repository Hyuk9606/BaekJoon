package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_9461_파도반_수열 {
	static int T;
	static long[] dp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		int[] input = new int[T];
		int N = 0;
		for (int t = 1; t <= T; t++) {
			input[t-1] = Integer.parseInt(br.readLine());
			N = Math.max(input[t-1], N);
		}
		dp = new long[N+1];
		for (int i = 0; i < T ; i++) {
			System.out.println(waves(input[i]));
		}
	}
	
	//top-down
	static long waves(int i) {
		if(i < 4) return dp[i] = 1;
		
		else if(dp[i] == 0) {
			return dp[i] = waves(i-2) + waves(i-3);
		}
		
		return dp[i];
	}
}
