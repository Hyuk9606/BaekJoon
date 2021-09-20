package BJ_Practice.Bronze;

import java.io.*;
import java.util.*;

public class BJ_B2_2798 {
	static int N, M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = data[i] + data[j] + data[k];
					if (sum <= M)
						answer = Math.max(sum, answer);
				}
			}
		}
		System.out.println(answer);
	}
}
