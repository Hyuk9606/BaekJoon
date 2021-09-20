package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B1_11050 {
	static int N, K;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int result = 1;
		for (int i = 0; i < K ; i++) {
			result *= N-i;
		}
		for (int i = K; i >= 1; i--)
			result /= i;
		
		System.out.println(result);
	}
}
