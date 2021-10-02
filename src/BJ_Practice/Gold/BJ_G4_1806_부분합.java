package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G4_1806_부분합 {
	static int N, S;
	static int[] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		data = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int s = 0, e = 0;
		int sum = 0;
		int min = N + 1;
		boolean flag = false;
		while (e <= N && s <= N) {
//			System.out.println("s :" + s + " e: " + e + "sum: " + sum);
			if (sum >= S) {
				flag = true;
				min = Math.min(min, e - s + 1);
				sum -= data[s];
				s++;
//				System.out.println(sum);
			} else {
				e++;
				if (e > N)
					break;
				sum += data[e];
			}
		}
		if(!flag) min = 0;
//		System.out.println("s :" + s + " e: " + e + "sum: " + sum);
		System.out.println(min);

	}
}

