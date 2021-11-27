package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_2473_세_용액 {
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
        Arrays.sort(data);
		while (start < N - 1) {
			int s = 0, e = N - 1;
			while (s < e) {
				if (s == start)
					s++;
				if(e == start) e--;
				if(s == e) break;
				long num = data[start] + data[e] + data[s];
				if (answer[0] > Math.abs(num)) {
					answer[0] = Math.abs(num);
					answer[1] = data[s];
					answer[2] = data[e];
					answer[3] = data[start];

				}
				if (num < 0) {
					s++;
				} else if (num > 0) {
					e--;
				} else {
					answer[0] = 0;
					answer[1] = data[s];
					answer[2] = data[e];
					answer[3] = data[start];
					break;
				}
			}
			start++;

		}
		long ans[] = Arrays.copyOfRange(answer, 1, 4);
		Arrays.sort(ans);
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
