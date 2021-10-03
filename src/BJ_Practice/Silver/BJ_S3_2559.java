package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_2559 {
	static int N,K;
	static int[] data;
	static int[] intervalSum;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		intervalSum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N ; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < K ; i++) {
			intervalSum[K-1] += data[i];
		}
		int max = intervalSum[K-1];
		for (int i = K; i < N ; i++) {
			intervalSum[i] = intervalSum[i-1] + data[i] - data[i-K];
			max = Math.max(max, intervalSum[i]);
		}
		System.out.println(max);
	}
}

