package BJ_Practice.Silver;

import java.util.*;

public class BJ_S3_10972 {
	public static int[] np(int[] numbers) {
		int N = numbers.length;
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return null;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		swap(numbers, i - 1, j);

		int k = N - 1;
		while (k > i)
			swap(numbers, i++, k--);

		return numbers;

	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		int[] a = np(input);
		if(a == null)
		System.out.println(-1);
		else
			for(int i=0; i<N; i++) {
				System.out.print(a[i] + " ");
			}
	}

}
