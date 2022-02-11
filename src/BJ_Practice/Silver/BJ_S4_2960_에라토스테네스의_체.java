package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S4_2960_에라토스테네스의_체 {

	static int N, K;
	static boolean[] numbers;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		numbers = new boolean[N + 1];

		int step = 0;
		for (int i = 2; i <= N; i++) {
			if (numbers[i])
				continue;
			int cnt = 2;
			for (int j = i; j <= N ; j = i * cnt++) {
				if(numbers[j]) continue;
				numbers[j] = true;
				step++;
				if(step == K) {
					System.out.println(j);
					return;
				}
			}
		}
	

	}
}
