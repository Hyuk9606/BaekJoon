package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S2_11053 {
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
				if (LIS[temp + 1] != arr[i])
					LIS[temp] = arr[i];

				if (temp == size)
					size++;
			}
			System.out.println(size);
		} else
			System.out.println(1);

	}
}
