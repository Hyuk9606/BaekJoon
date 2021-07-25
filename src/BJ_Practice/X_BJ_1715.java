package BJ_Practice;

import java.io.*;
import java.util.*;

public class X_BJ_1715 {
	public static int sum = 0;

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if (start < part2 - 1) {
			quickSort(arr, start, part2 - 1);
		}
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		int temp;
		while (start <= end) {
			while (arr[start] < pivot)
				start++;
			while (arr[end] > pivot)
				end--;
			if (start <= end) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}

		}
		return start;
	}

	public static int[] cardSum(int[] arr) {
		if (arr.length == 2)
			return arr;
		int[] res = new int[arr.length - 1];
		System.arraycopy(arr, 2, res, 1, res.length - 1);
		res[0] = arr[0] + arr[1];
		sum += res[0];
		int temp;
		for (int i = 0; i < res.length - 1; i++) {
			if (res[i] > res[i + 1]) {
				temp = res[i + 1];
				res[i + 1] = res[i];
				res[i] = temp;
			} else
				break;
		}

		return res;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] card = new int[N];
			for (int i = 0; i < N; i++) {
				card[i] = Integer.parseInt(br.readLine());

			}
			quickSort(card);
			while (card.length > 2) {
				card = cardSum(card);
			}
			if (card.length == 1)
				sum = card[0];
			else
				sum += card[0] + card[1];

			bw.write(sum + " ");
			bw.flush();
			bw.close();
			br.close();

		} catch (Exception e) {
		}
	}
}
