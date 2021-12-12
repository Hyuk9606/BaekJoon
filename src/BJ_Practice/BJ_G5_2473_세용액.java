package BJ_Practice;

import java.io.*;
import java.util.*;

public class BJ_G5_2473_세용액 {
	static int N;
	static long[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		data = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;

		long[] answer = new long[4];
		answer[0] = Long.MAX_VALUE;
		int s = 0, e = N - 1;
		while (s < e) {
			long num = data[e] + data[s];
			for (int i = 0; i < N; i++) {
				if(i == s || i == e) continue;
				long number = num + data[i];
//				num += data[i];
				if (answer[0] > Math.abs(number)) {
					answer[0] = Math.abs(number);
					answer[1] = data[s];
					answer[2] = data[e];
					answer[3] = data[i];
				}
				if(number == 0) {
					answer[0] = 0;
					answer[1] = data[s];
					answer[2] = data[e];
					answer[3] = data[i];
					break;
				}
			}
			if (num < 0) {
				s++;
			} else if (num > 0) {
				e--;
			}
		}

		long ans[] = Arrays.copyOfRange(answer, 1, 4);
		Arrays.sort(ans);
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
