package BJ_Practice.Gold;

import java.io.*;
import java.util.*;

public class BJ_G3_2143_두_배열의_합 {
	static int T, N, M;
	static int[] A;
	static int[] B;
	static long count = 0;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];
		}
		List<Integer> powerSumA = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				powerSumA.add(A[i] - A[j - 1]);
			}
		}
		List<Integer> powerSumB = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= i; j++) {
				powerSumB.add(B[i] - B[j - 1]);
			}
		}
		Collections.sort(powerSumA);
		Collections.sort(powerSumB);

		int sizeA = powerSumA.size();
		int sizeB = powerSumB.size();

		int indexA = 0;
		int indexB = sizeB - 1;

		while (indexA < sizeA && indexB >= 0) {
			int a = powerSumA.get(indexA);
			int b = powerSumB.get(indexB);

			if (a + b == T) {
				int cntA = 0, cntB = 0;

				while (indexA < sizeA && powerSumA.get(indexA) == a) {
					cntA++;
					indexA++;
				}
				while (indexB >= 0 && powerSumB.get(indexB) == b) {
					cntB++;
					indexB--;
				}
				count += (long) cntA * cntB;
			}
			else if(a+b < T) {
				indexA++;
			}else {
				indexB--;
			}
		}

		System.out.println(count);
		
		
		
		
		
	}
}
