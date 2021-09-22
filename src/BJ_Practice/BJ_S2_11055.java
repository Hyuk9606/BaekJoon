package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_S2_11055 {
	static int N;
	static int[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = Arrays.copyOf(data, data.length);
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < i ; j++) {
				if(data[i] > data[j]) {
					dp[i] = Math.max(dp[j] + data[i], dp[i]);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N ; i++) {
			answer= Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}
}
