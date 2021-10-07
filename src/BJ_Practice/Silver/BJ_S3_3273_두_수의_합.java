package BJ_Practice.Silver;

import java.io.*;
import java.util.*;

public class BJ_S3_3273_두_수의_합 {
	static int N, x;
	static int[] numbers = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int start = 0;
		int end = N - 1;
		int sum = 0;
		int result = 0;

		while (start < end) {
			sum = arr[start] + arr[end];
			if (sum == x)
				result++;

			if (sum <= x)
				start++;
			else
				end--;
		}

		System.out.println(result);
	}
}
