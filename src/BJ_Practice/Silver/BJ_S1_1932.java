package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S1_1932 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./out.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=i ; j++) {
				dp[j][i%2] = Integer.parseInt(st.nextToken()) + Math.max(dp[j-1][(i-1)%2], dp[j][(i-1)%2]);
			}
			
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i][N%2]);
		}
		System.out.println(ans);
		
		
	}
}
