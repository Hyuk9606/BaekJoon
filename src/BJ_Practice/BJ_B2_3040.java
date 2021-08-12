package BJ_Practice;

import java.io.*;

public class BJ_B2_3040 {

	private static boolean np(int[] numbers) {
		int N = numbers.length;

		// step1. 꼭대기 i 찾기, 교환위치 i-1 찾기
		int i = N - 1;

		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false;

		// step2. i-1 위치 값과 교환할 j값 찾기 -> j 는 i-1보다 바로 앞 큰 수
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. i-1위치 값과 j 위치 값 swap
		swap(numbers, i - 1, j);

		// step4. 꼭대기 i부터 맨 뒤 N-1까지 내림차순 형태인 순열을 오름차순으로 만들기.
		int k = N - 1;
		while (i <= k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] numbers = new int[9];

		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		int[] p = new int[9];
		int cnt = 0;
		while (++cnt <= 7)
			p[9 - cnt] = 1;
		do {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (p[i] == 1)
					sum += numbers[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 9; i++)
					if (p[i] == 1)
						System.out.println(numbers[i]);
				return;
			}

		} while (np(p));
	}
}
