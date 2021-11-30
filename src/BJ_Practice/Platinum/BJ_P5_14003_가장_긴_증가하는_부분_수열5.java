package BJ_Practice.Platinum;

import java.io.*;
import java.util.*;

public class BJ_P5_14003_가장_긴_증가하는_부분_수열5 {
	static int N;
	static int[] LIS;
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
		int[] ans = new int[N];
		LIS = new int[N + 1];
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = binarySearch(0, size, arr[i]);
			if (LIS[temp + 1] != arr[i]) {
				LIS[temp] = arr[i];
				ans[i] = temp;
			}

			if (temp == size) {
				size++;
			}
		}
		System.out.println(size);

		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (ans[i] == size - 1) {
				stack.push(arr[i]);
				size--;
				if (size == -1)
					break;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());

	}

	static int binarySearch(int left, int right, int key) {
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;

			if (LIS[mid] < key) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}