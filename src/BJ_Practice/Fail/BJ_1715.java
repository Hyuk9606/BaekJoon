package BJ_Practice.Fail;

import java.io.*;
import java.util.*;

public class BJ_1715 {
	public static int sum = 0;

	public static int[] cardSum(int[] arr) {
		if (arr.length == 2)
			return arr;
		int[] result = new int[arr.length - 1];
		System.arraycopy(arr, 2, result, 1, result.length - 1);
		result[0] = arr[0] + arr[1];
		sum += result[0];
		Arrays.sort(result);
//		int temp;
//		for (int i = 0; i < result.length - 1; i++) {
//			if (result[i] > result[i + 1]) {
//				temp = result[i + 1];
//				result[i + 1] = result[i];
//				result[i] = temp;
//			} else
//				break;
//		}

		return result;

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
			Arrays.sort(card);
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








