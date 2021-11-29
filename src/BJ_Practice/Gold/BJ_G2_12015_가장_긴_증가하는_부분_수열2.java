package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G2_12015_가장_긴_증가하는_부분_수열2 {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] LIS = new int[N];
		int size = 0;
		if (arr.length != 1) {
			for (int i = 0; i < N; i++) {
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
				if (temp != N-1 && LIS[temp + 1] != arr[i])
					LIS[temp] = arr[i];

				if (temp == size)
					size++;
			}
			System.out.println(size);
		} else
			System.out.println(1);
		for (int i = 0; i < size ; i++) {
			sb.append(LIS[i]).append(" ");
		}
		System.out.println(sb);
		

	}
}