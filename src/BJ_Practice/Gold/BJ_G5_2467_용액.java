package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G5_2467_용액 {

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

		int s = 0, e = N - 1;

		int answer =Integer.MAX_VALUE;
		int start=0, end = 0;

		while (s < e) {
			int num = data[e] + data[s];
			if (answer > Math.abs(num)) {
				answer = Math.abs(num);
				start = s;
				end = e;
			}
			if (num < 0) {
				s++;
			} else if (num > 0) {
				e--;
			} else {
				answer = 0;
				start = s;
				end= e;
				break;
			}
		}
		System.out.println(data[start] + " " + data[end]);
	}
}
