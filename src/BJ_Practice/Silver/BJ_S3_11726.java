package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_11726 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		int[] DP = new int[N+1];
		DP[0] = 1;
		DP[1] = 1;
		for (int i = 2; i <= N ; i++) {
			DP[i] = (DP[i-1]+DP[i-2])%10007;
		}
		System.out.println(DP[N]);
	}
}
